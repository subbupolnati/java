package com.bloodbank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.bloodbank.exception.BloodNotFoundException;
import com.bloodbank.exception.PatientNotFoundException;
import com.bloodbank.model.Blood;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Order;
import com.bloodbank.model.Patient;
import com.bloodbank.model.Permission;
import com.bloodbank.model.Role;
import com.bloodbank.service.BloodService;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.OrderService;
import com.bloodbank.service.PatientService;
import com.bloodbank.service.PermissionService;
import com.bloodbank.service.RoleService;

@SpringBootTest
class BloodBankManagementSystemApplicationTests {

	Permission permission;
	Role role;
	Donor donor;
	Blood blood;
	Patient patient;
	PermissionService ps=Mockito.mock(PermissionService.class);
	BloodService bs=Mockito.mock(BloodService.class);
	DonorService ds=Mockito.mock(DonorService.class);
	PatientService patientService=Mockito.mock(PatientService.class);
	RoleService rs=Mockito.mock(RoleService.class);
	OrderService os=Mockito.mock(OrderService.class);
	List<Blood> b1=new ArrayList<Blood>();
	List<Permission>pl=new ArrayList<Permission>();
	List<Donor> dl=new ArrayList<Donor>();
	@BeforeEach
	void init() {
		Permission p1=new Permission(1,"admin","admin","NA");
		Permission p2=new Permission(2,"Donor","Donor","NA");
		Permission p3=new Permission(3,"Patient","Patient","NA");
		pl.add(p1);pl.add(p2);pl.add(p3);
		Role r1=new Role(1,"admin","Na",p1);
		Role r2=new Role(2,"donor","Na", p2);
		Role r3=new Role(3,"patient","na",p3);
		Donor d=new Donor(1,"subrahmanyam","9951933459","subbu.polnati@gmail.com","Hyd","subbu","subbu", p2);
		Blood b=new Blood(1,"A","positve","Redcross","NA","1000", d, p2);
	}
	
	@Test
	void test1() {
		Blood b=blood;
		assertSame(b,blood);
	}
	@Test
	void test2() {
	assertEquals(role,role);
	}
	@Test
	void test3() {
	Permission p2=new Permission(2,"Donor","Donor","NA");
	Donor d=new Donor(1,"subrahmanyam","9951933459","subbu.polnati@gmail.com","Hyd","subbu","subbu", p2);
	assertEquals("Donor",d.getPermission().getPermissiontitle());
	}
	@Test
	void test4() {
	Permission p2=new Permission(2,"Donor","Donor","NA");
	Blood b=new Blood(1,"A","positve","Redcross","NA","1000", donor, p2);
	assertNotEquals("admin",b.getPermission().getPermissiontitle());
	}
	@Test
	void test5() {
		Donor d=new Donor(1,"subrahmanyam","9951933459","subbu.polnati@gmail.com","Hyd","subbu","subbu", permission);
		assertEquals(d.getDonorname(),"subrahmanyam");
	}
	@Test
	void test6() {
		assertThrows(NullPointerException.class,()->role.getDescription());
	}
	@Test
	void test7() {
		Permission p2=new Permission(2,"Donor","Donor","NA");
		assertSame("Donor",p2.getPermissiontitle());
	}
	@Test
	void test8() {
		Order o=new Order();
		assertNull(o.getBloodgroup());
	}
	@Test
	void test9() {
		assertNotNull(b1.size());
	}
	@Test
	void test10() {
		assertThrows(NullPointerException.class,()->blood.getBloodtype());
	}
	@Test
	void test11() {
		doThrow(new PatientNotFoundException("Not found")).when(patientService).deletPatient(0);
	}
	@Test
	void test12() {
		doThrow(new BloodNotFoundException("Notfound")).when(bs).searchBlood("A");
	}
	@Test
	void test13() {
		when(ds.addDonor(donor)).thenReturn(donor);
	}
	@Test
	void test14() {
		bs.getAllBlood();
		verify(bs,times(1)).getAllBlood();
	}
	@Test
	void test15() {
	doReturn(dl).when(ds).getALLDonors();
	
	}
	@Test
	void test16() {
	verify(patientService,never()).getPatient(0);
	}
	@Test
	void test17() {
		when(ps.getAllPermissions()).thenReturn(pl);
		assertEquals(pl,ps.getAllPermissions());
		verify(ps,atLeast(1)).getAllPermissions();
	}
	@Test
	void test18() {
		when(bs.getAllBlood()).thenReturn(b1);
		assertEquals(b1,bs.getAllBlood());
		assertEquals(b1,bs.getAllBlood());
		assertEquals(b1,bs.getAllBlood());
		verify(bs,atMost(3)).getAllBlood();
	}
	@Test
	void test19() {
		when(ps.getAllPermissions()).thenReturn(pl);
		assertEquals(3,pl.size());
	}
	@Test
	void test20() {
		when(rs.updateRole(1)).thenReturn(role);
	}
}
