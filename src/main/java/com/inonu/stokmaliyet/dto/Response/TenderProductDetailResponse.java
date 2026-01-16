package com.inonu.stokmaliyet.dto.Response;

public record TenderProductDetailResponse(

                Long tenderId,
                String productName,
                String unitName,
                Double tenderQuantity,
                Double remainingQuantityInTender,
                boolean increased,
                Double unitPrice,
                Double totalAmount

) {
}
