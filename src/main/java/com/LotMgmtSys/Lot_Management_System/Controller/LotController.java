package com.LotMgmtSys.Lot_Management_System.Controller;

import com.LotMgmtSys.Lot_Management_System.Entity.Lot;
import com.LotMgmtSys.Lot_Management_System.Service.LotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Controller for Lot
* consist of various exposed endpoints to perform CRUD operation
* has some dedicated endpoint to perform certain crud points
*/


@RestController
public class LotController {

	@Autowired
	LotServices lotServices;

	@PostMapping("/Lot/newLot")
	public ResponseEntity<String> createLot(@RequestBody Lot newLot){
		try {
			Lot createdLot = lotServices.createLot(newLot);
			return new ResponseEntity<>("Lot create as - " + createdLot.toString(), HttpStatus.CREATED);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to create Lot" + exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Lot/Delete/{id}")
	public ResponseEntity<String> deleteLot(@PathVariable Long id){
		try {
			lotServices.deleteLot(id);
			return new ResponseEntity<>("Lot Deleted at " + id , HttpStatus.OK);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to Delete Lot at " + id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Lot/DeleteAll")
	public ResponseEntity<String> deleteAllLot(){
		try {
			lotServices.deleteAllLot();
			return new ResponseEntity<>("Deleted all Lots ", HttpStatus.OK);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to Delete all lot", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Lot/{id}/Update")
	public ResponseEntity<String> updateLot(@PathVariable Long id, @RequestBody Lot updateLot)  {
		try {
			Lot updatedLot = lotServices.updateLot(id, updateLot);
			return new ResponseEntity<>("Lot updated - " + updatedLot.toString(), HttpStatus.OK);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to Update Lot " + exp.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/Lot/{id}/status/{status}")
	public ResponseEntity<String> statusUpdate(@PathVariable Long id, @PathVariable String status)  {
		try {
			lotServices.updateStatus(id, status);
			return new ResponseEntity<>("Status updated of Lot with ID - " + id, HttpStatus.OK);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to Update status " + exp.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Lot/Search/All")
	public ResponseEntity<List<Lot>> searchAll() {
		List<Lot> lot;
		try {
			lot = lotServices.findAll();
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lot != null) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Lot/Search/{id}")
	public ResponseEntity<Lot> searchById(@PathVariable Long id) {
		Lot lot;
		try {
			lot = lotServices.findLotByID(id);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (lot != null) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Lot/Search/To/{to}")
	public ResponseEntity<List<Lot>> searchByTo(@PathVariable String to) {
		List<Lot> lot;
		try {
			lot = lotServices.findAllByTo(to);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!lot.isEmpty()) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Lot/Search/From/{from}")
	public ResponseEntity<List<Lot>> searchByFrom(@PathVariable String from) {
		List<Lot> lot;
		try {
			lot = lotServices.findAllByFrom(from);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!lot.isEmpty()) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Lot/Search/Status/{status}")
	public ResponseEntity<List<Lot>> searchByStatus(@PathVariable String status) {
		List<Lot> lot;
		try {
			lot = lotServices.findAllByStatus(status);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!lot.isEmpty()) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Lot/Search/Date/{Date}")
	public ResponseEntity<List<Lot>> searchByCreationDate(@PathVariable String Date) {
		List<Lot> lot;
		try {
			lot = lotServices.findAllByDate(Date);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!lot.isEmpty()) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/Lot/Search/DateTo/{DateTo}/DateFrom/{DateFrom}")
	public ResponseEntity<List<Lot>> searchByCreationDateBetween(@PathVariable String DateTo,
	                                                             @PathVariable String DateFrom) {
		List<Lot> lot;
		try {
			lot = lotServices.findAllByDate(DateTo, DateFrom);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (!lot.isEmpty()) return new ResponseEntity<>(lot, HttpStatus.FOUND);
		else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
