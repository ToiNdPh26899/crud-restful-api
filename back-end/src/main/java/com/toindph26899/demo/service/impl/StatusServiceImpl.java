package com.toindph26899.demo.service.impl;

import com.toindph26899.demo.entity.Status;
import com.toindph26899.demo.repository.StatusRepository;
import com.toindph26899.demo.response.StatusResponse;
import com.toindph26899.demo.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusResponse> findAll() {
        return statusRepository.findAllCustom();
    }
}
