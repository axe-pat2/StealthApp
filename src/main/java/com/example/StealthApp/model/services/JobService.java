package com.example.StealthApp.model.services;

import com.example.StealthApp.model.dataStructure.BstService;
import com.example.StealthApp.model.entities.Job;
import com.example.StealthApp.model.exceptions.JobDoesNotExistException;
import com.example.StealthApp.model.exceptions.JobExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StealthApp.model.repository.*;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private BstService bstService;

    public void addJobId(Integer jobId, Integer startValue){
        if (exists(jobId))
            throw new JobExistsException("Job already exists");
        Job newJob = new Job(jobId,startValue);
        bstService.addNode(newJob);
        jobMapRepo.jobMap.put(jobId,newJob);
    }

    public void removeJobs(Integer jobId){
        if (!exists(jobId))
            throw new JobDoesNotExistException("Job doesn't exist");
        Job jobDelete = jobMapRepo.jobMap.get(jobId);
        bstService.removeNode(jobDelete);
        jobMapRepo.jobMap.remove(jobId);
    }

    public List<Job> getJobs(Integer startValue){
        return bstService.getNodes(startValue);
    }

    private Boolean exists(Integer jobId) {
        return jobMapRepo.jobMap.containsKey(jobId);
    }
}
