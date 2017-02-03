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

import com.GeoApp.Math.Pentagon;

public class TestPentagonGUI extends JFrame implements ActionListener {

	private double side, area, angle, height, perimeter, radiusSmaller, radiusBigger, diagonal;
	private JLabel labelSide, labelArea, labelAngle, labelHeight, labelPerimeter, 
					labelRadiusSmaller, labelRadiusBigger, labelDiagonal;
	private JTextField textSide, textArea, textAngle, textHeight, textPerimeter, 
						textRadiusSmaller, textRadiusBigger, textDiagonal;
	private JButton solve, reset;
	private JPanel panelSide, panelArea, panelAngle, panelHeight, panelPerimeter, 
						panelRadiusSmaller, panelRadiusBigger, panelDiagonal, panelButton;
	
	public TestPentagonGUI() {
		setSize(390, 330);
		setTitle("Hexagon Test");
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		createGUI();
		repaint();
		revalidate();
	}
	
	private void createGUI() {
		Dimension d = new Dimension(50,25);
		panelSide = new JPanel();
		labelSide = new JLabel("side");
		panelSide.add(labelSide);
		textSide = new JTextField();
		textSide.setPreferredSize(d);
		panelSide.add(textSide);
		add(panelSide);
		
		panelHeight = new JPanel();
		labelHeight = new JLabel("Height");
		panelHeight.add(labelHeight);
		textHeight = new JTextField();
		textHeight.setPreferredSize(d);
		panelHeight.add(textHeight);
		add(panelHeight);
		
		panelRadiusBigger = new JPanel();
		labelRadiusBigger = new JLabel("Radius Bigger");
		panelRadiusBigger.add(labelRadiusBigger);
		textRadiusBigger = new JTextField();
		textRadiusBigger.setPreferredSize(d);
		panelRadiusBigger.add(textRadiusBigger);
		add(panelRadiusBigger);
		
		panelRadiusSmaller = new JPanel();
		labelRadiusSmaller = new JLabel("Radius Smaller");
		panelRadiusSmaller.add(labelRadiusSmaller);
		textRadiusSmaller = new JTextField();
		textRadiusSmaller.setPreferredSize(d);
		panelRadiusSmaller.add(textRadiusSmaller);
		add(panelRadiusSmaller);
		
		panelDiagonal = new JPanel();
		labelDiagonal = new JLabel("Diagonal");
		panelDiagonal.add(labelDiagonal);
		textDiagonal = new JTextField();
		textDiagonal.setPreferredSize(d);
		panelDiagonal.add(textDiagonal);
		add(panelDiagonal);
		
		panelAngle = new JPanel();
		labelAngle = new JLabel("Angle Side");
		panelAngle.add(labelAngle);
		textAngle = new JTextField();
		textAngle.setPreferredSize(d);
		panelAngle.add(textAngle);
		add(panelAngle);
		
		panelArea=new JPanel();
		labelArea = new JLabel("Area");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(d);
		panelArea.add(textArea);
		add(panelArea);

		panelPerimeter=new JPanel();
		labelPerimeter = new JLabel("Perimeter");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(d);
		panelPerimeter.add(textPerimeter);
		add(panelPerimeter);
		
		panelButton = new JPanel();
		solve = new JButton("Solve!");
		solve.setPreferredSize(new Dimension(100, 25));
		panelButton.add(solve);
		solve.addActionListener(this);

		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(100, 25));
		panelButton.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		add(panelButton);
	}

	private void resetFields() {
		textSide.setText(""); textArea.setText(""); textAngle.setText(""); textHeight.setText(""); textPerimeter.setText("");
		textRadiusSmaller.setText(""); textRadiusBigger.setText(""); textDiagonal.setText("");
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

		if(!textSide.getText().equals("")){
			try {
				side = convert(textSide.getText());//jeœli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeœli litery to koñczymy
			}
			if(side<=0) return false;						//jeœli ujemny, to zwracamy false
		}
		else side = -1;									//jeœli by³ pusty, to inicjalizujemy na -1

		if(!textHeight.getText().equals("")){
			try {
				height = convert(textHeight.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(height<=0) return false;
		}
		else height = -1;
		
		if(!textDiagonal.getText().equals("")){
			try {
				diagonal = convert(textDiagonal.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonal<=0) return false;
		}
		else diagonal = -1;

		if(!textRadiusSmaller.getText().equals("")){
			try{
				radiusSmaller = convert(textRadiusSmaller.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(radiusSmaller<=0) return false;
		}
		else radiusSmaller=-1;
		
		if(!textRadiusBigger.getText().equals("")){
			try{
				radiusBigger = convert(textRadiusBigger.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(radiusBigger<=0) return false;
		}
		else radiusBigger = -1;

		if(!textPerimeter.getText().equals("")) {
			try {
				perimeter = convert(textPerimeter.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(perimeter<=0) return false;
		}
		else perimeter = -1;

		if(!textArea.getText().equals("")) {
			try {
				area = convert(textArea.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(area<=0) return false;
		}
		else area = -1;

		return true;
	}
	
	private boolean checkSensOfArguments() {

		//TODO

		return true;
	}
	
	private void setTextFields(Pentagon pentagon) {
		if(pentagon.getSide()!=-1) textSide.setText(String.format("%.3f",pentagon.getSide()));
		if(pentagon.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",pentagon.getPerimeter()));
		if(pentagon.getHeight()!=-1) textHeight.setText(String.format("%.3f",pentagon.getHeight()));
		if(pentagon.getDiagonal()!=-1) textDiagonal.setText(String.format("%.3f",pentagon.getDiagonal()));
		if(pentagon.getRadiusBigger()!=-1) textRadiusBigger.setText(String.format("%.3f", pentagon.getRadiusBigger()));
		if(pentagon.getRadiusSmaller()!=-1) textRadiusSmaller.setText(String.format("%.3f", pentagon.getRadiusSmaller()));
		if(pentagon.getAngleSide()!=-1) textAngle.setText(String.format("%.3f",pentagon.getAngleSide()));
		if(pentagon.getArea()!=-1) textArea.setText(String.format("%.3f",pentagon.getArea()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest b³êdny", 
					"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "B³êdne dane, podane wartoœci nie s¹ wartoœciami trójk¹ta", 
						"Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Pentagon pentagon = new Pentagon(side, height, area, perimeter, diagonal, radiusSmaller, radiusBigger);
				if(pentagon.checkCorrect())
					setTextFields(pentagon);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
	public static void main(String[] args) {
		new TestPentagonGUI();
	}
}
