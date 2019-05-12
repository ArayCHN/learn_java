package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;


public class TicTacToe {

    private int[][] board = new int[3][3];
    JFrame frame;
    JPanel panelPlayer, panelBoard;
    JButton[] buttons;
    JLabel currentPlayer; // 1: Alice, X; 2: Bob, O
    int currentPlayerNum, numRounds;
    Popup gameTerminatesWindow;
    JLabel popupLabel;
    boolean inGame;

    private ActionListener actAdd(int i, int j) {
        return new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (board[i][j] != 0 || inGame == false)
                    return; // ineffective
                numRounds += 1;
                board[i][j] = currentPlayerNum;
                if (currentPlayerNum == 1){
                    buttons[i * 3 + j].setText("X");
                    currentPlayer.setText("Bob: O");
                }
                else {
                    buttons[i * 3 + j].setText("O");
                    currentPlayer.setText("Alice: X");
                }
                currentPlayerNum = 3 - currentPlayerNum; // flip player
                int winner = who_wins();
                //System.out.println(winner);
                if (winner == 0 && numRounds < 9) // game not ending
                    return;
                else
                    if (winner == 1) {
                        popupLabel.setText("Alice wins!");
                        gameTerminatesWindow.show();
                        inGame = false;
                    }
                    else
                        if (winner == 2){
                            popupLabel.setText("Bob wins!");
                            gameTerminatesWindow.show();
                            inGame = false;
                        }
                        else {
                            popupLabel.setText("Ties!");
                            gameTerminatesWindow.show();
                            inGame = false;
                        }
            }
        };
    }

    private ActionListener popupListener() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                String d = e.getActionCommand(); 
                if (d.equals("Restart")) { 
                    gameTerminatesWindow.hide();
                    reset();
                }
            }
        };
    }

    TicTacToe() {
        frame = new JFrame();
        panelPlayer = new JPanel();
        currentPlayer = new JLabel();
        panelBoard = new JPanel();
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++)
            buttons[i] = new JButton("");

        reset();
    }

    void reset() {
        // initilize the board
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = 0;
        currentPlayerNum = 1; // Alice first
        numRounds = 0;
        // frame.removeAll();
        // panelPlayer.removeAll();
        // panelBoard.removeAll();
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].addActionListener(actAdd(i / 3, i % 3));
            //panelBoard.add(buttons[i]);
        }
        PopupFactory popFac = new PopupFactory();
        JPanel popupPanel = new JPanel();
        popupPanel.setLayout(new FlowLayout());
        popupLabel = new JLabel("Alice Wins!");
        popupPanel.add(popupLabel);
        JButton buttonRestart = new JButton("Restart");
        buttonRestart.addActionListener(popupListener());
        popupPanel.add(buttonRestart);
        gameTerminatesWindow = popFac.getPopup(frame, popupPanel, 400, 400);

        inGame = true;

        setVisible();
    }

    void setVisible() {
        frame.setLayout(new BorderLayout());

        currentPlayer.setText("Alice: X");
        panelPlayer.setLayout(new FlowLayout());
        panelPlayer.add(currentPlayer);
        frame.add("North", panelPlayer);

        panelBoard.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            panelBoard.add(buttons[i]);
        }
        frame.add("Center", panelBoard);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    // int place(int player, int row, int column) {
    //     if (board[row][column] != 0)
    //         return 3;
    //     board[row][column] = player;
    //     return who_wins();
    // }

    int who_wins() {
        // row
        for (int i = 0; i < 3; i++) {
            int current_player = board[i][0];
            boolean wins = true;
            for (int j = 1; j < 3; j++) {
                if (board[i][j] != current_player) {
                    wins = false;
                    break;
                }
            }
            if (wins)
                return current_player;
        }
        // column
        for (int i = 0; i < 3; i++) {
            int current_player = board[0][i];
            boolean wins = true;
            for (int j = 1; j < 3; j++) {
                if (board[j][i] != current_player) {
                    wins = false;
                    break;
                }
            }
            if (wins)
                return current_player;
        }
        // diagnal
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return board[0][2];
        // no one wins
        return 0;
    }
}