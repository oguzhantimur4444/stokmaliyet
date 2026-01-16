package com.inonu.stokmaliyet.Mapper;

import com.inonu.stokmaliyet.Entity.Refectory;
import com.inonu.stokmaliyet.dto.Response.RefectoryResponse;
import com.inonu.stokmaliyet.dto.Request.RefectoryCreateRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RefectoryMapper {

    public RefectoryResponse toResponse(Refectory refectory) {
        if (refectory == null) {
            return null;
        }
        return new RefectoryResponse(
                refectory.getId(),
                refectory.getName());
    }

    public List<RefectoryResponse> toResponseList(List<Refectory> refectoryList) {
        if (refectoryList == null) {
            return null;
        }
        return refectoryList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Refectory toEntity(RefectoryCreateRequest request) {
        if (request == null) {
            return null;
        }
        Refectory refectory = new Refectory();
        refectory.setName(request.name());
        return refectory;
    }
}