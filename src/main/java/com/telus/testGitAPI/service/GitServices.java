package com.telus.testGitAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitServices {

    private final RestTemplate restTemplate;
    @Value("${github.api.url}")
    private String githubApiUrl;
    @Value("${github.token}")
    private String githubToken;
    @Value("${github.owner}")
    private String owner;
    @Value("${github.repo}")
    private String repo;
    @Value("${github.branch}")
    private String branch;

    public GitServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String fetchGitBranchDetails() {
        String url = githubApiUrl+"/"+owner+"/"+repo+"/"+branch;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer" + githubToken );
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
