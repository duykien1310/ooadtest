package com.ooad.tuyendung.mapper;

import com.ooad.tuyendung.dto.CompanyDTO;
import com.ooad.tuyendung.dto.JobPostDTO;
import com.ooad.tuyendung.models.Company;
import com.ooad.tuyendung.models.JobPost;
import org.springframework.stereotype.Component;

@Component
public class JobPostMapper {
    public JobPostDTO toDto(JobPost jobPost) {
        JobPostDTO result = new JobPostDTO();
        result.setId(jobPost.getId());
        result.setTitle(jobPost.getTitle());
        result.setBusinessStreamId(jobPost.getBusinessStreamId());
        result.setCompanyId(jobPost.getCompanyId());
        result.setLocationId(jobPost.getLocationId());
        result.setDateRemaining(jobPost.getDateRemaining());
        result.setIsPresent(jobPost.getIsPresent());
        result.setJobDescription(jobPost.getJobDescription());
        result.setPostedByUserId(jobPost.getPostedByUserId());
        result.setUserIdApply(jobPost.getUserIdApply());

        result.setCreatedAt(jobPost.getCreatedAt());
        result.setUpdatedAt(jobPost.getUpdatedAt());
        result.setDeletedAt(jobPost.getDeletedAt());

        return result;
    }

    public JobPost toEntity(JobPostDTO jobPostDTO) {
        JobPost result = new JobPost();
        result.setTitle(jobPostDTO.getTitle());
        result.setBusinessStreamId(jobPostDTO.getBusinessStreamId());
        result.setCompanyId(jobPostDTO.getCompanyId());
        result.setLocationId(jobPostDTO.getLocationId());
        result.setDateRemaining(jobPostDTO.getDateRemaining());
        result.setIsPresent(jobPostDTO.getIsPresent());
        result.setJobDescription(jobPostDTO.getJobDescription());
        result.setPostedByUserId(jobPostDTO.getPostedByUserId());
        result.setUserIdApply(jobPostDTO.getUserIdApply());

        result.setCreatedAt(jobPostDTO.getCreatedAt());
        result.setUpdatedAt(jobPostDTO.getUpdatedAt());
        result.setDeletedAt(jobPostDTO.getDeletedAt());

        return result;
    }

    public JobPostDTO update(JobPost oldJobPost, JobPost newJobPost) {
        oldJobPost.setTitle(newJobPost.getTitle());
        oldJobPost.setCompanyId(newJobPost.getCompanyId());
        oldJobPost.setLocationId(newJobPost.getLocationId());
        oldJobPost.setDateRemaining(newJobPost.getDateRemaining());
        oldJobPost.setIsPresent(newJobPost.getIsPresent());
        oldJobPost.setBusinessStreamId(newJobPost.getBusinessStreamId());
        oldJobPost.setJobDescription(newJobPost.getJobDescription());
        oldJobPost.setPostedByUserId(newJobPost.getPostedByUserId());
        oldJobPost.setUserIdApply(newJobPost.getUserIdApply());

        oldJobPost.setCreatedAt(newJobPost.getCreatedAt());
        oldJobPost.setUpdatedAt(newJobPost.getUpdatedAt());
        oldJobPost.setDeletedAt(newJobPost.getDeletedAt());

        return JobPostMapper.this.toDto(oldJobPost);
    }
}
