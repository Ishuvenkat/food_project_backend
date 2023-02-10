package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Entityclass;


@Repository


public interface Repointerface extends JpaRepository<Entityclass, Integer> {
	

}
