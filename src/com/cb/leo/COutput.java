package com.cb.leo;

import java.io.*;

/**
 * Created by god0725 on 2016/1/7.
 */
public class COutput {
    public static void writeToTxt(String[] first, String[] second){
        System.out.println("共" + first.length * second.length + "組");
        BufferedWriter fw = null;
        try {

            File file = new File("c://text.txt");

            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常
            fw.append("結果:");
            fw.newLine();

            int i = 0;
            for(String child : first){
                for(String subChild : second){
                    fw.append(child + subChild + " | ");
                    i++;
                    if(i == 5){
                        i = 0;
                        fw.newLine();
                    }
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


}


