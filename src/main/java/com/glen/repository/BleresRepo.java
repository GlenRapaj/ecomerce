package com.glen.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glen.model.Bleres;
import com.glen.model.FullPayment;

public interface BleresRepo extends JpaRepository<Bleres, Integer> {

	@Query(" Select count(*) from Bleres where dataBlerjesProduktit BETWEEN ?1 AND ?2 ")   
	public int totalShitjeMujore( Date startData , Date endData  ); 
	
	@Query(" Select SUM(pagesa) , valuta  from Bleres where dataBlerjesProduktit BETWEEN ?1 AND ?2 GROUP BY valuta ")  // valuta   
	public List totalShitjeMujoreMonetare( Date startData , Date endData  ); // List<FullPayment> Integer
	
	@Query(" Select count(*) from Bleres where dataBlerjesProduktit BETWEEN ?1 AND ?2 and  bonusCode != 0 " )
	public int buyerBonusCode( Date startData , Date endData );
	
	
	@Query(" Select SUM(pagesa) , valuta  from Bleres where dataBlerjesProduktit BETWEEN ?1 AND ?2 and  bonusCode != 0 GROUP BY valuta  " )
	public List totalShitjeMujoreMonetareBonus( Date startData , Date endData  );

	@Query(" Select count(*) , bonusCode  from Bleres where dataBlerjesProduktit BETWEEN ?1 AND ?2 and  bonusCode != 0 GROUP BY bonus_code  ")
	public List getSellsGroupedByBonusSellers( Date startData , Date endData  );
	
	
	@Query( value = " select count(*) , p.kategoria_produktit from bleres b inner join produkte p on b.kod_produkti = p.id where data_blerjes_produktit BETWEEN ?1 AND ?2 group by kategoria_produktit ;" ,nativeQuery = true   )
	public List getSellsCategory( Date startData , Date endData );    //  ShitjeKategori
	
	
}
