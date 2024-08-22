package com.gju.computersec.aes;

public class Test {

    private static final int[] MULT_2 = new int[256];
    private static final int[] MULT_3 = new int[256];

    static {
        for (int i = 0; i < 256; i++) {
            MULT_2[i] = xtime(i);
            MULT_3[i] = MULT_2[i] ^ i;
        }
    }

    private static int xtime(int x) {
        return ((x << 1) & 0xFF) ^ (((x >> 7) & 1) * 0x1B);
    }

    public static void mixColumns(byte[][] state) {
        for (int c = 0; c < 4; c++) {
            int[] a = new int[4];
            int[] b = new int[4];

            // Copy state column to temporary arrays
            for (int i = 0; i < 4; i++) {
                a[i] = state[i][c] & 0xFF;  // Convert byte to int (unsigned)
                b[i] = (a[i] << 1) & 0xFF;  // Left shift by 1 (xtime)
                if ((a[i] & 0x80) != 0) {  // If MSB is set
                    b[i] ^= 0x1B;  // XOR with the AES polynomial (x^8 + x^4 + x^3 + x + 1)
                }
            }

            // Perform the mixColumns transformation
            state[0][c] = (byte) (b[0] ^ a[1] ^ b[1] ^ a[2] ^ a[3]);
            state[1][c] = (byte) (a[0] ^ b[1] ^ a[2] ^ b[2] ^ a[3]);
            state[2][c] = (byte) (a[0] ^ a[1] ^ b[2] ^ a[3] ^ b[3]);
            state[3][c] = (byte) (a[0] ^ b[0] ^ a[1] ^ a[2] ^ b[3]);
        }
    }

    public static byte[][] transpose(byte[][] matrix) {
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new IllegalArgumentException("Matrix must be 4x4.");
        }

        byte[][] transposed = new byte[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }
    public static void main(String[] args) {
        // Example state matrix
        byte[][] state = {
                {(byte)0x97, (byte)0x96, (byte)0x5f, (byte)0xef},
                {(byte)0x4b, (byte)0xf5, (byte)0xf8, (byte)0x4c},
                {(byte)0x2d, (byte)0xeb, (byte)0x65, (byte)0x50},
                {(byte)0xdb, (byte)0x5a, (byte)0x54, (byte)0xad}
        };
        state = transpose(state);
        mixColumns(state);
        state = transpose(state);
        // Print the transformed state matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%02X ", state[i][j]);
            }
            System.out.println();
        }
    }
}
