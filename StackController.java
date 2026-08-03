public final class StackController {
    private StackController() {}

    public static <T> Stack<T> reverse(Stack<T> stack){
        Stack<T> reversed = new Stack<>();
        while(!stack.empty()){
            reversed.push(stack.pop());
        }
        return reversed;
    }

    public static boolean isValidBrackets(char[] brackets){
        Stack<Character> stack = new Stack<>();
        for(char c : brackets){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                char top = stack.pop();
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) return false;
            }
        }
        return stack.empty();
    }


    public static int[] NextGreaterElements(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

            while(!stack.empty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while(!stack.empty()){
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void print(Stack<?> stack){
        Stack<?> temp = reverse(stack);
        System.out.print("[");
        while(!temp.empty()){
            System.out.print(temp.pop());
            if(!temp.empty()) System.out.print(", ");
        }
        System.out.println("]");
    }

}
