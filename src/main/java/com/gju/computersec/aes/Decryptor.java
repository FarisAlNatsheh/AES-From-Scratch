package com.gju.computersec.aes;

import java.nio.charset.StandardCharsets;

import static com.gju.computersec.utils.ByteMath.*;

public class Decryptor {
    private byte[] keyBytes;
    private byte[][][] roundKeys;
    public Decryptor(String key){
        keyBytes = key.getBytes(StandardCharsets.UTF_8);
        roundKeys = (new KeyExpander().getRoundKeys(keyBytes));
    }
    public byte[][] invSubBytes(byte[][] state) {
        byte[][] newState = new byte[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int byteValue = state[row][col];
                int upper = (byteValue >> 4) & 0x0F;
                int lower = byteValue & 0x0F;
                newState[row][col] = INV_S_BOX[upper][lower];
            }
        }
        return newState;
    }
    public byte[][] invShiftRows(byte[][] state) {
        byte temp;

        temp = state[1][3];
        state[1][3] = state[1][2];
        state[1][2] = state[1][1];
        state[1][1] = state[1][0];
        state[1][0] = temp;

        temp = state[2][0];
        state[2][0] = state[2][2];
        state[2][2] = temp;
        temp = state[2][1];
        state[2][1] = state[2][3];
        state[2][3] = temp;

        temp = state[3][0];
        state[3][0] = state[3][1];
        state[3][1] = state[3][2];
        state[3][2] = state[3][3];
        state[3][3] = temp;

        return state;
    }
    public byte[][] invMixColumns(byte[][] state) {
        int[] column = new int[4];

        for (int i = 0; i < 4; i++) {
            // Copy the current column into 'column' array
            for (int j = 0; j < 4; j++) {
                column[j] = state[j][i];
            }

            // Perform the matrix multiplication with the inverse fixed matrix
            state[0][i] = (byte) (mul14(column[0]) ^ mul11(column[1]) ^ mul13(column[2]) ^ mul9(column[3]));
            state[1][i] = (byte) (mul9(column[0]) ^ mul14(column[1]) ^ mul11(column[2]) ^ mul13(column[3]));
            state[2][i] = (byte) (mul13(column[0]) ^ mul9(column[1]) ^ mul14(column[2]) ^ mul11(column[3]));
            state[3][i] = (byte) (mul11(column[0]) ^ mul13(column[1]) ^ mul9(column[2]) ^ mul14(column[3]));
        }
        return state;
    }
    public byte[][] addRoundKey(byte[][] state, int roundNum){
        state = xorByteArrays(state, roundKeys[roundNum]);
        return state;
    }
}
