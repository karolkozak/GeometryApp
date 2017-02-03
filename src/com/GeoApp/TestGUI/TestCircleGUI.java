package com.GeoApp.TestGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.GeoApp.Math.Circle;

public class TestCircleGUI extends JFrame implements ActionListener {

	private double diameter, radius, area, perimeter, centralAngle, inscribedAngle,
						sector, angleLength;
	private JLabel labelDiameter, labelRadius, labelArea, labelPerimeter, labelCentralAngle, labelInscribedAngle,
						labelSector, labelAngleLength;
	private JTextField textDiameter, textRadius, textArea, textPerimeter, textCentralAngle, textInscribedAngle,
						textSector, textAngleLength;
	private JButton solve, reset;
	private JPanel panelDiameter, panelRadius, panelArea, panelPerimeter, panelCentralAngle, panelInscribedAngle,
					panelSector, panelAngleLength, panelButtons;
	
	public TestCircleGUI() {
		setSize(400, 220);
		setTitle("Circle Test");
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);

		drawFrame();
		repaint();
		revalidate();
	}

	private void drawFrame() {
		Dimension dimension = new Dimension(50, 22);
		panelDiameter = new JPanel();
		labelDiameter = new JLabel("Diameter");
		panelDiameter.add(labelDiameter);
		textDiameter = new JTextField();
		textDiameter.setPreferredSize(dimension);
		panelDiameter.add(textDiameter);
		add(panelDiameter);
		
		panelRadius = new JPanel();
		labelRadius = new JLabel("Radius");
		panelRadius.add(labelRadius);
		textRadius = new JTextField();
		textRadius.setPreferredSize(dimension);
		panelRadius.add(textRadius);
		add(panelRadius);
		
		panelArea = new JPanel();
		labelArea = new JLabel("Area");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(dimension);
		panelArea.add(textArea);
		add(panelArea);
		
		panelPerimeter = new JPanel();
		labelPerimeter = new JLabel("Perimeter");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(dimension);
		panelPerimeter.add(textPerimeter);
		add(panelPerimeter);
		
		panelCentralAngle = new JPanel();
		labelCentralAngle = new JLabel("Central Angle");
		panelCentralAngle.add(labelCentralAngle);
		textCentralAngle = new JTextField();
		textCentralAngle.setPreferredSize(dimension);
		panelCentralAngle.add(textCentralAngle);
		add(panelCentralAngle);
		
		panelInscribedAngle = new JPanel();
		labelInscribedAngle = new JLabel("Inscribed Angle");
		panelInscribedAngle.add(labelInscribedAngle);
		textInscribedAngle = new JTextField();
		textInscribedAngle.setPreferredSize(dimension);
		panelInscribedAngle.add(textInscribedAngle);
		add(panelInscribedAngle);
		
		
		panelSector = new JPanel();
		labelSector = new JLabel("Sector");
		panelSector.add(labelSector);
		textSector = new JTextField();
		textSector.setPreferredSize(dimension);
		panelSector.add(textSector);
		add(panelSector);
		
		panelAngleLength = new JPanel();
		labelAngleLength = new JLabel("Angle Length");
		panelAngleLength.add(labelAngleLength);
		textAngleLength = new JTextField();
		textAngleLength.setPreferredSize(dimension);
		panelAngleLength.add(textAngleLength);
		add(panelAngleLength);
		
		panelButtons = new JPanel();
		solve = new JButton("Solve!");
		solve.setPreferredSize(new Dimension(100, 25));
		panelButtons.add(solve);
		solve.addActionListener(this);
		
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(100, 25));
		panelButtons.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		add(panelButtons);
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
		if(circle.getDiameter()!=-1) textDiameter.setText(String.format("%.3f", circle.getDiameter()));
		if(circle.getSector()!=-1) textSector.setText(String.format("%.3f", circle.getSector()));
		if(circle.getAngleLength()!=-1) textAngleLength.setText(String.format("%.3f", circle.getAngleLength()));
		if(circle.getCentralAngle()!=-1) {
			double angle = circle.getCentralAngle()*180/Math.PI;
			textCentralAngle.setText(String.format("%.3f", angle));
		}
		if(circle.getInscribedAngle()!=-1) {
			double angle = circle.getInscribedAngle()*180/Math.PI;
			textInscribedAngle.setText(String.format("%.3f", angle));
		}
		if(circle.getRadius()!=-1) textRadius.setText(String.format("%.3f", circle.getRadius()));
		if(circle.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f", circle.getPerimeter()));
		if(circle.getArea()!=-1) textArea.setText(String.format("%.3f", circle.getArea()));
	}
	
	private boolean checkSensOfArguments() {
		//TODO
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest b³êdny", 
					"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "B³êdne dane, podane wartoœci nie s¹ wartoœciami ko³a", 
						"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Circle circle = new Circle(diameter, radius, area, perimeter, centralAngle, inscribedAngle, sector, angleLength);
				if(circle.checkCorrect())
					setTextFields(circle);
				else
					JOptionPane.showMessageDialog(this, "Nic nie zosta³o obliczone", "Komunikat", 
							JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new TestCircleGUI();
	}
}
