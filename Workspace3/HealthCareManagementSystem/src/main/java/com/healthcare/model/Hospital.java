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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hospital")
@Setter
@Getter
@NoArgsConstructor
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hospitalid")
	@SequenceGenerator(initialValue = 1,name="hospitalid",allocationSize = 1)
	private int hospitalid;
	private String name;
	private String place;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OperationTheatre> operationtheatre;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ward> ward;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Surgeon> surgeons;
	@OneToMany(cascade = CascadeType.ALL)
	public List<Patient> patient;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Nurses> nurses;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PatientOperation> patientOperations;
	public int getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public List<OperationTheatre> getOperationtheatre() {
		return operationtheatre;
	}
	public void setOperationtheatre(List<OperationTheatre> operationtheatre) {
		this.operationtheatre = operationtheatre;
	}
	public List<Ward> getWard() {
		return ward;
	}
	public void setWard(List<Ward> ward) {
		this.ward = ward;
	}
	public List<Surgeon> getSurgeons() {
		return surgeons;
	}
	public void setSurgeons(List<Surgeon> surgeons) {
		this.surgeons = surgeons;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}
	public List<Nurses> getNurses() {
		return nurses;
	}
	public void setNurses(List<Nurses> nurses) {
		this.nurses = nurses;
	}
	public List<PatientOperation> getPatientOperations() {
		return patientOperations;
	}
	public void setPatientOperations(List<PatientOperation> patientOperations) {
		this.patientOperations = patientOperations;
	}
	
}
