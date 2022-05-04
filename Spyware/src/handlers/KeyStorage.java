package handlers;

public class KeyStorage {

	
	private int keyCode;
	private boolean pressed;
	private long systemTimePressesMillis;
	
	public KeyStorage(int keyCode, boolean pressed, long systemTimePressesMillis) {
		super();
		this.keyCode = keyCode;
		this.pressed = pressed;
		this.systemTimePressesMillis = systemTimePressesMillis;
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
	public int getKeyCode() {
		return keyCode;
	}

	@Override
	public String toString() {
		return "KeyStorage [keyCode=" + keyCode + ", pressed=" + pressed + ", systemTimePressesMillis="
				+ systemTimePressesMillis + "]";
	}
	
	
}
