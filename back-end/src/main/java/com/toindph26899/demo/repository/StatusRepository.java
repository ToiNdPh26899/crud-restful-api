package com.toindph26899.demo.repository;

import com.toindph26899.demo.entity.Status;
import com.toindph26899.demo.response.StatusResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select new com.toindph26899.demo.response.StatusResponse(s.id, s.statusName) from Status s")
    List<StatusResponse> findAllCustom();

}
