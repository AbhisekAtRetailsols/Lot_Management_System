package com.LotMgmtSys.Lot_Management_System.Repository;

import com.LotMgmtSys.Lot_Management_System.Entity.Lot;
import com.LotMgmtSys.Lot_Management_System.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/*
* extends to JpaRepository
* list out few custom method to perform customized retrieve.
*/

public interface LotJPARepository extends JpaRepository<Lot, Long> {

	List<Lot> findAllByToLocation(String to);

	List<Lot> findAllByFromLocation(String from);

	List<Lot> findAllByStatus(Status status);

	List<Lot> findAllByCreationDateAfter(Date date);

	List<Lot> findAllByCreationDateBetween(Date startDate, Date endDate);

}
