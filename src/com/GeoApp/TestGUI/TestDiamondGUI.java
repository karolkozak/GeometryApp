package com.GeoApp.TestGUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.GeoApp.Math.*;
public class TestDiamondGUI extends JFrame implements ActionListener{

	private double a, diagonalLong, diagonalShort, acuteAngle, height, radius, area, perimeter;

	private JLabel labelA, labelDiagonalLong, labelDiagonalShort, labelAcuteAngle, labelHeight,
	labelRadius, labelArea, labelPerimeter;

	private JTextField textA, textDiagonalLong, textDiagonalShort, textAcuteAngle, textHeight,
	textArea, textRadius, textPerimeter;

	private JButton solve, reset;

	private JPanel panelA, panelDiagonalLong, panelDiagonalShort, panelAcuteAngle, panelHeight,
	panelRadius, panelArea, panelPerimeter, panelButton;

	public TestDiamondGUI() {
		setSize(400, 220);
		setTitle("Diamond Test");
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);

		createGUI();
		repaint();
		revalidate();
	}

	private void createGUI() {
		Dimension d=new Dimension(50,20);
		panelA=new JPanel();	
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(d);
		panelA.add(textA);
		add(panelA);

		panelHeight=new JPanel();
		labelHeight = new JLabel("Height");
		panelHeight.add(labelHeight);
		textHeight= new JTextField();
		textHeight.setPreferredSize(d);
		panelHeight.add(textHeight);
		add(panelHeight);

		panelRadius=new JPanel();
		labelRadius= new JLabel("Radius");
		panelHeight.add(labelRadius);
		textRadius=new JTextField();
		textRadius.setPreferredSize(d);
		panelRadius.add(textRadius);
		add(panelRadius);

		panelAcuteAngle=new JPanel();
		labelAcuteAngle = new JLabel("Angle Acute");
		panelAcuteAngle.add(labelAcuteAngle);
		textAcuteAngle=new JTextField();
		textAcuteAngle.setPreferredSize(d);
		panelAcuteAngle.add(textAcuteAngle);
		add(panelAcuteAngle);

		panelDiagonalLong=new JPanel();
		labelDiagonalLong= new JLabel("Diagonal long");
		panelDiagonalLong.add(labelDiagonalLong);
		textDiagonalLong = new JTextField();
		textDiagonalLong.setPreferredSize(d);
		panelDiagonalLong.add(textDiagonalLong);
		add(panelDiagonalLong);

		panelDiagonalShort=new JPanel();
		labelDiagonalShort=new JLabel("Diagonal short");
		panelDiagonalShort.add(labelDiagonalShort);
		textDiagonalShort=new JTextField();
		textDiagonalShort.setPreferredSize(d);
		panelDiagonalShort.add(textDiagonalShort);
		add(panelDiagonalShort);

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

		panelButton=new JPanel();
		solve = new JButton("Solve!");
		solve.setPreferredSize(new Dimension(100, 20));
		panelButton.add(solve);
		solve.addActionListener(this);

		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(100, 20));
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
		textA.setText("");  textDiagonalLong.setText(""); textDiagonalShort.setText(""); textHeight.setText("");
		textAcuteAngle.setText(""); textRadius.setText(""); textArea.setText(""); textPerimeter.setText(""); 
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

		if(!textA.getText().equals("")){
			try {
				a = convert(textA.getText());//jeœli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Litery!", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
				return false;							//jeœli litery to koñczymy
			}
			if(a<0) return false;						//jeœli ujemny, to zwracamy false
		}
		else a = -1; //jeœli by³ pusty, to inicjalizujemy na -1

		if(!textHeight.getText().equals("")){
			try{
				height=convert(textHeight.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(height<0) return false;
		}
		else height=-1;


		if(!textDiagonalLong.getText().equals("")){
			try {
				diagonalLong = convert(textDiagonalLong.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalLong<0) return false;
		}
		else diagonalLong = -1;


		if(!textDiagonalShort.getText().equals("")){
			try {
				diagonalShort = convert(textDiagonalShort.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalShort<0) return false;
		}
		else diagonalShort = -1;

		if(!textRadius.getText().equals("")){
			try{
				radius=convert(textRadius.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(radius<0) return false;
		}
		else radius=-1;

		if(!textDiagonalLong.getText().equals("")){
			try{
				diagonalLong=convert(textDiagonalLong.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(diagonalLong<0) return false;
		}
		else
			diagonalLong=-1;

		if(!textDiagonalShort.getText().equals("")){
			try{
				diagonalShort=convert(textDiagonalShort.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(diagonalShort<0) return false;
		}
		else
			diagonalShort=-1;
		if(!textAcuteAngle.getText().equals("")){
			try{
				acuteAngle=convert(textAcuteAngle.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(acuteAngle<0) return false;
		}
		else acuteAngle=-1;

		if(!textPerimeter.getText().equals("")) {
			try {
				perimeter = convert(textPerimeter.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(perimeter<0) return false;
		}
		else perimeter = -1;

		if(!textArea.getText().equals("")) {
			try {
				area = convert(textArea.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(area<0) return false;
		}
		else area = -1;

		return true;
	}

	private boolean checkSensOfArguments() {

		//TODO

		return true;
	}

	private void setTextFields(Diamond diamond) {
		if(diamond.getA()!=-1) textA.setText(String.format("%.3f",diamond.getA()));
		if(diamond.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",diamond.getPerimeter()));
		if(diamond.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format("%.3f",diamond.getDiagonalLong()));
		if(diamond.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format("%.3f",diamond.getDiagonalShort()));
		if(diamond.getRadius()!=-1) textRadius.setText(String.format("%.3f", diamond.getRadius()));
		if(diamond.getHeight()!=-1) textHeight.setText(String.format("%.3f", diamond.getHeight()));
		if(diamond.getArea()!=-1) textArea.setText(String.format("%.3f",diamond.getArea()));
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

				Diamond diamond = new Diamond(a, diagonalShort, diagonalLong, acuteAngle, radius, height, area, perimeter);
				if(diamond.checkCorrect())
					setTextFields(diamond);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);

			}
		}
	}
	public static void main(String [] args){
		new TestDiamondGUI();
	}
}