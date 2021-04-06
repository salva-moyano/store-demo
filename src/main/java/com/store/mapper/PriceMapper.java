package com.store.mapper;

import com.store.api.model.PriceResponse;
import com.store.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Mapper(componentModel = "spring")
public interface PriceMapper {

    String FORMAT_DATE = "yyyy-MM-dd HH:mm";

    @Mappings({
          @Mapping(target = "startDate", source = "startDate", qualifiedByName = "mapLocalDateTimeToString"),
          @Mapping(target = "endDate", source = "endDate", qualifiedByName = "mapLocalDateTimeToString")
    })
    PriceResponse mapToResponse(PriceEntity priceEntity);

    @Named("mapLocalDateTimeToString")
    static String mapLocalDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return localDateTime.format(formatter);
    }
}
