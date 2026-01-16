package com.inonu.stokmaliyet.Service;

import java.util.List;

import com.inonu.stokmaliyet.dto.Request.YemekRecetesiCreateRequest;
import com.inonu.stokmaliyet.dto.Response.YemekRecetesiResponse;
import com.inonu.stokmaliyet.Entity.YemekRecetesi;
import com.inonu.stokmaliyet.Enum.YemekTipi;

public interface YemekRecetesiService {
    List<YemekRecetesiResponse> getAllYemekReceteleri();

    List<YemekRecetesiResponse> getYemekReceteleriByTipi(YemekTipi tipi);

    YemekRecetesiResponse createYemekRecetesi(YemekRecetesiCreateRequest request);

    YemekRecetesiResponse updateYemekRecetesi(Long id, YemekRecetesiCreateRequest request);

    YemekRecetesiResponse deleteYemekRecetesi(Long id);

    YemekRecetesi getYemekRecetesiById(Long id);
}
