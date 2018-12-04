package handlers;

public class KeyStorage {
	
	private int keyCode;
	private boolean pressed;
	private long systemsTimePressedMillis;
	
	public KeyStorage(int keyCode, boolean pressed, long systemTimePressedMillis) {
		this.keyCode = keyCode;
		this.pressed = pressed;
		this.systemsTimePressedMillis = systemTimePressedMillis;
	}
	
	public int getKeyCode() {
		return keyCode;
	}
	
	public boolean isPressed() {
		return pressed;
	}
	
	public long getSystemsTimePressedMillis() {
		return systemsTimePressedMillis;
	}
	
	@Override
	public String toString() {
		return "KeyStorage [keyCode=" + keyCode + ", pressed=" + pressed + ", systemsTimePressedMillis=" + systemsTimePressedMillis + "]";
	}
	
}
