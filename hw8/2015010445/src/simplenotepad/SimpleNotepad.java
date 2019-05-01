package simplenotepad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class SimpleNotepad {

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JTextArea textArea;
    JPanel panel;
    JFrame frame;
    FileDialog saveWindow, loadWindow;

    class SaveListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            System.out.println("menuSelected");
            saveWindow.setVisible(true);
            String dir = saveWindow.getDirectory();
            String filename = saveWindow.getFile();
            if (filename == null)
                System.out.println("You cancelled the choice");
            else {
                System.out.println("You chose " + filename);
                String content = textArea.getText();
                BufferedWriter output;
                try {
                    File savedFile = new File(dir + filename);
                    output = new BufferedWriter(new FileWriter(savedFile));
                    output.write(content);
                    output.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        @Override
        public void menuDeselected(MenuEvent e) {}
        @Override
        public void menuCanceled(MenuEvent e) {}
    }

    class LoadListener implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            System.out.println("menuSelected");
            loadWindow.setVisible(true);
            String dir = saveWindow.getDirectory();
            String filename = saveWindow.getFile();
            if (filename == null)
                System.out.println("You cancelled the choice");
            else {
                System.out.println("You chose " + filename);
                BufferedReader input;
                try {
                    File openedFile = new File(dir + filename);
                    input = new BufferedReader(new FileReader(openedFile));
                    String content = "", line = "";
                    while ((line = input.readLine()) != null) {
                        content += line;
                        content += "\n";
                    }
                    textArea.setText(content);
                    input.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        @Override
        public void menuDeselected(MenuEvent e) {}
        @Override
        public void menuCanceled(MenuEvent e) {}
    }

    private void setMenus() {
        //Create the menu bar.
        menuBar = new JMenuBar();

        menu = new JMenu("Open");
        menu.setMnemonic(KeyEvent.VK_A);
        LoadListener menuListener1 = new LoadListener();
        menu.addMenuListener(menuListener1);
        menuBar.add(menu);

        menu = new JMenu("Save");
        menu.setMnemonic(KeyEvent.VK_A);
        SaveListener menuListener2 = new SaveListener();
        menu.addMenuListener(menuListener2);
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
    }

    private void setText() {
        panel = new JPanel();
        textArea = new JTextArea(100, 40);
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //panel.add(textField);
        panel.add(scrollPane);
        frame.add(panel);
    }

    private void setDialog() {
        saveWindow = new FileDialog(frame, "Save", FileDialog.SAVE);
        loadWindow = new FileDialog(frame, "Open", FileDialog.LOAD);
    }

    public SimpleNotepad() {
        frame = new JFrame("Simple Notepad");
        //frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMenus();
        setText();
        setDialog();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SimpleNotepad menu = new SimpleNotepad();
    }
}