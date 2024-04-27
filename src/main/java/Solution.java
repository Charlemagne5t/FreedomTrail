import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < ring.length(); i++) {
            List<Integer> list = map.getOrDefault(ring.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(ring.charAt(i), list);
        }
        Integer[][] memo = new Integer[key.length() + 1][ring.length() + 1];
        return dfs(key, map, 0, 0, ring.length(), memo);
    }
    int dfs(String key, Map<Character, List<Integer>> map, int i, int pos, int len, Integer[][] memo) {
        int n = key.length();
        if(i == n){
            return 0;
        }
        if(memo[i][pos] != null){
            return memo[i][pos];
        }

        int res = Integer.MAX_VALUE;
        char ch = key.charAt(i);

        List<Integer> indexes = map.get(ch);
        for(int j = 0; j < indexes.size(); j++ ) {
            int targetIndex = indexes.get(j);
            int distance = dist(pos, targetIndex, len);
            res = Math.min(res, 1 + distance  + dfs(key, map, i + 1, targetIndex, len, memo));
        }
        memo[i][pos] = res;
        return res;
    }

    int dist(int start, int target, int length){
        if(start == target){
            return 0;
        }

        return Math.min(Math.abs(target - start), length - Math.max(target, start)  + Math.min(target, start));
    }


}
