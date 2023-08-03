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
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

elementUsername = WebUI.getText(findTestObject('login page/element username'))

ArrayList arrUsername = elementUsername.split('\n')

usernameSuccess = (arrUsername[1])

elementPassword = WebUI.getText(findTestObject('login page/element password'))

ArrayList arrPassword = elementPassword.split('\n')

password = (arrPassword[1])

print(usernameSuccess)

print(password)

WebUI.setText(findTestObject('login page/input username'), usernameSuccess)

WebUI.setText(findTestObject('login page/input password'), password)

WebUI.click(findTestObject('login page/button login'))

WebUI.verifyElementPresent(findTestObject('home page/title product'), 1)

WebUI.click(findTestObject('home page/title_Sauce Labs Backpack'))

WebUI.verifyElementPresent(findTestObject('detail product page/button back to product'), 1)

elementPrice = WebUI.getText(findTestObject('detail product page/title price'))

price = elementPrice.substring(1)

println(price)

WebUI.verifyElementPresent(findTestObject('detail product page/button add to cart'), 1)

WebUI.verifyElementNotPresent(findTestObject('detail product page/button remove from cart'), 1)

WebUI.click(findTestObject('detail product page/button add to cart'))

WebUI.verifyElementNotPresent(findTestObject('detail product page/button add to cart'), 1)

WebUI.click(findTestObject('detail product page/button go to cart'))

WebUI.verifyElementPresent(findTestObject('cart page/title your cart'), 1)

WebUI.verifyElementPresent(findTestObject('cart page/title cart sauce labs backpack'), 1)

elementPriceCart = WebUI.getText(findTestObject('cart page/title price cart'))

priceCart = elementPriceCart.substring(1)

println(priceCart)

if (price == priceCart) {
    println('Price Benar')
} else {
    println('Price Salah')

    KeywordUtil.markFailedAndStop('Price Salah')
}

WebUI.click(findTestObject('cart page/button checkout'))

WebUI.verifyElementPresent(findTestObject('checkout page/title checkout your information'), 1)

WebUI.setText(findTestObject('checkout page/input first name'), 'rafi')

WebUI.setText(findTestObject('checkout page/input last name'), 'tes')

WebUI.setText(findTestObject('checkout page/input postal code'), '123')

WebUI.click(findTestObject('checkout page/button continue'))

WebUI.verifyElementPresent(findTestObject('checkout page/title checkout overview'), 1)

WebUI.verifyElementPresent(findTestObject('checkout page/title cart sauce labs backpack'), 1)

elementPriceCheckout = WebUI.getText(findTestObject('checkout page/title price checkout'))

priceCheckout = elementPriceCheckout.substring(1)

elementPriceSubTotal = WebUI.getText(findTestObject('checkout page/title sub total'))

priceSubTotal = elementPriceSubTotal.substring(13)

priceSubTotal = Float.parseFloat(priceSubTotal)

println(priceSubTotal)

elementTax = WebUI.getText(findTestObject('checkout page/title tax'))

tax = elementTax.substring(6)

tax = Float.parseFloat(tax)

println(tax)

cekPriceTotal = (priceSubTotal + tax)

cekPriceTotal = cekPriceTotal.round(2)

println(cekPriceTotal)

elementPriceTotal = WebUI.getText(findTestObject('checkout page/title total final'))

priceTotal = elementPriceTotal.substring(8)

	if (priceCheckout.toString() == priceSubTotal.toString()) {
		println('Price Benar')
	} else {
		println('Price Salah')
		println(priceCheckout)
		println(priceSubTotal)
		KeywordUtil.markFailedAndStop('Price Salah')
	}
	
if (cekPriceTotal.toString() == priceTotal) {
    println('Price Total Benar')
} else {
    println('Price Total Salah')

    println(cekPriceTotal)

    println(priceTotal)

    KeywordUtil.markFailedAndStop('Price Total Salah')

}

WebUI.click(findTestObject('checkout page/button finish'))

WebUI.verifyElementPresent(findTestObject('checkout page/title checkout complate'), 1)

