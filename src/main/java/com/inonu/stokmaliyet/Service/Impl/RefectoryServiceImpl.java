package com.inonu.stokmaliyet.Service.Impl;

import org.springframework.stereotype.Service;

import com.inonu.stokmaliyet.dto.Response.RefectoryResponse;
import com.inonu.stokmaliyet.Entity.Refectory;
import com.inonu.stokmaliyet.Exception.Refectory.RefectoryAlreadyExistsException;
import com.inonu.stokmaliyet.Exception.Refectory.RefectoryNotFoundException;
import com.inonu.stokmaliyet.Service.RefectoryService;
import com.inonu.stokmaliyet.dto.Request.RefectoryCreateRequest;
import com.inonu.stokmaliyet.Repository.RefectoryRepository;
import com.inonu.stokmaliyet.Mapper.RefectoryMapper;

import java.util.List;

@Service
public class RefectoryServiceImpl implements RefectoryService {

    private final RefectoryRepository refectoryRepository;
    private final RefectoryMapper refectoryMapper;

    public RefectoryServiceImpl(RefectoryRepository refectoryRepository, RefectoryMapper refectoryMapper) {
        this.refectoryRepository = refectoryRepository;
        this.refectoryMapper = refectoryMapper;
    }

    @Override
    public List<RefectoryResponse> getAllRefectories() {
        List<Refectory> categories = refectoryRepository.findAll();
        return refectoryMapper.toResponseList(categories);
    }

    @Override
    public RefectoryResponse createRefectory(RefectoryCreateRequest refectoryCreateRequest) {

        Refectory existing = getRefectoryByName(refectoryCreateRequest.name());
        if (existing != null) {
            throw new RefectoryAlreadyExistsException(
                    "Bu isimde bir Kategori zaten mevcut: " + refectoryCreateRequest.name());
        }

        Refectory refectory = refectoryMapper.toEntity(refectoryCreateRequest);
        Refectory toSave = refectoryRepository.save(refectory);

        return refectoryMapper.toResponse(toSave);
    }

    private Refectory getRefectoryByName(String name) {
        return refectoryRepository.findByName(name);
    }

    @Override
    public RefectoryResponse updateRefectory(Long id, RefectoryCreateRequest refectoryCreateRequest) {
        Refectory refectory = getRefectoryById(id);
        
        // Check if name already exists for another refectory
        Refectory existing = getRefectoryByName(refectoryCreateRequest.name());
        if (existing != null && !existing.getId().equals(id)) {
            throw new RefectoryAlreadyExistsException(
                    "Bu isimde bir Refectory zaten mevcut: " + refectoryCreateRequest.name());
        }
        
        refectory.setName(refectoryCreateRequest.name());
        Refectory updated = refectoryRepository.save(refectory);
        return refectoryMapper.toResponse(updated);
    }

    @Override
    public Refectory getRefectoryById(Long refectoryId) {
        return refectoryRepository.findById(refectoryId)
                .orElseThrow(() -> new RefectoryNotFoundException("Refectory Not Found by id: " + refectoryId));
    }

    @Override
    public RefectoryResponse deleteRefectory(Long refectoryId) {
        Refectory refectory = getRefectoryById(refectoryId);
        refectoryRepository.delete(refectory);
        return refectoryMapper.toResponse(refectory);
    }
}
