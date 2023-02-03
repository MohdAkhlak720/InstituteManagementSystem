package com.example.demo.model;

import java.util.Date;

public class FeeModel {
	private Long id;
	private Date date;
	private Long fee;
	private Long studentId;

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

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "FeeModel [id=" + id + ", date=" + date + ", fee=" + fee + ", studentId=" + studentId + "]";
	}

}
