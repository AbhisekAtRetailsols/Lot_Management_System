package com.LotMgmtSys.Lot_Management_System.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *   Defines the Device Entity,
 *   Uses Lombok to do the Boilerplate code
 *   Table is represented as t_device in Database, with column as Device ID, Manufacturer, Model, Colour, Device
 *   Quantity in a Lot.
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_device")
public class Device {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="device_number")
	@SequenceGenerator(name="device_number", sequenceName="device_number", allocationSize=1)
	private Long deviceId;
	private String manufacturer;
	private String model;
	private String colour;
	private Integer deviceQuantity;

}
