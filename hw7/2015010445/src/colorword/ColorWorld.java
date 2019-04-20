package colorworld;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorWorld {
    private JLabel labelText = new JLabel();
    private JRadioButton radioRed = new JRadioButton("Red");
    private JRadioButton radioGreen = new JRadioButton("Green");
    private JRadioButton radioBlue = new JRadioButton("Blue");
    private ButtonGroup groupColor = new ButtonGroup();
    private JPanel panelText = new JPanel();
    private JPanel panelColor = new JPanel();
    private JFrame frame = new JFrame("ColorWorld");
    private JPanel panel = new JPanel();
    public ColorWorld() {
        frame.setResizable(false);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2, 1));

        // text display
        labelText.setText("Hello, world!");
        labelText.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        labelText.setForeground(Color.RED);
        panelText.add(labelText);

        // set listner
        RadioButtonHandler listener = new RadioButtonHandler();

        // color selector
        radioRed.addItemListener(listener);
        radioGreen.addItemListener(listener);
        radioBlue.addItemListener(listener);
        groupColor.add(radioRed);
        groupColor.add(radioGreen);
        groupColor.add(radioBlue);
        groupColor.setSelected(radioRed.getModel(), true);
        panelColor.setLayout(new FlowLayout());
        panelColor.add(radioRed);
        panelColor.add(radioGreen);
        panelColor.add(radioBlue);

        panel.add(panelText);
        panel.add(panelColor);
        frame.add(panel);

        frame.setVisible(true);
    }
    private class RadioButtonHandler implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if(event.getSource() == radioRed) {
                labelText.setForeground(Color.RED);
            }
            else if(event.getSource() == radioGreen) {
                labelText.setForeground(Color.GREEN);
            }
            else if(event.getSource() == radioBlue) {
                labelText.setForeground(Color.BLUE);
            }
        }
    }
    public static void main(String[] args) {
        ColorWorld app = new ColorWorld();
    }
}