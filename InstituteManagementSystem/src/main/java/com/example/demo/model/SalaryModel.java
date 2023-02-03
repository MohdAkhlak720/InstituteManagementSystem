package com.example.demo.model;

import java.util.Date;

public class SalaryModel {
	private Long id;
	private Date date;
	private Long salary;
	private Long staffId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return "SalaryModel [id=" + id + ", date=" + date + ", salary=" + salary + ", staffId=" + staffId + "]";
	}

}
