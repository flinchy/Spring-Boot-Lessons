package com.example.quartzdemoemailschedulingapp.controller;

import com.example.quartzdemoemailschedulingapp.payload.ScheduleEmailRequest;
import com.example.quartzdemoemailschedulingapp.payload.ScheduleEmailResponse;
import com.example.quartzdemoemailschedulingapp.service.EmailJobSchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailJobSchedulerController {

    @Autowired
    private EmailJobSchedulerService emailJobSchedulerService;

    @PostMapping("/scheduleEmail")
    public ResponseEntity<ScheduleEmailResponse> scheduleEmail(@Valid @RequestBody ScheduleEmailRequest scheduleEmailRequest) {
        return emailJobSchedulerService.scheduleTheEmail(scheduleEmailRequest);
    }

}
