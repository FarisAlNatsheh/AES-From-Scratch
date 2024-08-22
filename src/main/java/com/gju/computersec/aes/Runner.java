package com.gju.computersec.aes;


public class Runner {
    Encryptor encryptor;
    Decryptor decryptor;
    public byte[] runEncryptionAlgorithm(String key, byte[][] text){
        encryptor = new Encryptor(key);
        byte[][] byteText = text;

        byteText = encryptor.addRoundKey(byteText,0);

        for(int i =0; i < 9; i++){
            byteText = encryptor.subBytes(byteText);
            byteText = encryptor.shiftRows(byteText);
            byteText = encryptor.mixColumns(byteText);
            byteText = encryptor.addRoundKey(byteText,i+1);
        }
        byteText = encryptor.subBytes(byteText);
        byteText = encryptor.shiftRows(byteText);
        byteText = encryptor.addRoundKey(byteText,10);

        //String encrypted = new String(flattenArray(byteText));
      //  System.out.println(Base64.encodeBase64String(flattenArray(byteText)));
        //System.out.println(encrypted);

        return flattenArray(byteText);
    }
    public byte[] runDecryptionAlgorithm(String key, byte[][] text){
        decryptor = new Decryptor(key);
        byte[][] byteText = text;

        // Initial round key addition
        byteText = decryptor.addRoundKey(byteText, 10);

        for(int i = 9; i >= 0; i--){

            byteText = decryptor.invShiftRows(byteText);
            byteText = decryptor.invSubBytes(byteText);
            byteText = decryptor.addRoundKey(byteText, i);
            if (i > 0) {
                byteText = decryptor.invMixColumns(byteText);
            }
        }
        //String decryptedText = new String(flattenArray(byteText));
        return (flattenArray(byteText));
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


}
