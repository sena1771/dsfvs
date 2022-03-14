package com.company;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.ArrayList;

public class Main {
    static final Pattern REGEX = Pattern.compile("<(.+?)>"); //wrote between < and > because tags are like that
    public static void main(String[] args) {
        String html = """
                <!DOCTYPE html>
                    <html>
                          <head>
                              \s
                           <title>
                                Hello
                           </title>
                               </head>
                                  \s
                                 <body>
                               <h1> Sena </h1>
                                   </body>
                                     \s
                             </html>
                        """;  // write the html code here


        System.out.println(method_1(html));
        String a = String.valueOf(method_1(html)); //created new string which equals html tags

        String b= a.replaceAll("[/][a-z0-9,]*" ," "); //used regex for accessing the right html tgas

        String c=b.replaceAll("[,]"," ");  //removed commas
        System.out.println(c);

        String lastHtml = c.toLowerCase();
        String[] last1 = lastHtml.split("\\s"); //splitting the list to the words by \\s

         HashMap<String,Integer> counter = new HashMap<>(); //i will use the put method through the hashmap
 //counting process
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


        System.out.println("Number of the HTML Tags: " + counter);
    }

    static List <String> method_1(String html){
        List <String> value= new ArrayList<>();
        Matcher match=REGEX.matcher(html);
        while(match.find()){
            value.add(match.group(1)); }

      return value;
    }
  }


