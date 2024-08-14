package com.pilotproject.SurveyMicro.Service;

import com.pilotproject.SurveyMicro.Client.Assessment;
import com.pilotproject.SurveyMicro.Client.FullResponse;
import com.pilotproject.SurveyMicro.Exceptions.AssessmentNotFoundException;
import com.pilotproject.SurveyMicro.Exceptions.SurveyNotFoundException;
import com.pilotproject.SurveyMicro.Feginn.FigenClient;
import com.pilotproject.SurveyMicro.model.Survey;
import com.pilotproject.SurveyMicro.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepo surveyRepo;

    @Autowired
    private FigenClient f;

    public Survey addSurvey(Survey survey) {
        return surveyRepo.save(survey);
    }

    public List<Survey> findSetName(String setName) {
        List<Survey> surveys = surveyRepo.findBySetName(setName);
        if (surveys == null || surveys.isEmpty()) {
            throw new SurveyNotFoundException("No surveys found with set name: " + setName);
        }
        return surveys;
    }


    public Survey findSurveyId(Long surveyid) {
        Survey survey = surveyRepo.findBySurveyid(surveyid);
        if (survey == null) {
            throw new SurveyNotFoundException("Survey with ID " + surveyid + " not found.");
        }
        return survey;
    }
    public List<Survey> getallSurveys() {
        return  surveyRepo.findAll();
    }

    public FullResponse dashboard(Long surveyid, String setName) {





        Survey survey = surveyRepo.findBySurveyid(surveyid);
        if (survey == null) {
            throw new SurveyNotFoundException("Survey with ID " + surveyid + " not found.");
        }


        Assessment assessment = f.getAssessment(setName);
        if (assessment == null) {
            throw new AssessmentNotFoundException("Assessment with set name " + setName + " not found.");
        }

else{
        FullResponse response = new FullResponse();
        response.setSurveyid(survey.getSurveyid());
        response.setSetName(survey.getSetName());
        response.setCompanyname(survey.getCompanyname());
        response.setDomain(survey.getDomain());
        response.setStatus(assessment.getStatus());
        response.setSetid(assessment.getSetid());
        response.setCreatedBy(assessment.getCreatedBy());
        response.setCreatedDate(assessment.getCreatedDate());
        response.setModifiedDate(assessment.getModifiedDate());

        return response;
        }
    }

}
