package com.tyss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
