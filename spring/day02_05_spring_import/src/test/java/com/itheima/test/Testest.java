package com.itheima.test;

import java.util.*;
public class Testest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请如数数据组数");
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<T; i++){
            System.out.println("清楚输入数据长度");
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            int[] len = new int[arr.length];
            for(int j = 0; j<arr.length;j++){
                len[j] = Integer.parseInt(arr[j]);
            }
            System.out.println("请输入str1:");
            String str1 = sc.next();
            System.out.println("请输入str2:");
            String str2 = sc.next();
            System.out.println("请输入str:");
            String str = sc.next();
            sc.nextLine();
            int count1 = count(str, str1);
            int count2 = count(str, str2);
            if(count1>count2){
                System.out.println(1);
            }else if(count2>count1){
                System.out.println(2);
            }else{
                System.out.println(-1);
            }
        }
    }
    public static  int count(String s, String key){
        int count = 0;
        int d = 0;
        while((d = s.indexOf(key, d))!=-1){
            s = s.substring(d+key.length());
            count++;
        }
        return count;
    }
}
