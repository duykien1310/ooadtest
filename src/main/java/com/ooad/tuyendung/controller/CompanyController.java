package com.ooad.tuyendung.controller;

import com.ooad.tuyendung.dto.CompanyDTO;
import com.ooad.tuyendung.models.Company;
import com.ooad.tuyendung.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<CompanyDTO> findAllCompany() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    // danh sách công ty phân trang.
    @GetMapping("/isPresent")
    public ResponseEntity<Map<String, Object>> findAllPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ) {
        try {
            Map<String, Object> response = new HashMap<>();
            Pageable paging = PageRequest.of(page, size);
            Page<CompanyDTO> pageCompanyDTO = companyService.findByIsPresent(true, paging);

            response.put("listCompany", pageCompanyDTO.getContent());
            response.put("currentPage", pageCompanyDTO.getNumber());
            response.put("totalItems", pageCompanyDTO.getTotalElements());
            response.put("totalPages", pageCompanyDTO.getTotalPages());

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("")
    public CompanyDTO insertCompany(@RequestBody Company companyModel) {
        return companyService.insert(companyModel);
    }

    @PutMapping("/{id}")
    public CompanyDTO updateCompany(@PathVariable Long id, @RequestBody Company companyModel) {
        return companyService.update(id, companyModel);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long[] ids) {
        companyService.delete(ids);
    }

//    Tìm kiếm công ty bằng param name
//    @GetMapping("/search")
//    public List<CompanyDTO> searchCompanyByName(@RequestParam("name") String name) {
//        if (name != null) {
//            return companyService.searchName(name);
//        } else {
//            return null;
//        }
//    }
}
