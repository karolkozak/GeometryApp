package com.GeoApp.App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class ApplicationMenu{

	private JMenuBar menuBar;
	private JMenu menuFile, menuHelp, menuTools;
	private JMenuItem menuItemClose, menuItemAbout, menuItemInstruction;
	private JCheckBoxMenuItem checkBoxMenuItemFormat;
	
	public ApplicationMenu() {
		menuBar = new JMenuBar();
		
		menuFile = new JMenu("Plik");
		menuTools = new JMenu("Narzêdzia");
		menuHelp = new JMenu("Pomoc");
		menuBar.add(menuFile);
		menuBar.add(menuTools);
		menuBar.add(menuHelp);
		
		menuItemClose = new JMenuItem("Zamknij");
		menuItemClose.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		menuFile.add(menuItemClose);
		
		menuItemAbout = new JMenuItem("O programie...");
		menuItemAbout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new ApplicationAbout().toString(), "O programie...", 
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		menuItemInstruction = new JMenuItem("Instrukcja");
		menuItemInstruction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, new ApplicationInstruction().toString(), "O programie...", 
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		menuHelp.add(menuItemInstruction);
		menuHelp.add(menuItemAbout);
		
		checkBoxMenuItemFormat = new JCheckBoxMenuItem("Formatowanie");
		menuTools.add(checkBoxMenuItemFormat);
	}
	
	public JMenuItem getMenuItemClose(){
		return menuItemClose;
	}
	
	public JCheckBoxMenuItem getCheckBoxMenuItemFormat(){
		return checkBoxMenuItemFormat;
	}
	
	public JMenuBar getMyMenuBar(){
		return menuBar;
	}
}
