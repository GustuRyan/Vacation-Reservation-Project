package Card;

import javax.swing.*;
import java.awt.*;

public class cardProduct extends JFrame {
    public JPanel product;
    private JButton button1;

    public cardProduct(){
        setLayout(new BorderLayout());
    }

    public JPanel getProductPanel() {
        return product;
    }

    public static void showCard (){
        cardProduct frame = new cardProduct();
        frame.setContentPane(frame.product);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
