package com.ooad.tuyendung.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostDTO extends BaseDTO {
    private String title;
    private Long companyId;
    private Long businessStreamId;
    private Long locationId;
    private Long dateRemaining;
    private String jobDescription;
    private Long postedByUserId;
    private Long UserIdApply;
}
