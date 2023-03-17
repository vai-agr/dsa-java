package alg.string;

import java.util.ArrayList;
import java.util.List;

//string matching algorithm using hashing
public class RabinKarp {
    private final int p = 31;
    private final int MOD = (int)1e9 + 9;
    private long[] pPowers;
    
    public List<Integer> findMatches(String s, String t){
        List<Integer> matchedIndexes = new ArrayList<>();

        int m = s.length(), n = t.length();
        if(m<n){
            return matchedIndexes;
        }

        pPowers = new long[m];
        pPowers[0] = 1;
        for(int i=1; i<m; i++)
            pPowers[i] = (pPowers[i-1]*p)%MOD;

        long hashT = 0;
        int i = 0;
        for(char c: t.toCharArray()){
            hashT+=((c-'a'+1)*pPowers[i])%MOD;
            i++;
        }
        

        long[] hashS = new long[m+1];
        hashS[0] = 0;
        i=1;

        for(char c:s.toCharArray()){
            if(i<n){
                hashS[i] = (hashS[i-1] + pPowers[i-1]*(c-'a'+1))%MOD ;
                i++;
                continue;
            }
            
            hashS[i] = (hashS[i-1] + pPowers[i-1]*(c-'a'+1))%MOD;
            if(hashS[i] - hashS[i-n] == hashT*pPowers[i-n] %MOD)
                matchedIndexes.add(i-n);
            i++;

        }

        return matchedIndexes;
    }

    public static void main(String[] args) {
        String s = "abccabacbabccabbcaabc", t = "abc";
        RabinKarp rk = new RabinKarp();
        List<Integer> ans = rk.findMatches(s,t);
        for (Integer i : ans) {
            System.out.print(i+" ");
        }
    }
}
