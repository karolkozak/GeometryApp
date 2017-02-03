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

import com.GeoApp.Math.Hexagon;

public class TestHexagonGUI extends JFrame implements ActionListener {

	private double a, area, angle, perimeter, radiusBigger, radiusSmaller, diagonalShort, diagonalLong;
	private JLabel labelA, labelArea, labelAngle, labelPerimeter, labelRadiusBigger, labelRadiusSmaller, 
					labelDiagonalShort, labelDiagonalLong;
	private JTextField textA, textArea, textAngle, textPerimeter, textRadiusBigger, textRadiusSmaller, 
						textDiagonalShort, textDiagonalLong;
	private JButton solve, reset;
	private JPanel panelA, panelAngle, panelRadiusBigger, panelRadiusSmaller, panelDiagonalLong, panelDiagonalShort,
					panelArea, panelPerimeter, panelButton;
	
	public TestHexagonGUI() {
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
		panelA=new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(d);
		panelA.add(textA);
		add(panelA);
		
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
		textA.setText(""); textDiagonalLong.setText(""); textDiagonalShort.setText(""); textRadiusBigger.setText(""); 
		textRadiusSmaller.setText(""); textArea.setText(""); textPerimeter.setText(""); textAngle.setToolTipText("");
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
			if(a<=0) return false;						//jeœli ujemny, to zwracamy false
		}
		else a = -1;									//jeœli by³ pusty, to inicjalizujemy na -1

		if(!textDiagonalLong.getText().equals("")){
			try {
				diagonalLong = convert(textDiagonalLong.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalLong<=0) return false;
		}
		else diagonalLong = -1;

		if(!textDiagonalShort.getText().equals("")){
			try {
				diagonalShort = convert(textDiagonalShort.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonalShort<=0) return false;
		}
		else diagonalShort = -1;

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
	
	private void setTextFields(Hexagon hexagon) {
		if(hexagon.getASide()!=-1) textA.setText(String.format("%.3f",hexagon.getASide()));
		if(hexagon.getPerimeter()!=-1) textPerimeter.setText(String.format("%.3f",hexagon.getPerimeter()));
		if(hexagon.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format("%.3f",hexagon.getDiagonalLong()));
		if(hexagon.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format("%.3f",hexagon.getDiagonalShort()));
		if(hexagon.getRadiusBigger()!=-1) textRadiusBigger.setText(String.format("%.3f", hexagon.getRadiusBigger()));
		if(hexagon.getRadiusSmaller()!=-1) textRadiusSmaller.setText(String.format("%.3f", hexagon.getRadiusSmaller()));
		if(hexagon.getAngleSide()!=-1) textAngle.setText(String.format("%.3f", hexagon.getAngleSide()));
		if(hexagon.getArea()!=-1) textArea.setText(String.format("%.3f",hexagon.getArea()));
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
				Hexagon hexagon = new Hexagon(a, area, perimeter, radiusBigger, radiusSmaller, diagonalShort, diagonalLong);
				if(hexagon.checkCorrect())
					setTextFields(hexagon);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrze¿enie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new TestHexagonGUI();
	}	
}
