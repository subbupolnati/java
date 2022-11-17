package com.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operationtheatre")
public class OperationTheatre {

	@Id
	private int operationid;

	public int getOperationid() {
		return operationid;
	}

	public void setOperationid(int operationid) {
		this.operationid = operationid;
	}

	public OperationTheatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationTheatre(int operationid) {
		super();
		this.operationid = operationid;
	}
}
