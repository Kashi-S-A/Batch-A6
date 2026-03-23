package com.tyss.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

	Integer countByUserUid(Integer uid);
	
	List<Course> findByUserUid(Integer uid);
}
