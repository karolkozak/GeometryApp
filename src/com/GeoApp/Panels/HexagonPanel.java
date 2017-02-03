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
import com.GeoApp.Math.Hexagon;

public class HexagonPanel extends JPanel implements ActionListener {

	private double a, area, perimeter, radiusBigger, radiusSmaller, diagonalShort, diagonalLong;
	private JLabel labelImage, labelA, labelArea, labelAngle, labelPerimeter, labelRadiusBigger, labelRadiusSmaller, 
					labelDiagonalShort, labelDiagonalLong;
	private JTextField textA, textArea, textAngle, textPerimeter, textRadiusBigger, textRadiusSmaller, 
						textDiagonalShort, textDiagonalLong;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelA, panelAngle, panelRadiusBigger, panelRadiusSmaller, 
					panelDiagonalLong, panelDiagonalShort, panelArea, panelPerimeter, panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public HexagonPanel(ApplicationToolBarFormat myToolBarFormat) {
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
		
		panelA=new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(d);
		panelA.add(textA);
		panelText.add(panelA);
		
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
		
		panelDiagonalLong=new JPanel();
		labelDiagonalLong= new JLabel("<html>d<sub>1</sub></html>");
		panelDiagonalLong.add(labelDiagonalLong);
		textDiagonalLong = new JTextField();
		textDiagonalLong.setPreferredSize(d);
		panelDiagonalLong.add(textDiagonalLong);
		panelText.add(panelDiagonalLong);

		panelDiagonalShort=new JPanel();
		labelDiagonalShort=new JLabel("<html>d<sub>2</sub></html>");
		panelDiagonalShort.add(labelDiagonalShort);
		textDiagonalShort=new JTextField();
		textDiagonalShort.setPreferredSize(d);
		panelDiagonalShort.add(textDiagonalShort);
		panelText.add(panelDiagonalShort);
		
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
		
		textA.addActionListener(this);
		textArea.addActionListener(this);
		textPerimeter.addActionListener(this);
		textRadiusBigger.addActionListener(this);
		textRadiusSmaller.addActionListener(this);
		textDiagonalShort.addActionListener(this);
		textDiagonalLong.addActionListener(this);

		panelButton=new JPanel();
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

		labelImage=new JLabel(new ImageIcon(getClass().getResource("/HexagonImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
	}
	
	private void resetFields() {
		textA.setText(""); textDiagonalLong.setText(""); textDiagonalShort.setText(""); textRadiusBigger.setText(""); 
		textRadiusSmaller.setText(""); textArea.setText(""); textPerimeter.setText(""); textAngle.setToolTipText("");
		textAngle.setText("");
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
				a = convert(textA.getText());//jeśli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeśli litery to kończymy
			}
			if(a<=0) return false;						//jeśli ujemny, to zwracamy false
		}
		else a = -1;									//jeśli był pusty, to inicjalizujemy na -1

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
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(hexagon.getASide()!=-1) textA.setText(String.format(form,hexagon.getASide()));
		if(hexagon.getPerimeter()!=-1) textPerimeter.setText(String.format(form,hexagon.getPerimeter()));
		if(hexagon.getDiagonalLong()!=-1) textDiagonalLong.setText(String.format(form,hexagon.getDiagonalLong()));
		if(hexagon.getDiagonalShort()!=-1) textDiagonalShort.setText(String.format(form,hexagon.getDiagonalShort()));
		if(hexagon.getRadiusBigger()!=-1) textRadiusBigger.setText(String.format(form, hexagon.getRadiusBigger()));
		if(hexagon.getRadiusSmaller()!=-1) textRadiusSmaller.setText(String.format(form, hexagon.getRadiusSmaller()));
		if(hexagon.getAngleSide()!=-1) textAngle.setText(String.format(form, hexagon.getAngleSide()));
		if(hexagon.getArea()!=-1) textArea.setText(String.format(form,hexagon.getArea()));
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
				Hexagon hexagon = new Hexagon(a, area, perimeter, radiusBigger, radiusSmaller, diagonalShort, diagonalLong);
				if(hexagon.checkCorrect())
					setTextFields(hexagon);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
