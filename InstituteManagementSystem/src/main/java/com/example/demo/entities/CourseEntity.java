package com.example.demo.entities;

import java.util.Date;
import java.util.Set;

import com.example.demo.staffEnum.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	@Enumerated(EnumType.STRING)
	private Course courseName;
	private Integer duration;
	private Integer coursePrice;

	@ManyToMany
	@JoinTable(name = "enrollment", joinColumns = @JoinColumn(name = "courseId"), inverseJoinColumns = @JoinColumn(name = "studentId"))
	private Set<StudentEntity> studentSet;

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

	public Course getCourseName() {
		return courseName;
	}

	public void setCourseName(Course courseName) {
		this.courseName = courseName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Integer coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Set<StudentEntity> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<StudentEntity> studentSet) {
		this.studentSet = studentSet;
	}

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", date=" + date + ", courseName=" + courseName + ", duration=" + duration
				+ ", coursePrice=" + coursePrice + "]";
	}

}
