package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

// 0~9, ., +-*/, =, C
/*
1 2 3 =
4 5 6 +
7 8 9 -
C 0 / *
*/

public class Calculator {
    JFrame frame;
    JPanel panelInput, panelOutput;
    JLabel result;
    int num1 = 0, num2 = 0, ans = 99999;
    boolean err = false;
    char opr = 'n'; // 'n' denotes null here
    private void setOutput() {
        panelOutput = new JPanel();
        panelOutput.setLayout(new FlowLayout());
        result = new JLabel("0");
        panelOutput.add(result);
        frame.add(panelOutput);
    }
    private ActionListener actAdd(int num) {
        return new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (opr == 'n') {
                    num1 = num1 * 10 + num;
                    result.setText(num1 + "");
                    ans = 99999;
                } else {
                    num2 = num2 * 10 + num;
                    result.setText(num2 + "");
                }
                err = false;
            }
        };
    }
    private ActionListener addOprAct(char tmpOpr) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opr = tmpOpr;
                if (ans != 99999)
                    num1 = ans;
            }
        };
    }
    private void setInput() {
        panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(4, 4));
        JButton[] buttons = new JButton[16];
        buttons[0] = new JButton("1");
        buttons[0].addActionListener(actAdd(1));
        buttons[1] = new JButton("2");
        buttons[1].addActionListener(actAdd(2));
        buttons[2] = new JButton("3");
        buttons[2].addActionListener(actAdd(3));
        buttons[3] = new JButton("=");
        buttons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (opr) {
                    case 'n': ans = num1; num1 = 0; return; // do nothing, don't change display!
                    case '+': num1 = num1 + num2; break;
                    case '-': num1 = num1 - num2; break;
                    case '*': num1 = num1 * num2; break;
                    case '/': if (num2 != 0) num1 = num1 / num2; else {err = true;} break;
                }
                if (err == true)
                    result.setText("Error!");
                else
                    result.setText(num1 + "");
                opr = 'n';
                num2 = 0;
                ans = num1;
                num1 = 0;
            }
        });
        buttons[4] = new JButton("4");
        buttons[4].addActionListener(actAdd(4));
        buttons[5] = new JButton("5");
        buttons[5].addActionListener(actAdd(5));
        buttons[6] = new JButton("6");
        buttons[6].addActionListener(actAdd(6));
        buttons[7] = new JButton("+");
        buttons[7].addActionListener(addOprAct('+'));
        buttons[8] = new JButton("7");
        buttons[8].addActionListener(actAdd(7));
        buttons[9] = new JButton("8");
        buttons[9].addActionListener(actAdd(8));
        buttons[10] = new JButton("9");
        buttons[10].addActionListener(actAdd(9));
        buttons[11] = new JButton("-");
        buttons[11].addActionListener(addOprAct('-'));
        buttons[12] = new JButton("C");
        buttons[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.setText("0");
                num1 = 0;
                num2 = 0;
                opr = 'n';
                err = false;
            }
        });
        buttons[13] = new JButton("0");
        buttons[13].addActionListener(actAdd(0));
        buttons[14] = new JButton("/");
        buttons[14].addActionListener(addOprAct('/'));
        buttons[15] = new JButton("*");
        buttons[15].addActionListener(addOprAct('*'));
        for (int i = 0; i < 16; i ++) {
            panelInput.add(buttons[i]);
        }
        frame.add(panelInput);
    }
    public Calculator() {
        frame = new JFrame("calculator");
        frame.setLayout(new FlowLayout());
        setOutput();
        setInput();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        Calculator cal = new Calculator();
    }
}