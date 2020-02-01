package com.glen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.glen.model.Bleres;
import com.glen.model.FullPayment;
import com.glen.model.MostSellingProductCategory;
import com.glen.model.Paths;
import com.glen.model.Produkte;
import com.glen.repository.BleresRepo;
import com.glen.repository.ProdukteRepo;

@RestController
public class ProductController {

	/* A controller made only for products  */
	
	@Autowired
	private ProdukteRepo produkteRepo ;
	
	@Autowired
	private BleresRepo bleresRepo ;
	
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
		productdetails.addObject("productDetails" , produkte );
		
		return productdetails;
	}
	
	
		
	@GetMapping("/most_sellingby_category")
	public List<MostSellingProductCategory[]> mostSellingByCategory() {
		
		List<String> kategoriaProduktit = new ArrayList<>() ;
		kategoriaProduktit = produkteRepo.getProductCategory();
		
		
		PageRequest firstPage = PageRequest.of( 0 , 3 ); 
		List<MostSellingProductCategory[]> listProdukte = new ArrayList<>();
		List<MostSellingProductCategory> listProdukteTemp = new ArrayList<>();
		
		/* 	
		for(int i = 0 ; i < kategoriaProduktit.size() ; i++ ) {
			
			System.out.println( kategoriaProduktit.get(i) );
			
			listProdukteTemp = produkteRepo.getMostSellingProductForCategory( "T-shirt" ); // firstPage,
			
			
			for( int j = 0 ; j < listProdukteTemp.size() ; j++ ) {
				
				listProdukte.add( listProdukteTemp.get(j) );
			}
			
		}
		  */
		
		listProdukte = produkteRepo.getMostSellingProductForCategory( "T-shirt" );
		
		System.out.println( "listProdukte : " + listProdukte.size() );
		System.out.println( "listProdukte inside : " + listProdukte.get(0) );
		MostSellingProductCategory[] Prod = listProdukte.get(0);
		// MostSellingProductCategory Prod =  listProdukte.get(0);
		
		// System.out.println( listProdukte.get(0).getCmimi() );
		// System.out.println( listProdukte.get(0).getKategoriaProduktit() );
		return listProdukte; 
	}
	
	
	
	// testing orm one to meny pourpose   path = "/test/{id}"
	@GetMapping( path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produkte> test( ) {
		// @PathVariable("id") int id 
		  return produkteRepo.findAll();
		
		// return bleresRepo.findAll();
	}
	
	@GetMapping( path = "/testtest")
	public String testtest( ) {
		Bleres bleres = new Bleres( 6, "dumy@email.com" , 0 , "adresa" , "qyteti", "shteti", 0 , 700 , "Lek", 000, "fullName", new Date() , new Date() , false );  
		
		List<Paths> path = new ArrayList<>();
		
		Produkte produkte1 = new Produkte( 21 , "M", 10 , "Female ", "pambuk" , "pershkrimProdukti" , "sezoni" , 0 , "kategoriaProduktit" , "Bardhe", "tipiProduktit" , 500 , 10 , 1 , "emerProdukti", 700 , path );   
		Produkte produkte2 = new Produkte( 21 , "M", 10 , "Female ", "pambuk" , "pershkrimProdukti" , "sezoni" , 0 , "kategoriaProduktit" , "Bardhe", "tipiProduktit" , 500 , 10 , 1 , "emerProdukti", 700 , path );   
		
		bleres.getProduktet().add( produkte1 );
		bleres.getProduktet().add( produkte2 );
		
		produkte1.getBleresit().add( bleres );
		produkte2.getBleresit().add( bleres );
		
		bleresRepo.save( bleres );
		 return " ok ";
	}
	
	// end testing 
	
	
}
