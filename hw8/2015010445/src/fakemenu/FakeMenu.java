package fakemenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FakeMenu {

    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    private void setMenus() {
        //Create the menu bar.
        menuBar = new JMenuBar();

        // The file menu
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);

        menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuItem = new JMenuItem("Open");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuBar.add(menu);

        // Edit
        menu = new JMenu("Edit");
        menu.setMnemonic(KeyEvent.VK_A);

        menuItem = new JMenuItem("Copy");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuItem = new JMenuItem("Cut");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuItem = new JMenuItem("Paste");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem = new JMenuItem("Cancel");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuBar.add(menu);

        // Window
        menu = new JMenu("Window");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);

        // Help
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_A);

        menuItem = new JMenuItem("About");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menuBar.add(menu);
    }
    public FakeMenu() {
        JFrame frame = new JFrame("FakeMenu");
        frame.setResizable(false);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMenus();

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        FakeMenu menu = new FakeMenu();
    }
}