package com.GeoApp.TestGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.GeoApp.Math.*;
public class TestDeltoidGUI extends JFrame implements ActionListener{

	private double a, b, radius, diagonalLong, diagonalShort, area, perimeter, angle;

	private JLabel labelA, labelB, labelRadius, labelDiagonalLong, labelDiagonalShort,
	labelArea, labelPerimeter, labelAngle;

	private JTextField textA, textB, textRadius, textDiagonalLong, textDiagonalShort,
	textArea, textPerimeter, textAngle;

	private JButton solve, reset;

	private JPanel panelA, panelB, panelRadius, panelDiagonalLong, panelDiagonalShort,
	panelArea, panelPerimeter, panelAngle, panelButton;

	public TestDeltoidGUI() {
		setSize(390, 330);
		setTitle("Deltoid Test");
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

		panelB=new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(d);
		panelB.add(textB);
		add(panelB);

		panelRadius=new JPanel();
		labelRadius= new JLabel("Radius");
		panelRadius.add(labelRadius);
		textRadius=new JTextField();
		textRadius.setPreferredSize(d);
		panelRadius.add(textRadius);
		add(panelRadius);

		panelAngle=new JPanel();
		labelAngle = new JLabel("Angle");
		panelAngle.add(labelAngle);
		textAngle=new JTextField();
		textAngle.setPreferredSize(d);
		panelAngle.add(textAngle);
		add(panelAngle);

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
		textA.setText(""); textB.setText("");  textDiagonalLong.setText(""); textDiagonalShort.setText("");
		textAngle.setText(""); textRadius.setText(""); textArea.setText(""); textPerimeter.setText(""); textAngle.setText("");
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
		else a = -1;									//jeœli by³ pusty, to inicjalizujemy na -1

		if(!textB.getText().equals("")){
			try {
				b = convert(textB.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(b<0) return false;
		}
		else b = -1;



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

		if(!textAngle.getText().equals("")){
			try{
				angle=convert(textAngle.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(angle<0) return false;
			angle = angle*(Math.PI/180.0);
		}
		else angle=-1;

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

	private void setTextFields(Deltoid deltoid) {
		if(deltoid.getA()!=-1) textA.setText(String.format("%.3f",deltoid.getA()));
		if(deltoid.getB()!=-1) textB.setText(String.format("%.3f",deltoid.getB()));
		if(deltoid.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",deltoid.getPerimeter()));
		if(deltoid.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format("%.3f",deltoid.getDiagonalLong()));
		if(deltoid.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format("%.3f",deltoid.getDiagonalShort()));
		if(deltoid.getRadius()!=-1) textRadius.setText(String.format("%.3f", deltoid.getRadius()));
		if(deltoid.getArea()!=-1) textArea.setText(String.format("%.3f",deltoid.getArea()));
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

				Deltoid deltoid = new Deltoid(a, b, radius, diagonalLong, diagonalShort, area, perimeter, angle);
				if(deltoid.checkCorrect())
					setTextFields(deltoid);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String [] args){
		new TestDeltoidGUI();
	}
}