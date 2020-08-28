package com.gsd.sreenidhi.arachnid.utils;

/**
 * @author sreenidhi.gsd@gmail.com
 */
public abstract class NumberUtils {

    public static int compareLong(long o1, long o2) {
        if (o1 < o2) {
            return -1;
        } else if (o1 == o2) {
            return 0;
        } else {
            return 1;
        }
    }
}
