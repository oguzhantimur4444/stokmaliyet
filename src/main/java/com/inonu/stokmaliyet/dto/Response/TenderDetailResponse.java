package com.inonu.stokmaliyet.dto.Response;

import java.util.List;

public record TenderDetailResponse(
                String formName,
                Double totalAmount,
                List<TenderProductDetailResponse> products) {
}
