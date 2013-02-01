package com.gui.start;

import javax.swing.JFrame;

public class StratUpLoader extends JFrame implements Runnable{

	public boolean done = false;
	
	public StratUpLoader() {
		
	}
	
	@Override
	public void run() {
		while(!done) {
			done = true;
		}
	}
}
