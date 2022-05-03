package com.example.StealthApp.model.dataStructure;

import com.example.StealthApp.model.entities.Job;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class JobNode {
    private Job jobdetails;
    private JobNode leftTree;
    private JobNode rightTree;

    public JobNode(final Job job){
        this.jobdetails = job;
        leftTree = null;
        rightTree = null;
    }
}
