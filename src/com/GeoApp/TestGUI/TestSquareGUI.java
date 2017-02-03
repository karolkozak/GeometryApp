package com.GeoApp.TestGUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.GeoApp.Math.Deltoid;
import com.GeoApp.Math.Square;

public class TestSquareGUI extends JFrame implements ActionListener {

	private double a, diagonal, area, perimeter;
	private JLabel labelA, labelDiagonal, labelArea, labelPerimeter;
	private JTextField textA, textDiagonal, textArea, textPerimeter;
	private JButton solve, reset;
	private JPanel panelA, panelDiagonal, panelArea, panelPerimeter, panelButton;
	
	public TestSquareGUI() {
		setSize(390, 120);
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
		
		panelA = new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(d);
		panelA.add(textA);
		add(panelA);
		
		panelDiagonal = new JPanel();
		labelDiagonal = new JLabel("Diagonal");
		panelDiagonal.add(labelDiagonal);
		textDiagonal = new JTextField();
		textDiagonal.setPreferredSize(d);
		panelDiagonal.add(textDiagonal);
		add(panelDiagonal);
		
		panelArea = new JPanel();
		labelArea = new JLabel("Area");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(d);
		panelArea.add(textArea);
		add(panelArea);
		
		panelPerimeter = new JPanel();
		labelPerimeter = new JLabel("Perimeter");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(d);
		panelPerimeter.add(textPerimeter);
		add(panelPerimeter);
		
		panelButton = new JPanel();
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
		textA.setText(""); textDiagonal.setText(""); textArea.setText(""); textPerimeter.setText("");
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
				return false;							//jeœli litery to koñczymy
			}
			if(a<0) return false;						//jeœli ujemny, to zwracamy false
		}
		else a = -1;									//jeœli by³ pusty, to inicjalizujemy na -1
		
		if(!textDiagonal.getText().equals("")){
			try {
				diagonal = convert(textDiagonal.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonal<0) return false;
		}
		else diagonal = -1;
		
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
	
	private void setTextFields(Square square) {
		if(square.getA()!=-1) textA.setText(String.format("%.3f", square.getA()));
		if(square.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f", square.getPerimeter()));
		if(square.getDiagonal()!=-1) textDiagonal.setText(String.format("%.3f", square.getDiagonal()));
		if(square.getArea()!=-1) textArea.setText(String.format("%.3f", square.getArea()));
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

				Square square = new Square(a, diagonal, area, perimeter);
				if(square.checkCorrect())
					setTextFields(square);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new TestSquareGUI();
	}
}
