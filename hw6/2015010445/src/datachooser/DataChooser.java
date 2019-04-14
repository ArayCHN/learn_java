package datachooser;

import java.io.*;
import java.util.*;

public class DataChooser {
    DataChooser(String inputFile, String outputFile) {
        try{
            Scanner input = new Scanner(new File(inputFile));
            File f = new File(outputFile);
                PrintStream out = new PrintStream(f);
                int startIndex = 0, endIndex = 0;
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    int tot = 0, i = 0;
                    while (line.charAt(i) != ',' || tot < 3) {
                        i ++;
                        if (line.charAt(i - 1) == ',') {
                            tot ++;
                            if (tot == 3)
                                startIndex = i;
                        }
                    }
                    endIndex = i;
                    // System.out.println(endIndex);
                    // System.out.println(line);
                    String department = line.substring(startIndex, endIndex);
                    out.println(department);
                    //System.out.println(department);
                }
        } catch (Exception e) {
            System.out.println("Error: Input or output file not found!");
        }
    }
}