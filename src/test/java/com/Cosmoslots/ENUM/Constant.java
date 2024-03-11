package com.Cosmoslots.ENUM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.Cosmoslots.utilities.BaseClass;

public class Constant {
	
	public static BaseClass bc = new BaseClass();
	public static String Firstnm = bc.Fakefirstname();
	public static String Lastnm = bc.Fakelastname();
	public static String Email = bc.FakeEmail().toLowerCase();
	public static String Phonenm = bc.Fakephonenumber().replaceAll("[^\\w\\s]", "");
	public static String Usernm = Firstnm + Lastnm;
	public static String email = Firstnm+Lastnm+"@gmail.com".toLowerCase();
	public static String Password="Gameium@1234";
	public static String DuplicateEmail = "ria@yopmail.com";
	public static String store = "CosmoSlot ";
	public static String parentuser = "Cosmopos Pos";
	public static String PlayerId=Email;
	public static String randNum = RandomStringUtils.randomNumeric(10);
	public static String randNum2 = RandomStringUtils.randomNumeric(2);

	public static String randomString = RandomStringUtils.randomAlphabetic(4); 
	public static String AnnouncementTitle="announcement"+RandomStringUtils.randomNumeric(6);
	public static Calendar today = Calendar.getInstance();
	public static String month = today.get(Calendar.DATE) + "";
	public static int DateInt = (int) Integer.parseInt(month);
	
	//PlayerProfile variables
	public static String Player_Id = "CS-1400";
	public static String Skrillid = "itsupport@ombpmllp.com";
	public static String cashappid = "itsupport@ombpmllp.com";
	public static String packge = "starpack4kTf";
	public static String Pkgamount = "10";
	public static String GT = "100";
	public static String ST = "100";

	//User Management variables
	
	public static String r = RandomStringUtils.randomAlphanumeric(4);
	public static List<String> shift = new ArrayList<String>();
	public static List<String> shiftweb = new ArrayList<String>();
	public static List<String> refcodeArray = new ArrayList<String>();
	public static int TotalStorePackage = 0;
	public static int purchasebool = 0;
	public static int pvr = 0;
	public static int parentcount = 0;
	
	//Pankaj
	public static String[] strAr = { "Master ", "Distributor ", "Agent ", "Store ", "POS " };
	public static String[] parentuser1 = { " Gameium Admin " };
	public static List<String> emailArray = new ArrayList<String>();
	public static int BonusGL = 100;
	public static int BonusSL = 100;
	public static int numberOfReferrals = 1;
	public static int rechargeAmount = 1;
	public static int nameBonusLevel_Increase = 0;
	public static int numberOfLevel = 3;
	public static String customPackageAdmin = "";
	public static String AdminDashboard = "/dashboard";
    public static String AdminPlayerProfile = "/player/list";
    public static String AdminGuestPlayer = "/guest-player/list";
    public static String AdminWithdrawRequests = "/payment/withdraw";
    public static String AdminWalletWithdrawRequests = "/wallet/withdraw";
    public static String AdminWalletdeposit = "/wallet/deposit";
    public static String AdminPurchaseHistory = "/payment/list";
    public static String AdminBlockUserdata = "/blocked-list/by-user-deta";
    public static String AdminBlockByIP = "/blocked-list/by-ip";
    public static String AdminJackpotWins = "/payment/jackpotwins";
    public static String AdminPlayerDeletion = "/player-deletion-history/list";
    public static String AdminprospectivePlayers = "/prospective-players/list";
    public static String AdminLobbyList = "/lobby/list";
    public static String AdminAccessControl = "/user/access-control";
    public static String AdminUserRole = "/user/role";
    public static String AdminUserControl = "/user/user-control";
    public static String AdminUserAdd = "/user/user-control/add";
    public static String AdminOrgChart = "/user/org-list";
    public static String AdminSupport = "/support/list";
    public static String AdminContactDetails = "/support/contact-details";
    public static String AdminChat = "/chat/list";
    public static String AdminHelpPlayer = "/help-player";
    public static String AdminNotification = "/notification/list";
    public static String AdminAnnouncement = "/announcement/list";
    public static String AdminDownloadList = "/download/list";
    public static String AdminChatProspectiveview = "/chat/prospective/view";
    public static String AdminSettingMyProfile = "/setting/my-profile";
    public static String AdminDevelopertools = "developertools/master-developer-tools";
    public static String AdminMasterSettings = "/setting/master-settings";
    public static String AdminChangePassword = "/setting/change-password";

    public static String WebsitePlayerProfile = "/profile";
    public static String WebsitePackages = "/profile?tab=packages";
    public static String WebsiteStats = "/profile?tab=stats";
    public static String WebsiteBonuses = "/profile?tab=bonuses";
    public static String WebsiteWithdraw = "/profile?tab=withdraw";
    public static String WebsiteTransactions = "/profile?tab=transactions";
    public static String WebsiteSupports = "/profile?tab=support";
    public static String WebsiteGameTransations = "/profile?tab=game-transactions";
    public static String WebsiteAnnoucement = "/profile?tab=announcement";
    public static String WebsiteVerify = "/profile?tab=verify";
    public static String WebsiteWallet = "/profile?tab=wallet";
    public static String WebsiteGames = "/games";
    public static String WebsiteAboutus = "/about-us";;
    public static String WebsitePromotions = "/promotions";
    public static String WebsiteNews = "/news";;
    public static String WebsiteContactus = "/contact-us";
    public static String WebsiteFreeSpin = "/earn-free-spin";
    public static String WebsiteFunzone = "/funzone";
    public static String WebsiteDownload = "/download";
//	public static ReadConfig readconfig = new ReadConfig();
//
//	public static String r = RandomStringUtils.randomAlphanumeric(4);
//	public static String randomString = r;
//	public static String randNum = RandomStringUtils.randomNumeric(4);
//	public static int BonusGL = 100;
//	public static int BonusSL = 100;
//	public static int numberOfReferrals = 1;
//	public static int rechargeAmount = 1;
//	public static int nameBonusLevel_Increase = 0;
//	public static int numberOfLevel = 3;
//	public static String customPackageAdmin = "";
//	public static Calendar today = Calendar.getInstance();
//	public static String month = today.get(Calendar.DATE) + "";
//	public static int DateInt = (int) Integer.parseInt(month);
//	public static String Skrillmethodd = "";
//	public static String Withdrawmethodd = "";
//	public static String SkrillmWithdrawmethoddethodd = "";
//	public static String UploadImage = readconfig.getImgUrl();
//	public static int TotalStorePackage = 0;
//	public static int purchasebool = 0;
//	public static int pvr = 0;
//	public static int parentcount = 0;
//	public static String[] strAr = { "Master ", "Distributor ", "Sub Distributor ", "Store ", "POS " };
//	public static String[] parentuser = { " Gameium Admin " };
//	public static List<String> shift = new ArrayList<String>();
//	public static List<String> shiftweb = new ArrayList<String>();
//	public static List<String> refcodeArray = new ArrayList<String>();
//	public static List<String> emailArray = new ArrayList<String>();
//	public static int randDigt = (int) Math.floor(Math.random() + 100000000);
//	public String Firstnm = BaseClass.Fakefirstname();
//	public String Lastnm = BaseClass.Fakelastname();
//	public String Usernm = Firstnm + Lastnm;
}
