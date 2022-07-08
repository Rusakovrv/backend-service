package com.postgres_backend.repository;

import com.postgres_backend.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<T extends Base> extends JpaRepository<T, Long> {

	@Query(value = "SELECT * FROM #{#entityName} WHERE id IN :ids", nativeQuery = true)
	List<T> find(@Param("ids") List<Long> ids);

}
