package core;

import org.openqa.selenium.WebDriver;

public class SignUp {

    public static void validate(WebDriver driver, String url) {

	    Common.open(url);

	    int i = 0;

	    for (String key : Locators.getMylist().keySet()) {
		if (i == 42) {
		    return;
		} else {
		    Common.validatePage(i, key);

		    i++;
		}
	    }
	}
    }

