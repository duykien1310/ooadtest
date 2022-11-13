package com.ooad.tuyendung.mapper;

import com.ooad.tuyendung.dto.SeekerProfileDTO;
import com.ooad.tuyendung.models.SeekerProfile;
import org.springframework.stereotype.Component;

@Component
public class SeekerMapper {

    public SeekerProfileDTO toDto(SeekerProfile seekerProfile) {
        SeekerProfileDTO result = new SeekerProfileDTO();

        result.setId(seekerProfile.getId());
        result.setFullName(seekerProfile.getFullName());
        result.setEmail(seekerProfile.getEmail());
        result.setGender(seekerProfile.getGender());
        result.setDateOfBirth(seekerProfile.getDateOfBirth());
        result.setContactNumber(seekerProfile.getContactNumber());
        result.setUserImage(seekerProfile.getUserImage());

        result.setUniversityName(seekerProfile.getUniversityName());
        result.setMajor(seekerProfile.getMajor());
        result.setStartDate(seekerProfile.getStartDate());
        result.setEndDate(seekerProfile.getEndDate());
        result.setGpa(seekerProfile.getGpa());

        result.setSkillDescription(seekerProfile.getSkillDescription());
        result.setProductName(seekerProfile.getProductName());
        result.setProductDescription(seekerProfile.getProductDescription());
        result.setSocialActivitiesDescription(seekerProfile.getSocialActivitiesDescription());

        result.setIsPresent(seekerProfile.getIsPresent());
        result.setCreatedAt(seekerProfile.getCreatedAt());
        result.setUpdatedAt(seekerProfile.getUpdatedAt());
        result.setDeletedAt(seekerProfile.getDeletedAt());

        return result;
    }

    public SeekerProfile toEntity(SeekerProfileDTO seekerProfileDTO) {
        SeekerProfile result = new SeekerProfile();

        result.setFullName(seekerProfileDTO.getFullName());
        result.setEmail(seekerProfileDTO.getEmail());
        result.setGender(seekerProfileDTO.getGender());
        result.setDateOfBirth(seekerProfileDTO.getDateOfBirth());
        result.setContactNumber(seekerProfileDTO.getContactNumber());
        result.setUserImage(seekerProfileDTO.getUserImage());

        result.setUniversityName(seekerProfileDTO.getUniversityName());
        result.setMajor(seekerProfileDTO.getMajor());
        result.setStartDate(seekerProfileDTO.getStartDate());
        result.setEndDate(seekerProfileDTO.getEndDate());
        result.setGpa(seekerProfileDTO.getGpa());

        result.setSkillDescription(seekerProfileDTO.getSkillDescription());
        result.setProductName(seekerProfileDTO.getProductName());
        result.setProductDescription(seekerProfileDTO.getProductDescription());
        result.setSocialActivitiesDescription(seekerProfileDTO.getSocialActivitiesDescription());

        result.setIsPresent(seekerProfileDTO.getIsPresent());
        result.setCreatedAt(seekerProfileDTO.getCreatedAt());
        result.setUpdatedAt(seekerProfileDTO.getUpdatedAt());
        result.setDeletedAt(seekerProfileDTO.getDeletedAt());

        return result;
    }

    public SeekerProfileDTO update(SeekerProfile oldSeekerProfile, SeekerProfile newSeekerProfile) {

        oldSeekerProfile.setFullName(newSeekerProfile.getFullName());
        oldSeekerProfile.setEmail(newSeekerProfile.getEmail());
        oldSeekerProfile.setGender(newSeekerProfile.getGender());
        oldSeekerProfile.setDateOfBirth(newSeekerProfile.getDateOfBirth());
        oldSeekerProfile.setContactNumber(newSeekerProfile.getContactNumber());
        oldSeekerProfile.setUserImage(newSeekerProfile.getUserImage());

        oldSeekerProfile.setUniversityName(newSeekerProfile.getUniversityName());
        oldSeekerProfile.setMajor(newSeekerProfile.getMajor());
        oldSeekerProfile.setStartDate(newSeekerProfile.getStartDate());
        oldSeekerProfile.setEndDate(newSeekerProfile.getEndDate());
        oldSeekerProfile.setGpa(newSeekerProfile.getGpa());

        oldSeekerProfile.setSkillDescription(newSeekerProfile.getSkillDescription());
        oldSeekerProfile.setProductName(newSeekerProfile.getProductName());
        oldSeekerProfile.setProductDescription(newSeekerProfile.getProductDescription());
        oldSeekerProfile.setSocialActivitiesDescription(newSeekerProfile.getSocialActivitiesDescription());

        oldSeekerProfile.setIsPresent(newSeekerProfile.getIsPresent());
        oldSeekerProfile.setCreatedAt(newSeekerProfile.getCreatedAt());
        oldSeekerProfile.setUpdatedAt(newSeekerProfile.getUpdatedAt());
        oldSeekerProfile.setDeletedAt(newSeekerProfile.getDeletedAt());

        return SeekerMapper.this.toDto(oldSeekerProfile);
    }
}
