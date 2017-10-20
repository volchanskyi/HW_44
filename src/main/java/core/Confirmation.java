package core;

import org.openqa.selenium.WebDriver;

public class Confirmation {

    public static void validate(WebDriver driver, String url) {

	Common.open(url);
	Common.validatePage(5, "el_05");
	Common.validatePage(6, "el_06");
	Common.validatePage(7, "el_07");
	Common.validatePage(8, "el_08");
	Common.validatePage(9, "el_09");
	Common.validatePage(10, "el_10");
	Common.validatePage(11, "el_11");
	Common.validatePage(12, "el_12");
	Common.validatePage(13, "el_13");
	Common.validatePage(14, "el_14");
	Common.validatePage(42, "el_42");
	Common.validatePage(43, "el_43");

    }
}
