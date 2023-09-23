package com.codes.java.encryptor_decryptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

class Decoder extends Operations {

    public static void Decode() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Enter the path of the file you want to decrypt.");
            System.out.println("[Example: C:\\Users\\Admin\\Documents\\File.txt]");
            String FilePath = sc.nextLine();
            File EncodedFile = new File(FilePath);
            System.out.println("");
            System.out.println("Enter the path of the key you used to encrypt the file. (Usually located within the same folder.)");
            System.out.println("[Example: C:\\Users\\Admin\\Documents\\Key.txt]");
            String KeyPath = sc.nextLine();
            File KeyFile = new File(KeyPath);
            try {
                Scanner EF = new Scanner(EncodedFile);
                ArrayList<char[]> FileContents = new ArrayList<>();
                while (EF.hasNextLine()) {
                    FileContents.add(EF.nextLine().toCharArray());
                }
                EF.close();
                Scanner KF = new Scanner(KeyFile);
                String Key = KF.nextLine();
                KF.close();
                for (char[] c : FileContents) {
                    for (int i = 0; i < c.length; i++) {
                        int j = i % Key.length();
                        int m = (int) c[i];
                        int n = (int) Key.charAt(j);
                        int k = m - n;
                        if (k < 0) {
                            k = k + 95;
                        }
                        int OldVal = k + 32;
                        c[i] = Character.toString((char) OldVal).charAt(0);
                    }
                }
                Formatter DecodedFile = new Formatter(FilePath);
                for (char[] charArr : FileContents) {
                    DecodedFile.format("%s", String.valueOf(charArr) + "\r\n");
                }
                DecodedFile.close();
                System.out.println("");
                System.out.println("Decrypting has been done successfully and the decrypted file has been saved in the same folder.");
                break;
            } catch (FileNotFoundException ex) {
                System.out.println("");
                System.out.println("Please recheck the given path.");
            }
        }
    }

}
