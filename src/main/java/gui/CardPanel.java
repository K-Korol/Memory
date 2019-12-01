package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import static mechanics.CardLists.cardsList;

import mechanics.Comparison;
import mechanics.type.Card;
import mechanics.type.ComparisonStatus;
import gui.InfoPanel.*;

import static mechanics.type.Music.playMusicAction;

public class CardPanel extends JPanel {

    String fileAddress = "src\\main\\resources\\cardCover.png";
    CardGraphicsLists cardGraphicsLists = new CardGraphicsLists();
    private int clickCounter = 0;
    Comparison comparison = new Comparison();

    int[] cardPanelBounds = {BackgroundPanel.tile >> 5,
            BackgroundPanel.tile >> 5,
            (BackgroundPanel.tile_x >> 1) + (BackgroundPanel.tile_x >> 3),
            BackgroundPanel.tile_y - (BackgroundPanel.tile >> 4)};

    int[] cardPanelGridDimensions = {7, 8};

    int[] cardPanelGridSizes = {
            cardPanelBounds[2] / cardPanelGridDimensions[0],
            cardPanelBounds[3] / cardPanelGridDimensions[1]};
    int cardSize;

    {
        int cache = Integer.min(cardPanelGridSizes[0], cardPanelGridSizes[0]);
        cardSize = cache - (cache >> 2);
    }   //  * cardSize definition

    public CardPanel() {
        super();

        setLayout(new GridLayout(
                cardPanelGridDimensions[0],
                cardPanelGridDimensions[1]));

        setBounds(
                cardPanelBounds[0],
                cardPanelBounds[1],
                cardPanelBounds[2],
                cardPanelBounds[3]);

        setOpaque(false);

        Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance(
                cardSize,
                cardSize,
                Image.SCALE_SMOOTH);

        /*for (int i = 0; i < 56; i++) {
            JButton button = new JButton();
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);

            Image sheet = new ImageIcon(fileAddress).getImage().getScaledInstance(
                    cardSize,
                    cardSize,
                    Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(sheet));
            add(button);
        }*/

        try {

            for (int i = 0; i < 28 ; i++) {
                cardsList.add(new Card(cardGraphicsLists.getFrontImagesList().get(i).getScaledInstance(
                        cardSize,
                        cardSize,
                        Image.SCALE_SMOOTH)));
               // cardsList.get(i).setCardId(cardId);
               // cardId = cardId+1;
               // cardsList.add(cardsList.get(i).clone());

            }

            for (int i = 0; i < 28; i++) {
                cardsList.add(cardsList.get(i).clone());
            }

            Collections.shuffle(cardsList);

           /* textField1.setBounds(xLocationOfCard+1300,yLocationOfCard+100,300,100);
            textField2.setBounds(xLocationOfCard+1300,yLocationOfCard+400,300,100);*/


            for (int i = 0; i < cardsList.size() ; i++) {
                final int i_final = i;
                cardsList.get(i).setjButton(new JButton());
                cardsList.get(i).getjButton().setOpaque(false);
                cardsList.get(i).getjButton().setContentAreaFilled(false);
                cardsList.get(i).getjButton().setBorderPainted(false);
                cardsList.get(i).setBack(sheet);
                cardsList.get(i).getjButton().setIcon(new ImageIcon(cardsList.get(i).getBack()));
                cardsList.get(i).getjButton().addActionListener(e -> {
                    clickCounter = clickCounter+1;
                    if (clickCounter<3) {
                       playMusicAction("src\\main\\resources\\SFX\\flipCard2.wav");
                        cardsList.get(i_final).getjButton().setIcon(new ImageIcon(cardsList.get(i_final).getFront()));
                        cardsComparison(cardsList.get(i_final));
                    }
                   // System.out.println(clickCounter);
                });


            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();

        }
        for (int i = 0; i < 56 ; i++) {
            add(cardsList.get(i).getjButton());
        }


    }

    public void cardsComparison (Card card){
        comparison.compare(card);
        if (comparison.getComparisonStatus()==ComparisonStatus.WAIT)
            clickCounter =1;

        if (comparison.getComparisonStatus()==ComparisonStatus.TRUE){
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getjButton().setVisible(false);
                            comparison.getCard2().getjButton().setVisible(false);
                            clickCounter=0;
                        }
                    },
                    1000
            );

           // players[turnChange.getCurrentPlayer()].addPoint();

        } else if (comparison.getComparisonStatus()==ComparisonStatus.FALSE){

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            comparison.getCard1().getjButton().setIcon(new ImageIcon(card.getBack()));
                            comparison.getCard2().getjButton().setIcon(new ImageIcon(card.getBack()));
                            clickCounter=0;
                        }
                    },
                    1000
            );

        }
       // turnChange.changePlayer(comparison.getComparisonStatus());

    }
}
