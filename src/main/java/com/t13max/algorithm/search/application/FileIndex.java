package com.t13max.algorithm.search.application;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 文件索引
 *
 * @Author 呆呆
 * @Datetime 2021/9/18 22:26
 */
public class FileIndex {
    public static void main(String[] args) {
        HashMap<String, HashSet<File>> st = new HashMap<>();
       /* for (String filename : args) {
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.containsKey(word)) st.put(word, new HashSet<File>());
                HashSet<File> set = st.get(word);
                set.add(file);
            }
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.containsKey(query))
                for (File file :
                        st.get(query)) {
                    System.out.println(" " + file.getName());
                }
        }*/
    }
}
