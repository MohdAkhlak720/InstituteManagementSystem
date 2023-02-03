package com.example.demo.model;

import java.util.Date;

import com.example.demo.staffEnum.Course;

public class CourseModel {
	private Long id;
	private Date date;
	private Course courseName;
	private Integer duration;
	private Integer coursePrice;
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

	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", date=" + date + ", courseName=" + courseName + ", duration=" + duration
				+ ", coursePrice=" + coursePrice + ", studentId=" + studentId + "]";
	}

}
