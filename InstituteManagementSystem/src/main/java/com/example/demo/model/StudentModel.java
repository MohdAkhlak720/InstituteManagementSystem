package com.example.demo.model;

import java.util.Set;

public class StudentModel {
	private Long id;
	private String name;
	private String fatherName;
	private Integer age;
	private Integer className;
	private Integer pincode;
	private String address;
	private Long phone;
	private Set<FeeModel> feeModel;
	private Set<CourseModel> courseModel;

	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentModel(Long id, String name, String fatherName, Integer age, Integer className, Integer pincode,
			String address, Long phone, Set<FeeModel> feeModel, Set<CourseModel> courseModel) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.age = age;
		this.className = className;
		this.pincode = pincode;
		this.address = address;
		this.phone = phone;
		this.feeModel = feeModel;
		this.courseModel = courseModel;
	}

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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getClassName() {
		return className;
	}

	public void setClassName(Integer className) {
		this.className = className;
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

	public Set<FeeModel> getFeeModel() {
		return feeModel;
	}

	public void setFeeModel(Set<FeeModel> feeModel) {
		this.feeModel = feeModel;
	}

	public Set<CourseModel> getCourseModel() {
		return courseModel;
	}

	public void setCourseModel(Set<CourseModel> courseModel) {
		this.courseModel = courseModel;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", age=" + age
				+ ", className=" + className + ", pincode=" + pincode + ", address=" + address + ", phone=" + phone
				+ ", feeModel=" + feeModel + ", courseModel=" + courseModel + "]";
	}

}
