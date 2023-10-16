package cronometro;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        cronometro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cronometro.setSize(300,250);
        cronometro.setVisible(true);
    }
}
