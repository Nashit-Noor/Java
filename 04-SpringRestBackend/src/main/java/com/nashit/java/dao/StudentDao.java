package com.nashit.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashit.java.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

}
