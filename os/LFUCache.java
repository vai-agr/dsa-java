package os;
//PASSED

import java.util.*;


class LFUCache {

    // key = key, value: {frequency, value}
    Map<Integer, int[]> cache; 
    Map<Integer, LinkedHashSet<Integer>> freq;
    int minf;
    int capacity;

    private void update(int key){
        int prevFreq = cache.get(key)[0];
        cache.get(key)[0]++;
        freq.get(prevFreq).remove(key);
        if(!freq.containsKey(prevFreq+1))
            freq.put(prevFreq+1, new LinkedHashSet<>());
        freq.get(prevFreq+1).add(key);
        if(minf == prevFreq && freq.get(prevFreq).isEmpty()){
            minf = prevFreq+1;
        }
        
    }

    private void insert(int key, int value){
        cache.put(key, new int[]{1, value});
        if(!freq.containsKey(1))
            freq.put(1, new LinkedHashSet<>());
        freq.get(1).add(key);
        minf =1;
    }
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();    
        minf = Integer.MAX_VALUE;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        update(key);
        return cache.get(key)[1];
    }
    
    public void put(int key, int value) {
         if (capacity <= 0) {
            return;
        }
        if(cache.containsKey(key)){
            cache.get(key)[1] = value;
            update(key);
        }

        else if(cache.size()<capacity){
            insert(key, value);
        }
        else{
            int removeKey = freq.get(minf).iterator().next();
            freq.get(minf).remove(removeKey);
            cache.remove(removeKey);
            insert(key,value);
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */