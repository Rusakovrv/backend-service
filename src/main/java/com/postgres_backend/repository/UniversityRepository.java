package com.postgres_backend.repository;

import com.postgres_backend.model.Student;
import com.postgres_backend.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
