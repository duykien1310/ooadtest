package com.ooad.tuyendung.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "businessStream")
public class BusinessStream extends BaseModel {
    @Column(name = "businessStreamName")
    private String name;
}
