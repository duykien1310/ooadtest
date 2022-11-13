package com.ooad.tuyendung.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seekerProfile")
public class SeekerProfile extends BaseModel {

    // personal information
    private String fullName;
    private String email;
    private String gender;
    private String dateOfBirth;
    private String contactNumber;
    private String userImage;

    // education information
    private String universityName;
    private String major;   // Chuyên ngành
    private String startDate;   // năm bắt đầu học
    private String endDate;     // năm kết thúc
    private Float gpa;          // điểm gpa

    // Skill
    @Column(name = "skillDescription", columnDefinition = "TEXT")
    private String skillDescription;

    // Product
    private String productName;
    @Column(name = "productDescription", columnDefinition = "TEXT")
    private String productDescription;

    // Social Activities & Volunteering
    @Column(name = "socialActivitiesDescription", columnDefinition = "TEXT")
    private String socialActivitiesDescription;
}
