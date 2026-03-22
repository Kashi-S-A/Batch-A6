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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(unique = true)
	private String email;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updateDate;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "stud_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
