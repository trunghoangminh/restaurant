package com.trunghoang.restaurant.services;

import com.trunghoang.restaurant.exceptions.ApplicationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default service
 *
 * @param <DTO>
 * @param <ENTITY>
 * @param <REPOSITORY>
 */
public abstract class DefaultService<DTO, ENTITY, REPOSITORY extends JpaRepository<ENTITY, Long>> implements IService<DTO> {

    @Override
    public List<DTO> findAll(int pageNumber, int numberOfRecord) {
        Pageable pageable = PageRequest.of(pageNumber, numberOfRecord);
        return convertToDTOs(getRepository().findAll(pageable).getContent());
    }

    @Override
    public DTO findById(long id) {
        Optional<ENTITY> entity = getRepository().findById(id);
        if (entity.isPresent()) {
            return convertToDTO(entity.get());
        }
        return null;
    }

    @Override
    @Transactional
    public DTO add(DTO dto) {
        ENTITY entity = getRepository().save(convertToEntity(dto));
        return convertToDTO(entity);
    }

    @Override
    @Transactional
    public DTO update(DTO dto) throws ApplicationException {
        ENTITY entity = getRepository().save(convertToEntity(dto));
        return convertToDTO(entity);
    }

    @Override
    @Transactional
    public void delete(long id) throws ApplicationException {
        getRepository().deleteById(id);
    }

    public abstract REPOSITORY getRepository();

    public abstract DTO convertToDTO(ENTITY entity);

    public abstract ENTITY convertToEntity(DTO dto);

    public abstract List<DTO> convertToDTOs(List<ENTITY> entities);
}
