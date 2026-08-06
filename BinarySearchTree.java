
public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
            return;
        }
        TreeNode current = root;
        while(true){
            if(value < current.value){
                // less than, smaller values left
                if(current.left == null){
                    current.left = new TreeNode(value);
                    return;
                } 
                current = current.left;
            }else{
                if(current.right == null){
                    current.right = new TreeNode(value);
                    return;
                } 
                current = current.right;
            }
        }
    }

    public boolean search(int value){
        TreeNode current = root;
        while(current != null){
            if(current.value < value){
                current = current.right;
            }else if(current.value > value){
                current = current.left;
            }else{
                return true;
            }
        }
        return false;
    }
    public int min(){
        if(root == null){
            return -1;
        }
        TreeNode current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.value;
    }

        public int max(){
        if(root == null){
            return -1;
        }
        TreeNode current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.value;
    }

    public void preOrder(TreeNode node){
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    public void postOrder(TreeNode node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

}
