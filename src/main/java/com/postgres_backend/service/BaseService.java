package com.postgres_backend.service;

import com.postgres_backend.model.Base;
import com.postgres_backend.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  BaseService <T extends Base> {

	private final BaseRepository<T> baseRepository;

	public List<T> getList(List<Long> ids)

	{
		return baseRepository.find(ids);
	}

}
