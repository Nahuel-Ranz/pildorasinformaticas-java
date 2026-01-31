package graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.awt.Toolkit.getDefaultToolkit;

public class Calculator1 {
	public static void main(String []args) {
		new CalculatorFrame().setVisible(true);
	}
}

class CalculatorFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public CalculatorFrame() {
		var screen= getDefaultToolkit().getScreenSize();
		int width = (int)screen.getWidth();
		int height = (int)screen.getHeight();
		
		this.setTitle("Calculator");
		this.setSize(300, 400);
		this.setLocation(
			width/2-super.getWidth()/2,
			height/2-super.getHeight()/2
		);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new CalculatorPannel());
	}
}

class CalculatorPannel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton display;
	private JPanel buttons;
	private String digits[][] = {
			"<,<<,%,^".split(","),
			"789+".split(""),
			"456-".split(""),
			"123*".split(""),
			"0.=/".split(""),
	};
	private String previousNumber = "";
	private boolean isNewNumber = true;
	private String currentOperation = "";
	private String []printable = "0.123456789".split("");
	private String dt;
	
	public CalculatorPannel() {
		this.setLayout(new BorderLayout(5, 5));
		
		this.display = new JButton("0");
		this.display.setEnabled(false);
		this.dt = display.getText();
		this.add(this.display, BorderLayout.NORTH);
		
		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(5, 4, 2, 2));
		this.addAction();
		
		this.add(this.buttons, BorderLayout.CENTER);
		
	}
	
	private void addAction() {
		Arrays.stream(this.digits).forEach( row -> {
			Arrays.stream(row).forEach(digit -> {
				
				JButton btn = new JButton(digit);
				if(contains(printable, digit)) btn.addActionListener(new InsertNumber());
				else btn.addActionListener(new Operator());
				this.buttons.add(btn);
			});
		});
	}
	
	private static boolean contains(String []strings, String string) {
		for(String o: strings) { if(o.equals(string)) return true;}
		return false;
	}
	
	private class InsertNumber implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String entered = e.getActionCommand();
			
			if(entered.equals(".")) {
				
				if(!dt.contains(".")) {
					if(isNewNumber) display.setText(dt = "0.");
					else display.setText(dt += ".");
				}
			} else if((dt.length() == 1 && dt.equals("0")) || isNewNumber) {
				
				display.setText(dt = entered);
			} else {
				display.setText(dt = dt.concat(entered));
			}
			
			isNewNumber = false;
			if(currentOperation.equals("=")) {
				previousNumber = "";
				currentOperation = "";
			}
		}
	}
	
	private class Operator implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String entered = e.getActionCommand();
			
			switch(entered) {
				case "+": toOperate("+"); break;
				case "-": toOperate("-"); break;
				case "*": toOperate("*"); break;
				case "/": toOperate("/"); break;
				case "%": toOperate("%"); break;
				case "^": toOperate("^"); break;
				case "<":
					if(dt.length() == 1) display.setText(dt = "0");
					else display.setText(dt = dt.substring(0, dt.length()-1));
					break;
				case "<<":
					previousNumber = "";
					isNewNumber = true;
					currentOperation = "";
					display.setText(dt = "0");
					break;
				case "=":
					if(
						currentOperation.equals("=") ||
						currentOperation.equals("") ||
						isNewNumber ||
						previousNumber.equals("")
					) return;
					else {
						display.setText(dt = toInteger(operate(previousNumber, dt, currentOperation)));
						previousNumber = dt;
						currentOperation = "=";
						isNewNumber = true;
					}
					break;
			}
		}
		
		private static String toInteger(String number) {
			int dotIndex = number.indexOf(".");
			return dotIndex > -1 && number.substring(dotIndex).matches("^\\.0*$")
				? number.substring(0, dotIndex)
				: number;
		}
		
		private static String operate(String num1, String num2, String operator) {
			double n1 = Double.parseDouble(num1);
			double n2 = Double.parseDouble(num2);
			
			return switch(operator) {
				case "+" -> String.valueOf(n1 + n2);
				case "-" -> String.valueOf(n1 - n2);
				case "*" -> String.valueOf(n1 * n2);
				case "/" -> {
					if(n2 == 0) yield "Cannot divide by zero.";
					yield String.valueOf(n1/n2);
				}
				case "%" -> String.valueOf(n1%n2);
				case "^" -> String.valueOf(Math.pow(n1, n2));
				default -> "";
			};
		}
		
		private void toOperate(String operator) {
			if(previousNumber.equals("") && isNewNumber) return;
			else if(!isNewNumber && previousNumber.equals("")) previousNumber = dt;
			else if(!isNewNumber && !previousNumber.equals(""))
				previousNumber = dt = toInteger(operate(previousNumber, dt, operator));
			
			isNewNumber = true;
			currentOperation = operator;
		}
	}
}