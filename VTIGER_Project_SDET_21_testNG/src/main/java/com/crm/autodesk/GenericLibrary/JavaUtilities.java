package com.crm.autodesk.GenericLibrary;

import java.util.Random;

/**
 * This class contains generic methods required by java
 * @author SHRUTHI
 *
 */
public class JavaUtilities 
{
	/**
	 * This method generates random number
	 */
	public int getRandomNumber()
	{
		Random rannum = new Random();
		int randomNum = rannum.nextInt(1000);
		return randomNum ;
	}
}
