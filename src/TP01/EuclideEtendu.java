package TP01;

import java.math.BigInteger;
import java.util.Scanner;

public class EuclideEtendu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a : ");
        String a = scanner.nextLine().trim();
        System.out.print("b : ");
        String b = scanner.nextLine().trim();

        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);

        /*
        BigInteger[] R = TP01.BigIntMAth.euclideEtendu(A,B);

        for (BigInteger r:R) {
            System.out.println(r.toString());
        }
        */

        BigInteger invMode = BigIntMAth.InverseMode(A,B);

        System.out.println(invMode);

    }
}
