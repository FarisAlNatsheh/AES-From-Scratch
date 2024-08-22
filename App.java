

// package com.gju.computersec;

// import com.gju.computersec.aes.Round;
// import com.gju.computersec.aes.Runner;
// import com.gju.computersec.aes.Decryptor;
// import com.gju.computersec.aes.DecryptorRunner;
// import com.gju.computersec.b64.Base64Encoder;
// import com.gju.computersec.aes.KeyExpander;

// import java.nio.charset.StandardCharsets;


// // // public class App {
// // //     public static void main(String[] args) throws IOException {
// // //         String filePath = "fruits.png";
// // //         String test = "test";

// // //         byte[][] hardcodedArray = {
// // //             { 1, 2, 3, 4 },
// // //             { 5, 6, 7, 8 },
// // //             { 9, 10, 11, 12 },
// // //             { 13, 14, 15, 16 }
// // //         };

// // //         String key = "ThisIsA16ByteKey";
// // //         String message = "This is a test message";

// // //         // Instantiate the Round class with a key
// // //         Round round = new Round(key);
// // //         //Round round = new Round("ThisIsA16ByteKey"); // Create an instance of the Round class
// // //         //byte[] ciphertext = round.encrypt(plaintext); // Call the encrypt method on the instance

// // //         // Encrypt the message
// // //         byte[] encryptedMessage = round.Round(message.getBytes());

// // //         // Decrypt the message
// // //         byte[] decryptedMessage = round.decrypt(encryptedMessage);

// // //         // Print the decrypted message
// // //         System.out.println("Decrypted message: " + new String(decryptedMessage));
// // //     }
// // // }

// // // import java.nio.charset.StandardCharsets;
// // // import java.util.Base64;

// // // public class App {
// // //     public static void main(String[] args) {
// // //         String key = "ThisIsA16ByteKey";
// // //         String encryptedTextBase64 = "AES16ByteMessage";

// // //         Round round = new Round(key);

// // //         // Decode the encrypted text from Base64
// // //         byte[] encryptedText = Base64.getDecoder().decode(encryptedTextBase64);

// // //         // Decrypt the text
// // //         byte[] decryptedText = round.decrypt(encryptedText);

// // //         // Convert the decrypted text to a string
// // //         String decryptedTextStr = new String(decryptedText, StandardCharsets.UTF_8);

// // //         System.out.println("Decrypted text: " + decryptedTextStr);
// // //     }
// // // }
// // // above has a index out of bound error idk why

// // // import java.nio.charset.StandardCharsets;
// // // import java.util.Base64;

// // // public class App {
// // //     public static void main(String[] args) {
// // //         String key = "ThisIsA16ByteKey";
// // //         String message = "AES16ByteMessage";

// // //         Round round = new Round(key);

// // //         // Encrypt the message
// // //         byte[] plaintext = message.getBytes(StandardCharsets.UTF_8);
// // //         byte[] ciphertext = encrypt(plaintext, round);

// // //         // Encode the ciphertext to Base64
// // //         String ciphertextBase64 = Base64.getEncoder().encodeToString(ciphertext);

// // //         System.out.println("Ciphertext (Base64): " + ciphertextBase64);

// // //         // Decrypt the ciphertext
// // //         byte[] decryptedText = round.decrypt(ciphertext);

// // //         // Convert the decrypted text to a string
// // //         String decryptedTextStr = new String(decryptedText, StandardCharsets.UTF_8);

// // //         System.out.println("Decrypted text: " + decryptedTextStr);
// // //     }

// // //     private static byte[] encrypt(byte[] plaintext, Round round) {
// // //         // Initialize the state matrix
// // //         byte[][] state = new byte[4][4];
// // //         for (int i = 0; i < 16; i++) {
// // //             state[i / 4][i % 4] = plaintext[i];
// // //         }

// // //         // Add round key 0
// // //         state = round.addRoundKey(state, 0);

// // //         // Perform 10 rounds of encryption
// // //         for (int i = 0; i < 10; i++) {
// // //             state = round.subBytes(state);
// // //             state = round.shiftRows(state);
// // //             state = round.mixColumns(state);
// // //             state = round.addRoundKey(state, i + 1);
// // //         }

// // //         // Convert the state matrix to a byte array
// // //         byte[] ciphertext = new byte[16];
// // //         for (int i = 0; i < 16; i++) {
// // //             ciphertext[i] = state[i / 4][i % 4];
// // //         }

// // //         return ciphertext;
// // //     }
// // // }

// // import java.io.IOException;

// // public class App
// // {
// //     public static void main( String[] args ) throws IOException {
// //         String filePath = "fruits.png";
// //         //String encodedFile = Base64Encoder.encodeToB64(filePath);
// //         String test = "test";

// //         byte[][] hardcodedArray = {
// //                 { 1, 2, 3, 4 },
// //                 { 5, 6, 7, 8 },
// //                 { 9, 10, 11, 12 },
// //                 { 13, 14, 15, 16 }
// //         };

// //         String key = "ThisIsA16ByteKey";
// //         String plaintext = "ThisIsA16ByteKey";

// //         // Encryption
// //         Runner runner = new Runner();
// //         byte[] encrypted = runner.runAlgorithm(key, plaintext);

// //         // Decryption
// //         DecryptorRunner decryptorRunner = new DecryptorRunner();
// //         String decrypted = decryptorRunner.runAlgorithm(key, new String(encrypted));

// //         System.out.println("Plaintext: " + plaintext);
// //         System.out.println("Encrypted: " + new String(encrypted));
// //         System.out.println("Decrypted: " + decrypted);
// //     }
// // }
// // package com.gju.computersec;

// // import com.gju.computersec.aes.Runner;
// // import com.gju.computersec.aes.DecryptorRunner;

// // import java.io.IOException;

// // public class App {
// //     public static void main(String[] args) throws IOException {
// //         String key = "ThisIsA16ByteKey";
// //         String plaintext = "ThisIsA16ByteKey";

// //         // Encryption
// //         Runner runner = new Runner();
// //         byte[] encrypted = runner.runAlgorithm(key, plaintext);
// //         //byte[] encrypted = runner.runAlgorithm(key, plaintext);


// //         // Decryption
// //         byte[] decryptedBytes = decryptorRunner.decrypt(key, encrypted);
// //         String decrypted = new String(decryptedBytes);
// //         //DecryptorRunner decryptorRunner = new DecryptorRunner();
// //         //String decrypted = decryptorRunner.runAlgorithm(key, new String(encrypted));

// //         System.out.println("Plaintext: " + plaintext);
// //         System.out.println("Encrypted: " + new String(encrypted));
// //         System.out.println("Decrypted: " + decrypted);
// //     }
// // }


// import java.io.IOException;

// // public class App {
// //     public static void main(String[] args) throws IOException {
// //         String key = "ThisIsA16ByteKey";
// //         String plaintext = "ThisIsA16ByteKey";

// //         // Encryption
// //         Runner runner = new Runner();
// //         byte[] encrypted = runner.runAlgorithm(key, plaintext);  // Ensure this method returns byte[]

// //         // Decryption
// //         // Initialize DecryptorRunner
// //         DecryptorRunner decryptorRunner = new DecryptorRunner();  // Ensure this constructor is correct
// //         byte[] decryptedBytes = decryptorRunner.decrypt(key, encrypted);
// //         String decrypted = new String(decryptedBytes);

// //         System.out.println("Plaintext: " + plaintext);
// //         System.out.println("Encrypted: " + new String(encrypted));
// //         System.out.println("Decrypted: " + decrypted);
// //     }
// // }
// // public class App {
// //     public static void main(String[] args) throws IOException {
// //         String key = "ThisIsA16ByteKey";
// //         String plaintext = "ThisIsA16ByteKey";

// //         // Encryption
// //         Runner runner = new Runner();
// //         byte[] encrypted = runner.runAlgorithm(key, plaintext);

// //         // Key Expansion
// //         KeyExpander keyExpander = new KeyExpander();
// //         byte[][][] roundKeys = keyExpander.expandKey(key.getBytes(StandardCharsets.UTF_8));

// //         // Decryption
// //         DecryptorRunner decryptorRunner = new DecryptorRunner(roundKeys);
// //         byte[] decryptedBytes = decryptorRunner.decrypt(encrypted);
// //         String decrypted = new String(decryptedBytes);

// //         System.out.println("Plaintext: " + plaintext);
// //         System.out.println("Encrypted: " + new String(encrypted));
// //         System.out.println("Decrypted: " + decrypted);
// //     }
// // }

// public class App {
//     public static void main(String[] args) throws IOException {
//         String key = "ThisIsA16ByteKey";
//         String plaintext = "ThisIsA16ByteKey";

//         // Encryption
//         Runner runner = new Runner();
//         byte[] encrypted = runner.runAlgorithm(key, plaintext);

//         // Key Expansion
//         KeyExpander keyExpander = new KeyExpander();
//         byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

//         // Get expanded key
//         byte[][][] roundKeys = keyExpander.keyExpansion(keyBytes);

//         // Decryption
//         DecryptorRunner decryptorRunner = new DecryptorRunner(roundKeys);
//         byte[] decryptedBytes = decryptorRunner.decrypt(encrypted);

//         String decrypted = new String(decryptedBytes, StandardCharsets.UTF_8);

//         System.out.println("Plaintext: " + plaintext);
//         System.out.println("Encrypted: " + Arrays.toString(encrypted));
//         System.out.println("Decrypted: " + decrypted);
//     }
// }
package com.gju.computersec;


import com.gju.computersec.aes.Round;
import com.gju.computersec.aes.Runner;
import com.gju.computersec.b64.Base64Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Base64;


public class App
{
    private static final String KEY = "ThisIsA16ByteKey";

    public static void main( String[] args ) throws IOException {

        String filePath = "fruits.png";
        //String encodedFile = Base64Encoder.encodeToB64(filePath);
        String test = "test";

        byte[][] hardcodedArray = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
//         new Runner().runAlgorithm("ThisIsA16ByteKey","ThisIsA16ByteKey");
//     }
// }
        Runner runner = new Runner();
        runner.runAlgorithm(KEY, KEY);
        
        // Sample encryption and decryption usage
        String originalText = "AES16ByteMessage";
        String encryptedText = encrypt(originalText, KEY);
        String decryptedText = decrypt(encryptedText, KEY);
        
        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
    
    // Method to encrypt a string
    public static String encrypt(String plainText, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Method to decrypt a string
    public static String decrypt(String encryptedText, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}