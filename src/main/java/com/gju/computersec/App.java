package com.gju.computersec;


import com.gju.computersec.aes.Runner;
import com.gju.computersec.b64.Base64Encoder;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.gju.computersec.utils.ByteMath.toHex;

public class App
{
    public static void main( String[] args ) throws IOException {
        String filePath = "fruits.png";
        //String encodedFile = Base64Encoder.encodeToB64(filePath);
        String test = "ThisIsA16ByteKey";

        byte[][] hardcodedArray = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        //System.out.println(toHex(test.getBytes(StandardCharsets.UTF_8)));



        byte[] enc = new Runner().runEncryptionAlgorithm("ThisIsA16ByteKey","ThisIsA16ByteMey");
        System.out.println(Base64.encodeBase64String(enc));
        new Runner().runDecryptionAlgorithm("ThisIsA16ByteKey", enc);
    }


}
