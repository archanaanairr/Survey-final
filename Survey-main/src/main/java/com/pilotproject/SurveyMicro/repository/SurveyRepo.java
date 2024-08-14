package com.pilotproject.SurveyMicro.repository;

import com.pilotproject.SurveyMicro.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SurveyRepo extends JpaRepository<Survey,Long> {

List<Survey> findBySetName(String setname);


    Survey findBySurveyid(Long surveyid);
}
