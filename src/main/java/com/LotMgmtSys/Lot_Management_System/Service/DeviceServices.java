package com.LotMgmtSys.Lot_Management_System.Service;

import com.LotMgmtSys.Lot_Management_System.Entity.Device;
import com.LotMgmtSys.Lot_Management_System.Entity.Lot;
import com.LotMgmtSys.Lot_Management_System.Repository.DeviceJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
* consist of method related to device's creation, deletion and update.
*/

@Service
public class DeviceServices {

	@Autowired
	DeviceJPARepository deviceJPARepository;

	public Device updateDevice(Long id, Device updateDevice) throws Exception {
		Device getDevice = deviceJPARepository.findById(id)
				.orElseThrow(() -> new Exception("Device not found using ID " + id));
		getDevice.setManufacturer(updateDevice.getManufacturer());
		getDevice.setModel(updateDevice.getModel());
		getDevice.setColour(updateDevice.getColour());
		getDevice.setDeviceQuantity(updateDevice.getDeviceQuantity());

		deviceJPARepository.save(getDevice);

		return deviceJPARepository.findById(id).get();
	}


	public String createDevice(Device createDevice) {
		Optional<Device> gotDevice =
				deviceJPARepository.findByManufacturerAndModelAndColour(createDevice.getManufacturer(),
				createDevice.getModel(), createDevice.getColour());
		if (gotDevice.isPresent()) return "Device already recorded at ID - " + gotDevice.get().getDeviceId();
		else {
			Device created = deviceJPARepository.save(createDevice);
			return "Device added Successfully at ID - " + created.getDeviceId();
		}
	}

	public Device findDeviceById(Long id) {
		Optional<Device> gotDevice = deviceJPARepository.findById(id);
		if (gotDevice.isPresent()) return gotDevice.get();
		else return null;
	}

	public void deleteDevice(Long id) {
		deviceJPARepository.deleteById(id);
	}
}
