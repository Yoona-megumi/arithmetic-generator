package test;

import generator.Main;
import org.junit.Test;

import java.io.IOException;

public class TestGenerator {

    /**
     * ������ -r �������
     *
     */
    @Test
    public void testCommandNotParamR() throws IOException {
        Main.main(new String[]{"-n", "5"});
    }

    /**
     * ���� -r �������������������
     */
    @Test
    public void testCommandFormatError() throws IOException {
        Main.main(new String[]{"-r", "��"});
    }

    /**
     * ������ -n ���������Ĭ��Ϊ5��������5���⣩
     */
    @Test
    public void testCommandNotParamN() throws IOException {
        //��ָ��-nʱĬ��Ϊ5
        Main.main(new String[]{"-r", "10"});
    }

    /**
     * ���Բ�������������
     */
    @Test
    public void testCommandParamError() throws IOException {
        Main.main(new String[]{"-nsfd", "5", "-r", "6"});
    }

    /**
     * ���Բ�������������������2��4��
     */
    @Test
    public void testCommandParamNumError() throws IOException {
        Main.main(new String[]{"-r", "5", "-n"});
    }

    /**
     * ����6���⣬���ֵΪ10�����(-n������ǰ)
     */
    @Test
    public void testCommandFirstNThenR() throws IOException {
        Main.main(new String[]{"-n", "6", "-r", "10"});
    }

    /**
     * ����10���⣬���ֵΪ10�����(-n�����ں�)
     */
    @Test
    public void testCommandFirstRThenN() throws IOException {
        Main.main(new String[]{"-r", "10", "-n", "20"});
    }

    /**
     * ����10000���⣬���ֵΪ10�����
     */
    @Test
    public void testCommandNice2() throws IOException {
        Main.main(new String[]{"-n", "10000", "-r", "10"});
    }

    @Test
    public void testGrade() throws IOException {
        Main.main(new String[]{"-e", "E:\\ArithmeticGenerator\\Exercise.txt", "-a", "E:\\ArithmeticGenerator\\Answers.txt"});
    }
}