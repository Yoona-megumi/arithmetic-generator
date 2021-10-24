package generator;

import util.Check;
import util.CommandResolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Check check = new Check();
        //�����в���������
        CommandResolver commandResolver = new CommandResolver();
        //�����в���ʱ������Ҫ�󣬳�����ֹ
        if (!commandResolver.resolve(args)) {
            return;
        }
        //�ж�ʹ�������������
        //ִ���ļ�У��
        if (args[0].equals("-e") || args[0].equals("-a")) {
            check.grade(commandResolver.getExercisefile(), commandResolver.getAnswerfile());
            System.out.println("��У����ɣ��뵽��ǰĿ¼�µ�Grade.txt�ļ��鿴���");

        } else {
            //ִ�б��ʽ���𰸵�����
            Generator.generate(commandResolver.getExpCounts(), commandResolver.getMaxValue());
            System.out.println("����������Ŀ���ɳɹ����뵽��ǰĿ¼�µ�Exercise.txt�鿴��Ŀ��Answers.txt�鿴��");
            System.out.println("���ɵ���Ŀ����" + commandResolver.getExpCounts() + "," +
                    "�����������ֵ��������ָ��ֵ����" + commandResolver.getMaxValue());
        }
    }
}