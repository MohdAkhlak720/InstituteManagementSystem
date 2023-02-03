package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "result")
public class ResultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
