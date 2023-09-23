package com.codes.java.encryptor_decryptor;

import java.util.Scanner;

class Operations extends Encryptor_Decryptor {

    public static String ChoiceOfOperation() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("Enter the operation you want to perform (Encrypt / Decrypt).");
            String Choice = sc.nextLine();
            if (Choice.equalsIgnoreCase("Encrypt") || Choice.equalsIgnoreCase("Decrypt")) {
                return Choice;
            } else {
                System.out.println("");
                System.out.println("Please enter (Encrypt / Decrypt) only.");
            }
        }
    }

}
