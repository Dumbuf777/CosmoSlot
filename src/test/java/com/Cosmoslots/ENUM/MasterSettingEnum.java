package com.Cosmoslots.ENUM;
import com.Cosmoslots.utilities.BaseClass;
public enum MasterSettingEnum {

////Advance filter variables
	Search_Promotion("CosmoSlots"),
	 Verify_Homepage("sub title"),
	 Search_Lobby("Cosmo"),
	 Verify_News("News"),
	 Verify_FAQ("sub title"),
	 Upload_Icon(BaseClass.UploadImage), // ./Cosmoslots/target/image/2_mb.jpg");
	 metadata_title("Redemption Policy"),
	 ReleaseNotes("1.1.1"),
	 Releaseurl("www.cosmoslots.com"),
	 Promotion_Search("Unlock next level to generate new token " + Constant.randNum),
	 Search_HomePage("New Home page"),
	 News_Create("title1" + Constant.randNum);

	private String value;

	MasterSettingEnum(String value) {
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
