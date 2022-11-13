package com.ooad.tuyendung.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeekerProfileDTO extends BaseDTO {
    // personal information
    private String fullName;
    private String email;
    private String gender;
    private String dateOfBirth;
    private String contactNumber;
    private String userImage;

    // education information
    private String universityName;
    private String major;       // Chuyên ngành
    private String startDate;   // năm bắt đầu học
    private String endDate;     // năm kết thúc
    private Float gpa;          // điểm gpa

    // Skill
    private String skillDescription;

    // Product
    private String productName;
    private String productDescription;

    // Social Activities & Volunteering
    private String socialActivitiesDescription;
}
