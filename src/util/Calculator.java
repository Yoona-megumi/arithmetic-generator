package util;

/**
 * �ṩ�˷�����ʽ�ļӼ��˳����㣬���ص��������������ʽ
 * Ҳ�ṩ�˸����ַ�����ȡ����ӷ�ĸ��String[]���Լ���ȡָ�������������ʽ�ķ���
 */
public class Calculator {

    /**
     * �ӷ�
     * ���������������ʽ
     * @param num1
     * @param num2
     * @return
     */
    public static String add(String num1, String num2){

        String[] result = new String[2];

        Integer[] fractions = getIntFractions(num1, num2);
        //��ĸ����С������
        Integer lcm = getLcm(fractions[1], fractions[3]);

        //��ĸ������С�����������ӳ��Զ�Ӧ���������
        result[0] = String.valueOf(fractions[0]*(lcm/fractions[1]) + fractions[2]*(lcm/fractions[3]));
        result[1] = String.valueOf(lcm);

        //���������ʽ
        return getSimplestFraction(result);
    }

    /**
     * ����
     * ���ڱ�����С�ڼ�����������������㣬����-1
     * @param num1
     * @param num2
     * @return
     */
    public static String sub(String num1, String num2){
        Integer[] fractions = getIntFractions(num1, num2);
        String[] result = new String[2];

        //��ĸ����С������
        Integer lcm = getLcm(fractions[1], fractions[3]);

        if(fractions[0]*(lcm/fractions[1]) < fractions[2]*(lcm/fractions[3])){
            return "-1";
        }

        result[0] = String.valueOf(fractions[0]*(lcm/fractions[1]) - fractions[2]*(lcm/fractions[3]));
        result[1] = String.valueOf(lcm);

        return getSimplestFraction(result);
    }

    /**
     * �˷�
     * @param num1
     * @param num2
     * @return
     */
    public static String mul(String num1, String num2){
        Integer[] fractions = getIntFractions(num1, num2);
        String[] result = new String[2];

        //���ӷ�ĸ���
        result[0] = String.valueOf(fractions[0]*fractions[2]);
        result[1] = String.valueOf(fractions[1]*fractions[3]);

        return getSimplestFraction(result);
    }

    /**
     * ����
     * ���ڳ���Ϊ0����������� "-1"
     * @param num1
     * @param num2
     * @return
     */
    public static String division(String num1, String num2){
        Integer[] fractions = getIntFractions(num1, num2);

        if(fractions[0]==0){
            return "0";
        }
        if(fractions[2]==0){
            return "-1";
        }

        String[] result = new String[2];

        //����������ڱ��������Գ����ĵ���
        result[0] = String.valueOf(fractions[0]*fractions[3]);
        result[1] = String.valueOf(fractions[1]*fractions[2]);

        return getSimplestFraction(result);
    }

    /**
     * ��ȡ�ַ�����Ӧ�ķ�����String[]���飬[0]��ŷ��ӣ�[1]��ŷ�ĸ��
     * �������number��: ��������ʽ���� 2'1/3 �� �� ��ͨ������ʽ���� 8/3 , 1/8���� ������ʽ 3�����
     */
    public static String[] getFraction(String number){
        String[] result = null;//result[0]�Ƿ��ӡ�result[1]�Ƿ�ĸ
        //number�Ǵ�����
        if(number.contains("'")){
            String[] temp = number.split("'");
            result = temp[1].split("/");

            Integer a = Integer.valueOf(temp[0]);//����������������
            Integer b = Integer.valueOf(result[0]);//�������������ֵķ���
            Integer c = Integer.valueOf(result[1]);//�������������ֵķ�ĸ

            result[0] = String.valueOf(a*c+b);
        }
        //number����ͨ����
        else if(number.contains("/")){
            result = number.split("/");
        }
        //number������
        else {
            result = new String[2];
            result[0] = number;
            result[1] = "" + 1;
        }
        return result;
    }

    // ���Լ��
    public static int getGcd(int a, int b) {
        int max, min;
        max = (a > b) ? a : b;
        min = (a < b) ? a : b;

        if (max % min != 0) {
            return getGcd(min, max % min);
        } else
            return min;

    }

    //��С������
    private static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }

    /**
     * ��ȡ�����������ʽ
     * @param fraction ָ������
     * @return
     */
    public static String getSimplestFraction(String[] fraction){
        //��ĸ�������ӣ�ֱ�ӷ���������ʽ
        if(Integer.parseInt(fraction[0])%Integer.parseInt(fraction[1])==0){
            return "" + Integer.parseInt(fraction[0])/Integer.parseInt(fraction[1]);
        }

        //���ӷ�ĸת��ΪInteger����
        Integer numerator = Integer.parseInt(fraction[0]);
        Integer denominator = Integer.parseInt(fraction[1]);

        //��ȡ���Լ��
        Integer gcd = getGcd(numerator, denominator);

        //����
        numerator = numerator/gcd;
        denominator = denominator/gcd;

        //���Ӵ��ڷ�ĸ����Ϊ������
        if(numerator>denominator){
            Integer intPart = numerator/denominator;
            numerator = numerator-intPart*denominator;
            return "" + intPart + "'" + numerator + "/" + denominator;
        }else {
            return "" + numerator + "/" + denominator;
        }
    }

    /**
     * �������������ַ�������ȡ���ǵķ�����ʽ
     * ���ص�Integer�����У�
     * [0]��ŵ�һ�����ķ��ӣ�[1]��ŵ�һ�����ķ�ĸ��[2]��ŵڶ������ķ��ӣ�[3]��ŵڶ������ķ�ĸ
     * @param num1
     * @param num2
     * @return
     */
    private static Integer[] getIntFractions(String num1, String num2){
        Integer[] result = new Integer[4];
        String[] fraction1 = getFraction(num1);
        String[] fraction2 = getFraction(num2);

        //��������
        result[0] = Integer.valueOf(fraction1[0]);
        result[2] = Integer.valueOf(fraction2[0]);
        //������ĸ
        result[1] = Integer.valueOf(fraction1[1]);
        result[3] = Integer.valueOf(fraction2[1]);

        return result;
    }
}