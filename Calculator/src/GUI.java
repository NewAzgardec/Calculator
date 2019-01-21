//package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class GUI extends JFrame {

    JTextArea display = new JTextArea();

    JPanel buttonPanel = new JPanel(new GridLayout(5, 3));
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonSum = new JButton("+");
    JButton button0 = new JButton("0");
    JButton buttonBack = new JButton("<-");
    JButton buttonDivide = new JButton("/");
    JButton buttonSub = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonStart = new JButton("=");
    int firstValue = 0;
    String operation = "+";

    GUI() {
        setBounds(500, 200, 270, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "9");
            }
        });
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = display.getText();
                display.setText(temp.substring(0, temp.length() - 1));
            }
        });
        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "+";
            }
        });
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "*";
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "/";
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Integer.valueOf(display.getText());
                display.setText("");
                operation = "-";
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int secondValue = Integer.valueOf(display.getText());
                if ("+".equals(operation)) {
                    display.setText((firstValue + secondValue) + "");
                }
                if ("-".equals(operation)) {
                    display.setText((firstValue - secondValue) + "");
                }
                if ("*".equals(operation)) {
                    display.setText((firstValue * secondValue) + "");
                }
                if ("/".equals(operation)) {
                    display.setText((firstValue / secondValue) + "");
                }
                firstValue = 0;
                operation = "+";
            }
        });
        setLayout(null);


        display.setBounds(10,10,235,25);
        button1.setBounds(10,190,50,50);
        button1.setBackground(Color.WHITE);
        button2.setBounds(60, 190, 50, 50);
        button2.setBackground(Color.WHITE);
        button3.setBounds(110, 190, 50, 50);
        button3.setBackground(Color.WHITE);
        button4.setBounds(10, 110, 50, 50);
        button4.setBackground(Color.WHITE);
        button5.setBounds(60, 110, 50, 50);
        button5.setBackground(Color.WHITE);
        button6.setBounds(110, 110, 50, 50);
        button6.setBackground(Color.WHITE);
        button7.setBounds(10, 40, 50, 50);
        button7.setBackground(Color.WHITE);
        button8.setBounds(60, 40, 50, 50);
        button8.setBackground(Color.WHITE);
        button9.setBounds(110, 40, 50, 50);
        button9.setBackground(Color.WHITE);
        button0.setBounds(10, 270, 50, 50);
        button0.setBackground(Color.WHITE);

        buttonStart.setBounds(60, 270, 50, 50);
        Font bigFontStart = new Font("serif", Font.BOLD, 20);
        buttonStart.setFont(bigFontStart);
        buttonStart.setBackground(Color.WHITE);
        buttonStart.setForeground(Color.BLACK);

        buttonBack.setBounds(110, 270, 50, 50);
        Font bigFontBack = new Font("serif", Font.BOLD, 15);
        buttonBack.setFont(bigFontBack);
        buttonBack.setBackground(Color.WHITE);
        buttonBack.setForeground(Color.BLACK);

        buttonSum.setBounds(170, 40, 75, 50);
        Font bigFontSum = new Font("serif", Font.BOLD, 20);
        buttonSum.setFont(bigFontSum);
        buttonSum.setBackground(Color.BLACK);
        buttonSum.setForeground(Color.WHITE);

        buttonDivide.setBounds(170, 270, 75, 50);
        Font bigFontDivide = new Font("serif", Font.BOLD, 20);
        buttonDivide.setFont(bigFontDivide);
        buttonDivide.setBackground(Color.BLACK);
        buttonDivide.setForeground(Color.WHITE);

        buttonMul.setBounds(170, 190, 75, 50);
        Font bigFontMul = new Font("serif", Font.BOLD, 20);
        buttonMul.setFont(bigFontMul);
        buttonMul.setBackground(Color.BLACK);
        buttonMul.setForeground(Color.WHITE);

        buttonSub.setBounds(170, 110, 75, 50);
        Font bigFontSub = new Font("serif", Font.BOLD, 20);
        buttonSub.setFont(bigFontSub);
        buttonSub.setBackground(Color.BLACK);
        buttonSub.setForeground(Color.WHITE);



        add(display);
        add(buttonStart);
        add(button1);
        add(button0);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(buttonSub);
        add(buttonSum);
        add(buttonDivide);
        add(buttonMul);
        add(buttonBack);

        setVisible(true);
        setResizable(false);
    }
}
