package com.postgres_backend.repository;

import com.postgres_backend.Address;
import com.postgres_backend.CompositeID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, CompositeID> {

	Address save(Address address);

}
