package streamEncryptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RC4Run {
    public static void main(String[] args) throws IOException {

        System.out.print("Enter the key : ");
        Scanner scanner =  new Scanner(System.in);
        String b = scanner.nextLine();
        byte[] key = b.getBytes();


        System.out.print("Enter the key size : ");
        int size = scanner.nextInt();

        System.out.println("generating the key stream ...");
        byte[] keyStream = RC4.keyStream(key, size, "32");


        System.out.print("Enter the input file name : ");
        FileInputStream in = new FileInputStream(scanner.next().trim());


        System.out.print("Enter the output file name : ");
        FileOutputStream out = new FileOutputStream(scanner.next().trim());

        int fileLength = in.available();

        DecimalFormat decimalFormat = new DecimalFormat("#,#00.00");

        System.out.println("Encryption/Decryption Started");
        String percent = "00.00%";
        System.out.print("treatment  " + percent);
        for (int k = 0; k < fileLength; k++) {
            if(k % 100 == 0){
                percent = decimalFormat.format(k/(double)fileLength*100) + "%";
                for (int i = 0; i < percent.length(); i++) {
                    System.out.print("\b");
                }
                System.out.print(percent);
            }
            out.write((byte) (keyStream[k % size] ^ (byte) in.read()));
        }
        System.out.println("Done!");

        scanner.close();
        in.close();
        out.close();


    }
}
