package com.ooad.tuyendung.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company extends BaseModel {
    private String companyName;
    private String imgCover;
    private String imgAvatar;
    private String address;
    private String businessStreamId;
    private String profileDescription;
    private String companyWebsiteUrl;
}
