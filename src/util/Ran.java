package util;

import java.util.Random;

/**
 * ���ֵ������
 * ����������������������Լ��ӽڵ�λ��
 */
public class Ran {

    /**
     * ��ȡ����ķ���
     *
     * @return operator
     */

    public static String getOperator(){
        String operator = "";
        Random ran = new Random();
        int i = ran.nextInt(4);
        switch(i){
            case 0:
                operator = "+";
                break;
            case 1:
                operator = "-";
                break;
            case 2:
                operator = "x";
                break;
            case 3:
                operator = "��";
                break;
        }
        return operator;
    }


    /**
     * ��������ķ�Χ��ȡ�����
     *
     * @param max
     * @return number
     */
    public static String getNumber(int max){
        Random ran = new Random();
        //�����ȡһ�����������
        if(ran.nextBoolean()) {
            return String.valueOf(ran.nextInt(max));
        }
        else {
            return getFraction(max);
        }
    }


    /**
     * �����ȡ������һ�뼸�ʼٷ���һ�뼸���������
     * @param max
     * @return
     */
    public static String getFraction(int max){
        Random random = new Random();
        int denominator = 0;//��ĸ
        int numerator = 0;//����
        String[] result = new String[2];

        //��ȡ1-20�ķ�ĸ�����������Ϊ0��1��
        while (denominator==0 || denominator==1){
            denominator = random.nextInt(10+1);
        }
        //��ȡ1-��ĸ�ķ��������������Ϊ0��
        while (numerator==0){
            numerator = random.nextInt(denominator);
        }

        result[0] = String.valueOf(numerator);
        result[1] = String.valueOf(denominator);

        //��������Ƿ񷵻ش�����
        if(random.nextBoolean()){
            //������������������1~max-2���������ֲ�����1���������ɵ����������С�� ���ֵ-1
            Integer intPart = random.nextInt(max-1);
            while (intPart==0){
                intPart = random.nextInt(max-1);
            }
            return "" + intPart + "'" + Calculator.getSimplestFraction(result);
        }

        return Calculator.getSimplestFraction(result);
    }

    /**
     * @param num
     * @return childPlace
     */
    public static boolean[] getChildPlace(int num){
        //ע�͵Ĵ���������������������
        // int d = 0;//Ҫ���ɵ�falseԪ�صĸ���
        // int size = 0;//���鳤��
        // int j=1;
        //
        // while(num >= (int)Math.pow(2, j)){
        //     j++;
        // }
        // d = (int)Math.pow(2, j) - 1 - num;
        // size = (int)Math.pow(2, j-1);
        // boolean[] k = new boolean[size];
        //
        // for(int i = 0; i < size; i++){
        //     k[i] = true;
        // }
        // for(int i = 0; i < d; i++){
        //     Random ran = new Random();
        //     int f = ran.nextInt(size);
        //     while(k[f] == false) {
        //         f = ran.nextInt(size);
        //     }
        //     k[f] = false;
        // }
        // return k;

        boolean[] result = new boolean[]{true, true};

        if(num==2){
            Random random = new Random();
            if(random.nextBoolean()){
                result[0] = false;
            }else {
                result[1] = false;
            }
        }

        return result;
    }
}