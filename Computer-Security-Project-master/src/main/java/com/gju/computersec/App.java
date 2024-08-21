package com.gju.computersec;


import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        // Encode the file
        String filePath = "cat.png";
        String encodedFile = Base64Encoder.encodeToB64(filePath);
        System.out.println("Encoded File: ");
        System.out.println(encodedFile);

        // Decode the file and save it
        String outputFilePath = "decoded_cat.png";
        Base64Decoder.decodeFromB64(encodedFile, outputFilePath);
        System.out.println("File decoded and saved as " + outputFilePath);
    }
}