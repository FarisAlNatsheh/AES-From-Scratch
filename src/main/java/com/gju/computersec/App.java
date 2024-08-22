package com.gju.computersec;


import com.gju.computersec.aes.FileEncryptor;
import org.apache.commons.codec.binary.Base64;

import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class App
{
    public static void main(String[] args) throws IOException {
        if(args.length < 3){
            System.out.println("Not enough arguments");
            return;
        }
        String mainArg = args[0];
        String keyArg = args[1];
        String filePath = args[2];

        Scanner scanner = new Scanner(System.in);
        System.err.println("Output base64? ");
        String includeB64 = scanner.nextLine();


        scanner.close();

        if(keyArg.length() != 16){
            System.out.println("Key must be 16 characters");
            return;
        }
        if(!(mainArg.equals("encrypt") || mainArg.equals("decrypt"))){
            System.out.println("Invalid operation");
            return;
        }


        byte[] file = Files.readAllBytes(Paths.get(filePath));

        byte[] output = null;

        if(mainArg.equals("encrypt"))
            output = new FileEncryptor().encrypt(file,keyArg);

        if(mainArg.equals("decrypt"))
            output= new FileEncryptor().decrypt(file,keyArg);


        if(includeB64.toLowerCase().startsWith("y")) {
            System.out.println(Base64.encodeBase64String(output));
        }
        else{
            try {
                FileOutputStream fos = new FileOutputStream(mainArg+ "ed-file");
                fos.write(output);
                System.out.println();
                System.out.println("File saved successfully.");
            } catch (IOException e) {
                System.err.println("Failed to save file: " + e.getMessage());
            }
        }


    }



}
