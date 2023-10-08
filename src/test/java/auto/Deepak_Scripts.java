package auto;

public class Deepak_Scripts {
	
	public static void main(String[] args) {
		
	
	
//	@Test(priority = 4, groups = { Groups.ORANGEHEALTH, Groups.DOCTOR, Groups.B2CPARTNER })
//	     public void verifyTestListAndPrices() throws Throwable
//	     {
//	         clickElement(driver, b2cDoctorHomePage.searchLabTests);
//	         String[] testPrices = testsPackagesListPage.searchTest(ConfigLoader.getValue("test_name"));
//	         int searchLabPageNetPrice = Integer.parseInt(testPrices[0]);
//	         int searchLabPageMRPPrice = Integer.parseInt(testPrices[1]);
//	         driver.navigate().back();
//	         scrollToElementAndClick(driver,b2cDoctorHomePage.orderTestButton);
//	         patientDetailsPage.enterPatientName();
//	         String phoneNumber = patientDetailsPage.enterPatientMobileNumber();
//	         patientDetailsPage.selectRequiredTest(ConfigLoader.getValue("test_name"));
//	         scrollToElementAndClick(driver,patientDetailsPage.reviewOrderButton);
//	         clickElement(driver,reviewOrderPage.confirmOrderButton);
//	         clickElement(driver,b2cDoctorHomePage.ordersAndReportsCard);
//	         waitForVisibilityOfElement(driver,ordersAndReportsPage.searchOrderField);
//	         sendKeys(driver,ordersAndReportsPage.searchOrderField,phoneNumber);
//	         clickElement(driver,ordersAndReportsPage.firstOrder);
//	         double orderPagePrices[] = ordersAndReportsPage.verifyPricesAfterOrderPlaced();
//	         double orderPageTotalMRP = orderPagePrices[0];
//	         double orderPageNetPrice = orderPagePrices[1];    
//	         Assert.assertEquals(searchLabPageMRPPrice, orderPageNetPrice);
//	         Assert.assertEquals(searchLabPageNetPrice, orderPageTotalMRP);
//	     }
	
//=============================================
	
//	@Test(priority = 4,groups = { Groups.ORANGEHEALTH, Groups.DOCTOR, Groups.B2CPARTNER })
//	     public void verifyPaymentBreakupFlowWithoutDiscount() throws Throwable{
//	         clickElement(driver,b2cDoctorHomePage.searchLabTests);
//	         testsPriceListPage.verifySearchTest(ConfigLoader.getValue("test_name"));
//	         double labTestPrice[]= testsPriceListPage.verifyLabTestPrices();
//	         double labPageTestTotalMRP = labTestPrice[0];
//	         double labPageTestNetPrice = labTestPrice [1];
//	         String patientName = patientDetailsPage.enterPatientName();
//	         String patientPhoneNumber = patientDetailsPage.enterPatientMobileNumber();
//	         patientDetailsPage.selectRequiredTest(ConfigLoader.getValue("test_name"));
//	         Assert.assertFalse(isElementDisplayed(driver,consultantDoctorHomePage.testingForDoctorFamilyRadioButton));
//	         scrollToElementAndClick(driver,patientDetailsPage.reviewOrderButton);
//	         double reviewPagePrices[] = reviewOrderPage.verifyTestPricesWithoutDiscount();
//	         Assert.assertFalse(isElementDisplayed(driver, consultantDoctorHomePage.testingForDoctorFamilyRadioButton));
//	         double reviewPageTotalMRP = reviewPagePrices[0];
//	         double reviewPageNetPrice = reviewPagePrices[1];
//	         clickElement(driver,reviewOrderPage.confirmOrderButton);
//	         waitForElementToBeClickable(driver, b2cDoctorHomePage.ledgerText);
//	         clickElement(driver,b2cDoctorHomePage.ordersAndReportsCard);
//	         ordersAndReportsPage.verifyOrderCreated(patientName,patientPhoneNumber);
//	         clickElement(driver,ordersAndReportsPage.firstOrder);
//	         double orderPagePrices[] = ordersAndReportsPage.verifyPricesAfterOrderPlaced();
//	         double orderPageTotalMRP = orderPagePrices[0];
//	         double orderPageNetPrice = orderPagePrices[1];            
//	         double doctorEarning = (orderPageTotalMRP-orderPageNetPrice);
//	         Assert.assertEquals(reviewPageTotalMRP, orderPageTotalMRP);
//	         Assert.assertEquals(reviewPageNetPrice, orderPageNetPrice);
//	     }
	
//	==========================================
//  
//	     @Test(priority = 5,groups = { Groups.ORANGEHEALTH, Groups.DOCTOR, Groups.B2CPARTNER })
//	     public void verifyPaymentBreakupFlowWithDiscount() throws Throwable
//	     {
//	         clickElement(driver,b2cDoctorHomePage.searchLabTests);
//	         testsPriceListPage.verifySearchTest(ConfigLoader.getValue("test_name"));
//	         double labTestPrice[]= testsPriceListPage.verifyLabTestPrices();
//	         double labPageTestTotalMRP = labTestPrice[0];
//	         double labPageTestNetPrice = labTestPrice [1];
//	         String patientName = patientDetailsPage.enterPatientName();
//	         String patientPhoneNumber = patientDetailsPage.enterPatientMobileNumber();
//	         patientDetailsPage.selectRequiredTest(ConfigLoader.getValue("test_name"));
//	         Assert.assertFalse(isElementDisplayed(driver,consultantDoctorHomePage.testingForDoctorFamilyRadioButton));
//	         scrollToElementAndClick(driver,patientDetailsPage.reviewOrderButton);
//	         double reviewPagePrices[]=reviewOrderPage.applyAdditionalDiscountAndVerifyPaymentStatus(10);
//	         Assert.assertFalse(isElementDisplayed(driver, consultantDoctorHomePage.testingForDoctorFamilyRadioButton));
//	         double reviewPageTotalMRP = reviewPagePrices[0];
//	         double reviewPageNetPrice = reviewPagePrices[1];
//	         clickElement(driver,reviewOrderPage.confirmOrderButton);
//	         waitForElementToBeClickable(driver, b2cDoctorHomePage.ledgerText);
//	         clickElement(driver,b2cDoctorHomePage.ordersAndReportsCard);
//	         ordersAndReportsPage.verifyOrderCreated(patientName,patientPhoneNumber);
//	         clickElement(driver,ordersAndReportsPage.firstOrder);
//	         double orderPagePrices[] = ordersAndReportsPage.verifyPricesAfterOrderPlaced();
//	         double orderPageTotalMRP = orderPagePrices[0];
//	         double orderPageNetPrice = orderPagePrices[1];            
//	         double doctorEarning = (orderPageTotalMRP-orderPageNetPrice);
//	         Assert.assertEquals(reviewPageTotalMRP, orderPageTotalMRP);
//	         Assert.assertEquals(reviewPageNetPrice, orderPageNetPrice);
	
	//===================================
	
//	public double[] verifyTestPricesWithoutDiscount()
//	     {
//	         int totalAmount = Integer.parseInt((totalMrp.getText().split("₹"))[1]);
//	         int netPriceAmount = Integer.parseInt((netPrice.getText().split("₹"))[1]);
//	         int doctorEarningAmount = Integer.parseInt((doctorEarningPrice.getText().split("₹"))[1]);
//	         double prices[] = {totalAmount,netPriceAmount,doctorEarningAmount};
//	         return prices;
//	     }
//	     
//	     public double[] applyAdditionalDiscountAndVerifyPaymentStatus(int discountPercentage)
//	     {
//	         waitForVisibilityOfElement(driver, additionalDiscountText);
//	         additionalDiscountText.click();
//	         waitForVisibilityOfElement(driver, discountDeductionText);
//	         discountPercentageField.sendKeys(String.valueOf(discountPercentage));
//	         applyButton.click();
//	         waitForVisibilityOfElement(driver, removeDiscountButton);
//	         waitForVisibilityOfElement(driver, driver
//	                 .findElement(By.xpath("//android.widget.TextView[@text='Discount @ " + discountPercentage + "%']")));
//	         int totalAmount = Integer.parseInt((totalMrp.getText().split("₹"))[1]);
//	         int netPriceAmount = Integer.parseInt((netPrice.getText().split("₹"))[1]);
//	         int discountAmountInRupees = Integer.parseInt((discountAmount.getText().split("₹"))[1]);
//	         int amountPayableByPatientInRupees = Integer.parseInt((amountPayableByPatient.getText().split("₹"))[1]);
//	         int doctorEarning = (amountPayableByPatientInRupees) - (netPriceAmount);
//	         Assert.assertEquals(amountPayableByPatientInRupees, (totalAmount - discountAmountInRupees));
//	         double prices[] = {totalAmount, netPriceAmount, doctorEarning};
//	         return prices;
//	     }
//	 }
	}
}
