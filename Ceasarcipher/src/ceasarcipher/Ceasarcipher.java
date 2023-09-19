
package ceasarcipher;

import java.util.Scanner;
//AUTO KEY CIPHER
public class Ceasarcipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine().toUpperCase(); // Convert to uppercase for simplicity
        System.out.print("Enter the key: ");
        String key = scanner.nextLine().toUpperCase();

        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        plaintext = plaintext.replaceAll("\\s+", ""); // Remove spaces from plaintext

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i % key.length()); // Repeat key if it's shorter than plaintext
            char encryptedChar = (char) (((plainChar - 'A') + (keyChar - 'A')) % 26 + 'A');
            ciphertext.append(encryptedChar);
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char encryptedChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i % key.length()); // Repeat key if it's shorter than ciphertext
            char decryptedChar = (char) (((encryptedChar - 'A') - (keyChar - 'A') + 26) % 26 + 'A');
            plaintext.append(decryptedChar);
        }

        return plaintext.toString();
    }
}


