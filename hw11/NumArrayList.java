package numarraylist;

import java.util.*;
import java.io.*;

public class NumArrayList {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            Integer n = new Integer(rand.nextInt(10001));
            c.add(n);
        }
        Iterator itr = c.iterator();
        int i = 0;
        while (itr.hasNext()) {
            //Integer num = (Integer)itr.next();
            Integer num = (Integer)itr.next();
            if (num > 5000) {
                itr.remove();
            }
            i++;
        }
        Iterator itrOut = c.iterator();
        while (itrOut.hasNext()) {
            System.out.println(itrOut.next());
        }
    }
}