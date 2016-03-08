package com.cb.leo;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello!");


//        long time1, time2;
//        CCombinations cCombinations = new CCombinations();
//
//        String[] allColorBall = new String[49];
//        for(int i = 0; i < 49 ; i++){
//            allColorBall[i] = String.valueOf(i + 1);
//        }
//        String[] winBall = new String[]{"2", "3", "4", "5", "6", "7", "8"};
//        time1 = System.currentTimeMillis();
//
//        WinBallsGotRightBalls();

        //PK10選號機率
//        printPK10Result();

        //百變王牌 任選
//        VarietyAceWinBallsGetN();

        //百變王牌選號機率
//        VarietyAce();

       //百變王牌總和
//        sumBS();
//        sumOE();
//        sumSBS();
//        sumBSOE();

//        NGetR();


//        String[] winBall = new String[]{"A", "B", "C"};
//        String temp = Arrays.toString(winBall).replaceAll("\\[", "").replaceAll("\\]", "").replace(",","") + " ";
//        System.out.println(temp.contains("CA"));
//        String dd = temp.replace(winBall[1] + " ","");
//        System.out.println(dd);
//        String[] temp2 = new CMethod().printComb3(winBall, 2);
//        String[] temp2 = dd.split(" ");
//        for(String child : temp2){
//            System.out.println(child);
//        }


        String[] allBalls = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
        String[] chooseBalls = new String[]{"A"};
//        new CMethod().printComb2(allBall, 6);

        objResult temp = new CMethod().VarietyAceNgetR2(allBalls, 6, chooseBalls, 2);
        System.out.println(temp.getAllComb().length);
        System.out.println(temp.getWinComb().length);
//        for(String child : temp.getWinComb()){
//            System.out.println(child);
//        }

//        String[] allBalls = new String[]{"A", "B", "C", "D", "E"};
//        String[] chooseBalls = new String[]{"A", "B", "C"};
//
//
//        String[] temp = new CMethod().totalBallsDrawNGetR(allBalls, 3, chooseBalls, 2);
//        for(String child : temp){
//            System.out.println(child);
//        }


//        String[] winBall = new String[]{"A", "B", "C", "D", "E"};
//        String[] test = new CMethod().printComb3(winBall, 2);
//
//        for(String child : test){
//            System.out.println(child);
//        }
//        String[] allComb = new CMethod().printComb3(winBall, 4);
//        for(String child : allComb){
//            System.out.println(child.replace(" ", ""));
//        }
//        int[] allNumber = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        List<int[]> result = new CCombinations().getCombData(allNumber, 3);
//        System.out.println("comb count" + result.size());
//        for(int[] temp : result){
//            for(int subTemp : temp){
//                System.out.print(subTemp + " ");
//            }
//            System.out.println(" ");
//        }
//        result.clear();

//        List<String> temp = CPermutations.permPrefix("ABCDEFGHIJ");
//        for(String child : temp){
//            System.out.println(child);
//        }
//        System.out.println("All Permutations:" + temp.size());
//        System.out.println("====================");
//        CPermutations.perm2(elements);
//        new CMethod().printComb(10, 3);
//        System.out.println("COUNT: " + new CMethod().threeNumSum(1, 2));
//        String[] test = new CMethod().printComb3(winBall, 4);
//        for(String child : test){
//            String[] temp = child.split(" ");
//            int sum = 0;
//            for(String subChild : temp){
//                sum +=  Integer.parseInt(subChild);
//            }
//            System.out.println(sum);
//        }
//
////        cCombinations.storePermAndCombToTxt(allColorBall, winBall, 7, 1);
//        time2 = System.currentTimeMillis();
//
//        System.out.println("共花了：" + (time2-time1)/1000 + "秒");


//*******************server/client********************
//        int port = 8080;
//
//        try{
//            Socket socket = new Socket("localhost", port);
//            MessageUtils.sendMessage(socket, "good job!");
//            MessageUtils.getMessage(socket);
//            socket.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

    //alphabet總球數(以英文字母表示); right**開出號碼
    public static void printPK10Result(){
        int N = Integer.parseInt("3");
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, N);
        String[] strArr = new String[]{"1", "2", "3"};
        int[] intArr = new int[]{1, 2, 3};

        System.out.println("----------------PK10四中二------------------");
        String[] right4 = new String[]{"B", "G", "A", "J"};
        String[] result4_2 = new CMethod().PK10NgetR(right4, 2);
        for(String child : result4_2){
            System.out.println(child);
        }
        System.out.println("----------------PK10四中三------------------");
        String[] result4_3 = new CMethod().PK10NgetR(right4, 3);
        for(String child : result4_3){
            System.out.println(child);
        }
        System.out.println("----------------PK10四中四------------------");
        String[] result4_4 = new CMethod().PK10NgetR(right4, 4);
        for(String child : result4_4){
            System.out.println(child);
        }
        System.out.println("----------------PK10三中二------------------");
        String[] right3 = new String[]{"C", "B", "A"};
        String[] result3_2 = new CMethod().PK10NgetR(right3, 2);
        for(String child : result3_2){
            System.out.println(child);
        }
        System.out.println("----------------PK10三中三------------------");
        String[] result3_3 = new CMethod().PK10NgetR(right3, 3);
        for(String child : result3_3){
            System.out.println(child);
        }
        System.out.println("----------------PK10二中一------------------");
        String[] right2 = new String[]{"F", "B"};
        String[] result2_1 = new CMethod().PK10NgetR(right2, 1);
        for(String child : result2_1){
            System.out.println(child);
        }
        System.out.println("----------------PK10二中二------------------");
        String[] result2_2 = new CMethod().PK10NgetR(right2, 2);
        for(String child : result2_2){
            System.out.println(child);
        }
    }

    //totalBalls總球數;winBalls開獎球數;drawBalls選球數;rightBalls兌中球數
    public static void WinBallsGotRightBalls(){
        int rightBalls = 1;
        int drawBalls = 1;
        int winBalls = 2;
        int totalBalls = 4;
        double probability = new CMethod().calculateLottoProbalility(totalBalls, winBalls, drawBalls, rightBalls);
////        System.out.println("C" + total + "取" + num + ":" + new CMethod().calculateComb(total, num));
        System.out.println(totalBalls + "個號碼開出" + winBalls + "個號碼," + "選" + drawBalls + "中" + rightBalls + "的機率是 : " + probability);
        System.out.println("賠率是 : " +(1 / probability));
    }

    //百變王牌 任選
    public static void VarietyAceWinBallsGetN(){
        double B, S, N, result1, result2;
        objResult BResult;
        objResult SResult;
        objResult NResult;
        B = 59.0/10000.0;
        S = 707.0/10000.0;
        N = 9235.0/10000.0;
        String[] allBalls = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

        System.out.println("----------------百變王牌 - 任選2------------------");
        String[] choose2Balls = new String[]{"A", "B"};
        NResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose2Balls, 2, 1);
        BResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose2Balls, 2, 2);
        SResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose2Balls, 2, 3);

        result1 = ((double)NResult.getWinComb().length / (double)NResult.getAllComb().length)*N + ((double)BResult.getWinComb().length / (double)BResult.getAllComb().length)*B +((double)SResult.getWinComb().length / (double)SResult.getAllComb().length)*S;
        result2 = 1 / result1;
        System.out.println("一般[中獎數:" + NResult.getWinComb().length + ",組和數:" + NResult.getAllComb().length + ", 機率:" + (double)NResult.getWinComb().length / (double)NResult.getAllComb().length + ", 賠率:" + (double)NResult.getAllComb().length / (double)NResult.getWinComb().length + "]");
        System.out.println("大王[中獎數:" + BResult.getWinComb().length + ",組和數:" + BResult.getAllComb().length + ", 機率:" + (double)BResult.getWinComb().length / (double)BResult.getAllComb().length + ", 賠率:" + (double)BResult.getAllComb().length / (double)BResult.getWinComb().length + "]");
        System.out.println("小王[中獎數:" + SResult.getWinComb().length + ",組和數:" + SResult.getAllComb().length + ", 機率:" + (double)SResult.getWinComb().length / (double)SResult.getAllComb().length + ", 賠率:" + (double)SResult.getAllComb().length / (double)SResult.getWinComb().length + "]");
        System.out.println("機率:" + result1);
        System.out.println("賠率:" + result2);

        System.out.println("----------------百變王牌 - 任選3------------------");
        String[] choose3Balls = new String[]{"A", "B","C"};
        NResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose3Balls, 3, 1);
        BResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose3Balls, 3, 2);
        SResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose3Balls, 3, 3);

        result1 = ((double)NResult.getWinComb().length / (double)NResult.getAllComb().length)*N + ((double)BResult.getWinComb().length / (double)BResult.getAllComb().length)*B +((double)SResult.getWinComb().length / (double)SResult.getAllComb().length)*S;
        result2 = 1 / result1;
        System.out.println("一般[中獎數:" + NResult.getWinComb().length + ",組和數:" + NResult.getAllComb().length + ", 機率:" + (double)NResult.getWinComb().length / (double)NResult.getAllComb().length + ", 賠率:" + (double)NResult.getAllComb().length / (double)NResult.getWinComb().length + "]");
        System.out.println("大王[中獎數:" + BResult.getWinComb().length + ",組和數:" + BResult.getAllComb().length + ", 機率:" + (double)BResult.getWinComb().length / (double)BResult.getAllComb().length + ", 賠率:" + (double)BResult.getAllComb().length / (double)BResult.getWinComb().length + "]");
        System.out.println("小王[中獎數:" + SResult.getWinComb().length + ",組和數:" + SResult.getAllComb().length + ", 機率:" + (double)SResult.getWinComb().length / (double)SResult.getAllComb().length + ", 賠率:" + (double)SResult.getAllComb().length / (double)SResult.getWinComb().length + "]");
        System.out.println("機率:" + result1);
        System.out.println("賠率:" + result2);

        System.out.println("----------------百變王牌 - 任選4------------------");
        String[] choose4Balls = new String[]{"A", "B", "C", "D"};
        NResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose4Balls, 4, 1);
        BResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose4Balls, 4, 2);
        SResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose4Balls, 4, 3);

        result1 = ((double)NResult.getWinComb().length / (double)NResult.getAllComb().length)*N + ((double)BResult.getWinComb().length / (double)BResult.getAllComb().length)*B +((double)SResult.getWinComb().length / (double)SResult.getAllComb().length)*S;
        result2 = 1 / result1;
        System.out.println("一般[中獎數:" + NResult.getWinComb().length + ",組和數:" + NResult.getAllComb().length + ", 機率:" + (double)NResult.getWinComb().length / (double)NResult.getAllComb().length + ", 賠率:" + (double)NResult.getAllComb().length / (double)NResult.getWinComb().length + "]");
        System.out.println("大王[中獎數:" + BResult.getWinComb().length + ",組和數:" + BResult.getAllComb().length + ", 機率:" + (double)BResult.getWinComb().length / (double)BResult.getAllComb().length + ", 賠率:" + (double)BResult.getAllComb().length / (double)BResult.getWinComb().length + "]");
        System.out.println("小王[中獎數:" + SResult.getWinComb().length + ",組和數:" + SResult.getAllComb().length + ", 機率:" + (double)SResult.getWinComb().length / (double)SResult.getAllComb().length + ", 賠率:" + (double)SResult.getAllComb().length / (double)SResult.getWinComb().length + "]");
        System.out.println("機率:" + result1);
        System.out.println("賠率:" + result2);

        System.out.println("----------------百變王牌 - 任選5------------------");
        String[] choose5Balls = new String[]{"A", "B", "C", "D", "E"};
        NResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose5Balls, 5, 1);
        BResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose5Balls, 5, 2);
        SResult = new CMethod().VarietyAceAnyNgetR(allBalls, 6, choose5Balls, 5, 3);

        result1 = ((double)NResult.getWinComb().length / (double)NResult.getAllComb().length)*N + ((double)BResult.getWinComb().length / (double)BResult.getAllComb().length)*B +((double)SResult.getWinComb().length / (double)SResult.getAllComb().length)*S;
        result2 = 1 / result1;
        System.out.println("一般[中獎數:" + NResult.getWinComb().length + ",組和數:" + NResult.getAllComb().length + ", 機率:" + (double)NResult.getWinComb().length / (double)NResult.getAllComb().length + ", 賠率:" + (double)NResult.getAllComb().length / (double)NResult.getWinComb().length + "]");
        System.out.println("大王[中獎數:" + BResult.getWinComb().length + ",組和數:" + BResult.getAllComb().length + ", 機率:" + (double)BResult.getWinComb().length / (double)BResult.getAllComb().length + ", 賠率:" + (double)BResult.getAllComb().length / (double)BResult.getWinComb().length + "]");
        System.out.println("小王[中獎數:" + SResult.getWinComb().length + ",組和數:" + SResult.getAllComb().length + ", 機率:" + (double)SResult.getWinComb().length / (double)SResult.getAllComb().length + ", 賠率:" + (double)SResult.getAllComb().length / (double)SResult.getWinComb().length + "]");
        System.out.println("機率:" + result1);
        System.out.println("賠率:" + result2);

    }

    //百變王牌 直選
    public static void VarietyAce(){
        String[] allBall = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

//        System.out.println("----------------百變王牌 - 前一------------------");
//        String[] right1 = new String[]{"A"};
//        String[] result1_1 = new CMethod().VarietyAceNgetR(allBall, 6, right1);
//        for(String child : result1_1){
//            System.out.println(child);
//        }
//
//        System.out.println("----------------百變王牌 - 前二直選------------------");
//        String[] right2 = new String[]{"A", "B"};
//        String[] result2_2 = new CMethod().VarietyAceNgetR(allBall, 6, right2);
//        for(String child : result2_2){
//            System.out.println(child);
//        }
//
//        System.out.println("----------------百變王牌 - 前二組選------------------");
//        String[] resultAny2_2 = new CMethod().VarietyAceAnyNgetR(allBall, 6, right2);
//        for(String child : resultAny2_2){
//            System.out.println(child);
//        }
//
//        System.out.println("----------------百變王牌 - 前三直選------------------");
//        String[] right3 = new String[]{"A", "B", "C"};
//        String[] result3_3 = new CMethod().VarietyAceNgetR(allBall, 6, right3);
//        for(String child : result3_3){
//            System.out.println(child);
//        }
//
//        System.out.println("----------------百變王牌 - 前三組選------------------");
//        String[] resultAny3_3 = new CMethod().VarietyAceAnyNgetR(allBall, 6, right3);
//        for(String child : resultAny3_3){
//            System.out.println(child);
//        }
    }

    public static void sumBS(){
        String[] allBallsNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        System.out.println("----------------百變王牌 - 總和大小和------------------");
        String[] result = new CMethod().VarietyAceNumSumBS(allBallsNum, 42, 6);
        for(String child : result){
            System.out.println(child);
        }
    }

    public static void sumOE(){
        String[] allBallsNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        System.out.println("----------------百變王牌 - 總和單雙------------------");
        String[] result = new CMethod().VarietyAceNumSumOE(allBallsNum, 6);
        for(String child : result){
            System.out.println(child);
        }
    }

    public static void sumSBS(){
        String[] allBallsNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        System.out.println("----------------百變王牌 - 總和尾大小------------------");
        String[] result = new CMethod().VarietyAceNumSumSBS(allBallsNum, 6);
        for(String child : result){
            System.out.println(child);
        }
    }

    public static void sumBSOE(){
        String[] allBallsNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

        System.out.println("----------------百變王牌 - 總和過關------------------");
        String[] result = new CMethod().VarietyAceNumSumBSOE(allBallsNum, 6);
        for(String child : result){
            System.out.println(child);
        }
    }

    public static void NGetR(){
        String[] allBallsNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        String[] test = new String[]{"1", "2", "3"};
        new CMethod().printComb2(test, 2);
    }
}
