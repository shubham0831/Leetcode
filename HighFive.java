package Leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

class HighFive {
    public int[][] highFive(int[][] items) {
        TreeMap <Integer, PriorityQueue<Integer>> avgMap = new TreeMap<>();
        
        for (int[] pairs : items){
            int id = pairs[0];
            int score = pairs[1];
            
            if (!avgMap.containsKey(id)){
                PriorityQueue<Integer> pq = new PriorityQueue<>(5);
                pq.offer(score);
                avgMap.put(id, pq);
            } else {
                PriorityQueue<Integer> pq = avgMap.get(id);
                if (pq.size() != 5){
                    pq.offer(score);
                    avgMap.put(id, pq);
                } else if (pq.size() == 5) {
                    int min = pq.peek();
                    if (min < score){
                        pq.poll();
                        pq.offer(score);
                    }
                    avgMap.put(id, pq);
                }
            }
        }
        
        int[][] sol = new int[avgMap.size()][2];
        int pointer = 0;    
        
        for (int id : avgMap.keySet()){
            sol[pointer][0] = id;
            PriorityQueue<Integer> pq = avgMap.get(id);
            int total = 0;
            int size = pq.size();
            while (!pq.isEmpty()){
                total += pq.poll();
            }
            total = total/size;
            
            sol[pointer][1] = total;
            pointer++;
        }
        
        return sol;
    }
}