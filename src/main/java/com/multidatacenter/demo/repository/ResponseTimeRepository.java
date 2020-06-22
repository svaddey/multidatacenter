package com.multidatacenter.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multidatacenter.demo.model.ResponseTime;

@Repository
public interface ResponseTimeRepository extends CrudRepository<ResponseTime, Integer> {

}
