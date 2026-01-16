package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inonu.stokmaliyet.Entity.YemekRecetesi;
import com.inonu.stokmaliyet.Enum.YemekTipi;
import java.util.List;

public interface YemekRecetesiRepository extends JpaRepository<YemekRecetesi, Long> {
    YemekRecetesi findByAdi(String adi);

    List<YemekRecetesi> findByTipi(YemekTipi tipi);
}
