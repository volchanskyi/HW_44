package core;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Linear {

    static WebDriver driver;
    static String url;
    static long start;
    static long finish;
    // static TreeMap<String, By> myList = new TreeMap<String, By>();
    private static final TreeMap<String, By> myList = createMap();

    public static void open(String url) {
	String USERAGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:55.0) Gecko/20100101 Firefox/55.0";
	Logger.getLogger("").setLevel(Level.OFF);
	driver = new HtmlUnitDriver();
	((HtmlUnitDriver) driver).setJavascriptEnabled(true);
	((HtmlUnitDriver) driver).getBrowserVersion().setUserAgent(USERAGENT);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get(url);
	System.out.println("Page URL: " + driver.getCurrentUrl());
	System.out.println(
		"UserAgent: " + (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));

    }

    private static TreeMap<String, By> createMap() {
	TreeMap<String, By> myList = new TreeMap<String, By>();
	myList.put("el_00", By.id("empty"));
	myList.put("el_01", By.id("id_quotes"));
	myList.put("el_02", By.id("id_current_location"));// signup
	myList.put("el_03", By.id("id_weather_icon")); // signup
	myList.put("el_04", By.id("id_temperature")); // signup
	myList.put("el_05", By.id("id_f_title")); // signup & confirmation
	myList.put("el_06", By.id("id_f_label_fn")); // signup & confirmation
	myList.put("el_07", By.id("id_fname")); // signup & confirmation
	myList.put("el_08", By.id("id_f_label_ln")); // signup & confirmation
	myList.put("el_09", By.id("id_lname")); // signup & confirmation
	myList.put("el_10", By.id("id_f_label_ea")); // signup & confirmation
	myList.put("el_11", By.id("id_email")); // signup & confirmation
	myList.put("el_12", By.id("id_f_label_pn")); // signup & confirmation
	myList.put("el_13", By.id("id_phone")); // signup & confirmation
	myList.put("el_14", By.id("id_rb_label_g")); // signup & confirmation
	myList.put("el_15", By.id("id_rb_label_m")); // signup
	myList.put("el_16", By.id("id_gender_male")); // signup
	myList.put("el_17", By.id("id_rb_label_f")); // signup
	myList.put("el_18", By.id("id_gender_female")); // signup
	myList.put("el_19", By.id("id_f_label_s")); // signup & confirmation
	myList.put("el_20", By.id("id_state")); // signup & confirmation
	myList.put("el_21", By.xpath("//*[@id='id_state']/option[6]")); // signup
	myList.put("el_22", By.id("id_cb_label_t")); // signup & confirmation
	myList.put("el_23", By.id("id_terms")); // signup & confirmation
	myList.put("el_24", By.id("id_img_facebook")); // signup
	myList.put("el_25", By.id("id_img_twitter")); // signup
	myList.put("el_26", By.id("id_img_flickr")); // signup
	myList.put("el_27", By.id("id_img_youtube")); // signup
	myList.put("el_28", By.id("id_reset_button")); // signup
	myList.put("el_29", By.id("id_submit_button")); // signup
	myList.put("el_30", By.id("timestamp")); // signup
	myList.put("el_31", By.id("copyright")); // signup & confirmation
	myList.put("el_32", By.id("os_browser")); // signup
	myList.put("el_33", By.id("ErrorLine")); // signup
	myList.put("el_34", By.id("fname_error")); // signup
	myList.put("el_35", By.id("lname_error")); // signup
	myList.put("el_36", By.id("email_error")); // signup
	myList.put("el_37", By.id("phone_error")); // signup
	myList.put("el_38", By.xpath("//*[@id='fname_error']/img")); // signup
	myList.put("el_39", By.xpath("//*[@id='lname_error']/img")); // signup
	myList.put("el_40", By.xpath("//*[@id='email_error']/img")); // signup
	myList.put("el_41", By.xpath("//*[@id='phone_error']/img")); // signup
	myList.put("el_42", By.id("id_gender")); // confirmation
	myList.put("el_43", By.id("id_back_button")); // confirmation
	return myList;
    }

    public static boolean isPresent(By by) {
	if (driver.findElements(by).size() > 0)
	    return true;
	else
	    return false;
    }

    public static boolean isVisible(By by) {
	if ((driver.findElements(by).size() > 0) && driver.findElement(by).isDisplayed())
	    return true;
	else
	    return false;
    }

    private static void printPresElems(int num, String elem) {
	System.out.println(elems[num] + (isPresent(getEl(elem)) ? "Exists" : "Not exist"));
    }

    private static void printVisElems(int num, String elem) {
	System.out.println(elems[num] + (isVisible(getEl(elem)) ? "Visible" : " Not visible"));
    }

    private static By getEl(String elem) {
	return myList.get(elem);
    }

    static String elems[] = { "00. Empty ", "01. Element [Quotes (dynamic)]: ", "02. Element [Current Location]: ",
	    "03. Element [Weather Icon]: ", "04. Element [Temperature]: ", "05. Element [Title]: ",
	    "06. Element [First Name (label)]: ", "07. Element [First Name (field)]: ",
	    "08. Element [Last Name (label)]: ", "09. Element [Last Name (field)]: ", "10. Element [Email (label)]: ",
	    "11. Element [Email (filed)]: ", "12. Element [Phone (label)]: ", "13. Element [Phone (field)]: ",
	    "14. Element [Genre (label)]: ", "15. Element [Male (label)]: ", "16. Element [Male (radio button)]: ",
	    "17. Element [Female (label)]: ", "18. Element [Female (radio button)]: ", "19. Element [State (label)]: ",
	    "20. Element [State (drop-down)]: ", "21. Element [State California (item)]: ",
	    "22. Element [Terms (label)]: ", "23. Element [Terms (checkbox)]: ", "24. Element [Image (facebook)]: ",
	    "25. Element [Image (twitter)]: ", "26. Element [Image (flickr)]: ", "27. Element [Image (youtube)]: ",
	    "28. Element [Reset (button)]: ", "29. Element [Submit (button)]: ", "30. Element [Timestamp (dynamic)]: ",
	    "31. Element [Copyright (dynamic)]: ", "32. Element [OS & Browser (dynamic)]: ",
	    "33. Element [Error Line]: ", "34. Element [First Name Error]: ", "35. Element [Last Name Error]: ",
	    "36. Element [Email Error]: ", "37. Element [Phone Error]: ", "38. Element [First Name Error (img)]: ",
	    "39. Element [Last Name Error (img)]: ", "40. Element [Email Error (img)]: ",
	    "41. Element [Phone Error (img)]: ", "42. Element [Genrge (field)): ", "43. Element [Back (button)]: " };

    public static void main(String[] args) {
	System.out.println("Browser: HtmlUnit");

	start = System.currentTimeMillis();

	url = "http://alex.academy/exe/signup/v1/index.php";

	open(url);
	System.out.println("------------- PRESENSE----------------");
	System.out.println("Page SignUp");
	// System.out.println(getEl("el_32"));

	int i = 0;
	for (String key : myList.keySet()) {
	    // iterate over key
	    // System.out.println(key);

	    printPresElems(i, key);
	    i++;
	}
	System.out.println("------------- VISABILITY----------------");

	printVisElems(33, "el_33"); // signup
	printVisElems(34, "el_34"); // signup
	printVisElems(35, "el_35"); // signup
	printVisElems(36, "el_36"); // signup
	printVisElems(37, "el_37"); // signup
	printVisElems(38, "el_38"); // signup
	printVisElems(39, "el_39"); // signup
	printVisElems(40, "el_40"); // signup
	printVisElems(41, "el_41"); // signup
	printVisElems(43, "el_43"); // signup

	System.out.println("OS/Browser: " + driver.findElement(getEl("el_32")).getText()); // signup
	System.out.println("+--------------------------------------------------------------+");
	driver.quit();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	url = "http://alex.academy/exe/signup/v1/confirmation.php";

	open(url);
	System.out.println("------------- PRESENSE----------------");
	System.out.println("Page Confirmation");
	printPresElems(1, "el_01");
	printPresElems(2, "el_02");
	printPresElems(3, "el_03");
	printPresElems(4, "el_04");
	printPresElems(5, "el_05");

	printPresElems(6, "el_06");
	// // signup &
	// // confirmation
	printPresElems(7, "el_07");
	// //signup &
	// // confirmation
	printPresElems(8, "el_08");
	// //signup &
	// // confirmation
	printPresElems(9, "el_09");
	// //signup &
	// // confirmation
	printPresElems(10, "el_10");
	// //signup &
	// // confirmation
	//
	printPresElems(11, "el_11");
	// //signup &
	// // confirmation
	printPresElems(12, "el_12");
	// //signup &
	// // confirmation

	driver.quit();

	finish = System.currentTimeMillis();
	System.out.println("+--------------------------------------------------------------+");
	System.out.println("Response time: " + (finish - start) + " ms");
    }
}
