package com.example.demo.entities;

import java.util.List;

import com.example.demo.staffEnum.Staff;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Staff staff;
	private Integer pincode;
	private String address;
	private Long phone;

	@OneToMany(mappedBy = "staffEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SalaryEntity> entities;

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

	public List<SalaryEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<SalaryEntity> entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "StaffEntity [id=" + id + ", name=" + name + ", age=" + age + ", staff=" + staff + ", pincode=" + pincode
				+ ", address=" + address + ", phone=" + phone + ", entities=" + entities + "]";
	}

}
