public class MapController {
    public static int mostFrequent(int[] nums){

        int bestElement = nums[0];
        int bestCount = 0;
        Map<Integer, Integer> map = new Map<Integer, Integer>();
        for(int n : nums){

            Integer seen = map.get(n);
            int count = seen == null ? 1 : seen + 1;
            map.put(n, count);


            if(count > bestCount){
                bestCount = count;
                bestElement = n;
            }

        }



        return bestElement;


    } 



    public static int[] twoSum(int[] nums, int x){
        Map<Integer, Integer> map = new Map<Integer, Integer>();
        int[] result = {0, 0};

        for(int i = 0; i < nums.length; i++){
            int needed = x - nums[i];

            if(map.containsKey(needed)){
                result[0] = map.get(needed);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);

        }
        return result;
    }
    public static int[] twoSumValues(int[] nums, int x){
        Map<Integer, Integer> map = new Map<Integer, Integer>();
        int[] result = {0, 0};

        for(int i = 0; i < nums.length; i++){
            int needed = x - nums[i];

            if(map.containsKey(needed)){
                result[0] = needed;
                result[1] = nums[i];
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }


    public static boolean containsDuplicate(int[] nums){
        Map<Integer, Boolean> map = new Map<Integer, Boolean>();

        for(int n : nums){
            if(map.containsKey(n)){
                return true;
            }
            map.put(n, true);
        }
        return false;
    }

    public static boolean isAnagram(String word, String check){
        if(word.length() != check.length()) return false;
        Map<Character, Integer> map = new Map<Character, Integer>();


        for(char c : word.toCharArray()){
            Integer seen = map.get(c);
            map.put(c, seen == null ? 1 : seen + 1);
        }

        for(char c : check.toCharArray()){
            Integer seen = map.get(c);
            if(seen == null || seen == 0) return false;
            map.put(c, seen - 1);
        }
        return true;
    }

}
