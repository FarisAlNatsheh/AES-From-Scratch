package com.gju.computersec;


import com.gju.computersec.aes.Round;
import com.gju.computersec.aes.Runner;
import com.gju.computersec.b64.Base64Encoder;

import java.io.IOException;

public class App
{
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
        new Runner().runAlgorithm("ThisIsA16ByteKey","ThisIsA16ByteKey");
    }
}
