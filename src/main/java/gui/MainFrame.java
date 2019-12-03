package gui;

import javax.swing.*;

public class MainFrame extends JFrame {


    public MainFrame() {
        super();
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setIconImage(new ImageIcon("src\\main\\resources\\gameIcon.png").getImage());

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        CardPanel cardPanel = new CardPanel();
        InfoPanel infoPanel = new InfoPanel();

//        add(new IntroPanel());
        add(infoPanel);
        add(cardPanel);
        add(backgroundPanel);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
