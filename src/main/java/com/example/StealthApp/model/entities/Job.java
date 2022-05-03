package com.example.StealthApp.model.entities;

import com.example.StealthApp.model.dataStructure.JobNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Job {
    private Integer jobId;
    private Integer startValue;
}
