package com.postgres_backend.repository;

import com.postgres_backend.CompositeID;
import com.postgres_backend.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, CompositeID> {

	List<User> findAll();
}
