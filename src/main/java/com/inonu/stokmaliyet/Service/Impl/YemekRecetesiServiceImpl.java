package com.inonu.stokmaliyet.Service.Impl;

import org.springframework.stereotype.Service;

import com.inonu.stokmaliyet.Entity.YemekRecetesi;
import com.inonu.stokmaliyet.Enum.YemekTipi;
import com.inonu.stokmaliyet.Exception.YemekRecetesi.YemekRecetesiAlreadyExistsException;
import com.inonu.stokmaliyet.Exception.YemekRecetesi.YemekRecetesiNotFoundException;
import com.inonu.stokmaliyet.Repository.YemekRecetesiRepository;
import com.inonu.stokmaliyet.Service.YemekRecetesiService;
import com.inonu.stokmaliyet.dto.Request.YemekRecetesiCreateRequest;
import com.inonu.stokmaliyet.dto.Response.YemekRecetesiResponse;
import com.inonu.stokmaliyet.Mapper.YemekRecetesiMapper;

import java.util.List;

@Service
public class YemekRecetesiServiceImpl implements YemekRecetesiService {

    private final YemekRecetesiRepository yemekRecetesiRepository;
    private final YemekRecetesiMapper yemekRecetesiMapper;

    public YemekRecetesiServiceImpl(YemekRecetesiRepository yemekRecetesiRepository, YemekRecetesiMapper yemekRecetesiMapper) {
        this.yemekRecetesiRepository = yemekRecetesiRepository;
        this.yemekRecetesiMapper = yemekRecetesiMapper;
    }

    @Override
    public List<YemekRecetesiResponse> getAllYemekReceteleri() {
        List<YemekRecetesi> receteler = yemekRecetesiRepository.findAll();
        return yemekRecetesiMapper.toResponseList(receteler);
    }

    @Override
    public List<YemekRecetesiResponse> getYemekReceteleriByTipi(YemekTipi tipi) {
        List<YemekRecetesi> receteler = yemekRecetesiRepository.findByTipi(tipi);
        return yemekRecetesiMapper.toResponseList(receteler);
    }

    @Override
    public YemekRecetesiResponse createYemekRecetesi(YemekRecetesiCreateRequest request) {
        YemekRecetesi existing = yemekRecetesiRepository.findByAdi(request.adi());
        if (existing != null) {
            throw new YemekRecetesiAlreadyExistsException(
                    "Bu isimde bir yemek reçetesi zaten mevcut: " + request.adi());
        }

        YemekRecetesi yemekRecetesi = yemekRecetesiMapper.toEntity(request);

        YemekRecetesi saved = yemekRecetesiRepository.save(yemekRecetesi);
        return yemekRecetesiMapper.toResponse(saved);
    }

    @Override
    public YemekRecetesiResponse updateYemekRecetesi(Long id, YemekRecetesiCreateRequest request) {
        YemekRecetesi yemekRecetesi = getYemekRecetesiById(id);

        // Aynı isimde başka bir reçete varsa kontrol et
        YemekRecetesi existing = yemekRecetesiRepository.findByAdi(request.adi());
        if (existing != null && !existing.getId().equals(id)) {
            throw new YemekRecetesiAlreadyExistsException(
                    "Bu isimde bir yemek reçetesi zaten mevcut: " + request.adi());
        }

        yemekRecetesi.setAdi(request.adi());
        yemekRecetesi.setAciklama(request.aciklama());
        yemekRecetesi.setReceteDetaylari(request.receteDetaylari());
        yemekRecetesi.setTipi(request.tipi());

        YemekRecetesi updated = yemekRecetesiRepository.save(yemekRecetesi);
        return yemekRecetesiMapper.toResponse(updated);
    }

    @Override
    public YemekRecetesiResponse deleteYemekRecetesi(Long id) {
        YemekRecetesi yemekRecetesi = getYemekRecetesiById(id);
        yemekRecetesiRepository.delete(yemekRecetesi);
        return yemekRecetesiMapper.toResponse(yemekRecetesi);
    }

    @Override
    public YemekRecetesi getYemekRecetesiById(Long id) {
        return yemekRecetesiRepository.findById(id)
                .orElseThrow(() -> new YemekRecetesiNotFoundException("Yemek reçetesi bulunamadı: " + id));
    }

}
