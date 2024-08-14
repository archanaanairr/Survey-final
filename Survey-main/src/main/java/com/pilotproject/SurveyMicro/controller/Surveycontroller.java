package com.pilotproject.SurveyMicro.controller;

import com.pilotproject.SurveyMicro.Client.FullResponse;
import com.pilotproject.SurveyMicro.Service.SurveyService;
import com.pilotproject.SurveyMicro.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
public class Surveycontroller {
    @Autowired
    SurveyService surveyService;
    @PostMapping("/add")
    public ResponseEntity<Survey > adding(@RequestBody Survey survey)
    {
        return  new ResponseEntity<Survey>(surveyService.addSurvey(survey),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Survey>> getAllSurveys(){
        return  new ResponseEntity<List<Survey>>(surveyService.getallSurveys(),HttpStatus.OK);
    }
    @GetMapping("/fetch/{setName}")
    public ResponseEntity<List<Survey>> getAssessment(@PathVariable String setName)
    {
        return  new ResponseEntity<List<Survey>>(surveyService.findSetName(setName),HttpStatus.OK);
    }
    @GetMapping("collect/{surveyid}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long surveyid) {

        return  new ResponseEntity<Survey>(surveyService.findSurveyId(surveyid),HttpStatus.OK);

    }
    @GetMapping("/getdashboard/{surveyid}/{setName}")
    public ResponseEntity<FullResponse> getdashboard(@PathVariable Long surveyid,@PathVariable String setName) {
        return  new ResponseEntity<FullResponse>(surveyService.dashboard(surveyid,setName),HttpStatus.OK);
    }
}
