package com.Cosmoslots.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getAdminURL()
	{
		String url=pro.getProperty("AdminURL");
		return url;
	}
	
	public String getWebURL()
	{
		String url=pro.getProperty("WebURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getGameiumUsername()
	{
	String Gusername=pro.getProperty("Gusername");
	return Gusername;
	}
	
	public String getMasterUsername()
	{
	String Musername=pro.getProperty("Musername");
	return Musername;
	}
	
	
	public String getDistributorUsername()
	{
	String Dusername=pro.getProperty("Dusername");
	return Dusername;
	}
	
	public String getSubdistributorUsername()
	{
	String SDusername=pro.getProperty("SDusername");
	return SDusername;
	}
	
	public String getStoreUsername()
	{
	String Susername=pro.getProperty("Susername");
	return Susername;
	}
	
	public String getPOSUsername()
	{
	String POSusername=pro.getProperty("POSusername");
	return POSusername;
	}
	
//	public String getGPassword()
//	{
//	String Gpassword=pro.getProperty("Gpassword");
//	return Gpassword;
//	}
	
	public String getPlayerId()
	{
	String username=pro.getProperty("PlayerId");
	return username;
	}
	
	public String getPlayerPass()
	{
	String username=pro.getProperty("PlayerPass");
	return username;
	}
	
	public String getImgUrl()
    {
    String ImgUrl=pro.getProperty("imgpath");
    return ImgUrl;
    }
	
	public String getImgUrl1()
    {
    String ImgUrl=pro.getProperty("imgpath1");
    return ImgUrl;
    }
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	public String getEdgePath()
	{
	String firefoxpath=pro.getProperty("edgepath");
	return firefoxpath;
	}
	public String getOperaPath()
	{
	String firefoxpath=pro.getProperty("operapath");
	return firefoxpath;
	}
	
	public String getBaseAPIURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
}




