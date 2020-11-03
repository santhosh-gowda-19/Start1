package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Acti_Login;
import generic.Base_Test;
import generic.Generic_Read_Excel;

public class Valid_Login extends Base_Test
{
	@Test
	public void validlogin()
	{
		String uname  = Generic_Read_Excel.getData("Sheet1",0,0);
		String pwd  =Generic_Read_Excel.getData("Sheet1",0,1);
		Acti_Login act=new Acti_Login(driver); 
		act.setUsername(uname);
		act.setPassword(pwd);
		act.passBtn();
		Assert.fail();
	}
}
