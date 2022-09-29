import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JPanel panel;
	JButton[] numbersButtons = new JButton[10];
	JButton[] functionsButtons = new JButton[8];
	JButton clrButton, delButton, addButton, devButton, multButton,
	        subButton, modButton, decButton, equButton;
	double num1=0, num2=0, result=0;
	char operator;
	
	Calculator() {
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 550);
		frame.setLayout(null);
		
		Font myFont = new Font("Ink Free", Font.BOLD, 25);
		
		textfield = new JTextField();
		textfield.setBounds(50, 20, 350, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		devButton = new JButton("/");
		multButton = new JButton("*");
		modButton = new JButton("%");
		equButton = new JButton("=");
		decButton = new JButton(".");
		clrButton = new JButton("Clear");
		delButton = new JButton("Delete");
		
		functionsButtons[0] = addButton;
		functionsButtons[1] = subButton;
		functionsButtons[2] = multButton;
		functionsButtons[3] = devButton;
		functionsButtons[4] = decButton;
		functionsButtons[5] = equButton;
		functionsButtons[6] = delButton;
		functionsButtons[7] = clrButton;
		
		for(int i =0; i < 8; i++) {
			
			functionsButtons[i].setFocusable(false);
			functionsButtons[i].setFont(myFont);
			functionsButtons[i].addActionListener(this);
		}
		
		delButton.setBounds(50, 430, 175, 50);
		delButton.setFont(myFont);
		
		clrButton.setBounds(225, 430, 175, 50);
		clrButton.setFont(myFont);
		
		panel = new JPanel();
		panel.setBounds(50, 80, 350, 330);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.LIGHT_GRAY);
		
		for(int i = 0; i < 10; i++) {
			numbersButtons[i] = new JButton(String.valueOf(i));
			numbersButtons[i].setFont(myFont);
			numbersButtons[i].setFocusable(false);
			numbersButtons[i].addActionListener(this);
		}
		
		panel.add(numbersButtons[1]);
		panel.add(numbersButtons[2]);
		panel.add(numbersButtons[3]);
		panel.add(addButton);
		
		panel.add(numbersButtons[4]);
		panel.add(numbersButtons[5]);
		panel.add(numbersButtons[6]);
		panel.add(subButton);
		
		panel.add(numbersButtons[7]);
		panel.add(numbersButtons[8]);
		panel.add(numbersButtons[9]);
		panel.add(multButton);
		
		panel.add(decButton);
		panel.add(numbersButtons[0]);
		panel.add(equButton);
		panel.add(devButton);
	
		
		frame.add(panel);
		frame.add(textfield);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numbersButtons[i]) {
				textfield.setText(textfield.getText().concat(numbersButtons[i].getText()));
			}
		}
		if(e.getSource() == decButton) {
			
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '+';
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '-';
		}
		if(e.getSource() == multButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '*';
		}
		if(e.getSource() == devButton) {
			num1 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			operator = '/';
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			textfield.setText("");
			switch(operator) {
			case '+' :
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case '*' :
				result = num1 * num2;
				break;
			case '/' :
				result = num1 / num2;
				break;	
			}
			
			textfield.setText(String.valueOf(result));
		}
		if(e.getSource() == clrButton) {
			
			textfield.setText("");
			
		}
		if(e.getSource() == delButton) {
			
			String string = textfield.getText();
			textfield.setText("");
			
			for(int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
	}

}
