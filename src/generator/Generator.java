package generator;

import expression.Expression;
import util.Check;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    /**
     * ���ݱ��ʽ������expCounts�������ֵ��max�����������Ŀ�ʹ�
     * ������Ŀд�뵱ǰĿ¼expFile.txt���Ѵ�д��answer.txt��ִ��jar��ʱ����jar������Ŀ¼�����ɣ�
     * д��ǰ��������ļ�ɾ���������ڣ����ٴ������ļ���д��
     * @param expCounts
     * @param max
     */
    public static void generate(int expCounts, int max){
        List<String> expressions = new ArrayList<>();
        List<String> answers = new ArrayList<>();


        Random random = new Random();
        Expression expression;


        for(int i=0;i<expCounts;i++){
            //�����ȡһ��1-3�����֣�����ָ�����������
            int opCounts = random.nextInt(4);
            while (opCounts==0){
                opCounts = random.nextInt(4);
            }

            //���ɱ��ʽ
            expression = new Expression(opCounts, max);
            expression.createExpression();
            //����������
            String answer = expression.getResult();

            //�����Ӧ����
            expressions.add(expression.toString() + " = ");
            answers.add(answer);

        }

        FileUtil.write(expressions, answers);

    }
}