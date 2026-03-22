package com.tyss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
