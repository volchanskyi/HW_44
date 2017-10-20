package core;

import org.openqa.selenium.WebDriver;

public class Confirmation {

    public static void validate(WebDriver driver, String url) {

	Common.open(url);
	Common.pageValidation(5, "el_05");
	Common.pageValidation(6, "el_06");
	Common.pageValidation(7, "el_07");
	Common.pageValidation(8, "el_08");
	Common.pageValidation(9, "el_09");
	Common.pageValidation(10, "el_10");
	Common.pageValidation(11, "el_11");
	Common.pageValidation(12, "el_12");
	Common.pageValidation(13, "el_13");
	Common.pageValidation(14, "el_14");
	Common.pageValidation(42, "el_42");
	Common.pageValidation(43, "el_43");

    }
}
