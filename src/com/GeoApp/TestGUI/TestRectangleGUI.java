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

public class TestRectangleGUI extends JFrame implements ActionListener{

	private double a, b, diagonal, area, perimeter, angleDiagonal;
	private JLabel labelA, labelB, labelDiagonal, labelArea, labelPerimeter, labelAngleDiagonal;
	private JTextField textA, textB, textDiagonal, textArea, textPerimeter, textAngleDiagonal;
	private JButton solve, reset;
	private JPanel panelA, panelB, panelDiagonal, panelArea, panelPerimeter, panelAngleDiagonal, panelButton; 

	public TestRectangleGUI() {

		setSize(345, 210);
		setTitle("Rectangle Test");
		setLocation(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
		createGUI();
		repaint();
		revalidate();
	}

	private void createGUI() {
		Dimension dimension=new Dimension(50, 20);
		panelA=new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(dimension);
		panelA.add(textA);
		add(panelA);

		panelB=new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(dimension);
		panelB.add(textB);
		add(panelB);

		panelDiagonal=new JPanel();
		labelDiagonal= new JLabel("Diagonal");
		panelDiagonal.add(labelDiagonal);
		textDiagonal = new JTextField();
		textDiagonal.setPreferredSize(dimension);
		panelDiagonal.add(textDiagonal);
		add(panelDiagonal);

		panelAngleDiagonal=new JPanel();
		labelAngleDiagonal = new JLabel("Angle Diagonal");
		panelAngleDiagonal.add(labelAngleDiagonal);
		textAngleDiagonal=new JTextField();
		textAngleDiagonal.setPreferredSize(dimension);
		panelAngleDiagonal.add(textAngleDiagonal);
		add(panelAngleDiagonal);

		panelArea=new JPanel();
		labelArea = new JLabel("Area");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(dimension);
		panelArea.add(textArea);
		add(panelArea);

		panelPerimeter=new JPanel();
		labelPerimeter = new JLabel("Perimeter");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(dimension);
		panelPerimeter.add(textPerimeter);
		add(panelPerimeter);

		panelButton=new JPanel();
		solve = new JButton("Solve!");
		solve.setPreferredSize(new Dimension(100, 20));
		panelButton.add(solve);
		solve.addActionListener(this);

		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(100,20));
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
		textA.setText(""); textB.setText("");  textDiagonal.setText(""); textAngleDiagonal.setText("");
		textArea.setText(""); textPerimeter.setText("");
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

		if(!textDiagonal.getText().equals("")){
			try {
				diagonal = convert(textDiagonal.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonal<0) return false;
		}
		else diagonal = -1;


		if(!textAngleDiagonal.getText().equals("")){
			try{
				angleDiagonal=convert(textAngleDiagonal.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(angleDiagonal<0) return false;
			angleDiagonal = angleDiagonal*(Math.PI/180.0);
		}
		else angleDiagonal=-1;

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

	private void setTextFields(Rectangle rectangle) {
		if(rectangle.getA()!=-1) textA.setText(String.format("%.3f",rectangle.getA()));
		if(rectangle.getB()!=-1) textB.setText(String.format("%.3f",rectangle.getB()));
		if(rectangle.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",rectangle.getPerimeter()));
		if(rectangle.getDiagonal()!=-1) textDiagonal.setText(String.format("%.3f",rectangle.getDiagonal()));
		if(rectangle.getAngleDiagonal()!=-1) {
			double angle = rectangle.getAngleDiagonal()*180/Math.PI;
			textAngleDiagonal.setText(String.format("%.3f", angle));
		}
		if(rectangle.getArea()!=-1) textArea.setText(String.format("%.3f",rectangle.getArea()));
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
				Rectangle rectangle = new Rectangle(a, b, diagonal, area, perimeter, angleDiagonal);
				if(rectangle.checkCorrect())
					setTextFields(rectangle);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public static void main(String [] args){
		new TestRectangleGUI();
	}
}