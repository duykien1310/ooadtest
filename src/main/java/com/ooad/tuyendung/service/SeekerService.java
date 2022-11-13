package com.ooad.tuyendung.service;

import com.ooad.tuyendung.dto.SeekerProfileDTO;
import com.ooad.tuyendung.mapper.SeekerMapper;
import com.ooad.tuyendung.models.SeekerProfile;
import com.ooad.tuyendung.repository.SeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeekerService {
    @Autowired
    private SeekerRepository seekerRepository;

    @Autowired
    private SeekerMapper seekerMapper;

    public List<SeekerProfileDTO> findALl() {
        return seekerRepository.findAll().stream().map(
                seekerProfile -> seekerMapper.toDto(seekerProfile)).collect(Collectors.toList());
    }

    public SeekerProfileDTO findById(Long id) {
        return seekerMapper.toDto(seekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()));
    }

    @Transactional
    public SeekerProfileDTO save(Long id, SeekerProfile seekerProfile) {
        SeekerProfile oldSeeker = seekerRepository.findById(id).orElseGet(() -> null);

        if (oldSeeker != null) {
            return seekerMapper.update(oldSeeker, seekerProfile);
        } else {
            return seekerMapper.toDto(seekerRepository.save(seekerProfile));
        }
    }

    public List<SeekerProfileDTO> deleteByIsPresent(Long[] ids) {
        List<SeekerProfileDTO> listDelete = new ArrayList<>();
        for (Long id : ids) {
            SeekerProfile seekerProfile = seekerRepository.findById(id).orElseGet(() -> null);
            if (seekerProfile != null) {
                seekerProfile.setIsPresent(false);
            }
            listDelete.add(seekerMapper.toDto(seekerProfile));
        }

        return listDelete;
    }

    @Transactional
    public void deleteById(Long[] ids) {
        for (Long id : ids) {
            seekerRepository.deleteById(id);
        }
    }
}
