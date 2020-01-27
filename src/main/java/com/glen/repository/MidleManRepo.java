package com.glen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glen.model.MidleMan;

public interface MidleManRepo extends JpaRepository< MidleMan, Integer >{

}
