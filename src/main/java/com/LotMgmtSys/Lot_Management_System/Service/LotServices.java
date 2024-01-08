package com.LotMgmtSys.Lot_Management_System.Service;

import com.LotMgmtSys.Lot_Management_System.Entity.Lot;
import com.LotMgmtSys.Lot_Management_System.Entity.Status;
import com.LotMgmtSys.Lot_Management_System.Repository.LotJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/*
*	This class is related to all the business logic related to Lot,
* it consists of various methods related to create, delete, update and retrieve operation
*/

@Service
public class LotServices {

	@Autowired
	private LotJPARepository lotJPARepository;


	public Lot createLot(Lot newLot) {
		return lotJPARepository.save(newLot);
	}

	public void deleteLot(Long id) {
		lotJPARepository.deleteById(id);
	}

	public void deleteAllLot() {
		lotJPARepository.deleteAll();
	}

	public Lot updateLot(Long id, Lot updateLot) throws Exception{
		Lot getLot = lotJPARepository.findById(id)
				.orElseThrow(() -> new Exception("Lot not found using ID " + id));
		getLot.setDevices(updateLot.getDevices());
		getLot.setStatus(updateLot.getStatus());
		getLot.setCreationDate(updateLot.getCreationDate());
		getLot.setFromLocation(updateLot.getFromLocation());
		getLot.setToLocation(updateLot.getToLocation());
		lotJPARepository.save(getLot);

		return lotJPARepository.findById(id).get();
	}

	public void  updateStatus(Long id, String status) throws Exception{
		Lot getLot = lotJPARepository.findById(id)
				.orElseThrow(() -> new Exception("Lot not found using ID " + id));
		getLot.setStatus(Status.getEnum(status));

		lotJPARepository.save(getLot);
	}

	public Lot findLotByID(Long id) {
		Optional<Lot> container = lotJPARepository.findById(id);
		return container.orElse(null);
	}

	public List<Lot> findAllByTo(String to) {
		return lotJPARepository.findAllByToLocation(to);
	}

	public List<Lot> findAllByFrom(String from) {
		return lotJPARepository.findAllByFromLocation(from);
	}

	public List<Lot> findAllByStatus(String status) {
		Status statusEnum = Status.getEnum(status);
		return lotJPARepository.findAllByStatus(statusEnum);
	}

	public List<Lot> findAllByDate(String... dateString) throws Exception {
		if (dateString.length == 2) {
			Date date1 = DateFormat.getDateInstance().parse(dateString[0]);
			Date date2 = DateFormat.getDateInstance().parse(dateString[1]);
			return lotJPARepository.findAllByCreationDateBetween(date1,date2);
		}
		Date date = DateFormat.getDateInstance().parse(dateString[0]);
		return lotJPARepository.findAllByCreationDateAfter(date);
	}

	public List<Lot> findAll() {
		return lotJPARepository.findAll();
	}
}
