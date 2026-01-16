package com.inonu.stokmaliyet.Mapper;

import com.inonu.stokmaliyet.Entity.Tender;
import com.inonu.stokmaliyet.dto.Request.TenderCreateRequest;
import com.inonu.stokmaliyet.dto.Response.TenderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TenderMapper {

    public TenderResponse toResponse(Tender tender) {
        if (tender == null) {
            return null;
        }
        return new TenderResponse(
                tender.getId(),
                tender.getTenderQuantity(),
                tender.getRemainingQuantityInTender(),
                tender.getStartDate(),
                tender.getEndDate(),
                tender.isIncreased(),
                tender.getIncreaseAmount(),
                tender.isActive(),
                tender.getUnitPrice(),
                tender.getTotalAmount(),
                tender.getCompanyName(),
                tender.getProduct() != null ? tender.getProduct().getId() : null,
                tender.getProduct() != null ? tender.getProduct().getName() : null,
                tender.getProduct() != null && tender.getProduct().getMeasurementType() != null 
                        ? tender.getProduct().getMeasurementType().getName() : null,
                tender.getPurchasedUnit() != null ? tender.getPurchasedUnit().getName() : null,
                tender.getPurchaseType() != null ? tender.getPurchaseType().getName() : null,
                tender.getTenderType() != null ? tender.getTenderType().name() : null);
    }

    public List<TenderResponse> toResponseList(List<Tender> tenderList) {
        if (tenderList == null) {
            return null;
        }
        return tenderList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Tender toEntity(TenderCreateRequest request) {
        if (request == null) {
            return null;
        }
        Tender tender = new Tender();
        tender.setTenderQuantity(request.tenderQuantity());
        tender.setStartDate(request.startDate());
        tender.setEndDate(request.endDate());
        tender.setUnitPrice(request.unitPrice());
        tender.setCompanyName(request.companyName());
        // Note: product, purchasedUnit, and purchaseType should be set in the service
        // as they require repository lookups
        return tender;
    }
}
