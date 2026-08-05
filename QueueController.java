public final class QueueController{

    public static <T> Queue<T> reverse(Queue<T> queue){
        Stack<T> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        Queue<T> newQueue = new Queue<>();
        while(!stack.isEmpty()){
            newQueue.enqueue(stack.pop());
        }
        return newQueue;
    }

    public static <T> Queue<T> reverseFirstK(Queue<T> queue, int k){
        Stack<T> stack = new Stack<>();
        Queue<T> newQueue = new Queue<>();

        for(int i = 0; i < k && !queue.isEmpty(); i++){
            stack.push(queue.dequeue());
        }
        while(!stack.isEmpty()){
            newQueue.enqueue(stack.pop());
        }
        while(!queue.isEmpty()){
            newQueue.enqueue(queue.dequeue());
        }
        return newQueue;
    }

    public static <T> Queue<T> interleave(Queue<T> queue){
        Queue<T> newQueue = new Queue<>();
        Queue<T> firstHalf = new Queue<>();
        int size = queue.size();

        for(int i = 0; i < size/2; i++){
            firstHalf.enqueue(queue.dequeue());
        }
        for(int i = 0; i < size/2; i++){
            newQueue.enqueue(firstHalf.dequeue());
            newQueue.enqueue(queue.dequeue());
        }
        if(size % 2 != 0){
            newQueue.enqueue(queue.dequeue());
        }
        return newQueue;
    }
}
