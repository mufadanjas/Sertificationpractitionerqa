import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// 1. Open Browser and Navigate to URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.saucedemo.com/')

// 2. Get and Verify the Title of the Web Page
String pageTitle = WebUI.getWindowTitle()
WebUI.verifyMatch(pageTitle, 'Swag Labs', false)

// 3. Verify Username Field is Present
TestObject usernameField = findTestObject('Object Repository/Page_Swag Labs/Verifikasi_element_username')
if (usernameField != null) {
	WebUI.verifyElementPresent(usernameField, 10)
} else {
	WebUI.comment('TestObject for Username field is null')
}

// 4. Verify Password Field is Present
TestObject passwordField = findTestObject('Object Repository/Page_Swag Labs/Verifikasi_element_username')
if (passwordField != null) {
	WebUI.verifyElementPresent(passwordField, 10)
} else {
	WebUI.comment('TestObject for Password field is null')
}

// 5. Verify Login Button is Present
TestObject loginButton = findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button')
if (loginButton != null) {
	WebUI.verifyElementPresent(loginButton, 10)
} else {
	WebUI.comment('TestObject for Login button is null')
}

// 6. Set Text in Username Field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')
WebUI.delay(2)

// 7. Set Text in Password Field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'secret_sauce')
WebUI.delay(2)

// 8. Click on Login Button
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))
WebUI.delay(2)

// 9. Verify User is Logged in
boolean isElementPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/div_Swag Labs'), 10)
// Print result
println("Is element present: " + isElementPresent)
if (isElementPresent) {
	// Highlight the element
	TestObject testObject = findTestObject('Object Repository/Page_Swag Labs/div_Swag Labs')
	String jsCode = 'arguments[0].style.border=\'3px solid red\''
	WebUI.executeJavaScript(jsCode, Arrays.asList(WebUI.findWebElement(testObject)))
	println("Element is present and highlighted.")
} else {
	println("Element is not present.")
}

// 10. Verify Products Page is Displayed
WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Products'), 'Products')
TestObject testObject = findTestObject('Object Repository/Page_Swag Labs/span_Products')
String jsCode = 'arguments[0].style.border=\'3px solid blue\''
WebUI.executeJavaScript(jsCode, Arrays.asList(WebUI.findWebElement(testObject)))
println("Element is present and highlighted.")

// choose 1 product
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/product1'))

// 11. Verify Add to Cart Button is Present for First Product
boolean isElementPresentButton = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart'), 10)
println("Is element present: " + isElementPresent)
if (isElementPresentButton) {
	// Highlight the element
	TestObject buttonObject = findTestObject('Object Repository/Page_Swag Labs/button_Add to cart')
	String jsHighlightCode = 'arguments[0].style.border=\'3px solid red\''
	WebUI.executeJavaScript(jsHighlightCode, Arrays.asList(WebUI.findWebElement(buttonObject)))
	println("Element is present and highlighted.")
} else {
	println("Element is not present.")
}

// 12. Click on add to card
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart'))

// 13. Verify Shopping Cart Badge is Updated
boolean isBadgePresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Badge_Keranjang'), 10)
if (isBadgePresent) {
	// Highlight the shopping cart badge element
	TestObject badgeObject = findTestObject('Object Repository/Page_Swag Labs/Badge_Keranjang')
	String jsHighlightBadge = 'arguments[0].style.border=\'3px solid yellow\''
	WebUI.executeJavaScript(jsHighlightBadge, Arrays.asList(WebUI.findWebElement(badgeObject)))
	println("Badge element is present and highlighted.")
} else {
	println("Badge element is not present.")
}

// 14. Click on Shopping Cart
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/Badge_Keranjang'))

// 15. Verify Cart Page is Displayed
boolean isCartPagePresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Halaman_Keranjang'), 10)
if (isCartPagePresent) {
	// Highlight the shopping cart page element
	TestObject cartPageObject = findTestObject('Object Repository/Page_Swag Labs/Halaman_Keranjang')
	String jsHighlightCartPage = 'arguments[0].style.border=\'3px solid green\''
	WebUI.executeJavaScript(jsHighlightCartPage, Arrays.asList(WebUI.findWebElement(cartPageObject)))
	println("Cart page element is present and highlighted.")
} else {
	println("Cart page element is not present.")
}

// 16. Verify Cart has 1 Item
boolean isCartHasOneItem = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Keranjang1Item'), 10)
if (isCartHasOneItem) {
	// Highlight the shopping cart page element
	TestObject cartOneItem = findTestObject('Object Repository/Page_Swag Labs/Keranjang1Item')
	String jsHighlightOneItem = 'arguments[0].style.border=\'3px solid red\''
	WebUI.executeJavaScript(jsHighlightOneItem, Arrays.asList(WebUI.findWebElement(cartOneItem)))
	println("Cart page element has one item is present and highlighted.")
} else {
	println("Cart page element has one item is not present.")
}

// 17. Click on Checkout Button
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))

//18. Verify Checkout Page is Displayed
boolean chekoutpagePresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Checkout_Page_Display'), 10)
if (chekoutpagePresent) {
	// Highlight the shopping cart badge element
	TestObject checkoutObject = findTestObject('Object Repository/Page_Swag Labs/Checkout_Page_Display')
	String jsHighlightcheckout = 'arguments[0].style.border=\'3px solid red\''
	WebUI.executeJavaScript(jsHighlightcheckout, Arrays.asList(WebUI.findWebElement(checkoutObject)))
	println("Checkout page is displayed and highlighted.")
} else {
	println("Checkout page is not displayed.")
}

// 19. Set Text in First Name Field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/Field_firstName'), 'Fadli')

// 20. Set Text in Last Name Field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/Field_lastName'), 'Anjas')

// 21. Set Text in Postal Code Field
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/Field_postalCode'), '12345')

// 22. Click on Continue Button
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/Button_continue'))

// 23. Verify Overview Page is Displayed
boolean overviewpagePresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Checkout Overview_Page'), 10)
if (overviewpagePresent) {
	// Highlight the shopping cart badge element
	TestObject checkoutOverview = findTestObject('Object Repository/Page_Swag Labs/Checkout Overview_Page')
	String jsHighlightoverview = 'arguments[0].style.border=\'3px solid blue\''
	WebUI.executeJavaScript(jsHighlightoverview, Arrays.asList(WebUI.findWebElement(checkoutOverview)))
	println("Checkout Overview page is displayed and highlighted.")
} else {
	println("Checkout Overview page is not displayed.")
}

// 24. Verify Total Price is Correct
// Define the test object paths
String totalPriceObjectPath = 'Object Repository/Page_Swag Labs/Total_Harga'
// Verify the total price element is present
boolean isTotalPricePresent = WebUI.verifyElementPresent(findTestObject(totalPriceObjectPath), 10)
if (isTotalPricePresent) {
    // Retrieve the total price text
    TestObject totalPriceObject = findTestObject(totalPriceObjectPath)
    String actualTotalPrice = WebUI.getText(totalPriceObject)
	String jsHighlightprice = 'arguments[0].style.border=\'3px solid red\''
	WebUI.executeJavaScript(jsHighlightprice, Arrays.asList(WebUI.findWebElement(totalPriceObject)))

    // Expected total price
    String expectedTotalPrice = 'Total: $32.39'  // Replace with the expected value

    // Verify the total price is correct
    WebUI.verifyEqual(actualTotalPrice, expectedTotalPrice)
    println("Total price is correct.")
} else {
    println("Total price element is not present.")
}

// 25. Click on Finish Button
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Finish'))


// 26. Verify Order Confirmation Page is Displayed
boolean OrderConfirmationPagePresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Verif_Halaman_KonfirmasiPesanan'), 10)
if (OrderConfirmationPagePresent) {
	// Highlight the shopping cart page element
	TestObject ConfirmPageObject = findTestObject('Object Repository/Page_Swag Labs/Verif_Halaman_KonfirmasiPesanan')
	String jsHighlightOrderConfirm = 'arguments[0].style.border=\'3px solid green\''
	WebUI.executeJavaScript(jsHighlightOrderConfirm, Arrays.asList(WebUI.findWebElement(ConfirmPageObject)))
	println("Order confirmation page element is present and highlighted.")
} else {
	println("Order confirmation page element is not present.")
}

// Close Browser
WebUI.delay(2)
WebUI.closeBrowser()