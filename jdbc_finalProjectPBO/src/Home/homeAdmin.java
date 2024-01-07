package Home;

import Explore.exploreIF;
import Reservasi.reservasiHotel;
import Update.updateAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeAdmin extends JFrame {
    private JPanel homePanel;
    private JButton HOMEButton;
    private JButton EXPLOREButton;
    private JButton RESERVATIONButton;
    private JButton usernameButton;
    private JButton REGISTERButton;
    private JPanel leftCardPanel;
    private JButton selengkapnyaButton;
    private JButton selengkapnyaButton1;
    private JButton updateButton;

    public homeAdmin(String username){
        usernameButton.setText(username);
        RESERVATIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservasiHotel frame = new reservasiHotel(username);
                frame.interfaceReservation(username);
                setVisible(false);
            }
        });
        EXPLOREButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdmin frame = new updateAdmin(username);
                frame.updateLIF(username);
                setVisible(false);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exploreIF frame = new exploreIF(username);
                frame.interfaceExplore(username);
                setVisible(false);
            }
        };
        selengkapnyaButton.addActionListener(listener);
        selengkapnyaButton1.addActionListener(listener);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdmin frame = new updateAdmin(username);
                frame.updateLIF(username);
                setVisible(false);
            }
        });
    }

    public static void homeLIF(String username){
        homeAdmin frame = new homeAdmin(username);
        frame.setContentPane(frame.homePanel);
        frame.setBounds(120, 40, 0, 0);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
