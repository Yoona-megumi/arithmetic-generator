package expression;

import util.Ran;
import java.util.ArrayList;
        /*
        * ���ʽ���࣬��װ��һ��������
        */
public class Expression {
    private TreeNode root;//���ڵ�
    private int opCounts;//���������
    private int max;//�����������������ֵ
    private ArrayList<TreeNode> opeList = new ArrayList<>();//��˳����������ļ���

    public TreeNode getRoot() {
        return root;
    }

    public Expression(int opCounts, int max){
        this.opCounts = opCounts;
        this.max = max;
    }

    public int getOpCounts() {
        return opCounts;
    }

    /**
     * ��ȡ���յı��ʽ
     * @return str
     */
    public String toString(){
        String str = root.toString();
        str = str.substring(1, str.length()-1);
        return str;
    }

    /**
     * ���㲢��֤���ʽ
     * @return result
     */
    public String CalAndVal(){
        return root.getResult();
    }

    /**
     * ���ַ�����ʽ���ر��ʽ�ļ�����
     * @return
     */
    public String getResult(){
        return root.getResult();
    }

    /**
     * ���㣨��ȫ�������������(����)
     *
     * @return deep
     */
    public int getDeep(){
        int i = this.opCounts;
        int deep = 2;
        while(i/2 > 0){
            deep++;
            i /= 2;
        }
        return deep;
    }

    /**
     * ���ɶ�����
     */
    public void createExpression(){
        TreeNode lchild, rchild, lnode, rnode;

        //ֻ��һ�������
        if(opCounts == 1){
            lchild = new TreeNode(Ran.getNumber(max), null, null);
            rchild = new TreeNode(Ran.getNumber(max), null, null);
            root = new TreeNode(Ran.getOperator(), lchild, rchild);
        }
        else{
            int num1 = 0;
            // int n = getDeep() - 3;
            boolean[] place = Ran.getChildPlace(opCounts);
            root = new TreeNode(Ran.getOperator(), null, null);
            opeList.add(root);

            //������������������3�������
            // for(int i = 0; i < n; i++){
            //     for(int j = 0; j < (int)Math.pow(2, i); j++, num1++){
            //         lchild = new TreeNode(Ran.getOperator(), null, null);
            //         rchild = new TreeNode(Ran.getOperator(), null, null);
            //         opeList.get(j + num1).setChild(lchild, rchild);
            //         opeList.add(lchild);
            //         opeList.add(rchild);
            //     }
            // }

            for(int i = 0; i < place.length; i++){
                //place[i]Ϊtrue������һ�����������Ϊ������������������Һ���������
                if(place[i]){
                    lnode  = new TreeNode(Ran.getNumber(max), null, null);
                    rnode  = new TreeNode(Ran.getNumber(max), null, null);
                    //iΪż������0��ʼ�ģ������´������������Ϊ��ǰ��㣨������������ӣ�Ϊ�棬����Ϊ�к���
                    if(i%2 == 0){
                        lchild = new TreeNode(Ran.getOperator(), lnode, rnode);
                        opeList.add(lchild);
                        opeList.get(num1).setLchild(lchild);
                    }
                    else{
                        rchild = new TreeNode(Ran.getOperator(), lnode, rnode);
                        opeList.add(rchild);
                        opeList.get(num1).setRchild(rchild);
                    }
                }
                //place[i]Ϊfalse����ֻ����һ������������װ����ǰ����������Һ���
                else{
                    if(i%2 == 0){
                        lchild = new TreeNode(Ran.getNumber(max), null, null);
                        opeList.get(num1).setLchild(lchild);
                    }
                    else{

                        rchild = new TreeNode(Ran.getNumber(max), null, null);
                        opeList.get(num1).setRchild(rchild);
                    }
                }
                //num1Ϊż����˵����ǰ��㻹δ�����к��ӣ�num1���䣻������������+1
                num1 = num1 + i%2;
            }
        }
        CalAndVal();//���������������У��
    }
}