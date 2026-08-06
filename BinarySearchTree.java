
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

    public int min(TreeNode root){
        if(root == null){
            return -1;
        }
        TreeNode current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.value;
    }

    public int max(TreeNode root){
        if(root == null){
            return -1;
        }
        TreeNode current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.value;
    }

    public void delete(int n){
        root = delete(root, n);
    }

    private TreeNode delete(TreeNode node, int n){
        if(node == null){
            return null;
        }

        if(n < node.value){
            node.left = delete(node.left, n);
        }else if( n > node.value){
            node.right = delete(node.right, n);
        }else{

            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }

            int successor = min(node.right);
            node.value = successor;
            node.right = delete(node.right, successor);

        }
        return node;
    }
}
