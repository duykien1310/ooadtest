package com.ooad.tuyendung.controller;

import com.ooad.tuyendung.dto.JobPostDTO;
import com.ooad.tuyendung.models.JobPost;
import com.ooad.tuyendung.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/test/jobpost")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping("")
    public List<JobPostDTO> findAllJobPost() {
        return jobPostService.findAll();
    }

    // danh sách các bài tuyển dụng còn hiệu lực.
    @GetMapping("/isActive")
    public List<JobPostDTO> findAllJobActive() {
        return jobPostService.findAllByActive();
    }

    @GetMapping("/{id}")
    public JobPostDTO findById(@PathVariable Long id) {
        return jobPostService.findById(id);
    }

    @PostMapping("")
    public JobPostDTO insert(@RequestBody JobPost jobPost) {
        return jobPostService.insert(jobPost);
    }

    @PutMapping("/{id}")
    public JobPostDTO update(@PathVariable Long id, @RequestBody JobPost newJobPost) {
        return jobPostService.update(id, newJobPost);
    }

    // bài tuyển dụng hết hiệu lực
    @PutMapping("")
    public List<JobPostDTO> deleteByActive(@RequestBody Long[] ids) {
        return jobPostService.deleteByActive(ids);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long[] ids) {
        jobPostService.delete(ids);
    }

    // danh sách các bài tuyển còn hiệu lực (phân trang).
    @GetMapping("/isPresent")
    public ResponseEntity<Map<String, Object>> findAllPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size
    ) {
        try {
            List<JobPostDTO> jobPostDTOList = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);

            Page<JobPostDTO> pageJobPtDTO = jobPostService.findByIsPresent(true, paging);
            jobPostDTOList= pageJobPtDTO.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("jobPostList", jobPostDTOList);
            response.put("currentPage", pageJobPtDTO.getNumber());
            response.put("totalItems", pageJobPtDTO.getTotalElements());
            response.put("totalPages", pageJobPtDTO.getTotalPages());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
