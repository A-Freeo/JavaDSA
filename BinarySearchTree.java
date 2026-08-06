
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

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }
    public void postOrder(){
        postOrder(root);
    }

    private void preOrder(TreeNode node){
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }
    private void postOrder(TreeNode node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }


    public void levelOrder(TreeNode node){
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(node);

        while(!(queue.isEmpty())){
            TreeNode current = queue.dequeue();
            System.out.print(current.value + " ");
            if(current.left != null) queue.enqueue(current.left);
            if(current.right != null) queue.enqueue(current.right);
        }
    }


    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public int size(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public int countLeaves(TreeNode node){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    public void invert(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }

    public boolean isValidBST(TreeNode node){
        return validate(node, null, null);
    }
    private boolean validate(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true;
        }
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }

        return validate(node.left, min, node.value) && validate(node.right, node.value, max);
    }


    public int lowestCommonAncestor(int a, int b){
        TreeNode current = root;
        while(current != null){
            if(a < current.value && b < current.value){
                current = current.left;
            }else if(a > current.value && b > current.value){
                current = current.right;
            }else{
                return current.value;
            }
        }
        return -1;
    }


    private int count;
    private int result;
    public int kthSmallest(int k){
        count = 0;
        result = -1;
        kthSmallest(root, k);
        return result;
    }

    private void kthSmallest(TreeNode node, int k){
        if(node == null){
            return;
        }
        kthSmallest(node.left, k);
        count++;

        if(count == k){
            result = node.value;
            return;
        }

        kthSmallest(node.right, k);
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
