// // // package com.gju.computersec.aes;

// // // public class Decryptor {
// // //     private byte[][][] roundKeys;
// // //     private byte[][] S_BOX;

// // //     public Decryptor(byte[][][] roundKeys, byte[][] S_BOX) {
// // //         this.roundKeys = roundKeys;
// // //         this.S_BOX = S_BOX;
// // //     }

// // //     public byte[][] decrypt(byte[][] state) {
// // //         for (int i = 10; i >= 0; i--) {
// // //             state = invShiftRows(state);
// // //             state = invSubBytes(state);
// // //             state = addRoundKey(state, i);
// // //             if (i != 0) {
// // //                 state = invMixColumns(state);
// // //             }
// // //         }
// // //         return state;
// // //     }

// // //     private byte[][] invShiftRows(byte[][] state) {
// // //         byte temp = state[1][3];
// // //         state[1][3] = state[1][2];
// // //         state[1][2] = state[1][1];
// // //         state[1][1] = state[1][0];
// // //         state[1][0] = temp;

// // //         temp = state[2][0];
// // //         state[2][0] = state[2][2];
// // //         state[2][2] = temp;
// // //         temp = state[2][1];
// // //         state[2][1] = state[2][3];
// // //         state[2][3] = temp;

// // //         temp = state[3][0];
// // //         state[3][0] = state[3][1];
// // //         state[3][1] = state[3][2];
// // //         state[3][2] = state[3][3];
// // //         state[3][3] = temp;

// // //         return state;
// // //     }

// // //     private byte[][] invSubBytes(byte[][] state) {
// // //         byte[][] invS_BOX = getInverseSBox();
// // //         byte[][] newState = new byte[4][4];
// // //         for (int row = 0; row < 4; row++) {
// // //             for (int col = 0; col < 4; col++) {
// // //                 int byteValue = state[row][col];
// // //                 int upper = (byteValue >> 4) & 0x0F;
// // //                 int lower = byteValue & 0x0F;
// // //                 newState[row][col] = invS_BOX[upper][lower];
// // //             }
// // //         }
// // //         return newState;
// // //     }

// // //     private byte[][] invS_BOX = {
// // //         // your pre-computed inverse S-box values here
// // //         {(byte)0x52, (byte)0x09, (byte)0x6A, (byte)0xD5, (byte)0x30, (byte)0x36, (byte)0xA5, (byte)0x38, (byte)0xBF, (byte)0x40, (byte)0xA3, (byte)0x9E, (byte)0x81, (byte)0xF3, (byte)0xD7, (byte)0xFB},
// // //         {(byte)0x7C, (byte)0xE3, (byte)0x39, (byte)0x82, (byte)0x9B, (byte)0x2F, (byte)0xFF, (byte)0x87, (byte)0x34, (byte)0x8E, (byte)0x43, (byte)0x44, (byte)0xC4, (byte)0xDE, (byte)0xE9, (byte)0xCB},
// // //         {(byte)0x54, (byte)0x7B, (byte)0x94, (byte)0x32, (byte)0xA6, (byte)0xC2, (byte)0x23, (byte)0x3D, (byte)0xEE, (byte)0x4C, (byte)0x95, (byte)0x0B, (byte)0x42, (byte)0xFA, (byte)0xC3, (byte)0x4E},
// // //         {(byte)0x08, (byte)0x2E, (byte)0xA1, (byte)0x66, (byte)0x28, (byte)0xD9, (byte)0x24, (byte)0xB2, (byte)0x76, (byte)0x5B, (byte)0xA2, (byte)0x49, (byte)0x6D, (byte)0x8B, (byte)0xD1, (byte)0x25},
// // //         {(byte)0x72, (byte)0xF8, (byte)0xF6, (byte)0x64, (byte)0x86, (byte)0x68, (byte)0x98, (byte)0x16, (byte)0xD4, (byte)0xA4, (byte)0x5C, (byte)0xCC, (byte)0x5D, (byte)0x65, (byte)0xB6, (byte)0x92},
// // //         {(byte)0x6C, (byte)0x70, (byte)0x48, (byte)0x50, (byte)0xFD, (byte)0xED, (byte)0xB9, (byte)0xDA, (byte)0x5E, (byte)0x15, (byte)0x46, (byte)0x57, (byte)0xA7, (byte)0x8D, (byte)0x9D, (byte)0x84},
// // //         {(byte)0x90, (byte)0xD8, (byte)0xAB, (byte)0x00, (byte)0x8C, (byte)0xBC, (byte)0xD3, (byte)0x0A, (byte)0xF7, (byte)0xE4, (byte)0x58, (byte)0x05, (byte)0xB8, (byte)0xB3, (byte)0x45, (byte)0x06},
// // //         {(byte)0xD0, (byte)0x2C, (byte)0x1E, (byte)0x8F, (byte)0xCA, (byte)0x3F, (byte)0x0F, (byte)0x02, (byte)0xC1, (byte)0xAF, (byte)0xBD, (byte)0x03, (byte)0x01, (byte)0x13, (byte)0x8A, (byte)0x6B},
// // //         {(byte)0x3A, (byte)0x91, (byte)0x11, (byte)0x41, (byte)0x4F, (byte)0x67, (byte)0xDC, (byte)0xEA, (byte)0x97, (byte)0xF2, (byte)0xCF, (byte)0xCE, (byte)0xF0, (byte)0xB4, (byte)0xE6, (byte)0x73},
// // //         {(byte)0x96, (byte)0xAC, (byte)0x74, (byte)0x22, (byte)0xE7, (byte)0xAD, (byte)0x35, (byte)0x85, (byte)0xE2, (byte)0xF9, (byte)0x37, (byte)0xE8, (byte)0x1C, (byte)0x75, (byte)0xDF, (byte)0x6E},
// // //         {(byte)0x47, (byte)0xF1, (byte)0x1A, (byte)0x71, (byte)0x1D, (byte)0x29, (byte)0xC5, (byte)0x89, (byte)0x6F, (byte)0xB7, (byte)0x62, (byte)0x0E, (byte)0xAA, (byte)0x18, (byte)0xBE, (byte)0x1B},
// // //         {(byte)0xFC, (byte)0x56, (byte)0x3E, (byte)0x4B, (byte)0xC6, (byte)0xD2, (byte)0x79, (byte)0x20, (byte)0x9A, (byte)0xDB, (byte)0xC0, (byte)0xFE, (byte)0x78, (byte)0xCD, (byte)0x5A, (byte)0xF4},
// // //         {(byte)0x1F, (byte)0xDD, (byte)0xA8, (byte)0x33, (byte)0x88, (byte)0x07, (byte)0xC7, (byte)0x31, (byte)0xB1, (byte)0x12, (byte)0x10, (byte)0x59, (byte)0x27, (byte)0x80, (byte)0xEC, (byte)0x5F},
// // //         {(byte)0x60, (byte)0x51, (byte)0x7F, (byte)0xA9, (byte)0x19, (byte)0xB5, (byte)0x4A, (byte)0x0D, (byte)0x2D, (byte)0xE5, (byte)0x7A, (byte)0x9F, (byte)0x93, (byte)0xC9, (byte)0x9C, (byte)0xEF},
// // //         {(byte)0xA0, (byte)0xE0, (byte)0x3B, (byte)0x4D, (byte)0xAE, (byte)0x2A, (byte)0xF5, (byte)0xB0, (byte)0xC8, (byte)0xEB, (byte)0xBB, (byte)0x3C, (byte)0x83, (byte)0x53, (byte)0x99, (byte)0x61},
// // //         {(byte)0x17, (byte)0x2B, (byte)0x04, (byte)0x7E, (byte)0xBA, (byte)0x77, (byte)0xD6, (byte)0x26, (byte)0xE1, (byte)0x69, (byte)0x14, (byte)0x63, (byte)0x55, (byte)0x21, (byte)0x0C, (byte)0x7D}
    
// // //     };
    
// // //     private byte[][] getInverseSBox() {
// // //         return invS_BOX;
// // //     }

// // //     private byte[][] invMixColumns(byte[][] state) {
// // //         int[] column = new int[4];

// // //         for (int i = 0; i < 4; i++) {
// // //             // Copy the current column into 'column' array
// // //             for (int j = 0; j < 4; j++) {
// // //                 column[j] = state[j][i];
// // //             }

// // //             // Perform the inverse matrix multiplication with fixed matrix
// // //             state[0][i] = (byte) (mulE(column[0]) ^ mulB(column[1]) ^ mulD(column[2]) ^ mul9(column[3]));
// // //             state[1][i] = (byte) (mul9(column[0]) ^ mulE(column[1]) ^ mulB(column[2]) ^ mulD(column[3]));
// // //             state[2][i] = (byte) (mulD(column[0]) ^ mul9(column[1]) ^ mulE(column[2]) ^ mulB(column[3]));
// // //             state[3][i] = (byte) (mulB(column[0]) ^ mulD(column[1]) ^ mul9(column[2]) ^ mulE(column[3]));
// // //         }
// // //         return state;
// // //     }

// // //     private byte[][] addRoundKey(byte[][] state, int roundNum) {
// // //         byte[][] roundKey = roundKeys[roundNum];
// // //         byte[][] result = new byte[4][4];

// // //         for (int i = 0; i < 4; i++) {
// // //             for (int j = 0; j < 4; j++) {
// // //                 result[i][j] = (byte) (state[i][j] ^ roundKey[i][j]);
// // //             }
// // //         }

// // //         return result;
// // //     }

// // //     private int mul2(int value) {
// // //         if (value < 0) {
// // //             value += 256;
// // //         }
// // //         return ((value << 1) ^ ((value >> 7) * 0x1b)) & 0xFF;
// // //     }

// // //     private int mul3(int value) {
// // //         return mul2(value) ^ value;
// // //     }

// // //     private int mul9(int value) {
// // //         return (mul2(mul2(mul2(value))) ^ value) & 0xFF;
// // //     }

// // //     private int mulB(int value) {
// // //         return (mul2(mul2(mul2(value))) ^ mul2(value) ^ value) & 0xFF;
// // //     }
    
// // //     private int mulD(int value) {
// // //         return (mul2(mul2(value)) ^ value) & 0xFF;
// // //     }
    
// // //     private int mulE(int value) {
// // //         return (mul2(mul2(mul2(value))) ^ mul2(mul2(value)) ^ value) & 0xFF;
// // //     }
// // // }
// // package com.gju.computersec.aes;

// // public class Decryptor {
// //     private byte[][][] roundKeys;
// //     private byte[][] invS_BOX;

// //     public Decryptor(byte[][][] roundKeys) {
// //         this.roundKeys = roundKeys;
// //         this.invS_BOX = new byte[][]{
// //             {(byte) 0x52, (byte) 0x09, (byte) 0x6A, (byte) 0xD5, (byte) 0x30, (byte) 0x36, (byte) 0xA5, (byte) 0x38, (byte) 0xBF, (byte) 0x40, (byte) 0xA3, (byte) 0x9E, (byte) 0x81, (byte) 0xF3, (byte) 0xD7, (byte) 0xFB},
// //             {(byte) 0x7C, (byte) 0xE3, (byte) 0x39, (byte) 0x82, (byte) 0x9B, (byte) 0x2F, (byte) 0xFF, (byte) 0x87, (byte) 0x34, (byte) 0x8E, (byte) 0x43, (byte) 0x44, (byte) 0xC4, (byte) 0xDE, (byte) 0xE9, (byte) 0xCB},
// //             {(byte) 0x54, (byte) 0x7B, (byte) 0x94, (byte) 0x32, (byte) 0xA6, (byte) 0xC2, (byte) 0x23, (byte) 0x3D, (byte) 0xEE, (byte) 0x4C, (byte) 0x95, (byte) 0x0B, (byte) 0x42, (byte) 0xFA, (byte) 0xC3, (byte) 0x4E},
// //             {(byte) 0x08, (byte) 0x2E, (byte) 0xA1, (byte) 0x66, (byte) 0x28, (byte) 0xD9, (byte) 0x24, (byte) 0xB2, (byte) 0x76, (byte) 0x5B, (byte) 0xA2, (byte) 0x49, (byte) 0x6D, (byte) 0x8B, (byte) 0xD1, (byte) 0x25},
// //             {(byte) 0x72, (byte) 0xF8, (byte) 0xF6, (byte) 0x64, (byte) 0x86, (byte) 0x68, (byte) 0x98, (byte) 0x16, (byte) 0xD4, (byte) 0xA4, (byte) 0x5C, (byte) 0xCC, (byte) 0x5D, (byte) 0x65, (byte) 0xB6, (byte) 0x92},
// //             {(byte) 0x6C, (byte) 0x70, (byte) 0x48, (byte) 0x50, (byte) 0xFD, (byte) 0xED, (byte) 0xB9, (byte) 0xDA, (byte) 0x5E, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xA7, (byte) 0x8D, (byte) 0x9D, (byte) 0x84},
// //             {(byte) 0x90, (byte) 0xD8, (byte) 0xAB, (byte) 0x00, (byte) 0x8C, (byte) 0xBC, (byte) 0xD3, (byte) 0x0A, (byte) 0xF7, (byte) 0xE4, (byte) 0x58, (byte) 0x05, (byte) 0xB8, (byte) 0xB3, (byte) 0x45, (byte) 0x06},
// //             {(byte) 0xD0, (byte) 0x2C, (byte) 0x1E, (byte) 0x8F, (byte) 0xCA, (byte) 0x3F, (byte) 0x0F, (byte) 0x02, (byte) 0xC1, (byte) 0xAF, (byte) 0xBD, (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8A, (byte) 0x6B},
// //             {(byte) 0x3A, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4F, (byte) 0x67, (byte) 0xDC, (byte) 0xEA, (byte) 0x97, (byte) 0xF2, (byte) 0xCF, (byte) 0xCE, (byte) 0xF0, (byte) 0xB4, (byte) 0xE6, (byte) 0x73},
// //             {(byte) 0x96, (byte) 0xAC, (byte) 0x74, (byte) 0x22, (byte) 0xE7, (byte) 0xAD, (byte) 0x35, (byte) 0x85, (byte) 0xE2, (byte) 0xF9, (byte) 0x37, (byte) 0xE8, (byte) 0x1C, (byte) 0x75, (byte) 0xDF, (byte) 0x6E},
// //             {(byte) 0x47, (byte) 0xF1, (byte) 0x1A, (byte) 0x71, (byte) 0x1D, (byte) 0x29, (byte) 0xC5, (byte) 0x89, (byte) 0x6F, (byte) 0xB7, (byte) 0x62, (byte) 0x0E, (byte) 0xAA, (byte) 0x18, (byte) 0xBE, (byte) 0x1B},
// //             {(byte) 0xFC, (byte) 0x56, (byte) 0x3E, (byte) 0x4B, (byte) 0xC6, (byte) 0xD2, (byte) 0x79, (byte) 0x20, (byte) 0x9A, (byte) 0xDB, (byte) 0xC0, (byte) 0xFE, (byte) 0x78, (byte) 0xCD, (byte) 0x5A, (byte) 0xF4},
// //             {(byte) 0x1F, (byte) 0xDD, (byte) 0xA8, (byte) 0x33, (byte) 0x88, (byte) 0x07, (byte) 0xC7, (byte) 0x31, (byte) 0xB1, (byte) 0x12, (byte) 0x10, (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xEC, (byte) 0x5F},
// //             {(byte) 0x60, (byte) 0x51, (byte) 0x7F, (byte) 0xA9, (byte) 0x19, (byte) 0xB5, (byte) 0x4A, (byte) 0x0D, (byte) 0x2D, (byte) 0xE5, (byte) 0x7A, (byte) 0x9F, (byte) 0x93, (byte) 0xC9, (byte) 0x9C, (byte) 0xEF},
// //             {(byte) 0xA0, (byte) 0xE0, (byte) 0x3B, (byte) 0x4D, (byte) 0xAE, (byte) 0x2A, (byte) 0xF5, (byte) 0xB0, (byte) 0xC8, (byte) 0xEB, (byte) 0xBB, (byte) 0x3C, (byte) 0x83, (byte) 0x53, (byte) 0x99, (byte) 0x61},
// //             {(byte) 0x17, (byte) 0x2B, (byte) 0x04, (byte) 0x7E, (byte) 0xBA, (byte) 0x77, (byte) 0xD6, (byte) 0x26, (byte) 0xE1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55, (byte) 0x21, (byte) 0x0C, (byte) 0x7D}
// //         };
// //     }

// //     public byte[][] decryptBlock(byte[][] input) {
// //         byte[][] state = addRoundKey(input, roundKeys[10]);
// //         state = invShiftRows(state);
// //         state = invSubBytes(state);

// //         for (int round = 9; round > 0; round--) {
// //             state = addRoundKey(state, roundKeys[round]);
// //             state = invMixColumns(state);
// //             state = invShiftRows(state);
// //             state = invSubBytes(state);
// //         }

// //         state = addRoundKey(state, roundKeys[0]);
// //         return state;
// //     }

// //     private byte[][] addRoundKey(byte[][] state, byte[][] roundKey) {
// //         for (int i = 0; i < 4; i++) {
// //             for (int j = 0; j < 4; j++) {
// //                 state[i][j] ^= roundKey[i][j];
// //             }
// //         }
// //         return state;
// //     }

// //     private byte[][] invSubBytes(byte[][] state) {
// //         for (int i = 0; i < 4; i++) {
// //             for (int j = 0; j < 4; j++) {
// //                 state[i][j] = invS_BOX[state[i][j] >> 4][state[i][j] & 0x0F];
// //             }
// //         }
// //         return state;
// //     }

// //     private byte[][] invShiftRows(byte[][] state) {
// //         byte temp;

// //         // Row 1: shift left by 1
// //         temp = state[1][3];
// //         for (int i = 3; i > 0; i--) {
// //             state[1][i] = state[1][i - 1];
// //         }
// //         state[1][0] = temp;

// //         // Row 2: shift left by 2
// //         temp = state[2][0];
// //         state[2][0] = state[2][2];
// //         state[2][2] = temp;
// //         temp = state[2][1];
// //         state[2][1] = state[2][3];
// //         state[2][3] = temp;

// //         // Row 3: shift left by 3 (same as right shift by 1)
// //         temp = state[3][0];
// //         for (int i = 0; i < 3; i++) {
// //             state[3][i] = state[3][i + 1];
// //         }
// //         state[3][3] = temp;

// //         return state;
// //     }

// //     private byte[][] invMixColumns(byte[][] state) {
// //         for (int i = 0; i < 4; i++) {
// //             byte[] col = new byte[4];
// //             for (int j = 0; j < 4; j++) {
// //                 col[j] = state[j][i];
// //             }

// //             state[0][i] = (byte) (galoisMultiply(col[0], 0x0e) ^ galoisMultiply(col[1], 0x0b) ^ galoisMultiply(col[2], 0x0d) ^ galoisMultiply(col[3], 0x09));
// //             state[1][i] = (byte) (galoisMultiply(col[0], 0x09) ^ galoisMultiply(col[1], 0x0e) ^ galoisMultiply(col[2], 0x0b) ^ galoisMultiply(col[3], 0x0d));
// //             state[2][i] = (byte) (galoisMultiply(col[0], 0x0d) ^ galoisMultiply(col[1], 0x09) ^ galoisMultiply(col[2], 0x0e) ^ galoisMultiply(col[3], 0x0b));
// //             state[3][i] = (byte) (galoisMultiply(col[0], 0x0b) ^ galoisMultiply(col[1], 0x0d) ^ galoisMultiply(col[2], 0x09) ^ galoisMultiply(col[3], 0x0e));
// //         }

// //         return state;
// //     }

// //     private byte galoisMultiply(byte a, int b) {
// //         byte p = 0;
// //         byte high_bit_mask = (byte) 0x80;
// //         byte high_bit = 0;
// //         byte modulo = (byte) 0x1b;

// //         for (int i = 0; i < 8; i++) {
// //             if ((b & 1) == 1) {
// //                 p ^= a;
// //             }

// //             high_bit = (byte) (a & high_bit_mask);
// //             a <<= 1;
// //             if (high_bit != 0) {
// //                 a ^= modulo;
// //             }
// //             b >>= 1;
// //         }

// //         return p;
// //     }
// // }

// package com.gju.computersec.aes;

// public class Decryptor {
//     private byte[][][] roundKeys;

//     // Inverse S-Box
//     private byte[][] invS_BOX = {
//         {(byte)0x52, (byte)0x09, (byte)0x6A, (byte)0xD5, (byte)0x30, (byte)0x36, (byte)0xA5, (byte)0x38, (byte)0xBF, (byte)0x40, (byte)0xA3, (byte)0x9E, (byte)0x81, (byte)0xF3, (byte)0xD7, (byte)0xFB},
//         {(byte)0x7C, (byte)0xE3, (byte)0x39, (byte)0x82, (byte)0x9B, (byte)0x2F, (byte)0xFF, (byte)0x87, (byte)0x34, (byte)0x8E, (byte)0x43, (byte)0x44, (byte)0xC4, (byte)0xDE, (byte)0xE9, (byte)0xCB},
//         {(byte)0x54, (byte)0x7B, (byte)0x94, (byte)0x32, (byte)0xA6, (byte)0xC2, (byte)0x23, (byte)0x3D, (byte)0xEE, (byte)0x4C, (byte)0x95, (byte)0x0B, (byte)0x42, (byte)0xFA, (byte)0xC3, (byte)0x4E},
//         {(byte)0x08, (byte)0x2E, (byte)0xA1, (byte)0x66, (byte)0x28, (byte)0xD9, (byte)0x24, (byte)0xB2, (byte)0x76, (byte)0x5B, (byte)0xA2, (byte)0x49, (byte)0x6D, (byte)0x8B, (byte)0xD1, (byte)0x25},
//         {(byte)0x72, (byte)0xF8, (byte)0xF6, (byte)0x64, (byte)0x86, (byte)0x68, (byte)0x98, (byte)0x16, (byte)0xD4, (byte)0xA4, (byte)0x5C, (byte)0xCC, (byte)0x5D, (byte)0x65, (byte)0xB6, (byte)0x92},
//         {(byte)0x6C, (byte)0x70, (byte)0x48, (byte)0x50, (byte)0xFD, (byte)0xED, (byte)0xB9, (byte)0xDA, (byte)0x5E, (byte)0x15, (byte)0x46, (byte)0x57, (byte)0xA7, (byte)0x8D, (byte)0x9D, (byte)0x84},
//         {(byte)0x90, (byte)0xD8, (byte)0xAB, (byte)0x00, (byte)0x8C, (byte)0xBC, (byte)0xD3, (byte)0x0A, (byte)0xF7, (byte)0xE4, (byte)0x58, (byte)0x05, (byte)0xB8, (byte)0xB3, (byte)0x45, (byte)0x06},
//         {(byte)0xD0, (byte)0x2C, (byte)0x1E, (byte)0x8F, (byte)0xCA, (byte)0x3F, (byte)0x0F, (byte)0x02, (byte)0xC1, (byte)0xAF, (byte)0xBD, (byte)0x03, (byte)0x01, (byte)0x13, (byte)0x8A, (byte)0x6B},
//         {(byte)0x3A, (byte)0x91, (byte)0x11, (byte)0x41, (byte)0x4F, (byte)0x67, (byte)0xDC, (byte)0xEA, (byte)0x97, (byte)0xF2, (byte)0xCF, (byte)0xCE, (byte)0xF0, (byte)0xB4, (byte)0xE6, (byte)0x73},
//         {(byte)0x96, (byte)0xAC, (byte)0x74, (byte)0x22, (byte)0xE7, (byte)0xAD, (byte)0x35, (byte)0x85, (byte)0xE2, (byte)0xF9, (byte)0x37, (byte)0xE8, (byte)0x1C, (byte)0x75, (byte)0xDF, (byte)0x6E},
//         {(byte)0x47, (byte)0xF1, (byte)0x1A, (byte)0x71, (byte)0x1D, (byte)0x29, (byte)0xC5, (byte)0x89, (byte)0x6F, (byte)0xB7, (byte)0x62, (byte)0x0E, (byte)0xAA, (byte)0x18, (byte)0xBE, (byte)0x1B},
//         {(byte)0xFC, (byte)0x56, (byte)0x3E, (byte)0x4B, (byte)0xC6, (byte)0xD2, (byte)0x79, (byte)0x20, (byte)0x9A, (byte)0xDB, (byte)0xC0, (byte)0xFE, (byte)0x78, (byte)0xCD, (byte)0x5A, (byte)0xF4},
//         {(byte)0x1F, (byte)0xDD, (byte)0xA8, (byte)0x33, (byte)0x88, (byte)0x07, (byte)0xC7, (byte)0x31, (byte)0xB1, (byte)0x12, (byte)0x10, (byte)0x59, (byte)0x27, (byte)0x80, (byte)0xEC, (byte)0x5F},
//         {(byte)0x60, (byte)0x51, (byte)0x7F, (byte)0xA9, (byte)0x19, (byte)0xB5, (byte)0x4A, (byte)0x0D, (byte)0x2D, (byte)0xE5, (byte)0x7A, (byte)0x9F, (byte)0x93, (byte)0xC9, (byte)0x9C, (byte)0xEF},
//         {(byte)0xA0, (byte)0xE0, (byte)0x3B, (byte)0x4D, (byte)0xAE, (byte)0x2A, (byte)0xF5, (byte)0xB0, (byte)0xC8, (byte)0xEB, (byte)0xBB, (byte)0x3C, (byte)0x83, (byte)0x53, (byte)0x99, (byte)0x61},
//         {(byte)0x17, (byte)0x2B, (byte)0x04, (byte)0x7E, (byte)0xBA, (byte)0x77, (byte)0xD6, (byte)0x26, (byte)0xE1, (byte)0x69, (byte)0x14, (byte)0x63, (byte)0x55, (byte)0x21, (byte)0x0C, (byte)0x7D}
//     };

//     // Constructor that receives round keys from App.java
//     public Decryptor(byte[][][] roundKeys) {
//         this.roundKeys = roundKeys;
//     }

//     // AES Decryption Function
//     public byte[][] decrypt(byte[][] state) {
//         // Initial round key addition
//         state = addRoundKey(state, roundKeys[10]);

//         // Main decryption rounds
//         for (int round = 9; round >= 1; round--) {
//             state = invShiftRows(state);
//             state = invSubBytes(state);
//             state = addRoundKey(state, roundKeys[round]);
//             state = invMixColumns(state);
//         }

//         // Final round (no MixColumns)
//         state = invShiftRows(state);
//         state = invSubBytes(state);
//         state = addRoundKey(state, roundKeys[0]);

//         return state;
//     }

//     // Inverse SubBytes
//     private byte[][] invSubBytes(byte[][] state) {
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 state[i][j] = invS_BOX[(state[i][j] & 0xF0) >> 4][state[i][j] & 0x0F];
//             }
//         }
//         return state;
//     }

//     // Inverse ShiftRows
//     private byte[][] invShiftRows(byte[][] state) {
//         byte temp;

//         // Row 1 (left circular shift by 1)
//         temp = state[1][3];
//         state[1][3] = state[1][2];
//         state[1][2] = state[1][1];
//         state[1][1] = state[1][0];
//         state[1][0] = temp;

//         // Row 2 (left circular shift by 2)
//         temp = state[2][0];
//         state[2][0] = state[2][2];
//         state[2][2] = temp;
//         temp = state[2][1];
//         state[2][1] = state[2][3];
//         state[2][3] = temp;

//         // Row 3 (left circular shift by 3)
//         temp = state[3][0];
//         state[3][0] = state[3][1];
//         state[3][1] = state[3][2];
//         state[3][2] = state[3][3];
//         state[3][3] = temp;

//         return state;
//     }

//     // Inverse MixColumns
//     private byte[][] invMixColumns(byte[][] state) {
//         for (int i = 0; i < 4; i++) {
//             byte[] temp = new byte[4];
//             temp[0] = (byte) (mul(0x0E, state[0][i]) ^ mul(0x0B, state[1][i]) ^ mul(0x0D, state[2][i]) ^ mul(0x09, state[3][i]));
//             temp[1] = (byte) (mul(0x09, state[0][i]) ^ mul(0x0E, state[1][i]) ^ mul(0x0B, state[2][i]) ^ mul(0x0D, state[3][i]));
//             temp[2] = (byte) (mul(0x0D, state[0][i]) ^ mul(0x09, state[1][i]) ^ mul(0x0E, state[2][i]) ^ mul(0x0B, state[3][i]));
//             temp[3] = (byte) (mul(0x0B, state[0][i]) ^ mul(0x0D, state[1][i]) ^ mul(0x09, state[2][i]) ^ mul(0x0E, state[3][i]));
//             for (int j = 0; j < 4; j++) {
//                 state[j][i] = temp[j];
//             }
//         }
//         return state;
//     }

//     // AddRoundKey
//     private byte[][] addRoundKey(byte[][] state, byte[][] roundKey) {
//         for (int i = 0; i < 4; i++) {
//             for (int j = 0; j < 4; j++) {
//                 state[i][j] ^= roundKey[i][j];
//             }
//         }
//         return state;
//     }

//     // Multiplication in GF(2^8)
//     private byte mul(int a, byte b) {
//         int p = 0;
//         int hiBitSet;
//         for (int counter = 0; counter < 8; counter++) {
//             if ((b & 1) != 0) {
//                 p ^= a;
//             }
//             hiBitSet = a & 0x80;
//             a <<= 1;
//             if (hiBitSet != 0) {
//                 a ^= 0x1B; // x^8 + x^4 + x^3 + x + 1
//             }
//             b >>= 1;
//         }
//         return (byte) p;
//     }
// }
package com.gju.computersec.aes;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Decrypt {
    private static final byte[][] INV_S_BOX = {
        {(byte)0x52, (byte)0x09, (byte)0x6A, (byte)0xD5, (byte)0x30, (byte)0x36, (byte)0xA5, (byte)0x38, (byte)0xBF, (byte)0x40, (byte)0xA3, (byte)0x9E, (byte)0x81, (byte)0xF3, (byte)0xD7, (byte)0xFB},
        {(byte)0x7C, (byte)0xE3, (byte)0x39, (byte)0x82, (byte)0x9B, (byte)0x2F, (byte)0xFF, (byte)0x87, (byte)0x34, (byte)0x8E, (byte)0x43, (byte)0x44, (byte)0xC4, (byte)0xDE, (byte)0xE9, (byte)0xCB},
        {(byte)0x54, (byte)0x7B, (byte)0x94, (byte)0x32, (byte)0xA6, (byte)0xC2, (byte)0x23, (byte)0x3D, (byte)0xEE, (byte)0x4C, (byte)0x95, (byte)0x0B, (byte)0x42, (byte)0xFA, (byte)0xC3, (byte)0x4E},
        {(byte)0x08, (byte)0x2E, (byte)0xA1, (byte)0x66, (byte)0x28, (byte)0xD9, (byte)0x24, (byte)0xB2, (byte)0x76, (byte)0x5B, (byte)0xA2, (byte)0x49, (byte)0x6D, (byte)0x8B, (byte)0xD1, (byte)0x25},
        {(byte)0x72, (byte)0xF8, (byte)0xF6, (byte)0x64, (byte)0x86, (byte)0x68, (byte)0x98, (byte)0x16, (byte)0xD4, (byte)0xA4, (byte)0x5C, (byte)0xCC, (byte)0x5D, (byte)0x65, (byte)0xB6, (byte)0x92},
        {(byte)0x6C, (byte)0x70, (byte)0x48, (byte)0x50, (byte)0xFD, (byte)0xED, (byte)0xB9, (byte)0xDA, (byte)0x5E, (byte)0x15, (byte)0x46, (byte)0x57, (byte)0xA7, (byte)0x8D, (byte)0x9D, (byte)0x84},
        {(byte)0x90, (byte)0xD8, (byte)0xAB, (byte)0x00, (byte)0x8C, (byte)0xBC, (byte)0xD3, (byte)0x0A, (byte)0xF7, (byte)0xE4, (byte)0x58, (byte)0x05, (byte)0xB8, (byte)0xB3, (byte)0x45, (byte)0x06},
        {(byte)0xD0, (byte)0x2C, (byte)0x1E, (byte)0x8F, (byte)0xCA, (byte)0x3F, (byte)0x0F, (byte)0x02, (byte)0xC1, (byte)0xAF, (byte)0xBD, (byte)0x03, (byte)0x01, (byte)0x13, (byte)0x8A, (byte)0x6B},
        {(byte)0x3A, (byte)0x91, (byte)0x11, (byte)0x41, (byte)0x4F, (byte)0x67, (byte)0xDC, (byte)0xEA, (byte)0x97, (byte)0xF2, (byte)0xCF, (byte)0xCE, (byte)0xF0, (byte)0xB4, (byte)0xE6, (byte)0x73},
        {(byte)0x96, (byte)0xAC, (byte)0x74, (byte)0x22, (byte)0xE7, (byte)0xAD, (byte)0x35, (byte)0x85, (byte)0xE2, (byte)0xF9, (byte)0x37, (byte)0xE8, (byte)0x1C, (byte)0x75, (byte)0xDF, (byte)0x6E},
        {(byte)0x47, (byte)0xF1, (byte)0x1A, (byte)0x71, (byte)0x1D, (byte)0x29, (byte)0xC5, (byte)0x89, (byte)0x6F, (byte)0xB7, (byte)0x62, (byte)0x0E, (byte)0xAA, (byte)0x18, (byte)0xBE, (byte)0x1B},
        {(byte)0xFC, (byte)0x56, (byte)0x3E, (byte)0x4B, (byte)0xC6, (byte)0xD2, (byte)0x79, (byte)0x20, (byte)0x9A, (byte)0xDB, (byte)0xC0, (byte)0xFE, (byte)0x78, (byte)0xCD, (byte)0x5A, (byte)0xF4},
        {(byte)0x1F, (byte)0xDD, (byte)0xA8, (byte)0x33, (byte)0x88, (byte)0x07, (byte)0xC7, (byte)0x31, (byte)0xB1, (byte)0x12, (byte)0x10, (byte)0x59, (byte)0x27, (byte)0x80, (byte)0xEC, (byte)0x5F},
        {(byte)0x60, (byte)0x51, (byte)0x7F, (byte)0xA9, (byte)0x19, (byte)0xB5, (byte)0x4A, (byte)0x0D, (byte)0x2D, (byte)0xE5, (byte)0x7A, (byte)0x9F, (byte)0x93, (byte)0xC9, (byte)0x9C, (byte)0xEF},
        {(byte)0xA0, (byte)0xE0, (byte)0x3B, (byte)0x4D, (byte)0xAE, (byte)0x2A, (byte)0xF5, (byte)0xB0, (byte)0xC8, (byte)0xEB, (byte)0xBB, (byte)0x3C, (byte)0x83, (byte)0x53, (byte)0x99, (byte)0x61},
        {(byte)0x17, (byte)0x2B, (byte)0x04, (byte)0x7E, (byte)0xBA, (byte)0x77, (byte)0xD6, (byte)0x26, (byte)0xE1, (byte)0x69, (byte)0x14, (byte)0x63, (byte)0x55, (byte)0x21, (byte)0x0C, (byte)0x7D}
    };

    private static final byte[][] INV_MIX_COLUMNS_MATRIX = {
        {(byte)0x0E, (byte)0x0B, (byte)0x0D, (byte)0x09},
        {(byte)0x09, (byte)0x0E, (byte)0x0B, (byte)0x0D},
        {(byte)0x0D, (byte)0x09, (byte)0x0E, (byte)0x0B},
        {(byte)0x0B, (byte)0x0D, (byte)0x09, (byte)0x0E}
    };

    private byte[][] state;

    public Decrypt(byte[][] state) {
        this.state = state;
    }

    public byte[][] decrypt(byte[][] input, byte[][] roundKeys) {
        addRoundKey(roundKeys[10]);
        
        for (int round = 9; round >= 1; round--) {
            invShiftRows();
            subBytes();
            addRoundKey(roundKeys[round]);
            invMixColumns();
        }
        
        invShiftRows();
        subBytes();
        addRoundKey(roundKeys[0]);
        
        return state;
    }

    private void addRoundKey(byte[] key) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] ^= key[i * 4 + j];
            }
        }
    }

    private void subBytes() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int row = (state[i][j] & 0xF0) >> 4;
                int col = state[i][j] & 0x0F;
                state[i][j] = INV_S_BOX[row][col];
            }
        }
    }

    private void invShiftRows() {
        byte[][] temp = new byte[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = state[i][(j - i + 4) % 4];
            }
        }
        state = temp;
    }

    private void invMixColumns() {
        byte[][] temp = new byte[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = (byte) (
                    xtime(state[0][j]) ^ xtime(state[1][j]) ^ state[2][j] ^ state[3][j]
                );
            }
        }
        state = temp;
    }

    private byte xtime(byte b) {
        return (b & 0x80) != 0 ? (byte) ((b << 1) ^ 0x1B) : (byte) (b << 1);
    }
}