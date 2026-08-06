public class TreeNode {
    int value;
    TreeNode right;
    TreeNode left;



    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setRight(TreeNode n){
        this.right = n;
    }

    public void setLeft(TreeNode n){
        this.left = n;
    }
    /*
    public TreeNode getRight(){
        return right;
    }
    public TreeNode getLeft(){
        return left;
    }
    public int getValue(){
        return value;
    }
     */

}
