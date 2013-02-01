package com.gui.start;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class StratUpLoader extends JFrame implements Runnable{

	public boolean done = false;
	private int procent = 0;
	private String comment = "loading";
	private JProgressBar progress;
	
	public StratUpLoader() {
		setUndecorated(true);
		setSize(500, 350);
		setLocationRelativeTo(null);
		progress = new JProgressBar();
		progress.setStringPainted(true);
		
		add(progress, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	/**
	 * @return the procent
	 */
	public int getProcent() {
		return procent;
	}

	/**
	 * @param procent the procent to set
	 */
	public void setProcent(int procent) {
		this.procent = procent;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment + " " + procent + "%";
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public void run() {
		while(!done) {
			progress.setValue(procent);
			progress.setString(getComment());
			
			if(procent == 100 && !done) {
				progress.setIndeterminate(true);
			}
			
			try {
				Thread.sleep(100);
				procent++;
				if(procent==100) {
					done = true;
				}
				this.repaint();
			} catch(InterruptedException e) {
				
			}
		}
		this.dispose();
	}
}
