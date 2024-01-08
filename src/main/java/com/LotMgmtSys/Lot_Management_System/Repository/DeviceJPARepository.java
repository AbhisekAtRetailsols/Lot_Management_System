package com.LotMgmtSys.Lot_Management_System.Repository;

import com.LotMgmtSys.Lot_Management_System.Entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceJPARepository extends JpaRepository<Device, Long> {

	public Optional<Device> findByManufacturerAndModelAndColour(String manufacturer, String model, String colour);
}
