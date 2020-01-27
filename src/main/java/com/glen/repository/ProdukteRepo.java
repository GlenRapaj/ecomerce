package com.glen.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glen.model.MostSellingProductCategory;
import com.glen.model.Produkte;

public interface ProdukteRepo extends JpaRepository< Produkte , Integer >{
	
	@Query("from Produkte")
	Slice<Produkte> getPeaceOfProductsByCategory(   PageRequest firstPage );
	
	@Query("from Produkte")
	List<Produkte> getPeaceOfProductsByCategoryAsList(   PageRequest firstPage );
	
// 
	@Query( nativeQuery = true, value = "select sum(b.pagesa), p.emer_produkti, p.kategoria_produktit from produkte p inner join bleres b on b.kod_produkti = p.id  where p.kategoria_produktit = ?1 group by p.emer_produkti order by b.pagesa;" )
	List<MostSellingProductCategory> getMostSellingProductForCategory( PageRequest firstPage , String kategoriaProduktit );
	
	@Query("select kategoriaProduktit from Produkte ")
	List<String> getProductCategory();
}
