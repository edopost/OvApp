package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.REST.actor.Stop;
import com.data.ListHolder;
import com.gui.start.StartUpLoader;

public class MainInterface extends JFrame implements Runnable, MouseListener, MouseMotionListener, ActionListener {

	private static final long serialVersionUID = 3583129179110930266L;
	private StartUpLoader loader;
	private int posX = 100;
	private int posY = 100;

	private JComboBox<String> townBox;
	private JComboBox<String> stationsInTown;

	private DetailedStopPanel detailedStopPanel;
	
	private Timer updateTimer;

	public MainInterface(StartUpLoader loader) {
		addMouseListener(this);
		addMouseMotionListener(this);

		this.loader = loader;
		setSize(700, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);

		BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/back.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setContentPane(new ImagePanel(image));
		setLayout(new BorderLayout());

		JPanel menu = new ImagePanel(image);
		menu.setLayout(new GridLayout(1, 2));

		townBox = new JComboBox<String>(ListHolder.TownList.toArray());
		menu.add(townBox);
		townBox.addActionListener(this);
		stationsInTown = new JComboBox<String>(ListHolder.StopsList.getStopsByTownArray(townBox.getSelectedItem().toString()));
		stationsInTown.setSelectedIndex(0);
		menu.add(stationsInTown);
		stationsInTown.addActionListener(this);

		add(menu, BorderLayout.NORTH);

		detailedStopPanel = new DetailedStopPanel(image);

		add(detailedStopPanel, BorderLayout.CENTER);

		JLabel footer = new JLabel("created by: Edo Post - Using OpenOV.nl API");
		footer.setForeground(Color.GRAY);
		footer.setAlignmentX(CENTER_ALIGNMENT);
		add(footer, BorderLayout.SOUTH);
		

		
		Stop stop = ListHolder.StopsList.getStopByName(stationsInTown.getSelectedItem().toString());
		detailedStopPanel.updateInformation(stop.getDetails());
		updateTimer = new Timer(60000, this);
		updateTimer.start();

	}

	@Override
	public void run() {
		while (true) {
			if (loader.isDone()) {
				setVisible(true);
			}
		}
	}

	/**
	 * nesseseary for compile not in use
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * this is to get the x and y of the mouse atm, we need this so we can
	 * calculate the new window position if it is beeing dragged
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		posX = e.getX();
		posY = e.getY();
	}

	/**
	 * nesseseary for compile not in use
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * nesseseary for compile not in use
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * nesseseary for compile not in use
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * this will update the frame possition when it is beeing dragged
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
	}

	/**
	 * nesseseary for compile not in use
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(townBox)) {
			DefaultComboBoxModel boxModel = (DefaultComboBoxModel) stationsInTown.getModel();
			boxModel.removeAllElements();
			String[] array = (ListHolder.StopsList.getStopsByTownArray(townBox.getSelectedItem().toString()));
			for (int i = 0; i < array.length; i++) {
				boxModel.addElement(array[i]);
			}
			stationsInTown.setSelectedIndex(0);
			Stop stop = ListHolder.StopsList.getStopByName(stationsInTown.getSelectedItem().toString());
			detailedStopPanel.updateInformation(stop.getDetails());
		} else if (e.getSource().equals(stationsInTown)) {
			if (((JComboBox) e.getSource()).isFocusOwner()) {
				Stop stop = ListHolder.StopsList.getStopByName(stationsInTown.getSelectedItem().toString());
				detailedStopPanel.updateInformation(stop.getDetails());
			}
		} else if(e.getSource().equals(updateTimer)) {
			Stop stop = ListHolder.StopsList.getStopByName(stationsInTown.getSelectedItem().toString());
			detailedStopPanel.updateInformation(stop.getDetails());
		}
		repaint();
	}
}
