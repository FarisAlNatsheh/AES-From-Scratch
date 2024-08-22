package com.gju.computersec.aes;
import java.util.Arrays;

import static com.gju.computersec.utils.ByteMath.S_BOX;

public class KeyExpander {

    private static final int KEY_SIZE = 16; // 128 bits = 16 bytes
    private static final int ROUNDS = 10;  // 10 rounds for AES-128
    private static final int WORD_SIZE = 4; // 4 bytes per word
    private static final int EXPANDED_KEY_SIZE = (ROUNDS + 1) * 4 * WORD_SIZE; // 176 bytes for AES-128

    private static final int[] RCON = {
            0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36
    };

    public byte[] keyExpansion(byte[] key) {
        byte[] expandedKey = new byte[EXPANDED_KEY_SIZE];
        int currentSize = 0;
        int rconIndex = 0;
        byte[] temp = new byte[WORD_SIZE];

        // Copy the original key as the first part of the expanded key
        System.arraycopy(key, 0, expandedKey, 0, KEY_SIZE);
        currentSize += KEY_SIZE;

        // Generate the rest of the expanded key
        while (currentSize < EXPANDED_KEY_SIZE) {
            // Copy the previous 4 bytes to temp
            System.arraycopy(expandedKey, currentSize - WORD_SIZE, temp, 0, WORD_SIZE);

            // Apply the key schedule core every 16 bytes
            if (currentSize % KEY_SIZE == 0) {
                temp = scheduleCore(temp, rconIndex++);
            }

            // XOR with the word 16 bytes before the current position
            for (int i = 0; i < WORD_SIZE; i++) {
                expandedKey[currentSize] = (byte) (expandedKey[currentSize - KEY_SIZE] ^ temp[i]);
                currentSize++;
            }
        }

        return expandedKey;
    }
    public byte[][][] getRoundKeys(byte[] key){
       return splitInto4x4Matrices(keyExpansion(key));
    }

    private byte[] scheduleCore(byte[] word, int rconIndex) {
        // Rotate the word (RotWord)
        byte temp = word[0];
        word[0] = word[1];
        word[1] = word[2];
        word[2] = word[3];
        word[3] = temp;

        // Substitute each byte with the corresponding value from the S-Box (SubWord)
        for (int i = 0; i < WORD_SIZE; i++) {
            int row = (word[i] >> 4) & 0x0F;
            int col = word[i] & 0x0F;
            word[i] = (byte) S_BOX[row][col];
        }

        // XOR the first byte with the round constant (Rcon)
        word[0] ^= RCON[rconIndex];

        return word;
    }
    public byte[][][] splitInto4x4Matrices(byte[] byteArray) {
        int numMatrices = 11;
        int bytesPerMatrix = 16; // 4x4 matrix
        byte[][][] matrices = new byte[numMatrices][4][4];

        for (int i = 0; i < numMatrices; i++) {
            int start = i * bytesPerMatrix;
            int end = Math.min(start + bytesPerMatrix, byteArray.length);

            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    int index = (row * 4 + col) + start;
                    if (index < end) {
                        matrices[i][row][col] = byteArray[index];
                    } else {
                        matrices[i][row][col] = 0; // Fill with 0 if not enough bytes
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(matrices));
        return matrices;
    }
}
