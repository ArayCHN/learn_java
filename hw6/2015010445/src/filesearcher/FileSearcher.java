package filesearcher;
import java.util.*;
import java.io.*;

public class FileSearcher {
    HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    boolean among26(char ch) { // if a character is among the 26 letters
        return (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z');
    }
    FileSearcher(String filename) {
        int tot = 0;
        try{
            Scanner input = new Scanner(new File(filename));
            // Scanner input = new Scanner(new File("dialog1.txt"),"UTF-8");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                tot += 1;
                //System.out.print(tot);
                // System.out.println(line);
                String word = "";
                int i = 0, j = 0;
                while (i < line.length() && !among26(line.charAt(i))) {
                    i ++;
                } // make sure i is now at the first actual character!
                while (i < line.length()) {
                    j = i;
                    while (j < line.length() && among26(line.charAt(j))) {
                        j ++;
                    }
                    word = line.substring(i, j).toLowerCase();
                    // if (word.length() == 2 && word.charAt(0) == 'w' && word.charAt(1) == 'e') {
                    //     System.out.println(line);
                    // }
                    if (wordCount.containsKey(word))
                        wordCount.put(word, wordCount.get(word) + 1);
                    else
                        wordCount.put(word, 1);
                    i = j;
                    while (i < line.length() && !among26(line.charAt(i))) {
                        i ++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error!" + e);
        }
    }
    int search(String w) {
        if (wordCount.containsKey(w))
            return wordCount.get(w);
        else
            return 0;
    }
}