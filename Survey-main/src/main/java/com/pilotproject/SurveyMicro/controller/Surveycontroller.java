package com.pilotproject.SurveyMicro.controller;

import com.pilotproject.SurveyMicro.model.Survey;
import com.pilotproject.SurveyMicro.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survey")
public class Surveycontroller {
    @Autowired
    private SurveyRepo surveyRepo;
    @PostMapping("/add")
    public Survey adding(@RequestBody Survey survey)
    {
        return surveyRepo.save(survey);
    }
    @GetMapping("/fetch/{setname}")
    public List<Survey> findingbyname(@PathVariable String setname)
    {
        return surveyRepo.findBySetname(setname);
    }
    @GetMapping("collect/{surveyid}")
    public Optional<Survey> getSurveyById(@PathVariable Long surveyid) {
        return surveyRepo.findById(surveyid);
    }
}
