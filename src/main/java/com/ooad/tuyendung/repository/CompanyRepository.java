package com.ooad.tuyendung.repository;

import com.ooad.tuyendung.models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "SELECT * FROM company WHERE is_present = true and company_name LIKE '%:name%' ORDER BY company_name ASC",
    nativeQuery = true)
    public List<Company> searchByName(@Param("name") String name);

    public Page<Company> findByIsPresent(boolean isPresent, Pageable pageable);
}
