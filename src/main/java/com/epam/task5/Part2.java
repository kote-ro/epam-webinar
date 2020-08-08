package com.epam.task5;

import java.io.*;
import java.util.logging.Logger;

public class Part2 {
    private static final Logger LOGGER = Logger.getLogger(Part2.class.getSimpleName());

    public static void main(final String[] args) {
        InputStream cachedIn = System.in;
        System.setIn(new DelayedLineSeparatorInputStream());
        Thread spam = new Thread(() -> Spam.main(null));
        spam.start();
        try {
            spam.join();
        } catch (InterruptedException e) {
            LOGGER.warning("The main thread was interrupted");
            Thread.currentThread().interrupt();
        } finally {
            System.setIn(cachedIn);
        }
    }

    private static class DelayedLineSeparatorInputStream extends InputStream {
        private static final int DELAY_MILLIS = 2000;
        private static final byte[] CONTENT = System.lineSeparator().getBytes();

        private int pointer = 0;

        @Override
        public int read() {
            if (pointer == 0) {
                sleep();
            }
            if (pointer == CONTENT.length) {
                return -1;
            }
            return Byte.toUnsignedInt(CONTENT[pointer++]);
        }

        private void sleep() {
            try {
                Thread.sleep(DELAY_MILLIS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // score is being reduced if the method has not been overridden
        // or overridden with delegating to super class
        @Override
        public int read(byte[] b, int off, int len) {
            if (b == null || b.length - off < len) {
                return 0;
            }

            int bytesCount = 0;
            for (int i = off; i < off + len; i++) {
                int next = read();
                if (next == -1) {
                    return bytesCount == 0 ? -1 : bytesCount;
                }
                b[i] = (byte)next;
                bytesCount++;
            }
            return bytesCount;
        }
    }

}
