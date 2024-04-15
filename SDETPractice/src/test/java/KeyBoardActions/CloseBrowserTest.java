package KeyBoardActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class CloseBrowserTest {

	public static void main(String[] args) throws AWTException, IOException {
		Runtime r=Runtime.getRuntime();
		Process proc=r.exec("taskkill /im chrome.exe /f /t");

	}

}
