package com.inonu.stokmaliyet.Mapper;

import com.inonu.stokmaliyet.Entity.YemekRecetesi;
import com.inonu.stokmaliyet.dto.Request.YemekRecetesiCreateRequest;
import com.inonu.stokmaliyet.dto.Response.YemekRecetesiResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class YemekRecetesiMapper {

    public YemekRecetesiResponse toResponse(YemekRecetesi yemekRecetesi) {
        if (yemekRecetesi == null) {
            return null;
        }
        return new YemekRecetesiResponse(
                yemekRecetesi.getId(),
                yemekRecetesi.getAdi(),
                yemekRecetesi.getAciklama(),
                yemekRecetesi.getReceteDetaylari(),
                yemekRecetesi.getTipi());
    }

    public List<YemekRecetesiResponse> toResponseList(List<YemekRecetesi> yemekRecetesiList) {
        if (yemekRecetesiList == null) {
            return null;
        }
        return yemekRecetesiList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public YemekRecetesi toEntity(YemekRecetesiCreateRequest request) {
        if (request == null) {
            return null;
        }
        YemekRecetesi yemekRecetesi = new YemekRecetesi();
        yemekRecetesi.setAdi(request.adi());
        yemekRecetesi.setAciklama(request.aciklama());
        yemekRecetesi.setReceteDetaylari(request.receteDetaylari());
        yemekRecetesi.setTipi(request.tipi());
        return yemekRecetesi;
    }
}
