package com.ooad.tuyendung.controller;

import com.ooad.tuyendung.dto.SeekerProfileDTO;
import com.ooad.tuyendung.models.SeekerProfile;
import com.ooad.tuyendung.service.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/test/seeker")
public class SeekerController {
    @Autowired
    private SeekerService seekerService;

    @GetMapping("")
    public List<SeekerProfileDTO> findAll() {
        return seekerService.findALl();
    }

    @GetMapping("/{id}")
    public SeekerProfileDTO findById(@PathVariable Long id) {
        return seekerService.findById(id);
    }

    // Cập nhật thông tin.
    @PostMapping("/{id}")
    public SeekerProfileDTO update(@PathVariable Long id, @RequestBody SeekerProfile seekerProfile) {
        return seekerService.save(id, seekerProfile);
    }

}
