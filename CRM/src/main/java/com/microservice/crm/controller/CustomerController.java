package com.microservice.crm.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.crm.model.Adjuster;
import com.microservice.crm.model.Customer;
import com.microservice.crm.model.Flooring;
import com.microservice.crm.model.Food;
import com.microservice.crm.model.Kid;
import com.microservice.crm.model.Manager;
import com.microservice.crm.model.Place;
import com.microservice.crm.model.Sport;
import com.microservice.crm.model.Spouse;
import com.microservice.crm.model.Trade;
import com.microservice.crm.service.AdjusterService;
import com.microservice.crm.service.CustomerService;
import com.microservice.crm.service.FlooringService;
import com.microservice.crm.service.FoodService;
import com.microservice.crm.service.KidService;
import com.microservice.crm.service.ManagerService;
import com.microservice.crm.service.PlaceService;
import com.microservice.crm.service.SportService;
import com.microservice.crm.service.SpouseService;
import com.microservice.crm.service.TradeService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdjusterService adjusterService;
	
	@Autowired
	private FlooringService flooringService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private KidService kidService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private SpouseService spouseService;
	
	@Autowired
	private TradeService tradeService;
	
	@GetMapping("/test")
	public String test() {
		return "Controller works fine";
	}
	
	//  CUSTOMER SECTION
	
	@PostMapping("/add")
	public Customer add(@RequestBody Customer customer) {
		
		customerService.add(customer);
		return customer;
		
	}
	
	@GetMapping("/findall")
	public ResponseEntity<?> findAllCustomers(){
		
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		
		Customer cstm  = customerService.findById(customer.getId());
		if(cstm== null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
		
		return new ResponseEntity<>(customerService.add(customer), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		customerService.deleteById(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// ADJUSTER SECTION
	
	 @PostMapping("/addadjust/{id}")
	    public ResponseEntity<?> addAdjuster(@PathVariable(value = "id") Long id, @RequestBody Set<Adjuster> adjuster){

	        Customer customer = customerService.findById(id);
	        for(Adjuster a: adjuster){

	        	adjusterService.add(a);
	        	
	        }

	        customer.getAdjusters().addAll(adjuster);
	        customerService.add(customer);
	        

	        return new ResponseEntity<>(HttpStatus.CREATED);

	    }
	
	@PutMapping("/updateadjust")
	public ResponseEntity<?> updateAdjuster(@RequestBody Adjuster adjuster){
		
		Adjuster adust  = adjusterService.findById(adjuster.getId());
		if(adust== null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
		
		return new ResponseEntity<>(adjusterService.add(adjuster), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteadjust/{id}")
	public ResponseEntity<?> deleteAdjuster(@PathVariable Long id){
		
		adjusterService.deleteById(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// FLOORING SECTION
	
	
	 @PostMapping("/addfloor/{id}")
	    public ResponseEntity<?> addFlooring(@PathVariable(value = "id") Long id, @RequestBody Set<Flooring> flooring){

	        Customer customer = customerService.findById(id);
	        for(Flooring f: flooring){

	        	flooringService.add(f);
	        	
	        }

	        customer.getFloorings().addAll(flooring);
	        customerService.add(customer);
	        

	        return new ResponseEntity<>(HttpStatus.CREATED);

	    }
	 
	    @PutMapping("/updateflooring")
		public ResponseEntity<?> updateFlooring(@RequestBody Flooring flooring){
			
		 	Flooring floor = flooringService.findById(flooring.getId());
			
			if(floor== null){
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
			
			return new ResponseEntity<>(flooringService.add(floor), HttpStatus.CREATED);
		}
	 
	    @DeleteMapping("/deleteflooring/{id}")
		public ResponseEntity<?> deleteFlooring(@PathVariable Long id){
			
			flooringService.deleteById(id);
			 return new ResponseEntity<>(HttpStatus.OK);
		}
	     
	  // FOOD SECTION
	     
	     
	        @PostMapping("/addfood/{id}")
		    public ResponseEntity<?> addFood(@PathVariable(value = "id") Long id, @RequestBody Set<Food> food){

		        Customer customer = customerService.findById(id);
		        for(Food f: food){
     	
		        	foodService.add(f);	        	
		        }

		        customer.getFood().addAll(food);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
	     
	        @PutMapping("/updatefood")
			public ResponseEntity<?> updateFood(@RequestBody Food food){
			
	        	Food fod = foodService.findById(food.getId());
			 					
				if(fod== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(foodService.add(food), HttpStatus.CREATED);
			}
		 

		    @DeleteMapping("/deletefood/{id}")
			public ResponseEntity<?> deleteFood(@PathVariable Long id){
				
				foodService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
		    
		 // KID SECTION
		    
		    @PostMapping("/addkid/{id}")
		    public ResponseEntity<?> addKid(@PathVariable(value = "id") Long id, @RequestBody Set<Kid> kid){

		       	Customer customer = customerService.findById(id);
		        for(Kid k: kid){
     	
		        	kidService.add(k);	        	
		        }

		        customer.getKids().addAll(kid);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
		    
		    @PutMapping("/updatekid")
			public ResponseEntity<?> updateKid(@RequestBody Kid kid){
			
		    	Kid kd = kidService.findById(kid.getId());
	        				 				
				if(kd== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(kidService.add(kd), HttpStatus.CREATED);
			}
		    
		    @DeleteMapping("/deletekid/{id}")
			public ResponseEntity<?> deleteKid(@PathVariable Long id){
				
				kidService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
		    
		    // MANAGER SECTION
		    
		    @PostMapping("/addmanager/{id}")
		    public ResponseEntity<?> addManager(@PathVariable(value = "id") Long id, @RequestBody Set<Manager> manager){

		    	
		        Customer customer = customerService.findById(id);
		        for(Manager m: manager){
     	
		        	managerService.add(m);	        	
		        }

		        customer.getManagers().addAll(manager);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
		    
		    @PutMapping("/updatemanager")
			public ResponseEntity<?> updateManager(@RequestBody Manager manager){
			
		    	
		    	Manager mngr = managerService.findById(manager.getId());
	        				 				
				if(mngr== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(managerService.add(manager), HttpStatus.CREATED);
			}
		    
		    @DeleteMapping("/deletemanger/{id}")
			public ResponseEntity<?> deleteManger(@PathVariable Long id){
				
				managerService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
	
		    // PLACE SECTION
		    
		    @PostMapping("/addplace/{id}")
		    public ResponseEntity<?> addPlace(@PathVariable(value = "id") Long id, @RequestBody Set<Place> place){

		    	
		        Customer customer = customerService.findById(id);
		        for(Place p : place){
     	
		        	placeService.add(p);	        	
		        }

		        customer.getPlaces().addAll(place);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
		    
		    @PutMapping("/updateplace")
			public ResponseEntity<?> updatePlace(@RequestBody Place place){
			
		    	Place plc = placeService.findById(place.getId());
		    	
	        				 				
				if(plc== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(placeService.add(place), HttpStatus.CREATED);
			}
		    
		    @DeleteMapping("/deleteplace/{id}")
			public ResponseEntity<?> deletePlace(@PathVariable Long id){
				
				placeService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
		    
		    // SPORT SECTION
		    
		    @PostMapping("/addsport/{id}")
		    public ResponseEntity<?> addSport(@PathVariable(value = "id") Long id, @RequestBody Set<Sport> sport){

		    	
		        Customer customer = customerService.findById(id);
		        for(Sport s : sport){
     	
		        	sportService.add(s);	        	
		        }

		        customer.getSports().addAll(sport);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
		    
		    @PutMapping("/updatesport")
			public ResponseEntity<?> updateSport(@RequestBody Sport sport){
			
		    	
		    	Sport sprt = sportService.findById(sport.getId());
		    	
	        				 				
				if(sprt== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(sportService.add(sport), HttpStatus.CREATED);
			}
		    
		    @DeleteMapping("/deletesport/{id}")
			public ResponseEntity<?> deleteSport(@PathVariable Long id){
				
				sportService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
		    
		  // SPOUSE SECTION
		    
		    
		    @PostMapping("/addspouse/{id}")
		    public ResponseEntity<?> addSpouse(@PathVariable(value = "id") Long id, @RequestBody Spouse spouse){

		    	
		        Customer customer = customerService.findById(id);
		        
		        customer.setSpouse(spouse);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
		    
		    @PutMapping("/updatespouse")
			public ResponseEntity<?> updateSpouse(@RequestBody Spouse spouse){
			
		    	Spouse spse = spouseService.findById(spouse.getId());
		    			    	        				 				
				if(spse== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(spouseService.add(spse), HttpStatus.CREATED);
			}
		    
		    @DeleteMapping("/deletespouse/{id}")
			public ResponseEntity<?> deleteSpouse(@PathVariable Long id){
				
				spouseService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
		    
		  // TRADE SECTION
		    
		    
		    @PostMapping("/addtrade/{id}")
		    public ResponseEntity<?> addTrade(@PathVariable(value = "id") Long id, @RequestBody Set<Trade> trade){

		    	
		        Customer customer = customerService.findById(id);
		        for(Trade t : trade){
     	
		        	tradeService.add(t);	        	
		        }

		        customer.getTrades().addAll(trade);
		        customerService.add(customer);
		       
		        return new ResponseEntity<>(HttpStatus.CREATED);
		    }
		    
		    
		    @PutMapping("/updatetrade")
			public ResponseEntity<?> updateTrade(@RequestBody Trade trade){
			
		    	Trade trd = tradeService.findById(trade.getId());
		    	
		    	
	        				 				
				if(trd== null){
		            return new ResponseEntity<>(HttpStatus.CONFLICT);
		        }
				
				return new ResponseEntity<>(tradeService.add(trade), HttpStatus.CREATED);
			}
		    
		    @DeleteMapping("/deletetrade/{id}")
			public ResponseEntity<?> deleteTrade(@PathVariable Long id){
				
				tradeService.deleteById(id);
				 return new ResponseEntity<>(HttpStatus.OK);
			}
		    
		    
}
