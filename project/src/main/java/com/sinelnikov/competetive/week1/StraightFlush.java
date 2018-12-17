package com.sinelnikov.competetive.week1;

import java.io.PrintWriter;
import java.util.*;

public class StraightFlush {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String[] cards = new String[5];
        for (int i = 0; i < 5; i++) {
            cards[i] = in.next();
        }
        out.println(isStraightFlush(cards) ? "YES" : "NO");
        in.close();
        out.close();
    }

    private static Map<Character, Integer> aceHighMapping;
    private static Map<Character, Integer> aceLowMapping;
    private static Set<Character> validSuites;
    static {
        aceHighMapping = new HashMap<>();
        aceHighMapping.put('2', 2);
        aceHighMapping.put('3', 3);
        aceHighMapping.put('4', 4);
        aceHighMapping.put('5', 5);
        aceHighMapping.put('6', 6);
        aceHighMapping.put('7', 7);
        aceHighMapping.put('8', 8);
        aceHighMapping.put('9', 9);
        aceHighMapping.put('T', 10);
        aceHighMapping.put('J', 11);
        aceHighMapping.put('Q', 12);
        aceHighMapping.put('K', 13);
        aceHighMapping.put('A', 14);
        aceLowMapping = new HashMap<>(aceHighMapping);
        aceLowMapping.put('A', 1);
        validSuites = new HashSet<>();
        validSuites.add('C');
        validSuites.add('D');
        validSuites.add('H');
        validSuites.add('S');
    }


    private static boolean isStraightFlush(String[] cards, Map<Character, Integer> mapping) {
        if (cards.length != 5) {
            return false;
        }
        int min = 100;
        Character validSuit = cards[0].charAt(1);
        for (String card: cards) {
            if (card.length() != 2) {
                return false;
            }
            Integer value = mapping.get(card.charAt(0));
            if (value == null) {
                return false;
            }
            Character suit = card.charAt(1);
            if (!validSuites.contains(suit) || !validSuit.equals(suit)) { // invalid or not equal
                return false;
            }
            min = Math.min(min, value);
        }
        for (int i = 1; i < 5; i++) {
            int valueToSearch = min + i;
            boolean found = false;
            for (String card: cards) {
                int value = mapping.get(card.charAt(0));
                if (value == valueToSearch) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStraightFlush(String[] cards) {


        return isStraightFlush(cards, aceHighMapping) || isStraightFlush(cards, aceLowMapping);
    }
}
