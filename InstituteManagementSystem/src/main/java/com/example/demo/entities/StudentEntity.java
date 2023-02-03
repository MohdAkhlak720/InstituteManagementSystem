package com.example.demo.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String fatherName;
	private Integer age;
	private Integer className;
	private Integer pincode;
	private String address;
	private Long phone;

	@OneToMany(mappedBy = "studentEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FeeEntity> feeEntities;

	@ManyToMany(mappedBy = "studentSet")
	private Set<CourseEntity> courseSet;

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

	public List<FeeEntity> getFeeEntities() {
		return feeEntities;
	}

	public void setFeeEntities(List<FeeEntity> feeEntities) {
		this.feeEntities = feeEntities;
	}

	public Set<CourseEntity> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<CourseEntity> courseSet) {
		this.courseSet = courseSet;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", age=" + age
				+ ", className=" + className + ", pincode=" + pincode + ", address=" + address + ", phone=" + phone
				+ ", feeEntities=" + feeEntities + ", courseSet=" + courseSet + "]";
	}

}
