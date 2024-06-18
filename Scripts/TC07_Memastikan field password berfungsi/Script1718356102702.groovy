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
TestObject usernameField = findTestObject('Page_Login/txt_Username')
if (usernameField != null) {
    WebUI.verifyElementPresent(usernameField, 10)
} else {
    WebUI.comment('TestObject for Username field is null')
}

// 4. Verify Password Field is Present
TestObject passwordField = findTestObject('Page_Login/txt_Password')
if (passwordField != null) {
    WebUI.verifyElementPresent(passwordField, 10)
} else {
    WebUI.comment('TestObject for Password field is null')
}

// 5. Verify Login Button is Present
TestObject loginButton = findTestObject('Page_Login/btn_Login')
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

WebUI.closeBrowser()



