package com.healthcare.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="patientOpertion")
public class PatientOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "opertionid")
	@SequenceGenerator(initialValue = 1,name="operationid",allocationSize = 1)
	private int operationid;
	private String name;
	private String type;
	@OneToOne(cascade = CascadeType.ALL)
	private OperationTheatre op;
	@OneToOne(cascade = CascadeType.ALL)
	private Patient patientid;
	@OneToOne(cascade = CascadeType.ALL)
	private Surgeon surgeonid;
	private int cost_of_opertion;
	public int getOperationid() {
		return operationid;
	}
	public void setOperationid(int operationid) {
		this.operationid = operationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Patient getPatientid() {
		return patientid;
	}
	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}
	public Surgeon getSurgeonid() {
		return surgeonid;
	}
	public void setSurgeonid(Surgeon surgeonid) {
		this.surgeonid = surgeonid;
	}
	public int getCost_of_opertion() {
		return cost_of_opertion;
	}
	public void setCost_of_opertion(int cost_of_opertion) {
		this.cost_of_opertion = cost_of_opertion;
	}
	public OperationTheatre getOp() {
		return op;
	}
	public void setOp(OperationTheatre op) {
		this.op = op;
	}
	
	
}
