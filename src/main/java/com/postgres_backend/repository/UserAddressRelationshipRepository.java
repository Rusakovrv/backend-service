package com.postgres_backend.repository;

import com.postgres_backend.UserAddressCompositeKey;
import com.postgres_backend.UserAddressRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRelationshipRepository extends JpaRepository<UserAddressRelationship, UserAddressCompositeKey> {

}
