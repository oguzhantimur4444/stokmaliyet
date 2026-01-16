package com.inonu.stokmaliyet.Service;

import java.util.List;

import com.inonu.stokmaliyet.Entity.Refectory;
import com.inonu.stokmaliyet.dto.Request.RefectoryCreateRequest;
import com.inonu.stokmaliyet.dto.Response.RefectoryResponse;

public interface RefectoryService {
    List<RefectoryResponse> getAllRefectories();

    RefectoryResponse createRefectory(RefectoryCreateRequest request);

    RefectoryResponse updateRefectory(Long id, RefectoryCreateRequest request);

    Refectory getRefectoryById(Long id);

    RefectoryResponse deleteRefectory(Long id);
}
