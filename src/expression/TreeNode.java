package expression;

import util.Calculator;
import util.Ran;

public class TreeNode {
    private String str;
    private TreeNode rchild = null;
    private TreeNode lchild = null;

    public TreeNode(String str, TreeNode lchild, TreeNode rchild){
        this.str = str;
        this.rchild = rchild;
        this.lchild = lchild;
    }

    public String getStr() {
        return str;
    }

    public void setChild(TreeNode lchild, TreeNode rchild){
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    public TreeNode getLchild() {
        return lchild;
    }
    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    private void swapChild(){
        TreeNode temp = getLchild();
        setLchild(getRchild());
        setRchild(temp);
    }

    /**
     * ��ȡÿ���ڵ���������������飺
     * - �����б������Ƿ�С�ڼ��������ǣ���������
     * - �����г����Ƿ�Ϊ0�����ǣ��滻��ǰ���������Ϊ���������
     * @return result
     */
    public String getResult(){
        //�����ӽڵ㣬˵����ǰ����������
        if(hasChild()){
            switch(str){
                case "+":
                    return Calculator.add(getLchild().getResult(), getRchild().getResult());
                case "-":
                    String subResult = Calculator.sub(getLchild().getResult(), getRchild().getResult());
                    //������ֵΪ-1���������Һ���
                    if(subResult.contains("-")){
                        swapChild();
                        return Calculator.sub(getLchild().getResult(), getRchild().getResult());
                    }
                    else {
                        return subResult;
                    }
                case "x":
                    return Calculator.mul(getLchild().getResult(), getRchild().getResult());
                case "��":
                    String divResult = Calculator.division(getLchild().getResult(), getRchild().getResult());
                    //���ؽ��Ϊ-1����ʾ����Ϊ0���滻�����
                    if(divResult.contains("-")){
                        while(str.equals("��")){
                            //����ǰ�����ת��Ϊ���������
                            str = Ran.getOperator();
                        }
                        return this.getResult();
                    }
                    else {
                        return divResult;
                    }
            }
        }
        //���ӽڵ㣬˵����ǰ�����Ҷ�ӽ�㣬ֱ�ӷ��ؽ��ֵ
        return str;
    }

    /**
     * �ȶ�ÿ������ʽ������ţ�Ȼ�����ȥ���ŷ���ȥ���������ʽ������
     * @return string
     */
    public String toString(){
        String leftExp = "";//����ʽ
        String rightExp = "";//�ұ��ʽ
        String result = "";//�����

        if(hasChild()){
            //����������к��ӣ�˵����������һ�����ʽ�����������ֽڵ㡣
            if(getRchild().hasChild()){
                //�ж��������ŵ�������Ƿ�Ϊ'/'
                if(str.equals("��")){
                    //��ȡ�������ı��ʽ����������
                    rightExp = getRchild().toString();
                }
                //�ж��������ŵ�������Ƿ�Ϊ'x'��'-'
                else if(str.equals("x") || str.equals("-")){
                    //�ж�op�Ƿ�Ϊ'+'��'-'
                    if(getRchild().str.equals("+") || getRchild().str.equals("-")){
                        rightExp = getRchild().toString();
                    }
                    else{
                        //��ȡ�������ı��ʽ������ȥ����
                        rightExp = getRchild().toString().substring(1, getRchild().toString().length()-1);
                    }
                }
                else{
                    //����������֮�ⶼ�ǿ���ȥ���ŵġ�
                    rightExp = getRchild().toString().substring(1, getRchild().toString().length()-1);
                }
            }
            else{
                rightExp = getRchild().str;
            }

            //�����������ͬ����������
            if(getLchild().hasChild()){
                if(str.equals("x") || str.equals("��")){
                    if(getLchild().str.equals("+") || getLchild().str.equals("-")){
                        leftExp = getLchild().toString();
                    }
                    else{
                        leftExp = getLchild().toString().substring(1, getLchild().toString().length()-1);
                    }
                }
                else{
                    leftExp = getLchild().toString().substring(1, getLchild().toString().length()-1);
                }
            }
            else{
                leftExp = getLchild().str;
            }
            //��ȡ��ǰ������ʽ������������
            result = "(" + leftExp + " " + str + " " + rightExp + ")";
        }
        else{
            //��û�к��ӣ�˵�������ֽڵ㣬ֱ�ӷ�������
            result = str;
        }
        return result;
    }

    public boolean hasChild(){
        return !(lchild == null && rchild == null);
    }
}
