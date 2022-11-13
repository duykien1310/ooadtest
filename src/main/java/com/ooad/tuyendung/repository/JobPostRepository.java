package com.ooad.tuyendung.repository;

import com.ooad.tuyendung.models.JobPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    @Query(value = "SELECT * FROM job_post WHERE is_present = true ORDER BY date_remaining ASC ", nativeQuery = true)
    public List<JobPost> findByActive();

    public Page<JobPost> findByIsPresent(boolean isPresent, Pageable pageable);
}
