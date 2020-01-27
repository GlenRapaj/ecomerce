package com.glen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.glen.model.MostSellingProductCategory;
import com.glen.model.Produkte;
import com.glen.repository.ProdukteRepo;

@RestController
public class ProductController {

	/* A controller made only for products  */
	
	@Autowired
	private ProdukteRepo produkteRepo ;
	
	@GetMapping("/")  // jep faqen kryesore
	public ModelAndView getIndexPage() {
		
		ModelAndView index = new ModelAndView();
		
		index.setViewName("index");
		return index ;
	}
	
	
	@GetMapping("/category/{kategori}")   //Jep faqen vetm, te dhenat do te merren me ajax
	public ModelAndView getProductCatgoryPage( @PathVariable("kategori") String kategori  ) {
		
		
	  
		ModelAndView productCategory = new ModelAndView();
		
		productCategory.setViewName("productkategory");  //     productCategory
		
		return productCategory ;
	}
	
	
	
	@PostMapping("/kategori/{kategori}")   // Merr te dhenat per prodektet e nje kategorie
	public  Slice<Produkte> getSliceProductCatgoryPage( @PathVariable("kategori") String kategori, @RequestBody int faqjaKerkuar   ) {
		
		// faqjaKerkuar eshte nr faqes qe po kerkohet qe eshte klikuar 
		int item_per_page_number = 9;
		
		System.out.println( faqjaKerkuar ); 
		
		PageRequest firstPage = PageRequest.of( faqjaKerkuar , item_per_page_number ); 
		
		Slice<Produkte> listProdukte ;
		
		listProdukte = produkteRepo.getPeaceOfProductsByCategory( firstPage );

		return listProdukte ;
	}
	
	
	

	@GetMapping("/category/{kategori}/{page}") // Sherben per reload faqes se per nndryshe krashes
	public ModelAndView  getProductDetails( @PathVariable("kategori") String kategori , @PathVariable("page") int page  ) {
		
		// System.out.println( id );
		 
		int item_per_page_number = 9;
		PageRequest firstPage = PageRequest.of( page , item_per_page_number ); 
		
		List<Produkte> listProdukte = new ArrayList<>() ;
		listProdukte =  produkteRepo.getPeaceOfProductsByCategoryAsList( firstPage );
		
		ModelAndView productCategory = new ModelAndView();
		
		productCategory.setViewName("productkategory");  //     productCategory

		
		productCategory.addObject( "productList", listProdukte );
		
		return productCategory ;
	}
	
	
	@GetMapping("/productdetails/{id}")  // Merr detajet per nje produkt specifik
	public ModelAndView  getProductDetails( @PathVariable("id") int id ) {
		
		 System.out.println( id ); 
		 
		ModelAndView productdetails = new ModelAndView();
		
		productdetails.setViewName("productdetails"); 
		
		Produkte produkte = produkteRepo.getOne( id );
		
		productdetails.addObject( "productDetails", produkte );
		
		return productdetails;
	}
	
	@GetMapping("/most_sellingby_category")
	public List<MostSellingProductCategory> mostSellingByCategory() {
		
		List<String> kategoriaProduktit = new ArrayList<>() ;
		kategoriaProduktit = produkteRepo.getProductCategory();
		
		
		PageRequest firstPage = PageRequest.of( 0 , 3 ); 
		List<MostSellingProductCategory> listProdukte = new ArrayList<>() ;
		List<MostSellingProductCategory> listProdukteTemp = new ArrayList<>() ;
		
		for(int i = 0 ; i < kategoriaProduktit.size() ; i++ ) {
			
			listProdukteTemp = produkteRepo.getMostSellingProductForCategory(firstPage, kategoriaProduktit.get(i) );
			
			for( int j = 0 ; j < listProdukteTemp.size() ; j++ ) {
				
				listProdukte.add( listProdukteTemp.get(j) );
			}
		}
		
		return listProdukte ;
	}
	
	
	
	
}
