package com.pilotproject.SurveyMicro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long surveyid;
    private String setName;
    private String companyname;
    private String domain;
    @Enumerated(EnumType.STRING)
    private Statuss statuss;
//    public Status status;
}
