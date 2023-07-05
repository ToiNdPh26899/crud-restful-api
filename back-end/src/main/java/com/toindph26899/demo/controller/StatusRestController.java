package com.toindph26899.demo.controller;

import com.toindph26899.demo.entity.Status;
import com.toindph26899.demo.response.StatusResponse;
import com.toindph26899.demo.service.StatusService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class StatusRestController {

    private StatusService statusService;

    public StatusRestController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/status")
    public List<StatusResponse> findAll() {
        System.out.println(statusService.findAll());
        return statusService.findAll();
    }

}
