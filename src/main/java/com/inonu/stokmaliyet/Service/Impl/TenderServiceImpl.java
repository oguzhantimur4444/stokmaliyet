package com.inonu.stokmaliyet.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inonu.stokmaliyet.Entity.Product;
import com.inonu.stokmaliyet.Entity.PurchaseType;
import com.inonu.stokmaliyet.Entity.PurchasedUnit;
import com.inonu.stokmaliyet.Entity.Tender;
import com.inonu.stokmaliyet.Exception.Tender.TenderNotFoundException;
import com.inonu.stokmaliyet.Mapper.TenderMapper;
import com.inonu.stokmaliyet.Repository.ProductRepository;
import com.inonu.stokmaliyet.Repository.PurchaseTypeRepository;
import com.inonu.stokmaliyet.Repository.PurchasedUnitRepository;
import com.inonu.stokmaliyet.Repository.TenderRepository;
import com.inonu.stokmaliyet.Service.TenderService;
import com.inonu.stokmaliyet.dto.Request.TenderCreateRequest;
import com.inonu.stokmaliyet.dto.Response.TenderResponse;

@Service
public class TenderServiceImpl implements TenderService {

    private final TenderRepository tenderRepository;
    private final ProductRepository productRepository;
    private final PurchasedUnitRepository purchasedUnitRepository;
    private final PurchaseTypeRepository purchaseTypeRepository;
    private final TenderMapper tenderMapper;

    public TenderServiceImpl(
            TenderRepository tenderRepository,
            ProductRepository productRepository,
            PurchasedUnitRepository purchasedUnitRepository,
            PurchaseTypeRepository purchaseTypeRepository,
            TenderMapper tenderMapper) {
        this.tenderRepository = tenderRepository;
        this.productRepository = productRepository;
        this.purchasedUnitRepository = purchasedUnitRepository;
        this.purchaseTypeRepository = purchaseTypeRepository;
        this.tenderMapper = tenderMapper;
    }

    @Override
    public TenderResponse createTender(TenderCreateRequest request) {
        // Use mapper to create basic Tender object
        Tender tender = tenderMapper.toEntity(request);

        // Fetch and set Product (required)
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.productId()));
        tender.setProduct(product);

        // Fetch and set PurchasedUnit (optional)
        if (request.purchasedUnitId() != null) {
            PurchasedUnit purchasedUnit = purchasedUnitRepository.findById(request.purchasedUnitId())
                    .orElseThrow(() -> new RuntimeException("PurchasedUnit not found with id: " + request.purchasedUnitId()));
            tender.setPurchasedUnit(purchasedUnit);
        }

        // Fetch and set PurchaseType (optional)
        if (request.purchaseTypeId() != null) {
            PurchaseType purchaseType = purchaseTypeRepository.findById(request.purchaseTypeId())
                    .orElseThrow(() -> new RuntimeException("PurchaseType not found with id: " + request.purchaseTypeId()));
            tender.setPurchaseType(purchaseType);
        }

        // Calculate and set remaining quantity and total amount
        if (tender.getTenderQuantity() != null) {
            tender.setRemainingQuantityInTender(tender.getTenderQuantity());
        }
        if (tender.getTenderQuantity() != null && tender.getUnitPrice() != null) {
            tender.setTotalAmount(tender.getTenderQuantity() * tender.getUnitPrice());
        }

        Tender saved = tenderRepository.save(tender);
        return tenderMapper.toResponse(saved);
    }

    @Override
    public List<TenderResponse> getAllTenders() {
        List<Tender> tenders = tenderRepository.findAll();
        return tenderMapper.toResponseList(tenders);
    }

    @Override
    public List<TenderResponse> getAllActiveTenders() {
        List<Tender> activeTenders = tenderRepository.findTenderByActiveTrue();
        return tenderMapper.toResponseList(activeTenders);
    }

    @Override
    public TenderResponse updateTenderRemainingQuantity(Long tenderId, Double quantity) {
        Tender tender = getTenderById(tenderId);
        tender.setRemainingQuantityInTender(quantity);
        Tender updated = tenderRepository.save(tender);
        return tenderMapper.toResponse(updated);
    }

    @Override
    public Tender getTenderById(Long id) {
        return tenderRepository.findById(id)
                .orElseThrow(() -> new TenderNotFoundException("Tender not found with id: " + id));
    }

    @Override
    public TenderResponse increaseTenderByTwentyPercent(Long tenderId, Double increasedQuantity) {
        Tender tender = getTenderById(tenderId);
        // Implementation for increasing tender by percentage
        // This is a placeholder - implement actual business logic as needed
        Tender updated = tenderRepository.save(tender);
        return tenderMapper.toResponse(updated);
    }

    @Override
    public void handleTendersAtYearEnd() {
        // Implementation for handling tenders at year end
        // This is a placeholder - implement actual business logic as needed
    }

    @Override
    public List<TenderResponse> getTenderByProductAndCompany() {
        // Implementation for getting tenders by product and company
        // This is a placeholder - implement actual business logic as needed
        List<Tender> tenders = tenderRepository.findAll();
        return tenderMapper.toResponseList(tenders);
    }

    @Override
    public TenderResponse updateTender(Long tenderId, TenderCreateRequest request) {
        Tender tender = getTenderById(tenderId);

        // Update basic fields using mapper
        Tender updatedTender = tenderMapper.toEntity(request);
        tender.setTenderQuantity(updatedTender.getTenderQuantity());
        tender.setStartDate(updatedTender.getStartDate());
        tender.setEndDate(updatedTender.getEndDate());
        tender.setUnitPrice(updatedTender.getUnitPrice());
        tender.setCompanyName(updatedTender.getCompanyName());

        // Update Product (required)
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.productId()));
        tender.setProduct(product);

        // Update PurchasedUnit (optional)
        if (request.purchasedUnitId() != null) {
            PurchasedUnit purchasedUnit = purchasedUnitRepository.findById(request.purchasedUnitId())
                    .orElseThrow(() -> new RuntimeException("PurchasedUnit not found with id: " + request.purchasedUnitId()));
            tender.setPurchasedUnit(purchasedUnit);
        } else {
            tender.setPurchasedUnit(null);
        }

        // Update PurchaseType (optional)
        if (request.purchaseTypeId() != null) {
            PurchaseType purchaseType = purchaseTypeRepository.findById(request.purchaseTypeId())
                    .orElseThrow(() -> new RuntimeException("PurchaseType not found with id: " + request.purchaseTypeId()));
            tender.setPurchaseType(purchaseType);
        } else {
            tender.setPurchaseType(null);
        }

        // Recalculate total amount
        if (tender.getTenderQuantity() != null && tender.getUnitPrice() != null) {
            tender.setTotalAmount(tender.getTenderQuantity() * tender.getUnitPrice());
        }

        Tender saved = tenderRepository.save(tender);
        return tenderMapper.toResponse(saved);
    }

    @Override
    public TenderResponse deleteTender(Long tenderId) {
        Tender tender = getTenderById(tenderId);
        tenderRepository.delete(tender);
        return tenderMapper.toResponse(tender);
    }
}
