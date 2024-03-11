package com.Cosmoslots.ENUM;

public enum FilterEnum {

////Advance filter variables
	 firstNameValueFilter("First Name"),
	 lastNameValueFilter("Last Name"),
	 fullNameValueFilter("Name"),
	 playerIDValueFilter("Player ID"),
	 displayNameValueFilter("Display Name"),
	 userNameValueFilter("User"),
	 storeValueFilter("Store"),
	 emailValueFilter("Email"),
	 countryValueFilter("Country"),
	 stateValueFilter("State"),
	 cityValueFilter("City"),
	 currentTokensValueFilter("Current Tokens"),
	 redeemableTokensValueFilter("Redeemable Tokens"),
	 totalPurchaseAmountValueFilter("Total Purchase Amount"),
	 createdAtValueFilter("Created At"),
	 updatedAtValueFilter("Updated At"),
	 tagsValueFilter("Tags"),
	

	 //Player data
	 firstNameFilter("shrikrushna"),
	 lastNameFilter("sonkar"),
	 fullNameFilter("shrikrushna sonkar"),
	 playerIDFilter("CS-1400"),
	 displayNameFilter("SSCS1400"),
	 userNameFilter("Cosmopos"),
	 storeFilter("CosmoSlot"),
	 emailFilter("shrikrushna.sonkarr@gameium.com"),
	 countryFilter("India"),
	 stateFilter("Gujrat"),
	 cityFilter("gandhinagar"),
	 currentTokensFilter("100"),
	 redeemableTokensFilter("100"),
	 totalPurchaseAmountFilter("100"),
	 createdAtFilter("100"),
	 updatedAtFilter("100"),
	 tagsFilter(" shrikrishna "),
	 //Player  deletion data
	DeletionfirstName("Wallace"), DeletionlastName("Johnson"), DeletionfullName("Wallace Johnson"),
	DeletionplayerID("BW-1096"), DeletiondisplayName("Wallace_BW_1096"), DeletionuserName("pos_user"),;

	private String value;

	FilterEnum(String value) {
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
