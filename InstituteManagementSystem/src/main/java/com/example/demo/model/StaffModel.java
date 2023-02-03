package com.example.demo.model;

import com.example.demo.staffEnum.Staff;

public class StaffModel {
	private Long id;
	private String name;
	private Integer age;
	private Staff staff;
	private Integer pincode;
	private String address;
	private Long phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StaffModel [id=" + id + ", name=" + name + ", age=" + age + ", staff=" + staff + ", pincode=" + pincode
				+ ", address=" + address + ", phone=" + phone + "]";
	}

}
