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

import com.GeoApp.Math.Ellipse;


public class TestEllipseGUI extends JFrame implements ActionListener {

	private double axis1, axis2, area, perimeter;
	private JLabel labelAxis1, labelAxis2, labelArea, labelPerimeter;
	private JTextField textAxis1, textAxis2, textArea, textPerimeter;
	private JButton solve, reset;
	private JPanel panelAxis1, panelAxis2, panelArea, panelPerimeter, panelButton;
	
	public TestEllipseGUI() {
		setSize(350, 180);
		setTitle("Ellipse Test");
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
		panelAxis1 = new JPanel();
		labelAxis1 = new JLabel("axis 1");
		panelAxis1.add(labelAxis1);
		textAxis1 = new JTextField();
		textAxis1.setPreferredSize(d);
		panelAxis1.add(textAxis1);
		add(panelAxis1);
		
		panelAxis2 = new JPanel();
		labelAxis2 = new JLabel("axis 2");
		panelAxis2.add(labelAxis2);
		textAxis2 = new JTextField();
		textAxis2.setPreferredSize(d);
		panelAxis2.add(textAxis2);
		add(panelAxis2);
		
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
		textAxis1.setText(""); textAxis2.setText(""); textArea.setText(""); textPerimeter.setText("");
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

		if(!textAxis1.getText().equals("")){
			try {
				axis1 = convert(textAxis1.getText());//jeœli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeœli litery to koñczymy
			}
			if(axis1<=0) return false;						//jeœli ujemny, to zwracamy false
		}
		else axis1 = -1;									//jeœli by³ pusty, to inicjalizujemy na -1
		
		if(!textAxis2.getText().equals("")){
			try {
				axis2 = convert(textAxis2.getText());//jeœli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeœli litery to koñczymy
			}
			if(axis2<=0) return false;						//jeœli ujemny, to zwracamy false
		}
		else axis2 = -1;									//jeœli by³ pusty, to inicjalizujemy na -1
		
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
	
	private void setTextFields(Ellipse ellipse) {
		if(ellipse.getAxis1()!=-1) textAxis1.setText(String.format("%.3f",ellipse.getAxis1()));
		if(ellipse.getAxis2()!=-1) textAxis2.setText(String.format("%.3f",ellipse.getAxis2()));
		if(ellipse.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",ellipse.getPerimeter()));
		if(ellipse.getArea()!=-1) textArea.setText(String.format("%.3f",ellipse.getArea()));
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
				Ellipse ellipse = new Ellipse(axis1, axis2, area, perimeter);
				if(ellipse.checkCorrect())
					setTextFields(ellipse);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new TestEllipseGUI();
	}
}
