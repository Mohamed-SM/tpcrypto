package TP01;

import java.util.Scanner;

public class Cisar2 {
    public static void main(String[] args) {

        char[] message = lireMessage();
        char cle = lirCle();

        char[] messageCrypte = crypte(message, cle);

        System.out.println(new String(messageCrypte));

    }

    private static char[] lireMessage() {
        System.out.print("Votre message : ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        return message.trim().toUpperCase().toCharArray();
    }

    private static char lirCle() {
        System.out.print("Votre cle : ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();
        return message.trim().toUpperCase().toCharArray()[0];
    }

    private static char[] crypte(char[] message, char cle) {
        char[] messageCrypte = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            messageCrypte[i] = substitute(message[i], cle);
        }
        return messageCrypte;
    }

    private static char substitute(char m, char cle) {
        int intCle = cle - 'A'; // cle - 65 bach yarje3 men 0 lel 26
        int intM = m - 'A'; // m - 65 bach yarje3 men 0 lel 26
        int c = (intM + intCle) % 26; // crypteage ta3 message
        return (char) (c + 'A'); // c + 56 - 65 bach yarje3 men men 65 lel 90
        /*
        * psq assci hada howa
        * 65 A * 66 B * 67 C * 68 D
        * 69 E * 70 F * 71 G * 72 H
        * 73 I * 74 J * 75 K * 76 L
        * 77 M * 78 N * 79 O * 80 P
        * 81 Q * 82 R * 83 S * 84 T
        * 85 U * 86 V * 87 W * 88 X
        * 89 Y * 90 Z
        *
        */
    }

}
