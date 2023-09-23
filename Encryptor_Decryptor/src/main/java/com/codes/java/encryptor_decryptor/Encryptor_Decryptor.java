package com.codes.java.encryptor_decryptor;

import java.util.Scanner;

public class Encryptor_Decryptor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String Choice = Operations.ChoiceOfOperation();
            if (Choice.equalsIgnoreCase("Encrypt")) {
                Encoder.Encode();
            } else if (Choice.equalsIgnoreCase("Decrypt")) {
                Decoder.Decode();
            }
            String Option;
            while (true) {
                System.out.println("");
                System.out.println("Do you want to perform another operation?");
                Option = sc.nextLine();
                if (Option.equalsIgnoreCase("Yes") || Option.equalsIgnoreCase("No")) {
                    break;
                } else {
                    System.out.println("");
                    System.out.println("Please answer (Yes / No) only.");
                }
            }
            if (Option.equalsIgnoreCase("Yes")) {
                continue;
            }
            break;
        }
    }

}
