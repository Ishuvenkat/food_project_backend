package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.entityclass;

@Repository


public interface repo extends JpaRepository<entityclass, Integer> {

}
