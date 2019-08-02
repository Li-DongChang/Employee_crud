package com.qdu.test;

import java.util.HashMap;
import java.util.Map;

/**
* @author lidcha
* @createDate ：2019年7月29日
*/
public class Test1 {
	public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        int res=0;
        int i=0;
        int len = s.length();
        int x1,x2;
        while(i<len){
            x1 = map.get(s.charAt(i));
            if(i==len-1)
                x2=0;
            else
                x2 = map.get(s.charAt(i+1));
            if(x1>=x2){
                res+=x1;
            }else{
                res-=x1;
            }
            i++;
        }
      return res;  
    }
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append(123321);
		sb.reverse();
		String str = 123321+"";
		System.out.println(str.equals(sb.toString()));
	}

}
