package numhashset;

import java.util.*;
import java.io.*;

public class NumHashSet {
    public static void main(String[] args) {
        HashMap<Character, Character> code = new HashMap<Character, Character>();
        String keys =      "veknohzfaljxdmygbrcswquptiVEKNOHZFALJXDMYGBRCSWQUPTI ";
        String realValue = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        for (int i = 0; i < 53; i ++)
            code.put(keys.charAt(i), realValue.charAt(i));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            try {
                s = br.readLine();
            }
            catch(Exception e) {
                break;
            }
            if (s == null || s.isEmpty())
                break;
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                ans += (code.get(s.charAt(i)));
            }
            System.out.println(ans);
        }
    }
}