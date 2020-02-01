package com.glen.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glen.model.Bilance;
import com.glen.model.RezultatBilanci;

public interface BilanceRepo extends JpaRepository<Bilance, Integer> {

	@Query( value = "Select  SUM( b.teardhura ), SUM( b.kosto ), SUM( b.midelman_fee_comision ) , bl.valuta from bilance b  inner join bleres bl on b.transaction_id = bl.id where bl.data_blerjes_produktit BETWEEN ?1 AND ?2 GROUP BY bl.valuta " , nativeQuery = true )
	List  rezultatBilanci( Date startData , Date endData );  //

}
