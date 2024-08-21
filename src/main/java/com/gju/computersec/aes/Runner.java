package com.gju.computersec.aes;

import org.apache.commons.codec.binary.Base64;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Runner {
    Round round;
    public void runAlgorithm(String key, String text){
        round = new Round(key);
        byte[][] byteText = stringToBytes16(text);

        byteText = round.addRoundKey(byteText,0);

        for(int i =0; i < 9; i++){
            byteText = round.subBytes(byteText);
            byteText = round.shiftRows(byteText);
            byteText = round.mixColumns(byteText);
            byteText = round.addRoundKey(byteText,i);
        }
        byteText = round.subBytes(byteText);
        byteText = round.shiftRows(byteText);
        byteText = round.addRoundKey(byteText,10);

        String encrypted = new String(flattenArray(byteText));
        System.out.println(Arrays.toString(flattenArray(byteText)));
        System.out.println(Base64.encodeBase64String(flattenArray(byteText)));

        System.out.println(encrypted);
    }
    private byte[] flattenArray(byte[][] arr){
        byte[] flat = new byte[16];
        int k = 0;
        for(int i =0; i < 4; i++){
            for(int j =0; j < 4; j++){
                flat[k] = arr[i][j];
                k++;
            }
        }
        return flat;
    }
    private byte[][] stringToBytes16(String input) {
        byte[][] byteArray = new byte[4][4];

        // Convert each character to byte and store in the 4x4 byte array
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                byteArray[i][j] = (byte) input.charAt(index);
                index++;
            }
        }

        return byteArray;
    }

}
