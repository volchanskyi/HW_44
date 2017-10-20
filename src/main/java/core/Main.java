package core;

import org.openqa.selenium.WebDriver;

public class Main {
    static long start;
    static long finish;
    static WebDriver driver;

    public static void main(String[] args) {
	System.out.println("Browser: HtmlUnit");
	System.out.println("+--------------------------------------------------------------+");
	start = System.currentTimeMillis();
	SignUp.validate(driver, "http://alex.academy/exe/signup/v1/index.php");
	System.out.println("+--------------------------------------------------------------+");
	Confirmation.validate(driver, "http://alex.academy/exe/signup/v1/confirmation.php");
	finish = System.currentTimeMillis();
	System.out.println("+--------------------------------------------------------------+");
	System.out.println("Response time: " + (finish - start) + " ms");
	Common.quite();
    }

}
