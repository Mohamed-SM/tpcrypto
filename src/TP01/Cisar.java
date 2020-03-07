package TP01;

import java.util.Scanner;

public class Cisar {
    public static char[] ALPHA = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("message : ");
        char[] message = scanner.nextLine().trim().toUpperCase().toCharArray();
        System.out.print("Cle : ");
        int cle = scanner.nextLine().trim().toUpperCase().toCharArray()[0] - 65;

        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < ALPHA.length; j++) {
                if(message[i] == ' '){
                    System.out.print(' ');
                    break;
                }
                else if(message[i] == ALPHA[j]) {
                    char c = (char)(((int)message[i] - 65 + cle) % 26 + 65) ;
                    System.out.print(c);
                    break;
                }
            }
        }

    }
}
