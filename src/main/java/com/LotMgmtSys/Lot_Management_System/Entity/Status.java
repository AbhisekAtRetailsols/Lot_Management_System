package com.LotMgmtSys.Lot_Management_System.Entity;


/**
 * Status enum class is used to assign only those values that are related to the shipping
 * each of these variable defines itself and consist of CONFIRMED , SHIPPED , ON_TIME OR DELAYED, DELIVERED
 */
public enum Status {
	SHIPPED("shipped"),
	CONFIRMED("confirmed"),
	DELIVERED("delivered"),
	DELAYED("delayed"),
	ON_TIME("on time");

	private String value;

	// Constructor to initialize the enum with a String value
	Status(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	// Method to get the enum value from a String
	public static Status getEnum(String value) {
		for (Status Status : Status.values()) {
			if (Status.value.equalsIgnoreCase(value)) {
				return Status;
			}
		}
		throw new IllegalArgumentException("No enum constant with string value: " + value);
	}
}

