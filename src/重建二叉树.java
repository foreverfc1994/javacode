import util.TreeNode;
public class 重建二叉树 {
    public static  TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null){
            return null;
        }
        TreeNode root = build(pre,0,pre.length-1,in,0,in.length-1);
        return root;

    }
    public  static TreeNode build(int [] pre,int startpre,int endpre,int [] in,int startin,int endin){
        if(startpre>endpre||startin>endin){
            return null;
        }
        TreeNode root = new TreeNode(pre[startpre]);
        if(startin==endpre&&startpre==endin){

            root.left=null;
            root.right=null;
            return root;
        }
        int rootindex = -1;
        for (int i = 0; i <in.length ; i++) {
            if(in[i]==pre[startpre]){
                rootindex=i;
                break;
            }

        }
        root.left = build(pre,startpre+1,startpre+rootindex-startin,in,startin,rootindex-1);
        root.right = build(pre,rootindex-startin+startpre+1,endpre,in,rootindex+1,endin);
        return root;


    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);

    }
}
