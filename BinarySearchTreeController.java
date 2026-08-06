public final class BinarySearchTreeController {
    private BinarySearchTreeController() {}

    // --- Traversals ---
    public static void preOrder(TreeNode node){
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(TreeNode node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    public static void levelOrder(TreeNode node){
        if(node == null) return;
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(node);

        while(!(queue.isEmpty())){
            TreeNode current = queue.dequeue();
            System.out.print(current.value + " ");
            if(current.left != null) queue.enqueue(current.left);
            if(current.right != null) queue.enqueue(current.right);
        }
    }

    // --- Metrics ---
    public static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static int size(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public static int countLeaves(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // --- Transform ---
    public static void invert(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }

    // --- Validation ---
    public static boolean isValidBST(TreeNode node){
        return validate(node, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true;
        }
        if((min != null && node.value <= min) || (max != null && node.value >= max)){
            return false;
        }
        return validate(node.left, min, node.value) && validate(node.right, node.value, max);
    }

    // --- Queries ---
    public static int lowestCommonAncestor(TreeNode root, int a, int b){
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

    public static int kthSmallest(TreeNode root, int k){
        int[] count = {0};
        int[] result = {-1};
        kthSmallest(root, k, count, result);
        return result[0];
    }

    private static void kthSmallest(TreeNode node, int k, int[] count, int[] result){
        if(node == null){
            return;
        }
        kthSmallest(node.left, k, count, result);
        count[0]++;

        if(count[0] == k){
            result[0] = node.value;
            return;
        }

        kthSmallest(node.right, k, count, result);
    }
}
