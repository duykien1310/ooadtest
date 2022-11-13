package com.ooad.tuyendung.dto;

import lombok.Data;

import java.util.Date;


@Data
public class BaseDTO {
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Boolean isPresent = true;
}