import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calc extends JFrame implements ActionListener {
    private JTextField display;
    private double num1, num2, result;
    private String operator;

    public calc() {
        setTitle("Scientific Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "√", "x²", "1/x",
            "sin", "cos", "tan", "log"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "C":
                    display.setText("");
                    break;
                case "=":
                    num2 = Double.parseDouble(display.getText());
                    switch (operator) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/": result = num1 / num2; break;
                    }
                    display.setText(String.valueOf(result));
                    break;
                case "√":
                    display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
                    break;
                case "x²":
                    display.setText(String.valueOf(Math.pow(Double.parseDouble(display.getText()), 2)));
                    break;
                case "1/x":
                    display.setText(String.valueOf(1 / Double.parseDouble(display.getText())));
                    break;
                case "sin":
                    display.setText(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(display.getText())))));
                    break;
                case "cos":
                    display.setText(String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(display.getText())))));
                    break;
                case "tan":
                    display.setText(String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(display.getText())))));
                    break;
                case "log":
                    display.setText(String.valueOf(Math.log10(Double.parseDouble(display.getText()))));
                    break;
                default:
                    if ("+-*/".contains(command)) {
                        num1 = Double.parseDouble(display.getText());
                        operator = command;
                        display.setText("");
                    } else {
                        display.setText(display.getText() + command);
                    }
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new calc();
    }
}