package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    /**
     * ���������ʽ���𰸷ֱ�д���Ӧ�ļ�
     * @param expressions
     * @param answers
     */
    public static void write(List<String> expressions, List<String> answers){
        String currentPath = new File("").getAbsolutePath();//��ǰ����·��
        File expFile = new File(currentPath + File.separator + "Exercise.txt");
        File answersFile = new File(currentPath + File.separator + "Answers.txt");

        FileWriter expWriter;
        FileWriter answerWriter;

        //����Ӧ�ļ����ڣ�ɾ�������´���
        if(expFile.exists()){
            expFile.delete();
        }
        if(answersFile.exists()){
            answersFile.delete();
        }

        try {
            //�����ļ�
            expFile.createNewFile();
            answersFile.createNewFile();

            //�����ļ���Ӧ�������
            expWriter = new FileWriter(expFile);
            answerWriter = new FileWriter(answersFile);

            writeToFile(expressions, expWriter);
            writeToFile(answers, answerWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��List�е�����д��������У�����������ʽ��
     * 1. ---
     * 2. ---
     * 3. ---
     * ...
     * @param content
     * @param writer
     */
    private static void writeToFile(List<String> content, FileWriter writer){
        for(int i=1; i<content.size()+1; i++){
            try {
                writer.write(i + ". " + content.get(i-1) + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}