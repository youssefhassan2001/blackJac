/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javax.print.DocFlavor;

/**
 *
 * @author xtreme
 */
public class Player {

    String Name;
    int Score;
    Card c[] = new Card[11];

    public Player(String Name) {
        this.Name = Name;
    }

    public Player(String Name, int Score) {
        this.Name = Name;
        this.Score = Score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public Card[] getC() {
        return c;
    }

    public void setC(Card[] c) {
        this.c = c;
    }

}
