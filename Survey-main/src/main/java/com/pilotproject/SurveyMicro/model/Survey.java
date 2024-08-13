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
    private String setname;
    private String companyname;
    private String domain;
    public Status status;


}
