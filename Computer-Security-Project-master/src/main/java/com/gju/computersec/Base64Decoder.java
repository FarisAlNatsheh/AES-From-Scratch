package com.gju.computersec;

import org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Base64Decoder {
    public static void decodeFromB64(String base64Str, String outputPath) throws IOException {
        byte[] decodedBytes = Base64.decodeBase64(base64Str);
        Files.write(Paths.get(outputPath), decodedBytes, StandardOpenOption.CREATE);
    }
}