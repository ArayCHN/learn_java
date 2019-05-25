package numtreeset;

import java.util.*;
import java.io.*;

public class NumTreeSet {
    public static void main(String[] args) {
        Random rand = new Random();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < 100; i ++) {
            Integer randn = new Integer(rand.nextInt(101));
            set.add(randn);
        }
        int tot = 0;
        for (Integer num: set) {
            System.out.println(num);
            tot ++;
        }
        System.out.println("total number of distinct numbers:" + String.valueOf(tot));
    }
}