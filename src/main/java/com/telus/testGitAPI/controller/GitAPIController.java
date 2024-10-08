package com.telus.testGitAPI.controller;

import com.telus.testGitAPI.service.GitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/gitApi")
public class GitAPIController {

    @Autowired
    private GitServices gitServices;

    @GetMapping ("/branchDetails")
    public String getGitBranchDetails() {
        String gitResponse = gitServices.fetchGitBranchDetails();
        System.out.println("Response ::"+gitResponse);
        return gitResponse;
    }


}
