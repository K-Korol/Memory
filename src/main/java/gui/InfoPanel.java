package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static gui.BackgroundPanel.tile_x;
import static gui.BackgroundPanel.tile_y;

public class InfoPanel extends JPanel {
    int[] infoPanelBounds = {
            (tile_x >> 1) + (tile_x >> 2) - (tile_x >> 5),
            tile_y >> 3,
            (tile_x >> 2) + (tile_x >> 6),
            tile_y - (tile_y >> 2) + (tile_y >> 5)
    };

    public int roundNumber = 0;

//    * PLAYERS

    public static boolean isPlayer_2Move = false;
    static int currentPlayerChooser = isPlayer_2Move ? 0 : 1;

    static int player_1Score = 0;
    static int player_2Score = 0;
    public static int[] playerPoints = {player_1Score, player_2Score};


    static JLabel player_1ScoreLabel = new JLabel();
    static JLabel player_2ScoreLabel = new JLabel();
    static JLabel[] scoreboard = {player_1ScoreLabel, player_1ScoreLabel};


    public static void updateScoreBoard() {
        int cache = InfoPanel.isPlayer_2Move ? 0 : 1;
        Image scoreBoardUrl = new ImageIcon(new StringBuilder()
                .append("src\\main\\resources\\infoPanel\\")
                .append(playerPoints[cache])
                .append(".png")
                .toString()
        ).getImage().getScaledInstance(
                300,
                300,
                Image.SCALE_SMOOTH
        );
//        scoreboard[cache].scoreUrl =


        //                .append(playerPoints[InfoPanel.playerPoints[InfoPanel.isPlayer_2Move?0:1]])
//        InfoPanel.playerPoints[InfoPanel.isPlayer_2Move?0:1]++;
    }

    public InfoPanel() {
        super();

//        *     INFO PANEL properties

        {
            setLayout(null);
            setBounds(
                    infoPanelBounds[0],
                    infoPanelBounds[1],
                    infoPanelBounds[2],
                    infoPanelBounds[3]
            );
            setBackground(new Color(255, 255, 255, 0));
        }


        player_1ScoreLabel = new JLabel();
        player_1ScoreLabel.setBounds(
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3) + (infoPanelBounds[2] >> 4),
                (infoPanelBounds[3] >> 2) /*+ (infoPanelBounds[3] >> 4)*/,
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046
        );
        Image player_1ScoreUrl = new ImageIcon("src\\main\\resources\\infoPanel\\0.png").getImage().getScaledInstance(
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                Image.SCALE_SMOOTH);
        player_1ScoreLabel.setIcon(new ImageIcon(player_1ScoreUrl));
        add(player_1ScoreLabel);



        player_2ScoreLabel = new JLabel();
        player_2ScoreLabel.setBounds(
                (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3) + (infoPanelBounds[2] >> 4),
                (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 4),
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046
        );
        Image player_2ScoreUrl = new ImageIcon("src\\main\\resources\\infoPanel\\0.png").getImage().getScaledInstance(
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                Image.SCALE_SMOOTH);
        player_2ScoreLabel.setIcon(new ImageIcon(player_2ScoreUrl));
        add(player_2ScoreLabel);


        JLabel panelHeadline = new JLabel();
        {
            panelHeadline.setBounds(
                    0,
                    0,
                    infoPanelBounds[2],
                    (infoPanelBounds[2] * 226 / 910)
            );
            panelHeadline.setOpaque(false);
            panelHeadline.setVisible(true);
            Image panelHeadlineUrl = new ImageIcon("src\\main\\resources\\infoPanel\\memory.png").getImage().getScaledInstance(
                    infoPanelBounds[2],
                    (infoPanelBounds[2] * 226 / 910),
                    Image.SCALE_SMOOTH);
            panelHeadline.setIcon(new ImageIcon(panelHeadlineUrl));
        }
        add(panelHeadline);

        JLabel player_1Headline = new JLabel();
        {
            player_1Headline.setBounds(
                    0,
                    (infoPanelBounds[3] >> 2) /*+ (infoPanelBounds[3] >> 4)*/,
                    (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046
            );
            player_1Headline.setOpaque(false);
            player_1Headline.setVisible(true);
            Image player_1HeadlineUrl = new ImageIcon(
                    "src\\main\\resources\\infoPanel\\Gracz1.png").getImage().getScaledInstance(
                    (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 443 / 1046,
                    Image.SCALE_SMOOTH
            );
            player_1Headline.setIcon(new ImageIcon(player_1HeadlineUrl));
        }
        add(player_1Headline);

        JLabel player_2Headline = new JLabel();
        {
            player_2Headline.setBounds(
                    0,
                    (infoPanelBounds[3] >> 1) + (infoPanelBounds[3] >> 4),
                    (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 429 / 1093
            );
            player_2Headline.setOpaque(false);
            player_2Headline.setVisible(true);
            Image player_2HeadlineUrl = new ImageIcon(
                    "src\\main\\resources\\infoPanel\\Gracz2.png").getImage().getScaledInstance(
                    (infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3),
                    ((infoPanelBounds[2] >> 1) + (infoPanelBounds[2] >> 3)) * 429 / 1093,
                    Image.SCALE_SMOOTH
            );
            player_2Headline.setIcon(new ImageIcon(player_2HeadlineUrl));
        }
        add(player_2Headline);


//        *     REPLAY BUTTON

        JLabel replay = new JLabel();
        {
            replay.setBounds(
                    0,
                    (infoPanelBounds[3]) - (infoPanelBounds[3] >> 4) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5)
            );
            replay.setOpaque(false);
            replay.setVisible(true);
            Image replayUrl = new ImageIcon("src\\main\\resources\\infoPanel\\replay.png").getImage().getScaledInstance(
                    (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5),
                    Image.SCALE_SMOOTH);
            replay.setIcon(new ImageIcon(replayUrl));

            replay.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

                    //  TODO    DOPISAC AKCJE DO PRZYCISKU RESTART
                }
            });
        }
        add(replay);

//       *      QUIT BUTTON

        JLabel rageQuit = new JLabel();
        {
            rageQuit.setBounds(
                    (infoPanelBounds[3] >> 2) + (infoPanelBounds[3] >> 4),
                    (infoPanelBounds[3]) - (infoPanelBounds[3] >> 4) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5)
            );
            rageQuit.setOpaque(false);
            rageQuit.setVisible(true);
            Image quitUrl = new ImageIcon("src\\main\\resources\\infoPanel\\quit.png").getImage().getScaledInstance(
                    (infoPanelBounds[3] >> 2) - (infoPanelBounds[3] >> 5),
                    (infoPanelBounds[3] >> 3) - (infoPanelBounds[3] >> 5),
                    Image.SCALE_SMOOTH);
            rageQuit.setIcon(new ImageIcon(quitUrl));

            rageQuit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
        }
        add(rageQuit);


    }


}
