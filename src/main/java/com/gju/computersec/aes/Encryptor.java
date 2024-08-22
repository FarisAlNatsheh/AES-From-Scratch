package com.gju.computersec.aes;

import java.nio.charset.StandardCharsets;

import static com.gju.computersec.utils.ByteMath.*;

public class Encryptor {
    private byte[][][] roundKeys;

    public Encryptor(String key){
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        roundKeys = (new KeyExpander().getRoundKeys(keyBytes));
    }

    public byte[][] subBytes(byte[][] state) {
        byte[][] newState = new byte[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int byteValue = state[row][col];
                int upper = (byteValue >> 4) & 0x0F;
                int lower = byteValue & 0x0F;
                newState[row][col] = S_BOX[upper][lower];
            }
        }
        //System.out.println("SubBytes: "+ toHex(flattenArray(newState)));
        return newState;
    }


    public byte[][] shiftRows(byte[][] input){
        byte[][] output = new byte[4][4];


        output[0][0] = input[0][0];
        output[1][0] = input[1][0];
        output[2][0] = input[2][0];
        output[3][0] = input[3][0];

        output[0][1] = input[1][1];
        output[1][1] = input[2][1];
        output[2][1] = input[3][1];
        output[3][1] = input[0][1];


        output[0][2] = input[2][2];
        output[1][2] = input[3][2];
        output[2][2] = input[0][2];
        output[3][2] = input[1][2];


        output[0][3] = input[3][3];
        output[1][3] = input[0][3];
        output[2][3] = input[1][3];
        output[3][3] = input[2][3];



       // System.out.println("shiftRows: "+ toHex(flattenArray(output)));
        return output;

    }




    public byte[][] mixColumns(byte[][] state) {
        state = transpose(state);
        int[] column = new int[4];

        for (int i = 0; i < 4; i++) {
            // Copy the current column into 'column' array
            for (int j = 0; j < 4; j++) {
                column[j] = state[j][i];
            }

            // Perform the matrix multiplication with fixed matrix
            state[0][i] = (byte) (mul2(column[0]) ^ mul3(column[1]) ^ column[2] ^ column[3]);
            state[1][i] = (byte) (column[0] ^ mul2(column[1]) ^ mul3(column[2]) ^ column[3]);
            state[2][i] = (byte) (column[0] ^ column[1] ^ mul2(column[2]) ^ mul3(column[3]));
            state[3][i] = (byte) (mul3(column[0]) ^ column[1] ^ column[2] ^ mul2(column[3]));
        }
        state = transpose(state);
        //System.out.println("mixCols: "+ toHex(flattenArray(state)));
        return state;
    }
    public byte[][] addRoundKey(byte[][] state, int roundNum){
        state = xorByteArrays(state, roundKeys[roundNum]);
        //System.out.println("used key: "+ toHex(flattenArray(roundKeys[roundNum])));
        //System.out.println("rkey: "+ toHex(flattenArray(state)));
        return state;
    }

}
