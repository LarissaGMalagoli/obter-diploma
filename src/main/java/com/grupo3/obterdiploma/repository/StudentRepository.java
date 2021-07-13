package com.grupo3.obterdiploma.repository;

import com.grupo3.obterdiploma.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
