package com.app.onlineShopping.controller;

import com.app.onlineShopping.model.Address;
import com.app.onlineShopping.repository.AddressRepository;
import com.app.onlineShopping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	
	@Autowired
	private AddressRepository repo;
	
	@PostMapping("/saveAddress")
	@CrossOrigin(origins = "http://localhost:4200")
	public Address saveAddressIndb(@RequestBody Address address) throws Exception,Throwable {
		Address addressObj = null;
		addressObj = service.saveAddress(address);
		return addressObj;
	}
	
	@GetMapping("/getAddress/{userId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Address getAddressIndb(@PathVariable(value = "userId") int id) throws Exception,Throwable {
		return service.fetchAddressByAddressId(id);
	}
	
	@GetMapping("/getAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Address> getAllNotes()
    {
        return service.ferchAllAddress();
    }
	
	@DeleteMapping("/deleteAddress/{addressId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Address deleteAddress(@PathVariable(value = "addressId") int id)
	{
		return repo.deleteById(id);
	}
	
//	@PutMapping("/updateAddress/{userId}")
//	@CrossOrigin(origins = "http://localhost:4200")
//	private ResponseEntity<Object> updateOrder(@RequestBody User user,@PathVariable(value = "userId") int id)   
//	{  
//		Optional<User> userRepo = Optional.ofNullable(repo.findById(id));
//		if(!userRepo.isPresent())
//			return ResponseEntity.notFound().build();
//		user.setId(id);
//		repo.save(user);
//		return ResponseEntity.noContent().build();
//	}
}
