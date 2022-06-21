package NaiveKeyBoard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import handlers.KeyStorage;

public class NativeKeyboard implements NativeKeyListener {

	
	private List<KeyStorage> keyCache = new ArrayList<>();
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		keyCache.add(new KeyStorage(e.getKeyCode(), true, System.currentTimeMillis()));
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			//chance
			System.out.println("test");
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		keyCache.add(new KeyStorage(e.getKeyCode(), false, System.currentTimeMillis()));
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void onSend() {
		keyCache.clear();
	}
	
	public void onFail() {
		System.out.println("Fail");
	};

	public List<KeyStorage> getKeyCache() {
		return keyCache;
	}
}
