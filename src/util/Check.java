package util;

import java.io.*;

public class Check {
    static private String file1 = null;//"d://Answers.txt";
    static private String file2 = null;//"d://Exercises.txt";
    static private String currentPath = new File("").getAbsolutePath();
    static final private String file3 = currentPath + File.separator +  "Grade.txt";
    static private BufferedReader br1;
    static private BufferedReader br2;
    static private BufferedWriter bw;
    static private StringBuilder sb1 = new StringBuilder();
    static private StringBuilder sb2 = new StringBuilder();
    static private String result1;
    static private String result2;
    static int rightCount = 0;
    static int wrongCount = 0;

    public void grade(String Exercisefile,String AnswerFile) throws IOException {
        file1 = Exercisefile;
        file2 = AnswerFile;

        try {
            br1 = new BufferedReader(new FileReader(file1));
            br2 = new BufferedReader(new FileReader(file2));
            bw = new BufferedWriter(new FileWriter(file3));
        } catch (IOException e) {
            e.printStackTrace();
        }

        result1 = "correct:";
        result2 = "wrong:";
        sb1.append("(");
        sb2.append("(");
        String str = null, str1 = null;
        String[] strings = null, strings1 = null;
        while ((str = br1.readLine()) != null && (str1 = br2.readLine()) != null) {
            strings = str.split("=");
            strings1 = str1.split("\\.");
            if (strings[1].equals(strings1[1])) {
                rightCount++;
                sb1.append(strings1[0] + ",");
            }else {
                wrongCount++;
                sb2.append(strings1[0] + ",");
            }
        }
        if(rightCount != 0)
            sb1.deleteCharAt(sb1.length() - 1);
        if(wrongCount != 0)
            sb2.deleteCharAt(sb2.length() - 1);
        sb1.append(")");
        sb2.append(")");
        result1 += rightCount + sb1.toString();
        result2 += wrongCount + sb2.toString();
        bw.write(result1);
        bw.newLine();
        bw.write(result2);
        br1.close();
        br2.close();
        bw.close();
    }
}