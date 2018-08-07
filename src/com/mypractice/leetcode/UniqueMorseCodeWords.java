package com.mypractice.leetcode;


import java.util.*;

public class UniqueMorseCodeWords {

    private static Map<String, String> initMap = new HashMap<>();

    static {
        initMap.put("a", ".-");
        initMap.put("b", "-...");
        initMap.put("c", "-.-.");
        initMap.put("d", "-..");
        initMap.put("e", ".");
        initMap.put("f", "..-.");
        initMap.put("g", "--.");
        initMap.put("h", "....");
        initMap.put("i", "..");
        initMap.put("j", ".---");
        initMap.put("k", "-.-");
        initMap.put("l", ".-..");
        initMap.put("m", "--");
        initMap.put("n", "-.");
        initMap.put("o", "---");
        initMap.put("p", ".--.");
        initMap.put("q", "--.-");
        initMap.put("r", ".-.");
        initMap.put("s", "...");
        initMap.put("t", "-");
        initMap.put("u", "..-");
        initMap.put("v", "...-");
        initMap.put("w", ".--");
        initMap.put("x", "-..-");
        initMap.put("y", "-.--");
        initMap.put("z", "--..");
    }

    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg", "a"};
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        int i = uniqueMorseCodeWords.uniqueMorseRepresentations(words);
        System.out.println("i:" + i);
    }

    public int uniqueMorseRepresentations(String[] words){
        int count = 0;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++){
            StringBuilder newString = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++){
                newString.append(initMap.get(String.valueOf(words[i].charAt(j))));
            }
            list.add(newString.toString());
        }
        while (list.size() > 0){
            count++;
            List<String> sub = new LinkedList<>();
            sub.addAll(list.subList(1, list.size()));
            int i = 0;
            while (i < sub.size()){
                if (list.get(0).equals(sub.get(i))){
                    sub.remove(i);
                } else {
                    i++;
                }
            }
            if (sub.size() == 0){
                break;
            } else {
                list.clear();
                list.addAll(sub);
            }
        }
        return count;
    }

    public int otherUniqueMorseRepresentations(String[] words){
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> s = new HashSet<>();
        for (String word : words) {
            String code = "";
            for (char c : word.toCharArray()) {
                code += d[c - 'a'];
            }
            s.add(code);
        }
        return s.size();
    }
}
