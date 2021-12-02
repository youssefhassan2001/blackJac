/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import static java.util.Random.*;

/**
 *
 * @author xtreme
 */
public class Game {

    Player[] player = new Player[4];
    int numofcard = 52;
    Card[] card = new Card[numofcard];
    Card[] totalCards = new Card[52];
    int VALID;
    int n = 52;

    void generate() {
        int s[] = new int[4];
        int r[] = new int[13];
        int v[] = new int[13];
        int k = 0;
        int index = 0;
        while (k < 4) {
            for (int i = 0; i < 13; i++) {
                switch (i) {
                    case 0:
                        s[k] = k;
                        r[0] = 0;
                        v[i] = 1;
                        break;
                    case 1:
                        s[k] = k;
                        r[1] = 1;
                        v[i] = 2;
                        break;
                    case 2:
                        s[k] = k;
                        r[2] = 2;
                        v[i] = 3;
                        break;
                    case 3:
                        s[k] = k;
                        r[3] = 3;
                        v[i] = 4;
                        break;
                    case 4:
                        s[k] = k;
                        r[4] = 4;
                        v[i] = 5;
                        break;
                    case 5:
                        s[k] = k;
                        r[5] = 5;
                        v[i] = 6;
                        break;
                    case 6:
                        s[k] = k;
                        r[6] = 6;
                        v[i] = 7;
                        break;
                    case 7:
                        s[k] = k;
                        r[7] = 7;
                        v[i] = 8;
                        break;
                    case 8:
                        s[k] = k;
                        r[8] = 8;
                        v[i] = 9;
                        break;
                    case 9:
                        s[k] = k;
                        r[9] = 9;
                        v[i] = 10;
                        break;
                    case 10:
                        s[k] = k;
                        r[10] = 10;
                        v[i] = 10;
                        break;
                    case 11:
                        s[k] = k;
                        r[11] = 11;
                        v[i] = 10;
                        break;
                    case 12:
                        s[k] = k;
                        r[12] = 12;
                        v[i] = 10;
                        break;
                }
                Card crd = new Card(s[k], r[i], v[i]);
                card[index] = crd;
                index++;
            }
            k++;
        }

    }

    Card randomCard() {
        int z = card.length;
        Card crdChois = null;
        Random r = new Random();
        int randomChoise = r.nextInt(z);
        if (card[randomChoise].equals(null)) {
            randomCard();
        }
        crdChois = new Card(card[randomChoise].getSuit(), card[randomChoise].getRank(), card[randomChoise].getValue());
        card[randomChoise].equals(null);
        return crdChois;
    }
//     void delete(int i){
//        Card[] nnew=new Card[numofcard-1];
//       for (int j = 0, k = 0; j < card.length; j++) {
//            if (j == i) {
//                continue;
//            }
//            nnew[k++] = card[j];
//        }
//        card=nnew;
//        totalCards=card;
//         try {
//              for (int k =0 ; k < numofcard; k++) {
//             totalCards[k]=card[k];
//         }
//         for (int j = numofcard; j < 51; j++) {
//             totalCards[j]=null;
//         }
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
////        
//        
//         //System.out.println(numofcard);
//    }

    void push() {
        boolean push=false;
        int a = 0;
        for (int i = 0; i != a; i++) {
            if (player[a].getScore() == player[i].getScore()) {
                push=true;
                break;
            }
            a++;
            if (a==4){
            break;
            }
        }
        if (push==true) {
            System.out.println("push!");
        }
        else{
        win();
        }
    }

    void setname(String n1) {

        int index = 0;
        int score = 0;
        Player player1 = new Player(n1);
        for (int i = 0; i < 2; i++) {
            player1.c[i] = randomCard();
            score = score + player1.c[i].getValue();
        }
        player1.setName(n1);
        player1.setScore(score);
        while (index < 4) {
            if (null == player[index]) {
                player[index] = player1;
                break;
            } else {
                index++;
            }
        }
        System.out.println();

    }

    void hit(int i, int ind) {
        int score = player[i].getScore();
        System.out.println(score);
        player[i].c[ind] = randomCard();
        score = score + player[i].c[ind].getValue();
        player[i].setScore(score);
        System.out.println(player[i].getScore());
    }

    void win() {
        int index =0;
        for (int i = 0; i < 4; i++) {
            if (player[i].getScore() > VALID && player[i].getScore() <= 21) {
                VALID = player[i].getScore();
                index = i;
            }
        }
        System.out.println("the maximum score is " + VALID + " and the winner is " + player[index].getName());
    }
}
