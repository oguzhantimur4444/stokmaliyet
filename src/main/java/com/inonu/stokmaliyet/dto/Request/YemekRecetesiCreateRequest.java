package com.inonu.stokmaliyet.dto.Request;

import com.inonu.stokmaliyet.Enum.YemekTipi;

public record YemekRecetesiCreateRequest(
        String adi,
        String aciklama,
        String receteDetaylari,
        YemekTipi tipi) {
}
