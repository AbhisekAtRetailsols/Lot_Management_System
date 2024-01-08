package com.LotMgmtSys.Lot_Management_System.Controller;

import com.LotMgmtSys.Lot_Management_System.Entity.Device;
import com.LotMgmtSys.Lot_Management_System.Entity.Lot;
import com.LotMgmtSys.Lot_Management_System.Service.DeviceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceController {

	@Autowired
	DeviceServices deviceServices;

	@GetMapping("/Device/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable Long id)   {
		try {
			Device getDevice = deviceServices.findDeviceById(id);
			if (getDevice != null) return new ResponseEntity<>(getDevice, HttpStatus.FOUND);
			else  return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/Device/{id}/Update")
	public ResponseEntity<String> updateDevice(@PathVariable Long id, @RequestBody Device updateDevice)  {
		try {
			Device updatedDevice = deviceServices.updateDevice(id, updateDevice);
			return new ResponseEntity<>("Device updated - " + updatedDevice.toString(), HttpStatus.OK);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to Update Device " + exp.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/Device/Delete/{id}")
	public ResponseEntity<String> deleteDevice(@PathVariable Long id)    {
		try {
			deviceServices.deleteDevice(id);
			return new ResponseEntity<>("Device Deleted at " + id , HttpStatus.OK);
		}
		catch (Exception exp)   {
			return new ResponseEntity<>("Failed to Delete Device at " + id, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
