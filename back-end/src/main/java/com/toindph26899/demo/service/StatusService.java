package com.toindph26899.demo.service;

import com.toindph26899.demo.entity.Status;
import com.toindph26899.demo.response.StatusResponse;

import java.util.List;

public interface StatusService {

    List<StatusResponse> findAll();

}
