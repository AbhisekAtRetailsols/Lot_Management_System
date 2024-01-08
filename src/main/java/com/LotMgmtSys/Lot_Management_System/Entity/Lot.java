package com.LotMgmtSys.Lot_Management_System.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 *  Defines the Lot Entity in the Database,
 *  uses lombok to do the Boilerplate code
 *  has attribute as Lot ID, List of Devices, Creation Date (dd-MM-yyyy),
 *  Status regarding the Lot in the form of ENUM variable,
 *  TO and FROM location for source and destination
  **/


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_lot")
public class Lot {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lot_number")
	@SequenceGenerator(name="lot_number", sequenceName="lot_number", allocationSize=1)
	private Long lotId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Device> devices;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date creationDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String toLocation;
	private String fromLocation;


}
