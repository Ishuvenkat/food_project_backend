package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntityClass;


@Repository
public interface RepoClass extends JpaRepository<EntityClass, Integer> {
	
	@Query(value = "select * from customer1.customer1 where email =:emailId",nativeQuery = true)
	EntityClass findByEmail(String emailId);
	
	
	
	
 

}