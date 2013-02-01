package com.gui;

import javax.swing.JFrame;

import com.gui.start.StartUpLoader;

public class MainInterface extends JFrame implements Runnable{
	
	private StartUpLoader loader;

	public MainInterface(StartUpLoader loader) {
		this.loader = loader;
		setSize(700, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
	}

	
	@Override
	public void run() {
		while(true) {
			if(loader.isDone()) {
				setVisible(true);
			}
		}
	}
}
