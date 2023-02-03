package com.example.demo.response;

import java.util.Date;
import java.util.List;

public class Response {
	private Date date;
	private List<String> errorMessage;
	private Object data;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(Date date, List<String> errorMessage, Object data) {
		super();
		this.date = date;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [date=" + date + ", errorMessage=" + errorMessage + ", data=" + data + "]";
	}

}
