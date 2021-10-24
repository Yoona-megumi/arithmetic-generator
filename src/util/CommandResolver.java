package util;

/**
 * ���������
 */
public class CommandResolver {
    //��������󽫻�ȡ����Чֵ����
    private int expCounts = 5;//Ĭ��ֵ��5
    private int maxValue;
    private String exercisefile = null;
    private String answerfile = null;

    /**
     * ���������в�����˼·���£�
     * �Ȼ�ȡ��������ĳ���
     * ����2��4֮��ĳ��ȣ�˵�������ʽ����
     * ������ -r ������Ҳ�Ǵ���
     * ������Ϊ2����ָ���Ĳ�����-r����ȡ-r֮��Ĳ����������������������򷢳���ʾ��Ϣ�����������
     * ������Ϊ4����������������ָ������ȡ[0]��[2]��λ�õĲ������ж��Ƿ���-n -r����һ���������ǣ�������ʾ��Ϣ�����������
     * ������ͨ���жϣ�����һ��������-n�����[1] [3]λ����ֵ�ֱ����Ϊ���ֵ����Ŀ��������һ��������-r����֮��
     * @param command
     */
    public boolean resolve(String[] command){
        int len = command.length;
        //�Ժ�����ʽ����ָ��������ȱ���2����4
        if(len != 2 && len != 4){
            System.out.println("���� -n expCount -r maxValue ����ʽ��-n -r�޴���Ҫ�󣬱���ָ��-r����������ָ��");
            return false;
        }

        if(!hasRParam(command)){
            System.out.println("����ָ�� -r ������ָ�����ֵ��");
            return false;
        }

        //����Ϊ2��ָֻ����-r����
        if(len==2){
            String maxStr = command[1];
            try {
                maxValue = Integer.parseInt(maxStr);
            }catch (NumberFormatException e){
                System.out.println("-n -r֮��Ĳ���Ӧ������");
                return  false;
            }
        }

        //����Ϊ4����������������ָ��
        if(len==4){
            String firstParam = command[0];
            String secondParam = command[2];
            String expStr = null;
            String maxStr = null;


            //����������һ������ -n��-r ���е�һ��������ʾ���������
            if(!(("-n".equals(firstParam) && "-r".equals(secondParam)) || ("-r".equals(firstParam) && "-n".equals(secondParam))
             || ("-e".equals(firstParam) && "-a".equals(secondParam)) || ("-a".equals(firstParam) && "-e".equals(secondParam)))){
                System.out.println("���� -n expCount -r maxValue ����ʽ��-n -r�޴���Ҫ�󣬱���ָ��-r����������ָ��");
                System.out.println("���� -e exercisefile -a answerfile ����ʽ��-e -a�޴���Ҫ�󣬱���ָ��exercisefile��answerfile�ļ��ľ���·��������ָ��");
                return false;
            }

            switch (firstParam){
                //��һ��������-n�� ��ڶ�����������-r
                case "-n":
                    expStr = command[1];
                    maxStr = command[3];
                    break;
                //ͬ��
                case "-r":
                    maxStr = command[1];
                    expStr = command[3];
                    break;

                case "-e":
                    exercisefile = command[1];
                    answerfile = command[3];
                    return true;

                case "-a":
                    answerfile = command[1];
                    exercisefile = command[3];
                    return true;

            }

            try {
                expCounts = Integer.parseInt(expStr);
                maxValue = Integer.parseInt(maxStr);
            }catch (NumberFormatException e){
                System.out.println("-n -r֮��Ĳ���Ӧ������");
                return false;
            }
        }
        return true;
    }

    /**
     * �����Ƿ���� -r ����
     * �Ƿ�
     * ��Ҫ�������-r����
     * @param command
     * @return
     */
    private boolean hasRParam(String[] command){
        for(String s : command){
            if("-r".equals(s)){
                return true;
            }else if ("-e".equals(s)){
                return true;
            }
        }
        return false;
    }

    public int getExpCounts() {
        return expCounts;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public String getExercisefile(){
        return exercisefile;
    }

    public String getAnswerfile() {
        return answerfile;
    }
}