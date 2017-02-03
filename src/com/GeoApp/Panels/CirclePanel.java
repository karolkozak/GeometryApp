package com.GeoApp.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.GeoApp.App.ApplicationCustomJToolTip;
import com.GeoApp.App.ApplicationToolBarFormat;
import com.GeoApp.Math.Circle;

public class CirclePanel extends JPanel implements ActionListener {
	
	private double diameter, radius, area, perimeter, centralAngle, inscribedAngle,
					sector, angleLength;
	private JLabel labelImage, labelDiameter, labelRadius, labelArea, labelPerimeter, labelCentralAngle, labelInscribedAngle,
					labelSector, labelAngleLength;
	private JTextField textDiameter, textRadius, textArea, textPerimeter, textCentralAngle, textInscribedAngle,
						textSector, textAngleLength;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelDiameter, panelRadius, panelArea, panelPerimeter, panelCentralAngle, 
					panelInscribedAngle, panelSector, panelAngleLength, panelButtons;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public CirclePanel(ApplicationToolBarFormat myToolBarFormat) {
		setLayout(new GridLayout(1, 2));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setBackground(new Color(214,217,223));
		
		this.myToolBarFormat = myToolBarFormat;
		
		drawFrame();
		repaint();
		revalidate();
	}

	private void drawFrame() {
		Dimension dimension = new Dimension(70, 25);
		panelText=new JPanel(new FlowLayout());
		
		panelDiameter = new JPanel();
		labelDiameter = new JLabel("d");
		panelDiameter.add(labelDiameter);
		textDiameter = new JTextField(){
			public JToolTip createToolTip(){
				return (new ApplicationCustomJToolTip(this));
			}
		};
		textDiameter.setToolTipText("lolo");
		textDiameter.setPreferredSize(dimension);
		panelDiameter.add(textDiameter);
		panelText.add(panelDiameter);
		
		panelRadius = new JPanel();
		labelRadius = new JLabel("r");
		panelRadius.add(labelRadius);
		textRadius = new JTextField();
		textRadius.setPreferredSize(dimension);
		panelRadius.add(textRadius);
		panelText.add(panelRadius);
		
		panelCentralAngle = new JPanel();
		labelCentralAngle = new JLabel("α");
		panelCentralAngle.add(labelCentralAngle);
		textCentralAngle = new JTextField();
		textCentralAngle.setPreferredSize(dimension);
		panelCentralAngle.add(textCentralAngle);
		panelText.add(panelCentralAngle);
		
		panelInscribedAngle = new JPanel();
		labelInscribedAngle = new JLabel("β");
		panelInscribedAngle.add(labelInscribedAngle);
		textInscribedAngle = new JTextField();
		textInscribedAngle.setPreferredSize(dimension);
		panelInscribedAngle.add(textInscribedAngle);
		panelText.add(panelInscribedAngle);
		
		panelArea = new JPanel();
		labelArea = new JLabel("Pole");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(dimension);
		panelArea.add(textArea);
		panelText.add(panelArea);
		
		panelPerimeter = new JPanel();
		labelPerimeter = new JLabel("Obwód");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(dimension);
		panelPerimeter.add(textPerimeter);
		panelText.add(panelPerimeter);
		
		panelSector = new JPanel();
		labelSector = new JLabel("Pole wycinka okręgu");
		panelSector.add(labelSector);
		textSector = new JTextField();
		textSector.setPreferredSize(dimension);
		panelSector.add(textSector);
		panelText.add(panelSector);
		
		panelAngleLength = new JPanel();
		labelAngleLength = new JLabel("Łuk okręgu");
		panelAngleLength.add(labelAngleLength);
		textAngleLength = new JTextField();
		textAngleLength.setPreferredSize(dimension);
		panelAngleLength.add(textAngleLength);
		panelText.add(panelAngleLength);
		
		textRadius.addActionListener(this);
		textDiameter.addActionListener(this);
		textArea.addActionListener(this);
		textPerimeter.addActionListener(this);
		textCentralAngle.addActionListener(this);
		textInscribedAngle.addActionListener(this);
		textSector.addActionListener(this);
		textAngleLength.addActionListener(this);
		
		panelButtons = new JPanel();
		solve = new JButton("Oblicz!");
		solve.setPreferredSize(new Dimension(100, 25));
		panelButtons.add(solve);
		solve.addActionListener(this);
		
		reset = new JButton("Resetuj");
		reset.setPreferredSize(new Dimension(100, 25));
		panelButtons.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		panelText.add(panelButtons);
		
		labelImage=new JLabel(new ImageIcon(getClass().getResource("/circleImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
	
	}
	
	private void resetFields() {
		textDiameter.setText(""); textRadius.setText(""); textArea.setText(""); textPerimeter.setText("");
		textCentralAngle.setText(""); textInscribedAngle.setText(""); textSector.setText(""); textAngleLength.setText("");
	}
	
	private double convert(String toConvert){
		int index;
		if(toConvert.contains("."))
			index = toConvert.indexOf(".");
		else if(toConvert.contains(","))
			index = toConvert.indexOf(",");
		else
			return Double.parseDouble(toConvert);
		String suf = toConvert.substring(index+1, toConvert.length());
		String pre = toConvert.substring(0, index);
		String convert = pre.concat(".").concat(suf);
		return Double.parseDouble(convert);
	}
	
	private boolean getFromTextFields() {
		if(!textDiameter.getText().equals("")){
			try {
				diameter = convert(textDiameter.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(diameter<=0) return false;
		}
		else diameter = -1;
		
		if(!textRadius.getText().equals("")){
			try {
				radius = convert(textRadius.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(radius<=0) return false;
		}
		else radius = -1;
		
		if(!textPerimeter.getText().equals("")){
			try {
				perimeter = convert(textPerimeter.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(perimeter<=0) return false;
		}
		else perimeter = -1;
		
		if(!textAngleLength.getText().equals("")){
			try {
				angleLength = convert(textAngleLength.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(angleLength<=0) return false;
		}
		else angleLength = -1;
		
		if(!textSector.getText().equals("")){
			try {
				sector = convert(textSector.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(sector<=0) return false;
		}
		else sector = -1;
		
		if(!textArea.getText().equals("")){
			try {
				area = convert(textArea.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(area<=0) return false;
		}
		else area = -1;
		
		if(!textCentralAngle.getText().equals("")){
			try {
				centralAngle = convert(textCentralAngle.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(centralAngle<=0) return false;
			centralAngle = centralAngle*(Math.PI/180.0);
		}
		else centralAngle = -1;
		
		if(!textInscribedAngle.getText().equals("")){
			try {
				inscribedAngle = convert(textInscribedAngle.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(inscribedAngle<=0) return false;
			inscribedAngle = inscribedAngle*(Math.PI/180.0);
		}
		else inscribedAngle = -1;
		
		return true;
	}
	
	private void setTextFields(Circle circle) {
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(circle.getDiameter()!=-1) textDiameter.setText(String.format(form, circle.getDiameter()));
		if(circle.getSector()!=-1) textSector.setText(String.format(form, circle.getSector()));
		if(circle.getAngleLength()!=-1) textAngleLength.setText(String.format(form, circle.getAngleLength()));
		if(circle.getCentralAngle()!=-1) {
			double angle = circle.getCentralAngle()*180/Math.PI;
			textCentralAngle.setText(String.format(form, angle));
		}
		if(circle.getInscribedAngle()!=-1) {
			double angle = circle.getInscribedAngle()*180/Math.PI;
			textInscribedAngle.setText(String.format(form, angle));
		}
		if(circle.getRadius()!=-1) textRadius.setText(String.format(form, circle.getRadius()));
		if(circle.getPerimeter()!=-1) textPerimeter.setText(String.format(form, circle.getPerimeter()));
		if(circle.getArea()!=-1) textArea.setText(String.format(form, circle.getArea()));
	}
	
	private boolean checkSensOfArguments() {
		//TODO
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest błędny", 
					"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "Błędne dane, podane wartości nie są wartościami koła", 
						"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Circle circle = new Circle(diameter, radius, area, perimeter, centralAngle, inscribedAngle, sector, angleLength);
				if(circle.checkCorrect())
					setTextFields(circle);
				else
					JOptionPane.showMessageDialog(this, "Nic nie zostało obliczone", "Komunikat", 
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
