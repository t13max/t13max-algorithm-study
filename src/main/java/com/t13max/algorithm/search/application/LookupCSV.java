package com.t13max.algorithm.search.application;

import java.util.HashMap;

/**
 * 字典的查找
 *
 * @Author 呆呆
 * @Datetime 2021/9/18 22:13
 */
public class LookupCSV {
    public static void main(String[] args) {
        //In in=new In(args[0]);
        int keyField=Integer.parseInt(args[1]);
        int valueField=Integer.parseInt(args[2]);
        HashMap<String,String> st=new HashMap<>();
       /* while (in.hasNextline()){
            String line=in.readLine();
            String[] tokens=line.split(",");
            String key=tokens[keyField];
            String value=tokens[valueField];
            st.put(key,value);
        }

        while(!StdIn.isEmpty()){
            String query=StdIn.readString();
            if(st.containsKey(query)){
                System.out.println(st.get(query));
            }
        }*/
    }
}
