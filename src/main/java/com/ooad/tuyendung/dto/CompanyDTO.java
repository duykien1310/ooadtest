package com.ooad.tuyendung.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO extends BaseDTO {
    private String companyName;
    private String imgCover;
    private String imgAvatar;
    private String address;
    private String profileDescription;
    private String companyWebsiteUrl;
}
