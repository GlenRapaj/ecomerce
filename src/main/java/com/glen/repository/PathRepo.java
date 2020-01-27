package com.glen.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.glen.model.Paths;

public interface PathRepo extends JpaRepository<Paths , Integer> 
{

}
