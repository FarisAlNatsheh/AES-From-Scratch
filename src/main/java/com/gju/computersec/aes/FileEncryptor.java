package com.gju.computersec.aes;

public class FileEncryptor {

    public FileEncryptor(){

    }
    public byte[] encrypt(byte[] file, String key){
        System.out.println("Running encryption...");
        byte[] encryptedFile = new byte[0];
        file = padTo16(file);
        byte[][][] splitFile = splitInto2DArrays(file, 4);


        System.out.println("Blocks:" + splitFile.length);

        System.out.println("Block Dimensions:" + splitFile[0].length + "x"+ splitFile[0][0].length);


        for(int i = 0; i < splitFile.length; i++) {
            byte[] block = new Runner().runEncryptionAlgorithm(key, splitFile[i]);
            encryptedFile = concatenate(encryptedFile, block);
        }
        System.out.println("Encryption done!");
        return (encryptedFile);

    }

    public byte[] decrypt(byte[] file, String key){
        System.out.println("Running decryption...");
        byte[] decryptedFile = new byte[0];
        //file = padTo16(file);

        byte[][][] splitFile = splitInto2DArrays(file, 4);

        System.out.println("Blocks:" + splitFile.length);

        System.out.println("Block Dimensions:" + splitFile[0].length + "x"+ splitFile[0][0].length);


        for(int i = 0; i < splitFile.length; i++) {
            byte[] block = new Runner().runDecryptionAlgorithm(key, splitFile[i]);
            decryptedFile = concatenate(decryptedFile, block);
        }

        //Undo padding
        byte lastByte = decryptedFile[decryptedFile.length - 1];
        int unsignedValue = lastByte & 0xFF;
        decryptedFile = trimArrayFromEnd(decryptedFile, unsignedValue);
        System.out.println("Decryption done!");
        return decryptedFile;
    }


    public static byte[] padTo16(byte[] byteArray) {
        int blockSize = 16;
        int length = byteArray.length;
        int padLength = blockSize - (length % blockSize);

        byte[] paddedArray = new byte[length + padLength];

        System.arraycopy(byteArray, 0, paddedArray, 0, length);

        for (int i = length; i < paddedArray.length; i++) {
            paddedArray[i] = (byte) padLength;
        }

        return paddedArray;
    }

    public static byte[][][] splitInto2DArrays(byte[] byteArray, int size) {
        int bytesPerMatrix = size * size;

        if (byteArray.length % bytesPerMatrix != 0) {
            throw new IllegalArgumentException("Byte array length must be a multiple of " + bytesPerMatrix + ".");
        }

        int numMatrices = byteArray.length / bytesPerMatrix;

        byte[][][] matrices = new byte[numMatrices][size][size];

        for (int m = 0; m < numMatrices; m++) {
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrices[m][r][c] = byteArray[m * bytesPerMatrix + r * size + c];
                }
            }
        }

        return matrices;
    }

    public static byte[] concatenate(byte[] array1, byte[] array2) {
        byte[] result = new byte[array1.length + array2.length];

        System.arraycopy(array1, 0, result, 0, array1.length);

        System.arraycopy(array2, 0, result, array1.length, array2.length);

        return result;
    }
    public static byte[] trimArrayFromEnd(byte[] array, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Trim amount must be non-negative.");
        }
        if (amount > array.length) {
            throw new IllegalArgumentException("Trim amount exceeds array length.");
        }
        int newLength = array.length - amount;
        byte[] newArray = new byte[newLength];
        System.arraycopy(array, 0, newArray, 0, newLength);
        return newArray;
    }
}
