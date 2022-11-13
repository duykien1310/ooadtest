package com.ooad.tuyendung.service;

import com.ooad.tuyendung.dto.CompanyDTO;
import com.ooad.tuyendung.mapper.CompanyMapper;
import com.ooad.tuyendung.models.Company;
import com.ooad.tuyendung.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyDTO> findAll() {
        return companyRepository.findAll().stream().map(
                companyModel -> companyMapper.toDto(companyModel))
                .collect(Collectors.toList());
    }

    public CompanyDTO findById(Long id) {
        Company companyModel = companyRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return companyMapper.toDto(companyModel);
    }

    public Page<CompanyDTO> findByIsPresent(boolean isPresent, Pageable pageable) {
        Page<Company> pageCompany = companyRepository.findByIsPresent(isPresent, pageable);
        List<CompanyDTO> companyDTOList = pageCompany.getContent().stream().map(
                company -> companyMapper.toDto(company)).collect(Collectors.toList());

        return new PageImpl<>(companyDTOList, pageable, companyDTOList.size());
    }

    public List<CompanyDTO> searchName(String name) {
        return companyRepository.searchByName(name).stream().map(
                companyModel -> companyMapper.toDto(companyModel)).collect(Collectors.toList());
    }

    @Transactional
    public CompanyDTO insert(Company companyModel) {
        return companyMapper.toDto(companyRepository.save(companyModel));
    }

    public CompanyDTO update(Long id, Company companyModel) {
        Company oldCompanyModel = companyRepository.findById(id).orElseGet(() -> null);
        if (oldCompanyModel != null) {
            return companyMapper.update(oldCompanyModel, companyModel);
        } else {
            return null;
        }
    }

    @Transactional
    public void delete (Long[] ids) {
        for (Long id : ids) {
            companyRepository.deleteById(id);
        }
    }
}
