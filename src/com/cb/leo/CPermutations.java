package com.cb.leo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by god0725 on 2015/12/31.
 */
public class CPermutations {

    // print N! permutation of the characters of the string s (in order)
    public  static void perm1(String s) { perm1("", s); }
    public static String[] permPrefix(String word) {
        List<String> listPermPrefix = permPrefix("", word, new ArrayList<String>());
        String[] returnArray = listPermPrefix.toArray(new String[listPermPrefix.size()]);

        for(int i = 0; i < returnArray.length; i++){
            returnArray[i] = returnArray[i].replace("", " ");
            returnArray[i] = returnArray[i].substring(1, returnArray[i].length() - 1);
        }

        return returnArray;
    }
    private static void perm1(String prefix, String s) {
        int N = s.length();
        if (N == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < N; i++){
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
            }
        }

    }

    private static List<String> permPrefix(String prefix, String word, List<String> permList) {
        int N = word.length();
        if (N == 0) {
            permList.add(prefix);
        }
        else {
            for (int i = 0; i < N; i++){
                permPrefix(prefix + word.charAt(i), word.substring(0, i) + word.substring(i + 1, N), permList);
            }
        }

        return permList;
    }

    // print N! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++)
            a[i] = s.charAt(i);
        perm2(a, N);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1);
            swap(a, i, n-1);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    private static int[] moveForward(int[] word, int index){
        int[] returnWord = new int[word.length];
        for(int i = 0; i < returnWord.length; i++ ){
            if(i >= index){
                if(i == returnWord.length - 1){
                    returnWord[i] = 0;
                } else {
                    returnWord[i] = word[i+1];
                }
            } else {
                returnWord[i] = word[i];
            }
        }
        return returnWord;
    }
}
