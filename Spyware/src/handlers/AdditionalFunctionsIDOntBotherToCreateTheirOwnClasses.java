package handlers;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AdditionalFunctionsIDOntBotherToCreateTheirOwnClasses {

	public static String Filename = "einzScreen";
	public static void MakeScreenshot() {
		
			
			try {
				Robot R2D2  = new Robot();
				Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				
				BufferedImage screenShot = R2D2.createScreenCapture(rect);
				ImageIO.write(screenShot, "JPG", new File("Screens/" + Filename + ".jpg"));
				System.out.println("ScreenTaken = true");
				
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}

	
}
