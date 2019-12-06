package com.trunghoang.restaurant.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.trunghoang.restaurant.exceptions.ApplicationException;
import com.trunghoang.restaurant.repositories.IRepository;

/**
 * 
 * Default service
 *
 * @param <DTO>
 * @param <ENTITY>
 * @param <REPOSITORY>
 */
public abstract class DefaultService<DTO, ENTITY, REPOSITORY extends IRepository<ENTITY>> implements IService<DTO> {

	@Override
	public List<DTO> findAll(int pageNumber, int numberOfRecord) {
		return convertToDTOs(getRepository().getAll(pageNumber, numberOfRecord));
	}

	@Override
	public DTO findById(long id) {
		return convertToDTO(getRepository().findById(id));
	}

	@Override
	@Transactional
	public void add(DTO dto) {
		getRepository().add(convertToEntity(dto));
	}

	@Override
	@Transactional
	public void update(DTO dto) {
		getRepository().update(convertToEntity(dto));
	}

	@Override
	@Transactional
	public void delete(long id) throws ApplicationException {
		getRepository().delete(id);
	}

	public abstract REPOSITORY getRepository();

	public abstract DTO convertToDTO(ENTITY entity);

	public abstract ENTITY convertToEntity(DTO dto);

	public abstract List<DTO> convertToDTOs(List<ENTITY> entities);
}
