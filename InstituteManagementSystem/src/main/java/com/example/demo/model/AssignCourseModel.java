package com.example.demo.model;

public class AssignCourseModel {
	private Long id;
	private Long studentId;
	private Long courseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "AssignCourseModel [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + "]";
	}

}
