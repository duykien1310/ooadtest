package com.ooad.tuyendung.mapper;

import com.ooad.tuyendung.dto.BusinessStreamDTO;
import com.ooad.tuyendung.models.BusinessStream;
import org.springframework.stereotype.Component;

@Component
public class BusinessStreamMapper {
    public BusinessStreamDTO toDto(BusinessStream businessStream) {
        BusinessStreamDTO result = new BusinessStreamDTO();

        result.setId(businessStream.getId());
        result.setName(businessStream.getName());
        result.setIsPresent(businessStream.getIsPresent());
        result.setCreatedAt(businessStream.getCreatedAt());
        result.setUpdatedAt(businessStream.getUpdatedAt());
        result.setDeletedAt(businessStream.getDeletedAt());

        return result;
    }

    public BusinessStream toEntity(BusinessStreamDTO businessStreamDTO) {
        BusinessStream result = new BusinessStream();

        result.setName(businessStreamDTO.getName());
        result.setIsPresent(businessStreamDTO.getIsPresent());
        result.setCreatedAt(businessStreamDTO.getCreatedAt());
        result.setUpdatedAt(businessStreamDTO.getUpdatedAt());
        result.setDeletedAt(businessStreamDTO.getDeletedAt());

        return result;
    }
}
