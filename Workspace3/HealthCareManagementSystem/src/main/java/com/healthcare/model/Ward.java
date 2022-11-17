package com.healthcare.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ward")
public class Ward {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wardno")
	@SequenceGenerator(initialValue = 1,name="wardno",allocationSize = 1)
	private int wardno;
	private String patient_admitted;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Nurses> nurses_assigned;
	public int getWardno() {
		return wardno;
	}
	public void setWardno(int wardno) {
		this.wardno = wardno;
	}
	public String getPatient_admitted() {
		return patient_admitted;
	}
	public void setPatient_admitted(String patient_admitted) {
		this.patient_admitted = patient_admitted;
	}
	public List<Nurses> getNurses_assigned() {
		return nurses_assigned;
	}
	public void setNurses_assigned(List<Nurses> nurses_assigned) {
		this.nurses_assigned = nurses_assigned;
	}
	
}
