package test;

import generator.Main;
import org.junit.Test;

import java.io.IOException;

public class TestGenerator {

    /**
     * 测试无 -r 参数情况
     *
     */
    @Test
    public void testCommandNotParamR() throws IOException {
        Main.main(new String[]{"-n", "5"});
    }

    /**
     * 测试 -r 参数后无输入整数情况
     */
    @Test
    public void testCommandFormatError() throws IOException {
        Main.main(new String[]{"-r", "五"});
    }

    /**
     * 测试无 -n 参数情况（默认为5，即生成5道题）
     */
    @Test
    public void testCommandNotParamN() throws IOException {
        //无指定-n时默认为5
        Main.main(new String[]{"-r", "10"});
    }

    /**
     * 测试参数输入错误情况
     */
    @Test
    public void testCommandParamError() throws IOException {
        Main.main(new String[]{"-nsfd", "5", "-r", "6"});
    }

    /**
     * 测试参数个数错误的情况（非2非4）
     */
    @Test
    public void testCommandParamNumError() throws IOException {
        Main.main(new String[]{"-r", "5", "-n"});
    }

    /**
     * 生成6道题，最大值为10的情况(-n参数在前)
     */
    @Test
    public void testCommandFirstNThenR() throws IOException {
        Main.main(new String[]{"-n", "6", "-r", "10"});
    }

    /**
     * 生成10道题，最大值为10的情况(-n参数在后)
     */
    @Test
    public void testCommandFirstRThenN() throws IOException {
        Main.main(new String[]{"-r", "10", "-n", "20"});
    }

    /**
     * 生成10000道题，最大值为10的情况
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