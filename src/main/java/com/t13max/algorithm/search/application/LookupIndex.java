package com.t13max.algorithm.search.application;

import java.util.HashMap;
import java.util.List;

/**
 * 索引和反向索引的查找
 *
 * @Author 呆呆
 * @Datetime 2021/9/18 22:19
 */
public class LookupIndex {
    public static void main(String[] args) {
        //In in=new In(args[0]);
        String sp = args[1];
        HashMap<String, List<String>> st = new HashMap<>();
        HashMap<String, List<String>> ts = new HashMap<>();
      /*  while (in.hasNext()) {
            String[] a = in.nextLine().split(sp);
            String key = a[0];
            for (int i = 0; i < a.length; i++) {
                String val = a[i];
                if (!st.containsKey(key)) st.put(key, new ArrayList<>());
                if (!ts.containsKey(val)) st.put(key, new ArrayList<>());
                st.get(key).add(val);
                ts.get(key).add(key);
            }
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            if (st.containsKey(query))
                for (String s :
                        st.get(query)) {
                    System.out.println(" " + s);
                }
            if (ts.containsKey(query))
                for (String s :
                        ts.get(query)) {
                    System.out.println(" " + s);
                }
        }*/
    }
}
