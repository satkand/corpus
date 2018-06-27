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
		case '-':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_MINUS);
			break;
		case '.':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_PERIOD);
			break;
		case '@':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_AT);
			break;
		case '#':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_POUND);
			break;
		case ')':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_NUMPAD_RIGHT_PAREN);
			break;
		case '(':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_NUMPAD_LEFT_PAREN);
			break;
		case '+':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_PLUS);
			break;
		case ';':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_SEMICOLON);
			break;
		case '\'':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_APOSTROPHE);
			break;
		case '/':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_SLASH);
			break;
		case '*':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_STAR);
			break;
		case 'A':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_A,1);
			break;
		case 'B':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_B,1);
			break;
		case 'C':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_C,1);
			break;
		case 'D':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_D,1);
			break;
		case 'E':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_E,1);
			break;
		case 'F':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_F,1);
			break;
		case 'G':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_G,1);
			break;
		case 'H':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_H,1);
			break;
		case 'I':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_I,1);
			break;
		case 'J':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_J,1);
			break;
		case 'L':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_L,1);
			break;
		case 'M':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_M,1);
			break;
		case 'N':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_N,1);
			break;
		case 'O':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_O,1);
			break;
		case 'P':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_P,1);
			break;
		case 'Q':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_Q,1);
			break;
		case 'R':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_R,1);
			break;
		case 'S':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_S,1);
			break;
		case 'T':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_T,1);
			break;
		case 'U':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_U,1);
			break;
		case 'V':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_V,1);
			break;
		case 'W':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_W,1);
			break;
		case 'X':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_X,1);
			break;
		case 'Y':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_Y,1);
			break;
		case 'Z':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_Z,1);
			break;	
		case 'a':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_A);
			break;
		case 'b':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_B);
			break;
		case 'c':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_C);
			break;
		case 'd':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_D);
			break;
		case 'e':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_E);
			break;
		case 'f':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_F);
			break;
		case 'g':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_G);
			break;
		case 'h':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_H);
			break;
		case 'i':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_I);
			break;
		case 'j':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_J);
			break;
		case 'k':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_K);
			break;
		case 'l':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_L);
			break;
		case 'm':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_M);
			break;
		case 'n':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_N);
			break;
		case 'o':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_O);
			break;
		case 'p':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_P);
			break;
		case 'q':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_Q);
			break;
		case 'r':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_R);
			break;
		case 's':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_S);
			break;
		case 't':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_T);
			break;
		case 'u':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_U);
			break;
		case 'v':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_V);
			break;
		case 'w':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_W);
			break;
		case 'x':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_X);
			break;
		case 'y':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_Y);
			break;
		case 'z':
			inputKeysByKeyboard(AndroidKeyCode.KEYCODE_Z);
			break;

		}
	}
	
	

}
