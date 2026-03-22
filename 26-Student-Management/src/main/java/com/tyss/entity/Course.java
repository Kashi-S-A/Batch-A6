package com.tyss.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String duration;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updateDate;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
}
