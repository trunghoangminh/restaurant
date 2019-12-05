package com.trunghoang.restaurant.services;

import java.util.List;

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
	public List<DTO> findAll() {
		return convertToDTOs(getRepository().getAll());
	}

	@Override
	public DTO findById(long id) {
		return convertToDTO(getRepository().findById(id));
	}

	@Override
	public void add(DTO dto) {
		getRepository().add(convertToEntity(dto));
	}

	@Override
	public void update(DTO dto) {
		getRepository().update(convertToEntity(dto));
	}

	@Override
	public void delete(DTO dto) {
		getRepository().delete(convertToEntity(dto));
	}

	public abstract REPOSITORY getRepository();

	public abstract DTO convertToDTO(ENTITY entity);

	public abstract ENTITY convertToEntity(DTO dto);

	public abstract List<DTO> convertToDTOs(List<ENTITY> entities);
}
