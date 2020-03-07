package TP01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Polybe {

    private static char[][] TABLE_POLYBE = {
            {'A', 'B', 'C', 'D', 'E',},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}};



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String clearMessage = scanner.nextLine();
        clearMessage = clearMessage.trim().toUpperCase();
        char[] clearMessageChar = clearMessage.toCharArray();

        for (int i = 0; i < clearMessageChar.length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (TABLE_POLYBE[j][k] == clearMessageChar[i]){
                        System.out.println("(" + (j + 1) + "," + (k + 1) + ")");
                        break;
                    }
                }
            }
        }

    }
}
