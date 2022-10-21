//package com.dbexample.joinquery.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.dbexample.joinquery.entity.Brand;
//import com.dbexample.joinquery.entity.Laptop;
//import com.dbexample.joinquery.repository.BrandRepository;
//import com.dbexample.joinquery.repository.LaptopRepository;
//import com.dbexample.joinquery.request.LaptopRequest;
//
//@RestController
//public class LaptopController {
//	@Autowired
//	private LaptopRepository lapRepo;
//	@Autowired
//	private BrandRepository brandRepo;
//	
//	@PostMapping
//	public Laptop postMap(@RequestBody LaptopRequest request) {
//		return lapRepo.save(request.getLaptop());
//	}
//	
//	@GetMapping("/laptops")
//	public ResponseEntity<List<Laptop>> getData(@RequestParam String brand) {
//		return new ResponseEntity<List<Laptop>>(lapRepo.findBrand(brand),HttpStatus.OK);
//	}
//}