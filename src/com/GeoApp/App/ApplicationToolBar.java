package com.GeoApp.App;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JToolTip;
import javax.swing.ToolTipManager;

public class ApplicationToolBar {

	private JButton[] buttons;
	private String buttonsText[] = {"Tr�jk�t", "Prostok�t", "Ko�o", "Elipsa", "Kwadrat", "Romb", "R�wnoleg�obok", 
									"Deltoid", "Trapez", "Pi�ciok�t foremny", "Sze�ciok�t foremny", "O�miok�t foremny"};
	private String buttonsIconTexts[] = {"/triangle.png", "/rectangle.png", "/circle.png", "/ellipse.png", "/square.png", 
								"/diamond.png", "/rhomboid.png", "/deltoid.png", "/trapezoid.png", "/pentagon.png", 
								"/hexagon.png",	"/octagon.png"}; 
	private JToolBar toolBar;
	
	public ApplicationToolBar() {
		toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(true);
		
		buttons = new JButton[buttonsText.length];
		for(int i = 0; i < buttonsText.length; i++){
			buttons[i] = new JButton(buttonsText[i], new ImageIcon(getClass().getResource(buttonsIconTexts[i]))){
				public JToolTip createToolTip(){
					return (new ApplicationCustomJToolTip(this));					
				}
			};
			
			buttons[i].setToolTipText(buttonsText[i]);
			toolBar.add(buttons[i]);
		}
	}

	public JButton[] getJButtons(){
		return buttons;
	}
	
	public JToolBar getToolBar(){
		return toolBar;
	}
}
