package com.glen.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glen.model.Bleres;
import com.glen.model.BonusSellers;
import com.glen.model.FullPayment;
import com.glen.model.Produkte;
import com.glen.model.RezultatBilanci;
import com.glen.model.ShitjeKategoriDTO;
import com.glen.repository.BilanceRepo;
import com.glen.repository.BleresRepo;
import com.glen.repository.ProdukteRepo;

@RestController
public class AdminController {
	
	@Autowired
	private ProdukteRepo produkteRepo;
	
	@Autowired
	private BleresRepo bleresRepo;
	
	@Autowired
	private BilanceRepo bilanceRepo ;
	
	@PostMapping("/shto")
	public void addProduct( @RequestBody Produkte produkte ) {
		
		
		/* System.out.println( " Inside of adding method " ); 
		Produkte produkte = new Produkte( 1, "L", 5, "Male", "Pambuk",
				"Bluze e Thjesht nje kolorshe pa disanje ", "Pranvere" , 0, "T-shirt", "Blu",
				"" , 10.00, 0 );
		*/
		produkteRepo.save( produkte );
		
		// return " ok " ;
	
	}
	
	
	@PutMapping( path = "/modifiko/{id}"  )
	public String  modifikoProduktin( @PathVariable int id, @RequestBody Produkte produkte  ) {
		
		System.out.println( " Inside of modifikoProduktin method " );
		produkteRepo.save( produkte );
		
		return " ok " ;
	}
	
	@GetMapping("/nrshitjesh")
	public int calkuloShitje(    ) throws ParseException {  // @RequestBody Date data  Date data
		
		//  data do vine nga front-end
		
		
		
		/*  
		 
		 Date data dhe Date startingDate
		 duhet te hiqen sepse te dhenat do te vine si input nga front-end
	
		
	
			 
		 */
		
		
		 LocalDate data = LocalDate.of(2019, 2, 1); 
		
		 LocalDate startingDate = LocalDate.of(2019, 1, 1); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		
		 int nrTotal = bleresRepo.totalShitjeMujore( startingd , endD ); 
		 System.out.println( nrTotal );
		return nrTotal;
	}
	
	@GetMapping("paymentreport")
	public List<FullPayment> monthlyPaymentReport() {
		
		/*
		 * vijne nga front-end
		 * Date endD Date startingd
		 * */
		
		/*
		  
		  Pjesa dates do fshihet sepse do te vije si input nga front-end
		  
		  LocalDate data
		  LocalDate startingDate
		  Date endD Date startingd
		  */
		
		 LocalDate data = LocalDate.of(2019, 3, 1); 
			
		 LocalDate startingDate = LocalDate.of(2019, 2, 1); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		 List<FullPayment> list = new ArrayList<>();
		 list = bleresRepo.totalShitjeMujoreMonetare( startingd, endD );
		 
		
		 // System.out.println( list.size() );
		 return list ;
	}
	
	
	@GetMapping("/bonusbuyers")
	public int buyerWithBonusCode() { 
		
		/*
		 
		  Do marri si input 2 Data fillimi dhe mbarimi
		  
		  dhe do ktheje numrin e personave qe kane blere me bonus-code  apo ndryshe ulje
		 
		 * */
		
		 LocalDate data = LocalDate.of( 2019, 3, 1 ); 
		
		 LocalDate startingDate = LocalDate.of( 2019, 2, 1 ); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		 int bonusCodeBuyers = bleresRepo.buyerBonusCode( startingd , endD);
		 
		 return bonusCodeBuyers ;
		
	}
	
	@GetMapping("/bonusbuyersmoney")
	public List<FullPayment> buyerWithBonusCodeMoney() { 
		
		/*
		 
		  Do marri si input 2 Data fillimi dhe mbarimi
		  
		  dhe do ktheje shumen e parave te personave qe kane blere me bonus-code  apo ndryshe ulje
		 
		 * */
		
		 LocalDate data = LocalDate.of( 2019, 3, 1 ); 
		
		 LocalDate startingDate = LocalDate.of( 2019, 2, 1 ); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		 List<FullPayment> listOfBonusBuyers = new ArrayList<>();
		 listOfBonusBuyers = bleresRepo.totalShitjeMujoreMonetareBonus( startingd, endD);
		 
		 return listOfBonusBuyers ;
		
	}
	
	@GetMapping("/groupsellers")
	public List<BonusSellers> getSellsInTimeBySellers() {
		
		/*
		 
		  Do marri si input 2 Data fillimi dhe mbarimi
		  
		  dhe do ktheje listen e shitjeve te grupuara sipas shitesve  me bonus-code  apo ndryshe ulje
		 
		 * */
		
		 LocalDate data = LocalDate.of( 2019, 3, 1 ); 
			
		 LocalDate startingDate = LocalDate.of( 2019, 2, 1 ); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		 List<BonusSellers> listOfBonusSellsBySellers = new ArrayList<>();
		// listOfBonusSellsBySellers = bleresRepo.getSellsGroupedByBonusSellers( startingd , endD  );
		
		 return listOfBonusSellsBySellers ;
	}
	
	
	@GetMapping( path = "/sellingcategory", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<ShitjeKategoriDTO> getSellsByCategory() {
		
		/*
		 
		  Do marri si input 2 Data fillimi dhe mbarimi
		  
		  dhe do ktheje listen e shitjeve te grupuara sipas kategorive  
		 
		 * */
		
		 LocalDate data = LocalDate.of( 2019, 3, 1 ); 
			
		 LocalDate startingDate = LocalDate.of( 2019, 2, 1 ); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		
		List<ShitjeKategoriDTO> sellingForCategory = new ArrayList<>();
		sellingForCategory = bleresRepo.getSellsCategory( startingd, endD );
		
		return sellingForCategory ;
	}
	
	/*
	 
	  Do marri si input 2 Data fillimi dhe mbarimi
	  
	  dhe do ktheje rezultanten e bilancit fitimin apo humbjen
	 
	 * */
	
	/*
	 
	 
	
	@GetMapping("/fitimi")
	public double fitimiRezultant() {
		
		
		
		LocalDate data = LocalDate.of( 2019, 3, 1 ); 
		
		 LocalDate startingDate = LocalDate.of( 2019, 2, 1 ); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		 
		 RezultatBilanci rezultatBilanci = bilanceRepo.rezultatBilanci( startingd, endD );
		 
		 double rezultat = rezultatBilanci.getTeardhura() - rezultatBilanci.getKosto();
		 rezultat = rezultat - rezultatBilanci.getMidelmanFee();
		 
		 return rezultat;
	}
	  */
	
	
	
	
	@GetMapping(path = "/kosto", produces = "application/json")
	public List<RezultatBilanci> kostoRezultant() {
		
		/*
		 
		  Do marri si input 2 Data fillimi dhe mbarimi
		  
		  dhe do ktheje kosto totale koston per ndermjetesin dhe te ardhurat
		 
		 * */
		
		LocalDate data = LocalDate.of( 2019, 7, 7 ); 
		
		 LocalDate startingDate = LocalDate.of( 2019, 2, 1 ); 
		
		
		 Date endD = Date.from( data.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 Date startingd = Date.from( startingDate.atStartOfDay( ZoneId.systemDefault() ).toInstant() );
		 
		 List<RezultatBilanci> bilance = new ArrayList<>();
		  bilance = bilanceRepo.rezultatBilanci( startingd, endD );
		 
		 
		 return bilance;
	}
	
	

	
	
	/* 
	@GetMapping( "/bliprodukt" )
	public void buyProduct() {
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();
		calendar.add( Calendar.MONTH, 1 ); 
		
		Bleres bleres = new Bleres( 1, "dumy@email.com" , 00000000, "adresa bleresit", " qyteti bleresit ", " shteti bleresit " , 0000000 , 0, 500, "Lek ", 000, 1, " Emri Mbiemri bleresit", calendar1, calendar, false);
	}
 */
	
	
}
