package com.Cosmoslots.ENUM;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import com.Cosmoslots.utilities.BaseClass;
public enum LobbyEnum {
	//Weburl(BaseClass.WebURL),
	playerId_Login("shrikrushna.sonkar@gameium.com"),
	playerId_Lobby("CS-1400"),
	default_StoreName("Cosmoslot"),
	Lcode("AT" + new Random().nextInt(10000)), LobbyName("store-" + RandomStringUtils.randomNumeric(5)),
	search_Storepackage("store" + Constant.randNum), 
	//search_StorepackageName("starpack" + Constant.r), 
	storePackageGT("500"),
	storePackageST("500"), 
	storePackageExtraST("100"), 
	storePackageAmount("10"), 
	storePackageDiscountAmount("1"),
	pkgAmount("10"), GT("100"),
	ST("100"), 
	search_CustomPackageName("starpackcc" + Constant.randomString),
	search_Custompackage("CUST" + Constant.randNum), 
	customPackageGT("250"),
	customPackageST("250"),
	customPackageExtraST("100"), 
	customPackageAmount("10"),
	search_Lobby("Cosmo"),
	search_Lobby_Expected("Cosmoslots"), 
	search_Game("Fortune Teller"), 
	search_Bonus("Registration"),
	search_BonusName("Registration"),
	nameBonusLevel("Level"), 
	jackpotName("Jackpot" + Constant.randomString),
	jackpot_InitialValue("1"), 
	jackpot_Percentage("10"), 
	JackpotST("Sweep Token"), 
	JackpotGT("Game Token"),
	storecouponName("coupon" + Constant.randomString), 
	storecouponamount("90"), 
	GameName("FOT"),
	Country("India"), LobbyDescription("This is just for AutoTesting"),
	SearchAddPlayerURL("yopmail"),
	Playerusername("cs-1400"), 
	storerole("Store "),
	storeusername("Renoi_Store__8129 "), 
	Lobbycode("Lcode"),
	POSnmm(""),
	Skrillmethod("Skrill"), 
	zenmethod("zen"),
	Othermethod("other"), 
	paySafeMethod("paysafe"), 
	fishgame("yes"),
	fishCode("Fish" + Constant.randNum),
	POSname(""), invitecode("mJXstbkG"), 
	storePackageAdmin(""),
	Withdrawmethod(""),
	onpurchase("On Package Purchase"),
	WebsiteTransactionid(""), paymentway(""),
	paymentMethodFromWebsite(""),
	afterpurchase("After Package Purchase"),
	PlayersRegisration("3"),
	EventType_Gameplay("Gameplay "),EventType_Login("Login "),EventType_LossMaking("Loss Making "),EventType_Purchase("Purchase "),
	TraceType_Daily("Daily "),TraceType_Hourly("Hourly "),TraceType_Monthly ("Monthly "),TraceType_Weekly ("Weekly "),TraceType_CustomDate("Custom Date "),
     ;
	private String value;

	LobbyEnum(String value) {
		this.value = value;
	}
	 public int toInt() {
	        return Integer.parseInt(value);
	    }
	public void setValue(String newValue) {
		this.value = newValue;
	}

	public String getValue() {
		return value;
	}
}
