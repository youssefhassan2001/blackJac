/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author xtreme
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    static Game g = null;
    static Scanner s = null;
    static int n = 2;
    static int i = 0;

    public static void main(String[] args) {

        g = new Game();
        g.generate();
        s = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("player  "+(i+1)+" enter your name ");
            String name = s.next();
            g.setname(name);
        }
        g.setname("dealer");
        GUI gui = new GUI();
        gui.runGUI(g.card, g.player[0].c, g.player[1].c, g.player[2].c, g.player[3].c);

//       g.dis();
        n = 2;
        while (i < 3) {
            System.out.println("are you want to hit or stand  "+g.player[i].getName());
            String c = s.next();
            if (g.player[i].getScore() < 21) {
                if (c.equals("hit") && g.player[i].getScore() < 21) {
                    g.hit(i, n);
                    gui.updatePlayerHand(g.player[i].c[n], i);
                    n++;
                } else if (c.equals("stand") || g.player[i].getScore() >= 21) {
                        i++;
                }
            }else {
                i++;
            }
        }
        if (i == 3) {
            if (g.player[i].getScore() < 21) {
                if (g.player[i].getScore() < 21) {
                    g.hit(i, n);
                    gui.updateDealerHand(g.player[i].c[n], g.card);
                    n++;
                } 
            } 
        }
        g.push();

    }
}
