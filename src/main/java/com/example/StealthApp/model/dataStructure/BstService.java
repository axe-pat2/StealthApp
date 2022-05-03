package com.example.StealthApp.model.dataStructure;

import com.example.StealthApp.model.entities.Job;
import com.example.StealthApp.model.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BstService {

    public JobNode addNode(Job curJob){
        if(rootNodeRepo.rootNode==null) {
            rootNodeRepo.rootNode = new JobNode(curJob);
            return rootNodeRepo.rootNode;
        }
        return addNode(rootNodeRepo.rootNode,curJob);
    }

    public JobNode removeNode(Job curJob){
        return rootNodeRepo.rootNode = removeNode(rootNodeRepo.rootNode,curJob);
    }

    public List<Job> getNodes(Integer startValue){

        return getNodes(rootNodeRepo.rootNode,startValue);
    }

    public List<Job> getNodes(JobNode root, Integer searchValue){
        List<Job> collectedNodes = new ArrayList<>();
        inorder(rootNodeRepo.rootNode,collectedNodes,false,searchValue);
        return collectedNodes;
    }

    private JobNode addNode(JobNode root, Job curJob){
        
        if(root == null){
            root = new JobNode(curJob);
            return root;
        }
        if(curJob.getStartValue()<root.getJobdetails().getStartValue())
            root.setLeftTree(addNode(root.getLeftTree(),curJob));
        else if(curJob.getStartValue()>root.getJobdetails().getStartValue())
            root.setRightTree(addNode(root.getRightTree(),curJob));
        return root;
    }

    private JobNode removeNode(JobNode root, Job curJob){
        if(root==null)
            return root;
        if (curJob.getStartValue()<root.getJobdetails().getStartValue())
            root.setLeftTree(removeNode(root.getLeftTree(),curJob));

        else if(curJob.getStartValue()> root.getJobdetails().getStartValue())
            root.setRightTree(removeNode(root.getRightTree(),curJob));

        else {
            if (root.getLeftTree()==null)
                return root.getRightTree();

            else if(root.getRightTree()==null)
                return root.getLeftTree();

            root.setJobdetails(minimumValue(root.getRightTree()));

            root.setRightTree(removeNode(root.getRightTree(),curJob));
        }
        return root;
    }

    Job minimumValue(JobNode root){
        Job minJob = root.getJobdetails();
        while (root.getLeftTree()!=null){
            minJob = root.getLeftTree().getJobdetails();
            root = root.getLeftTree();
        }
        return minJob;
    }

    private void inorder(JobNode root, List<Job> collectedNodes, Boolean flag, Integer baseVal){
        if(root==null)
            return;

        inorder(root.getLeftTree(),collectedNodes,flag,baseVal);
        if (root.getJobdetails().getStartValue()>=baseVal)
            flag=true;
        if (flag){
            System.out.println(root.getJobdetails().getStartValue());
            collectedNodes.add(root.getJobdetails());
        }
        inorder(root.getRightTree(),collectedNodes,flag,baseVal);
    }

}
