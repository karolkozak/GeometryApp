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
import com.GeoApp.Math.Rectangle;

public class RectanglePanel extends JPanel implements ActionListener {
	
	private double a, b, diagonal, area, perimeter, angleDiagonal;
	private JLabel labelImage, labelA, labelB, labelDiagonal, labelArea, labelPerimeter, labelAngleDiagonal;
	private JTextField textA, textB, textDiagonal, textArea, textPerimeter, textAngleDiagonal;
	private JButton solve, reset;
	private JPanel panelText, panelImage, panelA, panelB, panelDiagonal, panelArea, panelPerimeter, panelAngleDiagonal, 
					panelButton;
	private ApplicationToolBarFormat myToolBarFormat;
	
	public RectanglePanel(ApplicationToolBarFormat myToolBarFormat) {
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
		Dimension dimension=new Dimension(70, 25);
		panelText=new JPanel(new FlowLayout());
		
		panelA=new JPanel();
		labelA = new JLabel("a");
		panelA.add(labelA);
		textA = new JTextField();
		textA.setPreferredSize(dimension);
		panelA.add(textA);
		panelText.add(panelA);

		panelB=new JPanel();
		labelB = new JLabel("b");
		panelB.add(labelB);
		textB = new JTextField();
		textB.setPreferredSize(dimension);
		panelB.add(textB);
		panelText.add(panelB);

		panelDiagonal=new JPanel();
		labelDiagonal= new JLabel("d");
		panelDiagonal.add(labelDiagonal);
		textDiagonal = new JTextField();
		textDiagonal.setPreferredSize(dimension);
		panelDiagonal.add(textDiagonal);
		panelText.add(panelDiagonal);

		panelAngleDiagonal=new JPanel();
		labelAngleDiagonal = new JLabel("α");
		panelAngleDiagonal.add(labelAngleDiagonal);
		textAngleDiagonal=new JTextField();
		textAngleDiagonal.setPreferredSize(dimension);
		panelAngleDiagonal.add(textAngleDiagonal);
		panelText.add(panelAngleDiagonal);

		panelArea=new JPanel();
		labelArea = new JLabel("Pole");
		panelArea.add(labelArea);
		textArea = new JTextField();
		textArea.setPreferredSize(dimension);
		panelArea.add(textArea);
		panelText.add(panelArea);

		panelPerimeter=new JPanel();
		labelPerimeter = new JLabel("Obwód");
		panelPerimeter.add(labelPerimeter);
		textPerimeter = new JTextField();
		textPerimeter.setPreferredSize(dimension);
		panelPerimeter.add(textPerimeter);
		panelText.add(panelPerimeter);
		
		textA.addActionListener(this);
		textB.addActionListener(this);
		textDiagonal.addActionListener(this);
		textArea.addActionListener(this);
		textPerimeter.addActionListener(this);
		textAngleDiagonal.addActionListener(this);

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
		
		labelImage=new JLabel(new ImageIcon(getClass().getResource("/rectangleImage.png")));
		panelImage=new JPanel();
		panelImage.add(labelImage, new BorderLayout());

		add(panelText);
		add(panelImage);
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
				a = convert(textA.getText());//jeśli niepusty, to pobieramy
			} catch (NumberFormatException e) {
				return false;							//jeśli litery to kończymy
			}
			if(a<=0) return false;						//jeśli ujemny, to zwracamy false
		}
		else a = -1;									//jeśli był pusty, to inicjalizujemy na -1

		if(!textB.getText().equals("")){
			try {
				b = convert(textB.getText());
			} catch (NumberFormatException e) {
				return false;
			}
			if(b<=0) return false;
		}
		else b = -1;

		if(!textDiagonal.getText().equals("")){
			try {
				diagonal = convert(textDiagonal.getText());
			} catch (NumberFormatException e1) {
				return false;
			}
			if(diagonal<=0) return false;
		}
		else diagonal = -1;


		if(!textAngleDiagonal.getText().equals("")){
			try{
				angleDiagonal=convert(textAngleDiagonal.getText());
			}catch(NumberFormatException e){
				return false;
			}
			if(angleDiagonal<=0) return false;
			angleDiagonal = angleDiagonal*(Math.PI/180.0);
		}
		else angleDiagonal=-1;

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

	private void setTextFields(Rectangle rectangle) {
		int numberOfDotted = myToolBarFormat.getNumberOfDotted();
		String form = "%.2f";
		if(numberOfDotted==2)
			form = "%.2f";
		else if(numberOfDotted==3)
			form = "%.3f";
		else
			form = "%.4f";
		
		if(rectangle.getA()!=-1) textA.setText(String.format(form,rectangle.getA()));
		if(rectangle.getB()!=-1) textB.setText(String.format(form,rectangle.getB()));
		if(rectangle.getPerimeter()!=-1) textPerimeter.setText(String.format(form,rectangle.getPerimeter()));
		if(rectangle.getDiagonal()!=-1) textDiagonal.setText(String.format(form,rectangle.getDiagonal()));
		if(rectangle.getAngleDiagonal()!=-1) {
			double angle = rectangle.getAngleDiagonal()*180/Math.PI;
			textAngleDiagonal.setText(String.format(form, angle));
		}
		if(rectangle.getArea()!=-1) textArea.setText(String.format(form,rectangle.getArea()));
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
				Rectangle rectangle = new Rectangle(a, b, diagonal, area, perimeter, angleDiagonal);
				if(rectangle.checkCorrect())
					setTextFields(rectangle);
				else
					JOptionPane.showMessageDialog(this, "Nic nie obliczono", "Ostrzeżenie", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
