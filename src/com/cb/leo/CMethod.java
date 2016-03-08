package com.cb.leo;

import java.io.*;
import java.util.*;

/**
 * Created by god0725 on 2015/5/4.
 */
public class CMethod {

    private int totalValues[];
    private int values[];
    private List<String> result = new ArrayList<String>();

    public int calculateComb(int total, int param){
        return combNum(total, param);
    }

    public double calculateLottoProbalility(int totalBallNum, int winBallNum, int chooseNum, int gotNum){
        int allCombinations = 0;
        int winCombinations = 0;

        allCombinations = calculateComb(totalBallNum, chooseNum);

        winCombinations = calculateComb(winBallNum, gotNum) * calculateComb(totalBallNum - winBallNum, chooseNum - gotNum);

        return (double)winCombinations / allCombinations;
    }

    public String[] totalBallsDrawNGetR(String[] allBalls, int winBallNum, String[] chooseNum, int gotNum){
        List<String> returnResult = new ArrayList<String>();

        String[] WinBallNum = printComb3(allBalls , winBallNum);

        for(String child : WinBallNum){
            String[] subWinBall = child.split(" ");

            int count = 0;
            for(String chooseBall : chooseNum){
                for(String winBall : subWinBall){
                    if(chooseBall.equals(winBall)){
                        count++;
                    }
                }
            }

            if(count == gotNum){
                returnResult.add(child);
            }
        }

        String[] returnArray = returnResult.toArray(new String[returnResult.size()]);
        returnResult.clear();
        return returnArray;
    }

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

    public void printComb2(String[] fromNum, int toNum){

        String[] to = new String[fromNum.length];
        for (int i = toNum; i <= toNum; i++) {
            List<String> tempResult = comb2(fromNum, to, i, fromNum.length, i);
            for(String child : tempResult){
                result.add(child);
            }
            tempResult.clear();
        }

        for(String child : result){
            System.out.println(child);
        }
        System.out.println("共" + result.size() + "筆");
    }

    public String[] printComb3(String[] fromNum, int toNum){
        List<String> returnResult = new ArrayList<String>();
        String[] to = new String[fromNum.length];
        for (int i = toNum; i <= toNum; i++) {
            List<String> tempResult = comb2(fromNum, to, i, fromNum.length, i);
            for(String child : tempResult){
                returnResult.add(child);
            }
            tempResult.clear();
        }

        return returnResult.toArray(new String[returnResult.size()]);
    }

    public List<int[]> printComb4(int[] fromNum, int toNum){
        List<int[]> returnResult = new ArrayList<int[]>();
        int[] to = new int[fromNum.length];
        for (int i = toNum; i <= toNum; i++) {
            List<int[]> tempResult = combWithResult(fromNum, to, i, fromNum.length, i);
            for(int[] child : tempResult){
                returnResult.add(child);
            }
            tempResult.clear();
        }

        return returnResult;
    }

    private static int combNum(int m, int n){
        int result = 0;
        if (n == 0) {
            result++;
        } else {
            if (m > n - 1) {
                result = combNum(m - 1, n - 1);
            }
            if (m > n) {
                result += combNum(m - 1, n);
            }
        }
        return result;
    }

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

    private List<String> comb2(String[] from, String[] to, int len, int m, int n) {
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
                returnArray = comb2(from, to, len, m - 1, n - 1);
            }
            if (m > n) {
                for(String child : comb2(from, to, len, m - 1, n)){
                    returnArray.add(child);
                }
            }
        }
        return returnArray;
    }

    private List<int[]> combWithResult(int[] from, int[] to, int len, int m, int n) {
        List<int[]> returnArray = new ArrayList<int[]>();
        if (n == 0) {
            int[] tempResult = new int[len];
            System.arraycopy(to, 0, tempResult, 0, len);
            returnArray.add(tempResult);
        } else {
            to[n - 1] = from[m - 1];

            if (m > n - 1) {
                returnArray = combWithResult(from, to, len, m - 1, n - 1);
            }
            if (m > n) {
                for(int[] child : combWithResult(from, to, len, m - 1, n)){
                    returnArray.add(child);
                }
            }
        }
        return returnArray;
    }

    public void writerTxt(String[] src){
        BufferedWriter fw = null;
        try {

            File file = new File("c://text.txt");

            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常
            fw.append("結果:");
            fw.newLine();

            int i = 0;
            for(String child : src){
                fw.append(child + " | ");
                i++;
                if(i == 5){
                    i = 0;
                    fw.newLine();
                }
            }

            fw.flush(); // 全部寫入緩存中的內容

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            if (fw != null) {

                try {

                    fw.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

        }
    }

    //PK系列 - 龍虎(取前X與後X)和數
    public int PKTigerAndDragonTieCount(int Num, int compareCount){
        String[] srcStrArr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] result1 = printComb3(srcStrArr, 3);
        int count = 0;
        for(String child : result1){
            String[] childArr = child.split(" ");
            int childSum = 0;
            List<String> srcStrList = new ArrayList<String>(Arrays.asList(srcStrArr));
            for (String subChild : childArr){
                childSum += Integer.parseInt(subChild);
                srcStrList.remove(subChild);
            }
            String[] result2 = printComb3(srcStrList.toArray(new String[srcStrList.size()]), 3);
            for(String subChild : result2){
                int subChildSum = 0;
                String[] subChildArr = subChild.split(" ");
                for(String tempChild : subChildArr){
                    subChildSum += Integer.parseInt(tempChild);
                }
                if(childSum == subChildSum){
                    System.out.println(child + " vs " + subChild);
                    count++;
                }
            }
        }
        return count;
    }

    //PK前三後三和
    public int threeNumSum(int firstNum, int lastNum){
        String[] srcStrArr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] result1 = printComb3(srcStrArr, 3);
        int count = 0;
        for(String child : result1){
            String[] childArr = child.split(" ");
            int childSum = 0;
            List<String> srcStrList = new ArrayList<String>(Arrays.asList(srcStrArr));
            for (String subChild : childArr){
                childSum += Integer.parseInt(subChild);
                srcStrList.remove(subChild);
            }
            String[] result2 = printComb3(srcStrList.toArray(new String[srcStrList.size()]), 3);
            for(String subChild : result2){
                int subChildSum = 0;
                String[] subChildArr = subChild.split(" ");
                for(String tempChild : subChildArr){
                    subChildSum += Integer.parseInt(tempChild);
                }
                if(childSum == subChildSum){
                    System.out.println(child + " vs " + subChild);
                    count++;
                }
            }
        }
        return count;
    }

    //總和組數
    public int NumSum(String[] allBallsNum, int totalValue, int sumBallsCount, boolean isPrint){
        String[] result = printComb3(allBallsNum, sumBallsCount);
        int count = 0;
        for(String child : result){
            String[] childArr = child.split(" ");
            int childSum = 0;
            for (String subChild : childArr){
                childSum += Integer.parseInt(subChild);
            }
            if(totalValue == childSum){
                if(isPrint) {
                    System.out.println(child + " sum :" + totalValue);
                }
                count++;
            }
        }

        return count;
    }

    //百變王牌總和大小和組數
    public String[] VarietyAceNumSumBS(String[] allBallsNum, int totalValue, int sumBallsCount){
        double sumBS = 0.0d;
        String[] returnResult = new String[10];

        int count = NumSum(allBallsNum, totalValue, sumBallsCount, false);
        String[] result = printComb3(allBallsNum, sumBallsCount);

        sumBS = ((double)result.length - (double)count) / 2;

        returnResult[0] = "組合總數量:" + result.length;
        returnResult[1] = "中獎數量-大:" + sumBS;
        returnResult[2] = "機率-大:" + String.valueOf((sumBS / (double)result.length));
        returnResult[3] = "賠率-大:" + String.valueOf(((double)result.length / sumBS));
        returnResult[4] = "中獎數量-小:" + sumBS;
        returnResult[5] = "機率-小:" + String.valueOf((sumBS / (double)result.length));
        returnResult[6] = "賠率-小:" + String.valueOf(((double)result.length / sumBS));
        returnResult[7] = "中獎數量-和:" + count;
        returnResult[8] = "機率-和:" + String.valueOf(((double)count / (double)result.length));
        returnResult[9] = "賠率-和:" + String.valueOf(((double)result.length / (double)count));

        return returnResult;
    }

    //百變王牌總和過關組數
    public String[] VarietyAceNumSumBSOE(String[] allBallsNum, int sumBallsCount){
        String[] returnResult = new String[16];
        double sumBO, sumBE, sumSO, sumSE, sumTie;
        sumBO = 0.0d;
        sumBE = 0.0d;
        sumSO = 0.0d;
        sumSE = 0.0d;
        sumTie = 0.0d;
        String[] result = printComb3(allBallsNum, sumBallsCount);

        for(int i = 21; i < 64; i++){
            if(i < 42){
                if(i % 2 == 0){
                    sumSE += NumSum(allBallsNum, i, sumBallsCount, false);
                } else {
                    sumSO += NumSum(allBallsNum, i, sumBallsCount, false);
                }
            } else if(i > 42){
                if(i % 2 == 0){
                    sumBE += NumSum(allBallsNum, i, sumBallsCount, false);
                } else {
                    sumBO += NumSum(allBallsNum, i, sumBallsCount, false);
                }
            } else {
                sumTie += NumSum(allBallsNum, i, sumBallsCount, false);
            }
        }

        returnResult[0] = "組合總數量:" + result.length;
        returnResult[1] = "中獎數量-和:" + sumTie;
        returnResult[2] = "機率-和:" + String.valueOf((sumTie / (double)result.length));
        returnResult[3] = "賠率-和:" + String.valueOf(((double)result.length / sumTie));

        returnResult[4] = "中獎數量-大單:" + sumBO;
        returnResult[5] = "機率-大單:" + String.valueOf((sumBO / (double)result.length));
        returnResult[6] = "賠率-大單:" + String.valueOf(((double)result.length / sumBO));

        returnResult[7] = "中獎數量-大雙:" + sumBE;
        returnResult[8] = "機率-大雙:" + String.valueOf((sumBE / (double)result.length));
        returnResult[9] = "賠率-大雙:" + String.valueOf(((double)result.length / sumBE));

        returnResult[10] = "中獎數量-小單:" + sumSO;
        returnResult[11] = "機率-小單:" + String.valueOf((sumSO / (double)result.length));
        returnResult[12] = "賠率-小單:" + String.valueOf(((double)result.length / sumSO));

        returnResult[13] = "中獎數量-小雙:" + sumSE;
        returnResult[14] = "機率-雙小:" + String.valueOf((sumSE / (double)result.length));
        returnResult[15] = "賠率-雙小:" + String.valueOf(((double)result.length / sumSE));

        return returnResult;
    }

    //百變王牌總和單雙組數
    public String[] VarietyAceNumSumOE(String[] allBallsNum, int sumBallsCount){
        String[] returnResult = new String[7];
        int sumO = 0;
        int sumE = 0;
        for(int i = 21; i < 64; i++){
            if(i % 2 == 0){
                sumE += NumSum(allBallsNum, i, sumBallsCount, false);
            } else {
                sumO += NumSum(allBallsNum, i, sumBallsCount, false);
            }
        }
        String[] result = printComb3(allBallsNum, sumBallsCount);

        returnResult[0] = "組合總數量:" + result.length;
        returnResult[1] = "中獎數量-單:" + sumO;
        returnResult[2] = "機率-單:" + String.valueOf(((double)sumO / (double)result.length));
        returnResult[3] = "賠率-單:" + String.valueOf(((double)result.length / (double)sumO));
        returnResult[4] = "中獎數量-雙:" + sumE;
        returnResult[5] = "機率-雙:" + String.valueOf(((double)sumE / (double)result.length));
        returnResult[6] = "賠率-雙:" + String.valueOf(((double)result.length / (double)sumE));

        return returnResult;
    }

    //百變王牌總和單雙組數
    public String[] VarietyAceNumSumSBS(String[] allBallsNum, int sumBallsCount){
        String[] returnResult = new String[7];
        int sumSB = 0;
        int sumSS = 0;
        for(int i = 21; i < 64; i++){
            if(i % 10 < 5){
                sumSS += NumSum(allBallsNum, i, sumBallsCount, false);
            } else {
                sumSB += NumSum(allBallsNum, i, sumBallsCount, false);
            }
        }
        String[] result = printComb3(allBallsNum, sumBallsCount);

        returnResult[0] = "組合總數量:" + result.length;
        returnResult[1] = "中獎數量-尾小:" + sumSS;
        returnResult[2] = "機率-尾小:" + String.valueOf(((double)sumSS / (double)result.length));
        returnResult[3] = "賠率-尾小:" + String.valueOf(((double)result.length / (double)sumSS));
        returnResult[4] = "中獎數量-尾大:" + sumSB;
        returnResult[5] = "機率-尾大:" + String.valueOf(((double)sumSB / (double)result.length));
        returnResult[6] = "賠率-尾大:" + String.valueOf(((double)result.length / (double)sumSB));

        return returnResult;
    }

    //PK10 N中R的機率與賠率 (用英文大寫代號)
    public String[] PK10NgetR(String[] result, int R){
        String[] returnResult = new String[4];
        int NgetRCount = 0;

        String[] allBall = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] allComb = new CMethod().printComb3(allBall, result.length);
        List<String> allPerm = new ArrayList<String>();
        for(String child : allComb){
            List<String> temp = CPermutations.permPrefix(child.replace(" ", ""));
            for(String subChild : temp){
                allPerm.add(subChild);
            }
            temp.clear();
        }

        List<String[]> allPermSplit = new ArrayList<String[]>();
        for(String child : allPerm){
            String[] tempStr = new String[child.length()];
            for(int i = 0; i < child.length(); i++){
                tempStr[i] = child.substring(i, i+1);
            }
            allPermSplit.add(tempStr);
        }

        for(String[] child : allPermSplit){
            int i = 0;
            for(int x = 0; x < result.length; x++){
                if(result[x].equals(child[x])){
                    i++;
                }
            }
            if(i == R){
                NgetRCount++;
            }
        }

        returnResult[0] = "總數量:" + allPerm.size();
        returnResult[1] = "中獎數量:" + NgetRCount;
        returnResult[2] = "機率:" + String.valueOf(((double)NgetRCount / (double)allPerm.size()));
        returnResult[3] = "賠率:" + String.valueOf(((double)allPerm.size() / (double)NgetRCount));
        return returnResult;
    }

    //N中R的機率與賠率 (用英文大寫代號) 位置同
    public String[] VarietyAceNgetR(String[] allBall, int WinBalls, String[] result){
        String[] returnResult = new String[4];
        int total = 0;
        String[] allComb = new CMethod().printComb3(allBall, WinBalls);
        List<String> allPerm = new ArrayList<String>();
        for(String child : allComb){
            String[] tempChild = child.split(" ");

            boolean wrong = false;
            for(int i = 0; i < result.length; i++){
                if(!tempChild[i].equals(result[i])){
                    wrong = true;
                }
            }
            if(wrong){
                continue;
            }

            for(String Str : result){
                child = child.replace(Str, "");
            }
            List<String> temp = CPermutations.permPrefix(child.replace(" ", ""));
            for(String subChild : temp){
                allPerm.add(result[0] + subChild);
            }
            temp.clear();
        }

        total = allComb.length;
        for(int i = 1; i <= WinBalls; i++){
            total *= i;
        }

        returnResult[0] = "總數量:" + total;
        returnResult[1] = "中獎數量:" + allPerm.size();
        returnResult[2] = "機率:" + String.valueOf(((double)allPerm.size() / (double)total));
        returnResult[3] = "賠率:" + String.valueOf(((double)total / (double)allPerm.size()));
        return returnResult;
    }

    //N中R的機率與賠率 (用英文大寫代號) 位置同
    public objResult VarietyAceNgetR2(String[] allBalls, int WinBalls, String[] chooseBalls, int S){

        objResult returnObj = new objResult();
        if(S == 1){
            List<String> resultPerm = new ArrayList<String>();
            List<String> allPerm = new ArrayList<String>();
            String[] allComb = printComb3(allBalls, WinBalls);

            for(String subComb : allComb){

                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for(String tempPerm : perm){
                    allPerm.add(tempPerm);
                }
                perm.clear();

                boolean wrong = false;
                for(String chooseBall : chooseBalls){
                    if(!subComb.contains(chooseBall)){
                        wrong = true;
                    }
                }
                if(wrong){
                    continue;
                }

                String beforeBall = "";
                for(String chooseBall : chooseBalls){
                    beforeBall += chooseBall;
                }
                for(String chooseBall : chooseBalls){
                    subComb = subComb.replace(chooseBall + " ", "");
                }
                perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for(String subChild : perm){
                    resultPerm.add(beforeBall + subChild);
                }
                perm.clear();
            }

            returnObj.setWinComb(resultPerm.toArray(new String[resultPerm.size()]));
            returnObj.setAllComb(allPerm.toArray(new String[allPerm.size()]));
            resultPerm.clear();
            allPerm.clear();
            return returnObj;
        } else if(S == 2){
            List<String> resultPerm = new ArrayList<String>();
            List<String> allPerm = new ArrayList<String>();

            String chooseBallsStr = Arrays.toString(chooseBalls).replaceAll("\\[", "").replaceAll("\\]", "").replace(",","").replace(" ", "");
            String remBalls = removeUsedBalls(allBalls, Arrays.toString(chooseBalls).replaceAll("\\[", "").replaceAll("\\]", "").replace(",",""));
            String[] allComb = printComb3(remBalls.split(" "), WinBalls - chooseBalls.length - 1);

            for(String subComb : allComb){
                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for(String tempPerm : perm){
                    tempPerm = tempPerm.replace("", " ").substring(1);
                    String notUsedBalls = removeUsedBalls(remBalls.split(" "), tempPerm);
                    for(String notUsedBall : notUsedBalls.split(" ")){
                        resultPerm.add(chooseBallsStr + tempPerm.replace(" ", "") + notUsedBall);
                    }
                }
                perm.clear();
            }

            allComb = printComb3(remBalls.split(" "), WinBalls - chooseBalls.length);
            for(String subComb : allComb){
                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for(String tempPerm : perm){
                    tempPerm = tempPerm.replace("", " ").substring(1);
                    String notUsedBalls = removeUsedBalls(remBalls.split(" "), tempPerm);
                    for(String notUsedBall : notUsedBalls.split(" ")){
                        resultPerm.add(chooseBallsStr + tempPerm.replace(" ", "") + notUsedBall);
                    }
                }
                perm.clear();
            }

            allComb = printComb3(allBalls, WinBalls);
            for(String subComb : allComb) {

                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for (String tempPerm : perm) {
                    allPerm.add(tempPerm);
                }
                perm.clear();
            }

            returnObj.setWinComb(resultPerm.toArray(new String[resultPerm.size()]));
            returnObj.setAllComb(allPerm.toArray(new String[allPerm.size()]));
            resultPerm.clear();
            allPerm.clear();
            return returnObj;
        } else if(S == 3){
            List<String> resultPerm = new ArrayList<String>();
            List<String> allPerm = new ArrayList<String>();

            String chooseBallsStr = Arrays.toString(chooseBalls).replaceAll("\\[", "").replaceAll("\\]", "").replace(",","").replace(" ", "");
            String remBalls = removeUsedBalls(allBalls, Arrays.toString(chooseBalls).replaceAll("\\[", "").replaceAll("\\]", "").replace(",",""));
            String[] allComb = printComb3(remBalls.split(" "), WinBalls - 2);

            for(String subComb : allComb){
                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for(String tempPerm : perm){
                    tempPerm = tempPerm.replace("", " ").substring(1);
                    String notUsedBalls = removeUsedBalls(remBalls.split(" "), tempPerm);
                    for(String notUsedBall : notUsedBalls.split(" ")){
                        resultPerm.add(chooseBallsStr + tempPerm.replace(" ", "") + notUsedBall);
                    }
                }
                perm.clear();
            }

            allComb = printComb3(remBalls.split(" "), WinBalls - 1);
            for(String subComb : allComb){
                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for(String tempPerm : perm){
                    tempPerm = tempPerm.replace("", " ").substring(1);
                    String notUsedBalls = removeUsedBalls(remBalls.split(" "), tempPerm);
                    for(String notUsedBall : notUsedBalls.split(" ")){
                        resultPerm.add(chooseBallsStr + tempPerm.replace(" ", "") + notUsedBall);
                    }
                }
                perm.clear();
            }

            allComb = printComb3(allBalls, WinBalls);
            for(String subComb : allComb) {

                List<String> perm = CPermutations.permPrefix(subComb.replace(" ", ""));
                for (String tempPerm : perm) {
                    allPerm.add(tempPerm);
                }
                perm.clear();
            }

            returnObj.setWinComb(resultPerm.toArray(new String[resultPerm.size()]));
            returnObj.setAllComb(allPerm.toArray(new String[allPerm.size()]));
            resultPerm.clear();
            allPerm.clear();
            return returnObj;
        } else {

            return returnObj;
        }

    }

    //N中R的機率與賠率 (用英文大寫代號) 1:一般 2:大王 3:小王
    public objResult VarietyAceAnyNgetR(String[] allBalls, int winBallCount, String[] chooseNum, int gotNum, int S) {
        List<String> returnResult = new ArrayList<String>();
        objResult returnObj = new objResult();
        if(S == 1){
            returnObj.setWinComb(totalBallsDrawNGetR(allBalls, winBallCount, chooseNum, gotNum));
            returnObj.setAllComb(printComb3(allBalls, winBallCount));
            return returnObj;
        } else if(S == 2){
            //總彩球 A 個, 抽出 N 個, 中 R 個;

            //中獎數
            //從 A 中取 N - 1 個,中 R 個的數量, 與從 A - (N - 1) 中全取沒中的數量的組合數
            String[] first = totalBallsDrawNGetR(allBalls, winBallCount - 1, chooseNum, gotNum);
            for(String winBalls : first){
                for(String child : allBalls){
                    if(!winBalls.contains(child)){
                        returnResult.add(winBalls + child);
                    }
                }
            }
            //中獎數
            //從 A 中取 N - 1 個,中 R - 1 個的數量, 與從 A - (N - 1) 中取 8 個,中 1 個的數量的組合數
            String[] combChooseNum = printComb3(chooseNum, chooseNum.length - 1);
            for(String combChoose : combChooseNum){
                String notUsedChooseNum = removeUsedBalls(chooseNum, combChoose);
                String[] combChooseArr = combChoose.split(" ");
                String[] second = totalBallsDrawNGetR(allBalls, winBallCount - 1, combChooseArr, combChooseArr.length);

                for(String secondResult : second){
                    if(!secondResult.contains(notUsedChooseNum)){
                        returnResult.add(secondResult + notUsedChooseNum);
                    }
                }
            }

            //總組和數           　
            //從 A 中取 N - 1 個, 與從 A - (N - 1) 中取 8 個的組合數
            List<String> allComb = new ArrayList<String>();
            String[] before5 = printComb3(allBalls, winBallCount - 1);
            for(String getFirst5 : before5){
                String temp = removeUsedBalls(allBalls, getFirst5);
                String[] after8 = printComb3(temp.split(" "), 8);
                for(String after : after8){
                    allComb.add(getFirst5 + after);
                }
            }

            returnObj.setWinComb(returnResult.toArray(new String[returnResult.size()]));
            returnObj.setAllComb(allComb.toArray(new String[allComb.size()]));
            return returnObj;
        } else if(S == 3){
            //總彩球 A 個, 抽出 N 個, 中 R 個;

            //中獎數
            //從 A 中取 N - 1 個,中 R 個的數量, 與從 A - (N - 1) 中取 2 個沒中的數量的組合數
            String[] before5Got2 = totalBallsDrawNGetR(allBalls, winBallCount - 1, chooseNum, gotNum);
            for(String before5 : before5Got2){
                String allBallsStr = removeUsedBalls(allBalls, before5);
                String[] after2Got0 = printComb3(allBallsStr.split(" "), 2);
                for(String after2 : after2Got0){
                    returnResult.add(before5 + after2);
                }
            }

            //中獎數
            //從 A 中取 N - 1 個,中 R - 1 個的數量, 與從 A - (N - 1) 中取 2 個,中 1 個的數量的組合數
            String[] combChooseNum = printComb3(chooseNum, chooseNum.length - 1);
            for(String combChoose : combChooseNum){
                String allChooseNum = Arrays.toString(chooseNum).replaceAll("\\[", "").replaceAll("\\]", "").replace(",","") + " ";
                String[] combChooseArr = combChoose.split(" ");
                before5Got2 = totalBallsDrawNGetR(allBalls, winBallCount - 1, combChooseArr, combChooseArr.length);
                for(String before5 : before5Got2){
                    String allBallsStr = removeUsedBalls(allBalls, before5);
                    String notUsed = allChooseNum;
                    for(String usedNum : combChooseArr){
                        notUsed = notUsed.replace(usedNum + " ", "");
                    }
                    String[] after2Got1 = totalBallsDrawNGetR(allBallsStr.split(" "), 2, notUsed.split(" "), 1);
                    for(String after2 : after2Got1){
                        returnResult.add(before5 + after2);
                    }
                }
            }
            //總組和數           　
            //從 A 中取 N - 1 個, 與從 A - (N - 1) 中取 2 個的組合數
            List<String> allComb = new ArrayList<String>();
            String[] before5 = printComb3(allBalls, winBallCount - 1);
            for(String getFirst5 : before5){
                String temp = removeUsedBalls(allBalls, getFirst5);
                String[] after2 = printComb3(temp.split(" "), 2);
                for(String after : after2){
                    allComb.add(getFirst5 + after);
                }
            }

            returnObj.setWinComb(returnResult.toArray(new String[returnResult.size()]));
            returnObj.setAllComb(allComb.toArray(new String[allComb.size()]));
            return returnObj;
        } else {
            return null;
        }

    }

    private String removeUsedBalls(String[] allBalls, String usedBalls) {
        String returnBalls = Arrays.toString(allBalls).replaceAll("\\[", "").replaceAll("\\]", "").replace(",","") + " ";
        String[] usedBallsArr = usedBalls.split(" ");
        for(String usedBall : usedBallsArr){
            returnBalls = returnBalls.replace(usedBall + " " , "");
        }
        return returnBalls;
    }
}
