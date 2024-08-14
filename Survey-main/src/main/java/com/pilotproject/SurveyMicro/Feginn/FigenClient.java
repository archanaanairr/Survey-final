package com.pilotproject.SurveyMicro.Feginn;

import com.pilotproject.SurveyMicro.Client.Assessment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="AssessmentService",url = "http://localhost:9000/assessments")

public interface  FigenClient {
    @GetMapping("/getallassments/{setName}")
    public Assessment getAssessment(@PathVariable  String setName);
}
