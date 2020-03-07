package streamEncryptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RC4 {

    private static byte[] s;
    private static int i, j;

    private static void initialization(byte[] key, int keyLength) {

        s = new byte[keyLength];

        for (int i = 0; i < keyLength; i++) {
            s[i] = (byte) i;
        }

        int j = 0;
        for (int i = 0; i < keyLength; i++) {
            j = (j + (s[i] & 0xFF) + key[i % key.length]) % keyLength;

            byte t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    private static byte byteStream(int keyLength) {
        i = (i + 1) % keyLength;
        j = (j + (s[i] & 0xFF)) % keyLength;

        byte t = s[i];
        s[i] = s[j];
        s[j] = t;

        return s[((s[i] & 0xFF) + (s[j] & 0xFF)) % keyLength];
    }

    static byte[] keyStream(byte[] key, int size, String choice) {
        int keyLength = 256;

        if(choice.equals("16"))
            keyLength = 128;

        byte[] keyStemTable = new byte[size];

        initialization(key,keyLength);

        for (int k = 0; k < size; k++) {
            keyStemTable[k] = byteStream(keyLength);
        }

        return keyStemTable;

    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        //here put the user key and size
        System.out.print("The key : ");
        byte[] key = scanner.nextLine().trim().getBytes();

        System.out.print("The text : ");
        byte[] text = scanner.nextLine().trim().getBytes();

        String choix = "";
        while (!choix.equals("32") && !choix.equals("16") ) {
            System.out.print("The key length [16/32]: ");
            choix = scanner.nextLine().trim();
        }


        int size = text.length;
        byte[] c = new byte[size];
        byte[] d = new byte[size];


        // this is the generated key for the encryption and decryption
        byte[] keyStream = keyStream(key,size, choix);

        System.out.println("KeyStream : " + Arrays.toString(keyStream));


        System.out.println("Encrypted message : ");
        for (int k = 0; k < size; k++) {
            c[k] = (byte) (keyStream[k] ^ text[k]) ;
        }

        System.out.println(Arrays.toString(c));


        for (int k = 0; k < size; k++) {
            d[k] = (byte) (keyStream[k] ^ c[k]) ;
        }

        System.out.println("Decrypted message : " + new String(d));

    }
}
