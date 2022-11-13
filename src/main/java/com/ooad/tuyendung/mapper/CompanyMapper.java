package com.ooad.tuyendung.mapper;

import com.ooad.tuyendung.dto.CompanyDTO;
import com.ooad.tuyendung.models.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyDTO toDto(Company companyModel) {
        CompanyDTO result = new CompanyDTO();

        result.setId(companyModel.getId());
        result.setCompanyName(companyModel.getCompanyName());
        result.setImgCover(companyModel.getImgCover());
        result.setImgAvatar(companyModel.getImgAvatar());
        result.setAddress(companyModel.getAddress());
        result.setProfileDescription(companyModel.getProfileDescription());
        result.setCompanyWebsiteUrl(companyModel.getCompanyWebsiteUrl());
        result.setIsPresent(companyModel.getIsPresent());

        result.setCreatedAt(companyModel.getCreatedAt());
        result.setUpdatedAt(companyModel.getUpdatedAt());
        result.setDeletedAt(companyModel.getDeletedAt());

        return result;
    }

    public Company toEntity(CompanyDTO companyDTO) {
        Company result = new Company();

        result.setCompanyName(companyDTO.getCompanyName());
        result.setImgCover(companyDTO.getImgCover());
        result.setImgAvatar(companyDTO.getImgAvatar());
        result.setAddress(companyDTO.getAddress());
        result.setProfileDescription(companyDTO.getProfileDescription());
        result.setCompanyWebsiteUrl(companyDTO.getCompanyWebsiteUrl());
        result.setIsPresent(companyDTO.getIsPresent());

        result.setCreatedAt(companyDTO.getCreatedAt());
        result.setUpdatedAt(companyDTO.getUpdatedAt());
        result.setDeletedAt(companyDTO.getDeletedAt());

        return result;
    }

    public CompanyDTO update(Company oldCompanyModel, Company NewCompanyModel) {
        oldCompanyModel.setCompanyName(NewCompanyModel.getCompanyName());
        oldCompanyModel.setImgCover(NewCompanyModel.getImgCover());
        oldCompanyModel.setImgAvatar(NewCompanyModel.getImgAvatar());
        oldCompanyModel.setAddress(NewCompanyModel.getAddress());
        oldCompanyModel.setProfileDescription(NewCompanyModel.getProfileDescription());
        oldCompanyModel.setCompanyWebsiteUrl(NewCompanyModel.getCompanyWebsiteUrl());
        oldCompanyModel.setIsPresent(NewCompanyModel.getIsPresent());

        oldCompanyModel.setCreatedAt(NewCompanyModel.getCreatedAt());
        oldCompanyModel.setUpdatedAt(NewCompanyModel.getUpdatedAt());
        oldCompanyModel.setDeletedAt(NewCompanyModel.getDeletedAt());

        return CompanyMapper.this.toDto(oldCompanyModel);
    }
}
