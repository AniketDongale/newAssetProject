package com.company.dto;

import javax.validation.constraints.Min;

public class EmployeeDto2 {
	
	@Min(value = 0,message = "Put valid Employee id ")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
