package Home;

import signIn_signUp.App;

import javax.swing.*;
import java.util.Arrays;

public class interfaceHome  extends  JFrame  {
    private JTextArea textArea1;
    private JPanel homePanel;
    private JButton HOMEButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JButton LOGINButton;
    private JButton REGISTERButton;

    public interfaceHome(){
         textArea1.setText(Arrays.toString(App.printData()));
    }

    public static void homeIF(){
        interfaceHome frame = new interfaceHome();
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        homeIF();
    }
}
