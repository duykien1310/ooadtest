package com.ooad.tuyendung.service;

import com.ooad.tuyendung.dto.JobPostDTO;
import com.ooad.tuyendung.mapper.JobPostMapper;
import com.ooad.tuyendung.models.JobPost;
import com.ooad.tuyendung.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostService {
    @Autowired
    private JobPostMapper jobPostMapper;

    @Autowired
    private JobPostRepository jobPostRepository;

    public List<JobPostDTO> findAll() {
        return jobPostRepository.findAll().stream().map(
                jobPost -> jobPostMapper.toDto(jobPost)).collect(Collectors.toList());
    }

    public List<JobPostDTO> findAllByActive() {
        return jobPostRepository.findByActive().stream().map(
                jobPost -> jobPostMapper.toDto(jobPost)).collect(Collectors.toList());
    }

    public JobPostDTO findById(Long id) {
        return jobPostMapper.toDto(jobPostRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Transactional
    public JobPostDTO insert(JobPost jobPost) {
        return jobPostMapper.toDto(jobPostRepository.save(jobPost));
    }

    public JobPostDTO update(Long id, JobPost jobPost) {
        JobPost oldJobPost = jobPostRepository.findById(id).orElseGet(() -> null);
        if (oldJobPost != null) {
            return jobPostMapper.update(oldJobPost, jobPost);
        } else {
            return null;
        }
    }

    public List<JobPostDTO> deleteByActive(Long[] ids) {
        List<JobPostDTO> jobPostDTOList = new ArrayList<>();
        for (Long id : ids) {
            JobPost jobPost = jobPostRepository.findById(id).orElseGet(() -> null);
            if (jobPost != null) {
                jobPost.setIsPresent(false);
            }
            jobPostDTOList.add(jobPostMapper.toDto(jobPost));
        }
        return jobPostDTOList;
    }

    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            jobPostRepository.deleteById(id);
        }
    }

    public Page<JobPostDTO> findByIsPresent(boolean isPresent, Pageable pageable) {
        Page<JobPost> pageJobPt = jobPostRepository.findByIsPresent(isPresent, pageable);
        List<JobPostDTO> jobPostDTOList = pageJobPt.getContent().stream().map(
                jobPost -> jobPostMapper.toDto(jobPost)).collect(Collectors.toList());

        return new PageImpl<>(jobPostDTOList, pageable, jobPostDTOList.size());
    }
}
