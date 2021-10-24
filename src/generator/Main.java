package generator;

import util.Check;
import util.CommandResolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Check check = new Check();
        //命令行参数解析器
        CommandResolver commandResolver = new CommandResolver();
        //命令行参数时不符合要求，程序终止
        if (!commandResolver.resolve(args)) {
            return;
        }
        //判断使用哪条命令语句
        //执行文件校对
        if (args[0].equals("-e") || args[0].equals("-a")) {
            check.grade(commandResolver.getExercisefile(), commandResolver.getAnswerfile());
            System.out.println("已校对完成，请到当前目录下的Grade.txt文件查看结果");

        } else {
            //执行表达式及答案的生成
            Generator.generate(commandResolver.getExpCounts(), commandResolver.getMaxValue());
            System.out.println("四则运算题目生成成功，请到当前目录下的Exercise.txt查看题目、Answers.txt查看答案");
            System.out.println("生成的题目数：" + commandResolver.getExpCounts() + "," +
                    "运算数的最大值（不包括指定值）：" + commandResolver.getMaxValue());
        }
    }
}