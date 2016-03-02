package com.cb.leo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by god0725 on 2015/5/4.
 */
public class CCombinations {
    private int totalValues[];
    private int values[];
    private List<String> result = new ArrayList<String>();

    public void printComb(int fromNum, int toNum){

        this.totalValues = new int[fromNum];
        for(int i = 1; i <= fromNum; i++){
            this.totalValues[i - 1] = i;
        }
        this.values = new int[totalValues.length];

        for (int i = toNum; i <= toNum; i++) {
            System.out.print(comb(totalValues, values, i, fromNum, i));
        }
    }

    public void printComb(String[] fromNum, int toNum){

        String[] to = new String[fromNum.length];
        for (int i = toNum; i <= toNum; i++) {
            for(String child : comb(fromNum, to, i, fromNum.length, i)){
                result.add(child);
            }
        }

        for(String child : result){
            System.out.println(child);
        }

        result.clear();
    }

    public String[] permutationAndCombination(String[] AllColorBall, String[] winNum , int chooseCount, int winCount){

        if(isRepeat(winNum) || isRepeat(AllColorBall)){
            return null;
        }

        if(isNonexistence(AllColorBall, winNum)){
            return null;
        }

        String[] loseNum = getLoseNum(AllColorBall, winNum);

        return twoArrayCombin(getCombData(winNum, winCount), getCombData(loseNum, chooseCount - winCount));
    }

    public void storePermAndCombToTxt(String[] AllColorBall, String[] winNum , int chooseCount, int winCount){

        if(isRepeat(winNum) || isRepeat(AllColorBall)){
            System.out.println("重複彩球");
        }

        if(isNonexistence(AllColorBall, winNum)){
            System.out.println("中獎彩球不存在");
        }

        String[] loseNum = getLoseNum(AllColorBall, winNum);

        COutput.writeToTxt(getCombData(winNum, winCount), getCombData(loseNum, chooseCount - winCount));

    }

    public String[] twoArrayCombin(String[] first, String[] second){
        String[] returnArray = new String[first.length * second.length];
        System.out.println("共" + returnArray.length + "組");
        int i = 0;
        for(String child : first){
            for(String subChild : second){
                returnArray[i] = child + subChild;
                i++;
            }
        }

        return returnArray;
    }

    public String[] getCombData(String[] fromNum, int toNum){

        String[] to = new String[fromNum.length];

        for (int i = toNum; i <= toNum; i++) {
            for(String child : comb(fromNum, to, i, fromNum.length, i)){
                result.add(child);
            }
        }
        String[] returnArray = new String[result.size()];
        result.toArray(returnArray);
        result.clear();

        return returnArray;
    }

    public List<int[]> getCombData(int[] fromNum, int toNum){
        List<int[]> returnArray = new ArrayList<int[]>();
        int[] to = new int[fromNum.length];

        for(int[] child : combList(fromNum, to, toNum, fromNum.length, toNum)){
            returnArray.add(child);
        }

        return returnArray;
    }

    //組合 C(m, n) 結果存在List<String>
    private List<String> comb(String[] from, String[] to, int len, int m, int n) {
        List<String> returnArray = new ArrayList<String>();
        if (n == 0) {
            String tempResult = "";
            for (int i = 0; i < len; i++) {
                tempResult += to[i] + " ";
            }
            returnArray.add(tempResult);
        } else {
            to[n - 1] = from[m - 1];

            if (m > n - 1) {
                returnArray = comb(from, to, len, m - 1, n - 1);
            }
            if (m > n) {
                for(String child : comb(from, to, len, m - 1, n)){
                    returnArray.add(child);
                }
            }
        }
        return returnArray;
    }

    //組合 C(m, n) 結果存在List<int[]>
    private List<int[]> combList(int[] from, int[] to, int len, int m, int n) {
        List<int[]> returnArray = new ArrayList<int[]>();
        if (n == 0) {
            int[] tempResult = new int[len];
            System.arraycopy(to, 0, tempResult, 0, len);
            returnArray.add(tempResult);
        } else {
            to[n - 1] = from[m - 1];

            if (m > n - 1) {
                returnArray = combList(from, to, len, m - 1, n - 1);
            }
            if (m > n) {
                for(int[] child : combList(from, to, len, m - 1, n)){
                    returnArray.add(child);
                }
            }
        }
        return returnArray;
    }

    //組合 C(m, n) 直接將結果存成字串　
    private static String comb(int[] from, int[] to, int len, int m, int n) {
        String result = "";
        if (n == 0) {
            for (int i = 0; i < len; i++) {
                result += to[i] + " ";
            }
            result += "\n";
        } else {
            to[n - 1] = from[m - 1];

            if (m > n - 1) {
                result = comb(from, to, len, m - 1, n - 1);
            }
            if (m > n) {
                result = comb(from, to, len, m - 1, n) + result;
            }
        }
        return result;
    }

    private boolean isRepeat(String[] src){
        for(int i = 0; i < src.length; i++){
            for(int j = i + 1; j < src.length; j++){
                if(src[i].equals(src[j])){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNonexistence(String[] allBall, String[] winBall){
        int i = 0;

        for(String winChild : winBall){
            for(String allChild : allBall){
                if(winChild.equals(allChild)){
                    i++;
                }
            }
        }

        return winBall.length != i;
    }

    private String[] getLoseNum(String[] allBall, String[] winBall){
        String[] returnArray = new String[allBall.length - winBall.length];

        ArrayList<String> temp =  new ArrayList<String>(Arrays.asList(allBall));

        for(String child : winBall){
            int i = temp.indexOf(child);
            temp.remove(i);
        }

        temp.toArray(returnArray);
        temp.clear();

        return returnArray;
    }

}
