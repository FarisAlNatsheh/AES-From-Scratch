// // package com.gju.computersec.aes;

// // import java.util.Arrays;

// // public class DecryptorRunner {
// //     Decryptor decryptor;

// //     public void runAlgorithm(String key, String text){
// //         byte[][] keyBytes = stringToBytes16(key);
// //         decryptor = new Decryptor(keyBytes, new byte[4][4]);

// //         byte[][] byteText = stringToBytes16(text);

// //         // Expand the key
// //         KeyExpander keyExpander = new KeyExpander();
// //         byte[] expandedKey = keyExpander.keyExpansion(keyBytes);

// //         // Add round keys in reverse order
// //         for (int i = 10; i >= 0; i--) {
// //             int startIndex = i * 16;
// //             byte[] roundKey = Arrays.copyOfRange(expandedKey, startIndex, startIndex + 16);
// //             byteText = decryptor.addRoundKey(byteText, roundKey);
// //             // Inverse rounds
// //             if (i > 0) {
// //                 byteText = decryptor.invMixColumns(byteText);
// //                 byteText = decryptor.invShiftRows(byteText);
// //                 byteText = decryptor.invSubBytes(byteText);
// //             }
// //         }

// //         String decrypted = new String(flattenArray(byteText));
// //         System.out.println(Arrays.toString(flattenArray(byteText)));
// //         System.out.println(decrypted);
// //     }

// //     private byte[] flattenArray(byte[][] arr){
// //         byte[] flat = new byte[16];
// //         int k = 0;
// //         for(int i =0; i < 4; i++){
// //             for(int j =0; j < 4; j++){
// //                 flat[k] = arr[j][i];
// //                 k++;
// //             }
// //         }
// //         return flat;
// //     }

// //     private byte[][] stringToBytes16(String input) {
// //         byte[][] byteArray = new byte[4][4];

// //         // Convert each character to byte and store in the 4x4 byte array
// //         int index = 0;
// //         for (int i = 0; i < 4; i++) {
// //             for (int j = 0; j < 4; j++) {
// //                 byteArray[j][i] = (byte) input.charAt(index);
// //                 index++;
// //             }
// //         }

// //         return byteArray;
// //     }
// // }
// // // public class DecryptorRunner {
// // //     Decryptor decryptor;

// // //     public void runAlgorithm(String key, String text){
// // //         decryptor = new Decryptor(key);
// // //         byte[][] byteText = stringToBytes16(text);

// // //     //     // Add round keys
// // //     //     byteText = decryptor.addRoundKey(byteText, 10);

// // //     //     // Inverse rounds
// // //     //     for(int i = 9; i >= 1; i--){
// // //     //         byteText = decryptor.invMixColumns(byteText);
// // //     //         byteText = decryptor.invShiftRows(byteText);
// // //     //         byteText = decryptor.invSubBytes(byteText);
// // //     //         byteText = decryptor.addRoundKey(byteText, i);
// // //     //     }

// // //     //     byteText = decryptor.invSubBytes(byteText);
// // //     //     byteText = decryptor.invShiftRows(byteText);

// // //     //     String decrypted = new String(flattenArray(byteText));
// // //     //     System.out.println(Arrays.toString(flattenArray(byteText)));
// // //     //     System.out.println(decrypted);
// // //     // }
// // //     // Expand the key
// // //     KeyExpander keyExpander = new KeyExpander();
// // //     byte[] expandedKey = keyExpander.keyExpansion(key.getBytes());

// // //     // Add round keys in reverse order
// // //     for (int i = 10; i >= 0; i--) {
// // //         int startIndex = i * 16;
// // //         byte[] roundKey = Arrays.copyOfRange(expandedKey, startIndex, startIndex + 16);
// // //         byteText = decryptor.addRoundKey(byteText, roundKey);
// // //         // Inverse rounds
// // //         byteText = decryptor.invMixColumns(byteText);
// // //         byteText = decryptor.invShiftRows(byteText);
// // //         byteText = decryptor.invSubBytes(byteText);
// // //     }

// // //     String decrypted = new String(flattenArray(byteText));
// // //     System.out.println(Arrays.toString(flattenArray(byteText)));
// // //     System.out.println(decrypted);
// // // }

// // //     private byte[] flattenArray(byte[][] arr){
// // //         byte[] flat = new byte[16];
// // //         int k = 0;
// // //         for(int i =0; i < 4; i++){
// // //             for(int j =0; j < 4; j++){
// // //                 flat[k] = arr[i][j];
// // //                 k++;
// // //             }
// // //         }
// // //         return flat;
// // //     }

// // //     private byte[][] stringToBytes16(String input) {
// // //         byte[][] byteArray = new byte[4][4];

// // //         // Convert each character to byte and store in the 4x4 byte array
// // //         int index = 0;
// // //         for (int i = 0; i < 4; i++) {
// // //             for (int j = 0; j < 4; j++) {
// // //                 byteArray[i][j] = (byte) input.charAt(index);
// // //                 index++;
// // //             }
// // //         }

// // //         return byteArray;
// // //     }
// // // }
// // package com.gju.computersec.aes;

// // import java.util.Scanner;

// // public class DecryptorRunner {

// //     public static void main(String[] args) {
// //         Scanner scanner = new Scanner(System.in);

// //         System.out.println("Enter the 16-byte (128-bit) key (in hex):");
// //         String keyHex = scanner.nextLine();
// //         byte[][][] roundKeys = RoundKeyGenerator.generateRoundKeys(hexStringToByteArray(keyHex));

// //         System.out.println("Enter the encrypted message (in hex):");
// //         String encryptedHex = scanner.nextLine();
// //         byte[] encryptedBytes = hexStringToByteArray(encryptedHex);
        
// //         Decryptor decryptor = new Decryptor(roundKeys);
// //         byte[][] decryptedBlock = decryptor.decryptBlock(byteArrayToState(encryptedBytes));

// //         System.out.println("Decrypted message (in hex):");
// //         System.out.println(stateToHexString(decryptedBlock));
// //     }

// //     private static byte[] hexStringToByteArray(String s) {
// //         int len = s.length();
// //         byte[] data = new byte[len / 2];
// //         for (int i = 0; i < len; i += 2) {
// //             data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
// //                                 + Character.digit(s.charAt(i+1), 16));
// //         }
// //         return data;
// //     }

// //     private static byte[][] byteArrayToState(byte[] array) {
// //         byte[][] state = new byte[4][4];
// //         for (int i = 0; i < array.length; i++) {
// //             state[i % 4][i / 4] = array[i];
// //         }
// //         return state;
// //     }

// //     private static String stateToHexString(byte[][] state) {
// //         StringBuilder hexString = new StringBuilder();
// //         for (int i = 0; i < 4; i++) {
// //             for (int j = 0; j < 4; j++) {
// //                 hexString.append(String.format("%02x", state[i][j]));
// //             }
// //         }
// //         return hexString.toString();
// //     }
// // }

// package com.gju.computersec.aes;

// public class DecryptorRunner {
//     private Decryptor decryptor;

//     // Constructor that initializes the Decryptor with the round keys
//     public DecryptorRunner(byte[][][] roundKeys) {
//         this.decryptor = new Decryptor(roundKeys);
//     }

//     // Method to decrypt a given encrypted block of data
//     public byte[] decrypt(byte[] encryptedData) {
//         // Convert the flat byte array to a 4x4 state matrix
//         byte[][] state = new byte[4][4];
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 state[j][i] = encryptedData[i * 4 + j];
//             }
//         }

//         // Perform decryption
//         state = decryptor.decrypt(state);

//         // Convert the decrypted state matrix back to a flat byte array
//         byte[] decryptedData = new byte[16];
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 decryptedData[i * 4 + j] = state[j][i];
//             }
//         }

//         return decryptedData;
//     }
// }

package com.gju.computersec.aes;

import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;
public class DecryptRunner {
    private Decrypt decrypt;

    public void runDecryption(String key, String base64Text) {
        // Convert the key from String to byte[][] format
        byte[][] keyBytes = stringToByteArray16(key); // Assuming 16 bytes key for AES-128

        // Initialize decrypt with a sample state; this example assumes 16 bytes key is used
        byte[][] state = new byte[4][4]; // Placeholder, should be initialized with actual data
        decrypt = new Decrypt(state);

        byte[] encryptedBytes = Base64.decodeBase64(base64Text);
        byte[][] byteText = bytesToByteArray16(encryptedBytes);

        // Assuming keyBytes are used as round keys; normally you would generate round keys
        byte[][][] roundKeys = generateRoundKeys(keyBytes); // Generate round keys correctly

        // Decryption process
        byteText = decrypt.decrypt(byteText, roundKeys);

        String decrypted = new String(flattenArray(byteText));
        System.out.println(Arrays.toString(flattenArray(byteText)));
        System.out.println(decrypted);
    }

    private byte[][] bytesToByteArray16(byte[] input) {
        byte[][] byteArray = new byte[4][4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                byteArray[i][j] = input[index++];
            }
        }
        return byteArray;
    }

    private byte[] flattenArray(byte[][] arr) {
        byte[] flat = new byte[16];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                flat[k++] = arr[i][j];
            }
        }
        return flat;
    }

    private byte[][] stringToByteArray16(String key) {
        // Convert key from String to byte[] assuming it's a hex-encoded string
        byte[] keyBytes = key.getBytes(); // Modify this if your key needs different encoding
        return bytesToByteArray16(keyBytes);
    }

    private byte[][][] generateRoundKeys(byte[][] key) {
        // Placeholder for key expansion logic
        // You should implement the actual key expansion for AES
        byte[][][] roundKeys = new byte[11][4][4]; // Example for AES-128
        // Initialize roundKeys with actual key expansion data
        return roundKeys;
    }
}

// public class DecryptRunner {
//     private Decrypt decrypt;

//     public void runDecryption(String key, String base64Text) {
//         // Convert the key from String to byte[][] format
//         byte[][] keyBytes = stringToByteArray16(key); // Assuming 16 bytes key for AES-128

//         // Initialize decrypt with a sample state; this example assumes 16 bytes key is used
//         byte[][] state = new byte[4][4]; // Placeholder, should be initialized with actual data
//         decrypt = new Decrypt(state);

//         byte[] encryptedBytes = Base64.decodeBase64(base64Text);
//         byte[][] byteText = bytesToByteArray16(encryptedBytes);

//         // Assuming keyBytes are used as round keys; normally you would generate round keys
//         byte[][][] roundKeys = generateRoundKeys(keyBytes); // Placeholder method to generate round keys

//         // Decryption process
//         byteText = decrypt.decrypt(byteText, roundKeys);

//         String decrypted = new String(flattenArray(byteText));
//         System.out.println(Arrays.toString(flattenArray(byteText)));
//         System.out.println(decrypted);
//     }

//     private byte[][] bytesToByteArray16(byte[] input) {
//         byte[][] byteArray = new byte[4][4];
//         int index = 0;
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 byteArray[i][j] = input[index++];
//             }
//         }
//         return byteArray;
//     }

//     private byte[] flattenArray(byte[][] arr) {
//         byte[] flat = new byte[16];
//         int k = 0;
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 flat[k++] = arr[i][j];
//             }
//         }
//         return flat;
//     }

//     private byte[][] stringToByteArray16(String key) {
//         // Convert key from String to byte[] assuming it's a hex-encoded string
//         byte[] keyBytes = key.getBytes(); // Modify this if your key needs different encoding
//         return bytesToByteArray16(keyBytes);
//     }

//     private byte[][][] generateRoundKeys(byte[][] key) {
//         // Placeholder for key expansion logic
//         // You should implement the actual key expansion for AES
//         byte[][][] roundKeys = new byte[11][4][4]; // Example for AES-128
//         // Initialize roundKeys with actual key expansion data
//         return roundKeys;
//     }
// }

// public class DecryptRunner {
//     Decrypt decrypt;

//     public void runDecryption(String key, String base64Text) {
//         decrypt = new Decrypt(key);
//         byte[] encryptedBytes = Base64.decodeBase64(base64Text);
//         byte[][] byteText = bytesToByteArray16(encryptedBytes);

//         for (int i = 10; i >= 1; i--) {
//             byteText = decrypt.addRoundKey(byteText, i);
//             byteText = decrypt.shiftRows(byteText);
//             byteText = decrypt.subBytes(byteText);
//             byteText = decrypt.mixColumns(byteText);
//         }
//         byteText = decrypt.addRoundKey(byteText, 0);
//         String decrypted = new String(flattenArray(byteText));
//         System.out.println(Arrays.toString(flattenArray(byteText)));
//         System.out.println(decrypted);
//     }

//     private byte[][] bytesToByteArray16(byte[] input) {
//         byte[][] byteArray = new byte[4][4];
//         int index = 0;
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 byteArray[i][j] = input[index++];
//             }
//         }
//         return byteArray;
//     }

//     private byte[] flattenArray(byte[][] arr) {
//         byte[] flat = new byte[16];
//         int k = 0;
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 flat[k++] = arr[i][j];
//             }
//         }
//         return flat;
//     }
// }