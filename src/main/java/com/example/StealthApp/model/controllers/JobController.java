package com.example.StealthApp.model.controllers;

import com.example.StealthApp.model.entities.Job;
import com.example.StealthApp.model.exceptions.JobDoesNotExistException;
import com.example.StealthApp.model.exceptions.JobExistsException;
import com.example.StealthApp.model.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;
    private Integer value;
    private Integer jobId;

    @GetMapping("/add")
    public ResponseEntity<String> addJob(@RequestParam Integer value, @RequestParam Integer jobId){
        try {
            jobService.addJobId(jobId,value);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (JobExistsException jobExistsException){
            return new ResponseEntity<>(jobExistsException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public List<Job> allJobs(@RequestParam Integer value){
        return jobService.getJobs(value);
    }

    @GetMapping("/remove")
    public ResponseEntity<String> removeJob(@RequestParam Integer jobId){
        try {
            jobService.removeJobs(jobId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (JobDoesNotExistException jobDoesNotExistException){
            return new ResponseEntity<>(jobDoesNotExistException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public String kyaa(){
        return "Hey loser";
    }
}
