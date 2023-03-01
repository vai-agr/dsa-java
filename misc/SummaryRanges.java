package misc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SummaryRanges {
    private Set<Integer> set;
    public SummaryRanges() {
        set = new HashSet<>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {
        List<int[]> ans = new ArrayList<int[]>();

        

        return (int[][]) ans.toArray();
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */