package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.ArrayList;

public class Main {
    static final Pattern REGEX = Pattern.compile("<(.+?)>"); //wrote between < and > because tags are like that
    public static void main(String[] args) {
         //translating html file to the string and reading file
        StringBuilder my = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("Untitled-1.html"));
            String str;
            while ((str = in.readLine()) != null) {
                my.append(str);
            }
            in.close();
        } catch (IOException e) {

        }
        String html = my.toString();



        System.out.println(method_1(html));
        String a = String.valueOf(method_1(html)); //created new string which equals html tags

        String b= a.replaceAll("[/][a-z0-9,]*" ," ");

        String c=b.replaceAll("[=][\"].+?[,]", " "); //for attributes
        System.out.println(c);
        String d=c.replaceAll("[,]"," ");//removed commas
        System.out.println(d);

        String lastHtml = d.toLowerCase();
        String[] last1 = lastHtml.split("\\s"); //splitting the list to the words by \\s

        HashMap<String,Integer> counter = new HashMap<>(); //i will use the put method through the hashmap
          //counting the number of each html tag
        for (int i = 0; i < last1.length -1; i++) {

            int Count = 0;

            for (int j = 0; j < last1.length - 1; j++) {
                if (last1[j].equals(last1[i])) {
                    Count++;
                }

                if(last1[i].equals("html")){
                    Count=1;

                }
            }


            counter.put(last1[i], Count);
            counter.remove(""); //removed number of the different tags

        }


        System.out.println("Number of the HTML Tags and Attributes: " + counter);
    }

    static List <String> method_1(String html){
        List <String> value= new ArrayList<>();
        Matcher match=REGEX.matcher(html);
        while(match.find()){
            value.add(match.group(1)); }

        return value;
    }
}

