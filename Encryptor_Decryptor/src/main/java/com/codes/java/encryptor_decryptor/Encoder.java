package com.codes.java.encryptor_decryptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

class Encoder extends Operations {

    public static void Encode() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Enter the path of the file you want to encrypt.");
            System.out.println("[Example: C:\\Users\\Admin\\Documents\\File.txt]");
            String FilePath = sc.nextLine();
            String File = "";
            for (int i = FilePath.length() - 1; FilePath.charAt(i) != '\\'; i--) {
                File = FilePath.charAt(i) + File;
            }
            String Path = FilePath.replace(File, "");
            File DecodedFile = new File(FilePath);
            try {
                Scanner DF = new Scanner(DecodedFile);
                ArrayList<char[]> FileContents = new ArrayList<>();
                while (DF.hasNextLine()) {
                    FileContents.add(DF.nextLine().toCharArray());                    
                }
                DF.close();
                System.out.println("");
                System.out.println("Enter the key (A string you want to use to encrypt.)");
                String Key = sc.nextLine();
                for (char[] c : FileContents) {
                    for (int i = 0; i < c.length; i++) {
                        int j = i % Key.length();
                        int m = (int) c[i];
                        int n = (int) Key.charAt(j);
                        int k = m + n - 64;
                        int NewVal = (k % 95) + 32;
                        c[i] = Character.toString((char) NewVal).charAt(0);
                    }
                }
                String KeyPath = Path + "Key.txt";
                Formatter EncodedFile = new Formatter(FilePath);
                for (char[] charArr : FileContents) {
                    EncodedFile.format("%s", String.valueOf(charArr) + "\r\n");
                }
                EncodedFile.close();
                Formatter KeyFile = new Formatter(KeyPath);
                KeyFile.format("%s", Key);
                KeyFile.close();
                System.out.println("");
                System.out.println("Encrypting has been done successfully and the encrypted file has been saved in the same folder.");
                break;
            } catch (FileNotFoundException ex) {
                System.out.println("");
                System.out.println("Please recheck the given path.");
            }
        }
    }

}
