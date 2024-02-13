package com.Cosmoslots.ENUM;

import com.Cosmoslots.utilities.BaseClass;

public enum PlayerEnum {
	First(""), Last(""), pEmail(""),
	Upload_Icon(BaseClass.UploadImage),
	Upload_Icon1(BaseClass.UploadImage1),
	refcode(""),
	PlayersRegisration("3"),
	SearchPlayerID("AT131-1533"), // "CS-1426";
	otp("1234"), 
	min("10000001"),
	max("1000000001"), 
	numberOfLevel(""),
	lobbycode("AT131"),
	Package("starpack4kTf"),
	Skrillid("itsupport@ombpmllp.com"),
	cashappid("itsupport@ombpmllp.com"),
	PlayerId("CS-1400"),
	Pkgamount("10"),SearchItemSupportRequest("CS-SR-2936"),SearchItemPlayerLedger("Deposit"),
	SearchItemTrancsationHistory("91ae2aac-417e-4357-adf2-d89782ed1cb7"),
	SearchItemWithdrawRequest("CS-1222"),
	SearchItemPurchaseHistory("CS-1877"),
	SearchPlayer("Bhadresh Patel"),
	GT("100"),ST("100");

	private String value;

	PlayerEnum(String value) {
		this.value = value;
	}

	public void setValue(String newValue) {
		this.value = newValue;
	}

	public int toInt() {
		return Integer.parseInt(value);
	}

	public String getValue() {
		return value;
	}

}
