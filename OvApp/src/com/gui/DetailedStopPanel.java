package com.gui;

import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


import com.REST.actor.DetailedStop;
import com.data.DetailedStopList;

public class DetailedStopPanel extends ImagePanel {

	
	

	private static final long serialVersionUID = -6424252408543118893L;
//	private static final Color ONTIME = new Color(27, 224, 89);
//	private static final Color LATE = new Color(224, 27, 27);
	
	//TODO time colors and + 2 min etc.
	
	
	private JTable infromation;
	private DefaultTableModel tableModel;
	
	private String[] heads = {"Tijd", "Lijn", "Naam", "Perron"};

	public DetailedStopPanel(Image image) {
		super(image);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(heads);

		
		infromation = new JTable(tableModel)  {
			private static final long serialVersionUID = 3804623061947388666L;

			@Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                final Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JComponent) {
                    ((JComponent) c).setOpaque(false);
                }
                return c;
            }
        };
        
		infromation.setEnabled(false);
		infromation.setOpaque(false);
		infromation.setShowGrid(false);
	
		setLayout(new BorderLayout());
		ImageScrollPanel layout = new ImageScrollPanel(infromation, image);
		
		add(layout, BorderLayout.CENTER);

	}

	public void updateInformation(DetailedStopList list) {
		ArrayList<DetailedStop> stopList = list.getDetailedStops();
		String[] tableRow = new String[heads.length];
		
		if (tableModel.getRowCount() > 0) {
		    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
		    	tableModel.removeRow(i);
		    }
		}
		
		for(int i=0;i<stopList.size();i++) {
			tableRow[0] = stopList.get(i).getTargetDepartureTime();
			tableRow[1] = stopList.get(i).getLinePublicNumber();
			tableRow[2] = stopList.get(i).getLineName();
			tableRow[3] = stopList.get(i).getSideCode();
			tableModel.addRow(tableRow);
		}
		
		repaint();
	}
	
	
	
}
