package com.gui;

import java.awt.*;
import javax.swing.*;

public class ImageScrollPanel extends JScrollPane {


	private static final long serialVersionUID = -5229843452906088288L;
	Image image;

	public ImageScrollPanel(JComponent component, Image image) {
		super(component);
		this.image = image;
		
		setOpaque(false);
		getViewport().setOpaque(false);

	}
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}

}
