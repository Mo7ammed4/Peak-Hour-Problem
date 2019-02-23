/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peakhour;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author mohammedalessa
 */
public class PeakHour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner s = new Scanner(new FileReader("peak.in"));
        int cases = s.nextInt();
        for (int counter = 1; counter <= cases; counter++) {
            int emails = s.nextInt();
            int frame = s.nextInt();
            HashMap map = new HashMap();
            for (int i = 0; i < emails; i++) {
                int temp = s.nextInt();
                if (map.containsKey(temp)) {
                    map.replace(temp, Integer.parseInt(map.get(temp).toString()) + 1);
                } else {
                    map.put(temp, 1);
                }
            }

            Set set = map.keySet();
            List keys = new ArrayList(set);
            Collections.sort(keys);
            int maxTP = 0;
            for (int i = 0; i < keys.size(); i++) {
                int max = (int) map.get(keys.get(i));
                int key = (int) keys.get(i);
                for (int frameCounter = 1; frameCounter < frame; frameCounter++) {
                    try {
                        int temp = (int) keys.get(i + frameCounter);
                        if (temp - key < frame) {
                            max += (int) map.get(temp);
                        } else {
                            continue;
                        }
                    } catch (Exception e) {

                    }

                }
                if (max > maxTP) {
                    maxTP = max;
                }
            }
            System.out.println(counter + " : " + maxTP);
        }
    }

}
