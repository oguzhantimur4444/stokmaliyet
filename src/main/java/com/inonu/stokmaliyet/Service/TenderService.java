package com.inonu.stokmaliyet.Service;

import java.util.List;

import com.inonu.stokmaliyet.Entity.Tender;
import com.inonu.stokmaliyet.dto.Request.TenderCreateRequest;
import com.inonu.stokmaliyet.dto.Response.TenderResponse;

public interface TenderService {

    TenderResponse createTender(TenderCreateRequest request);

    List<TenderResponse> getAllTenders();

    List<TenderResponse> getAllActiveTenders();

    TenderResponse updateTenderRemainingQuantity(Long tenderId, Double quantity);

    Tender getTenderById(Long id);

    TenderResponse increaseTenderByTwentyPercent(Long tenderId, Double increasedQuantity);

    void handleTendersAtYearEnd();

    List<TenderResponse> getTenderByProductAndCompany();

    TenderResponse updateTender(Long tenderId, TenderCreateRequest request);

    TenderResponse deleteTender(Long tenderId);
}
