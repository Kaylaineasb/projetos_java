package jogo_da_velha;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Jogo_da_velha implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton [] buttons = new JButton[9];
    private boolean xTurn = true;

    public Jogo_da_velha(){
        frame = new JFrame("Jogo-da-velha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        for (int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial",Font.PLAIN,40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        if(xTurn){
            button.setText("X");
        }else{
            button.setText("O");
        }
        button.setEnabled(false);
        xTurn=!xTurn;
        checkForWinner();
    }

    public void checkForWinner(){
        for (int i=0;i<9;i+=3){
            if (buttons[i].getText().equals(buttons[i+1].getText())&&buttons[i].getText().equals(buttons[i+2].getText())&&!buttons[i].isEnabled()){
                JOptionPane.showConfirmDialog(frame,buttons[i].getText()+" ganhou!");
                resetGame();
                return;
            }
        }
        for (int i=0;i<3;i++){
            if(buttons[i].getText().equals(buttons[i+3].getText())&& buttons[i].getText().equals(buttons[i+6].getText())&& !buttons[i].isEnabled()){
                JOptionPane.showConfirmDialog(frame,buttons[i].getText()+" ganhou!");
                resetGame();
                return;
            }
        }
        if (buttons[0].getText().equals(buttons[4].getText())&& buttons[0].getText().equals(buttons[8].getText())&& !buttons[0].isEnabled()){
            JOptionPane.showConfirmDialog(frame,buttons[0].getText()+" ganhou!");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText())&& buttons[2].getText().equals(buttons[6].getText())&& !buttons[2].isEnabled()){
            JOptionPane.showConfirmDialog(frame,buttons[2].getText()+" ganhou!");
            resetGame();
            return;
        }

        //check for tie
        boolean tie= true;
        for (int i=0;i<9;i++){
            if (buttons[i].isEnabled()){
                tie= false;
                break;
            }
        }

        if(tie){
            JOptionPane.showConfirmDialog(frame,"Tie game!");
            resetGame();
        }
    }
    public void resetGame(){
        for (int i=0;i<9;i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn=true;
    }
}
