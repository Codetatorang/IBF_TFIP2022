package ibf2022.tfip.sdf.task01.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[0];
        String dirPath = System.getProperty("user.dir");
        File file = new File(dirPath + File.separator + fileName + ".txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        // variables
        String readString, strippedString;
        Integer counts = 0;
        Integer totalwords = 0;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        try {
            while ((readString = br.readLine()) != null) {
                readString = readString.toLowerCase();
                strippedString = readString.replaceAll("\\p{Punct}", "");
                String[] wordArray = strippedString.split(" ");

                totalwords += wordArray.length;
                for (String word : wordArray) {
                    counts = wordMap.get(word);
                    if (null == counts) {
                        counts = 1;
                    } else {
                        counts += 1;
                    }
                    if (!word.isBlank())
                        wordMap.put(word, counts);
                }
            }

            // sort and print
            List<Map.Entry<String, Integer>> entrySetList = new LinkedList<Map.Entry<String, Integer>>(
                    wordMap.entrySet());
            // sort through the list
            Collections.sort(entrySetList, (map1, map2) -> map2.getValue().compareTo(map1.getValue()));

            // print out the top 10 results
            for (int i = 0; i < 10; i++) {
                Float termFreq = ((float) entrySetList.get(i).getValue() / totalwords);
                System.out.printf("word [%s] occured [%d] with a frequency count of [%.3f]\n", entrySetList.get(i).getKey(), entrySetList.get(i).getValue(),termFreq);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            br.close();
        }

    }
}
