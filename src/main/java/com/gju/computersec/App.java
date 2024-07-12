package com.gju.computersec;


import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException {
        String filePath = "fruits.png";
        String encodedFile = Base64Encoder.encodeToB64(filePath);

        System.out.println(encodedFile);
    }
}
