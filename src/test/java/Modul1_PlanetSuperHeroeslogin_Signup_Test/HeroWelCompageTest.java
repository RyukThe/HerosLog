package Modul1_PlanetSuperHeroeslogin_Signup_Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.HerosWelcomePage;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.SignUp_Login_Page;

public class HeroWelCompageTest extends BaseClass
{
	
	int TCID;
	HerosWelcomePage wel;
	SignUp_Login_Page slp;
	org.apache.logging.log4j.Logger log= LogManager.getLogger("HeroWelCompageTest");
	
	
	@BeforeClass
	public void opnBr() throws EncryptedDocumentException, IOException
	{
		
		openBrowser();
		log.info("Opening broswer");
		wel= new HerosWelcomePage(m);
		slp= new SignUp_Login_Page(m);
		TCID=4;
		
		UtilityClass.getHandelDropDown(m,slp.clickSignUp_Login_Pageprofile());
		
		slp.login_signSignUp_Login_Page();
		
	}
	
	@Test
	public void verifytitle() throws EncryptedDocumentException, IOException
	{
		TCID=4;
		String act = wel.verifyHerosWelcomePageTitle();
		
		Assert.assertEquals(act, UtilityClass.getData("Sheet6", 2, 0));
	}
	@Test(dependsOnMethods = "verifytitle")
	public void login() throws IOException
	{
		wel.inpHerosWelcomePagemailorphone(UtilityClass.getPropertyFileData("email"));
		
		wel.clickHerosWelcomePageContinuebtn();
	}
	
	
	
	
	

}
