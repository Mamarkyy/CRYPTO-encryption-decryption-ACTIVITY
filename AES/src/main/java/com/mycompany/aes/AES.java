/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aes;
import java.util.Scanner;

/**
 *
 * @author User
 */

public class AES {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = scan.nextLine();

        System.out.print("Enter Caesar Cipher Key: ");
        int caesarShift = scan.nextInt();
        
        System.out.println("*****************************************");
        String encryptedCaesarMessage = encryptMonoalpabetic(message, caesarShift);
        System.out.println("Monoalpabetic Encrypted Message: " + encryptedCaesarMessage);

        String decryptedCaesarMessage = decryptMonoalpabetic(encryptedCaesarMessage, caesarShift);
        System.out.println("Monoalpabetic Decrypted Message: " + decryptedCaesarMessage);

        scan.nextLine(); // Consume newline character

        System.out.println("*****************************************");
        System.out.print("Enter Vigener Cipher Key: ");
        String vigenerKey = scan.nextLine();
        
        String encryptedVigenereMessage = encryptVigenere(message, vigenerKey);
        System.out.println("Vigener Encrypted Message: " + encryptedVigenereMessage);

        String decryptedVigenereMessage = decryptVigener(encryptedVigenereMessage, vigenerKey);
        System.out.println("Vigener Decrypted Message: " + decryptedVigenereMessage);
    }
//ADDITIVE
    public static String encryptMonoalpabetic(String message, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();
        message = message.toLowerCase();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (Character.isLetter(c)) {
                c = (char) ((c - 'a' + shift + 26) % 26 + 'a');
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }

    public static String decryptMonoalpabetic(String message, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();
        message = message.toLowerCase();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (Character.isLetter(c)) {
                c = (char) ((c - 'a' - shift + 26) % 26 + 'a');
            }
            decryptedMessage.append(c);
        }
        return decryptedMessage.toString();
    }
//VEGENERE
    public static String encryptVigenere(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
        message = message.toLowerCase();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (Character.isLetter(c)) {
                int shift = key.charAt(j % key.length()) - 'a';
                c = (char) ((c - 'a' + shift + 26) % 26 + 'a');
                j++;
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }

    public static String decryptVigener(String message, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
        message = message.toLowerCase();
        key = key.toLowerCase();

        for (int i = 0, j = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (Character.isLetter(c)) {
                int shift = key.charAt(j % key.length()) - 'a';
                c = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                j++;
            }
            decryptedMessage.append(c);
        }
        return decryptedMessage.toString();
    }
}


