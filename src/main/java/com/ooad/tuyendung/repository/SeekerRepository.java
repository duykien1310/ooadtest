package com.ooad.tuyendung.repository;

import com.ooad.tuyendung.models.SeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerRepository extends JpaRepository<SeekerProfile, Long> {
}
