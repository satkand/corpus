package pages.marketplace.common;

import automation.framework.common.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Keyboard extends BasePage{

	public Keyboard(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void enterKeyUsingKeyboard(char key) {

		switch (key) {

		case '1':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_1);
			break;
		case '2':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_2);
			break;
		case '3':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_3);
			break;
		case '4':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_4);
			break;
		case '5':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_5);
			break;
		case '6':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_6);
			break;
		case '7':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_7);
			break;
		case '8':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_8);
			break;
		case '9':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_9);
			break;
		case '0':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_0);
			break;
		case '.':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_PERIOD);
		case 'a':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_A);

		}
	}
	
	

}
