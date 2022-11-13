package com.ooad.tuyendung.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobPost")
public class JobPost extends BaseModel {
    private String title;
    private Long companyId;
    private Long businessStreamId;
    private Long locationId;
    private Long dateRemaining;

    @Column(name = "jobDescription", columnDefinition = "TEXT")
    private String jobDescription;

    private Long postedByUserId;

    private Long UserIdApply;
}
