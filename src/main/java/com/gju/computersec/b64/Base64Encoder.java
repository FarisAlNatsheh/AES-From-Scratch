package com.gju.computersec.b64;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Base64Encoder {
    public static String encodeToB64(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        return Base64.encodeBase64String(bytes);
    }
}
