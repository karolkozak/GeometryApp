package com.GeoApp.App;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ApplicationToolBarFormat {
	
	private JToolBar toolBar;
	private ButtonGroup buttonGroupDotted;
	private JRadioButton dotted2, dotted3, dotted4;
	private JPanel panelDotted;
	private JLabel labelTitleBorder;
	private JButton lol;
	private int numberOfDotted;   //2 - 2 liczby, 3 - trzy liczby, 4 - cztery liczby
	private RadioListener radioListener;
	
	public ApplicationToolBarFormat() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		toolBar = new JToolBar();
		toolBar.setRollover(false);
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(214,217,223));
		toolBar.setOrientation(1);  //Pion
		
		labelTitleBorder = new JLabel("Miejsca po przecinku");
		labelTitleBorder.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		
		panelDotted = new JPanel(new GridLayout(4,1));
		buttonGroupDotted = new ButtonGroup();
		dotted2 = new JRadioButton("0.(2)", true);
		dotted3 = new JRadioButton("0.(3)", false);
		dotted4 = new JRadioButton("0.(4)", false);
		buttonGroupDotted.add(dotted2);
		buttonGroupDotted.add(dotted3);
		buttonGroupDotted.add(dotted4);
		panelDotted.add(dotted2);
		panelDotted.add(dotted3);
		panelDotted.add(dotted4);
		panelDotted.setBorder(BorderFactory.createTitledBorder(""));
		panelDotted.setBackground(new Color(238, 238, 238));
		toolBar.add(labelTitleBorder);
		toolBar.add(panelDotted);
		
		setNumberOfDotted();
		radioListener = new RadioListener();
		dotted2.addActionListener(radioListener);
		dotted3.addActionListener(radioListener);
		dotted4.addActionListener(radioListener);
		
		lol = new JButton("Pointless button");
		toolBar.add(lol);
		lol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "I'm a pointless button! :)", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	private void setNumberOfDotted(){
		if(dotted2.isSelected())
			numberOfDotted = 2;
		else if(dotted3.isSelected())
			numberOfDotted = 3;
		else
			numberOfDotted = 4;
	}
	
	public int getNumberOfDotted(){
		return numberOfDotted;
	}
	
	public JToolBar getToolBar(){
		return toolBar;
	}
	
	class RadioListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setNumberOfDotted();
		}	
	}
}
