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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.GeoApp.App.ApplicationToolBarFormat;
import com.GeoApp.Math.Pentagon;

public class PentagonPanel extends JPanel implements ActionListener {

	private double side, area, height, perimeter, radiusSmaller, radiusBigger, diagonal;
	private JLabel labelImage, labelSide, labelArea, labelAngle, labelHeight, labelPerimeter, 
					labelRadiusSmaller, labelRadiusBigger, labelDiagonal;
	private JTextField textSide, textArea, textAngle, textHeight, textPerimeter, 
						textRadiusSmaller, textRadiusBigger, textDiagonal;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelSide, panelArea, panelAngle, panelHeight, panelPerimeter, 
						panelRadiusSmaller, panelRadiusBigger, panelDiagonal, panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public PentagonPanel(ApplicationToolBarFormat myToolBarFormat) {
		setLayout(new GridLayout(1, 2));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setBackground(new Color(214,217,223));
		
		this.myToolBarFormat = myToolBarFormat;
		
		createGUI();
		repaint();
		revalidate();
	}
	
	private void createGUI() {
		Dimension d = new Dimension(70,25);
		panelText=new JPanel(new FlowLayout());
		
		panelSide = new JPanel();
		labelSide = new JLabel("a");
		panelSide.add(labelSide);
		textSide = new JTextField();
		textSide.setPreferredSize(d);
		panelSide.add(textSide);
		panelText.add(panelSide);
		
		panelHeight = new JPanel();
		labelHeight = new JLabel("h");
		panelHeight.add(labelHeight);
		textHeight = new JTextField();
		textHeight.setPreferredSize(d);
		panelHeight.add(textHeight);
		panelText.add(panelHeight);
		
		panelRadiusBigger = new JPanel();
		labelRadiusBigger = new JLabel("R");
		panelRadiusBigger.add(labelRadiusBigger);
		textRadiusBigger = new JTextField();
		textRadiusBigger.setPreferredSize(d);
		panelRadiusBigger.add(textRadiusBigger);
		panelText.add(panelRadiusBigger);
		
		panelRadiusSmaller = new JPanel();
		labelRadiusSmaller = new JLabel("r");
		panelRadiusSmaller.add(labelRadiusSmaller);
		textRadiusSmaller = new JTextField();
		textRadiusSmaller.setPreferredSize(d);
		panelRadiusSmaller.add(textRadiusSmaller);
		panelText.add(panelRadiusSmaller);
		
		panelDiagonal = new JPanel();
		labelDiagonal = new JLabel("d");
		panelDiagonal.add(labelDiagonal);
		textDiagonal = new JTextField();
		textDiagonal.setPreferredSize(d);
		panelDiagonal.add(textDiagonal);
		panelText.add(panelDiagonal);
		
		panelAngle = new JPanel();
		labelAngle = new JLabel("α");
		panelAngle.add(labelAngle);
		textAngle = new JTextField();
		textAngle.setPreferredSize(d);
		panelAngle.add(textAngle);
		panelText.add(panelAngle);
		
		panelArea=new JPanel();
		labelArea = new JLabel("Pole");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(d);
		panelArea.add(textArea);
		panelText.add(panelArea);

		panelPerimeter=new JPanel();
		labelPerimeter = new JLabel("Obwód");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(d);
		panelPerimeter.add(textPerimeter);
		panelText.add(panelPerimeter);
		
		textSide.addActionListener(this);
		textArea.addActionListener(this);
		textHeight.addActionListener(this);
		textPerimeter.addActionListener(this);
		textRadiusSmaller.addActionListener(this);
		textRadiusBigger.addActionListener(this);
		textDiagonal.addActionListener(this);
		
		panelButton = new JPanel();
		solve = new JButton("Oblicz!");
		solve.setPreferredSize(new Dimension(100, 25));
		panelButton.add(solve);
		solve.addActionListener(this);

		reset = new JButton("Resetuj");
		reset.setPreferredSize(new Dimension(100, 25));
		panelButton.add(reset);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		panelText.add(panelButton);
		
		labelImage=new JLabel(new ImageIcon(getClass().getResource("/pentagonImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
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
				side = convert(textSide.getText());//jeśli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeśli litery to kończymy
			}
			if(side<=0) return false;						//jeśli ujemny, to zwracamy false
		}
		else side = -1;									//jeśli był pusty, to inicjalizujemy na -1

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
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(pentagon.getSide()!=-1) textSide.setText(String.format(form,pentagon.getSide()));
		if(pentagon.getAngleSide()!=-1) textAngle.setText(String.format(form,pentagon.getAngleSide()));
		if(pentagon.getPerimeter()!=-1) textPerimeter.setText(String.format(form,pentagon.getPerimeter()));
		if(pentagon.getHeight()!=-1) textHeight.setText(String.format(form,pentagon.getHeight()));
		if(pentagon.getDiagonal()!=-1) textDiagonal.setText(String.format(form,pentagon.getDiagonal()));
		if(pentagon.getRadiusBigger()!=-1) textRadiusBigger.setText(String.format(form, pentagon.getRadiusBigger()));
		if(pentagon.getRadiusSmaller()!=-1) textRadiusSmaller.setText(String.format(form, pentagon.getRadiusSmaller()));
		if(pentagon.getArea()!=-1) textArea.setText(String.format(form,pentagon.getArea()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!getFromTextFields())
			JOptionPane.showMessageDialog(this, "Jeden z podanych argumentów jest błędny", 
					"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
		else{
			if(!checkSensOfArguments()){
				JOptionPane.showMessageDialog(this, "Błędne dane, podane wartości nie są wartościami trójkąta", 
						"Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
			else{
				Pentagon pentagon = new Pentagon(side, height, area, perimeter, diagonal, radiusSmaller, radiusBigger);
				if(pentagon.checkCorrect())
					setTextFields(pentagon);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
