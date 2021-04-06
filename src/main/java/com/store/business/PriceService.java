package com.store.business;

import com.store.api.model.PriceResponse;
import com.store.business.exception.PriceNotFoundException;
import com.store.business.exception.StoreException;
import com.store.business.model.Price;
import com.store.mapper.PriceMapper;
import com.store.persistence.entity.PriceEntity;
import com.store.persistence.repository.PriceEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceEntityRepository priceEntityRepository;
    private final PriceMapper priceMapper;


    public PriceResponse getProduct(LocalDateTime date, int productIdentity, int stringIdentity) throws StoreException  {

        try {
            List<PriceEntity> prices = priceEntityRepository.findAll();
            PriceEntity pricesEntity = prices.stream()
                                             .filter(p -> stringIdentity == p.getBrand().getId())
                                             .filter(p -> productIdentity == p.getProductId())
                                             .filter(p -> !date.isBefore(p.getStartDate()))
                                             .filter(p -> !date.isAfter(p.getEndDate()))
                                             .max((Comparator.comparingInt(PriceEntity::getPriority)))
                                             .orElseThrow(()-> new PriceNotFoundException("Price Not found in our system with this criteria"));
            return priceMapper.mapToResponse(pricesEntity);
        } catch (DataAccessException e) {
            throw new StoreException("Unexpected DB error", e);
        }
    }

}
