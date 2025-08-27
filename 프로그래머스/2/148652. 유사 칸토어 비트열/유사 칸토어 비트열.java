class Solution {
    public int solution(int n, long l, long r) {
        return (int) (calculate(n,r)-calculate(n,l-1));
    }
    
    public long calculate(int n, long k){
        long count = 0;
        if (n == 0){return 1;}
        if (k <= 0){return 0;}
        
        long full = k/(long)Math.pow(5,n-1);
        long rem = k%(long)Math.pow(5,n-1);
        
        for (int i=0; i<full; i++){
            if (i == 2){continue;}
            else {count += (long)Math.pow(4,n-1);}
        }
        if (full != 2 && rem>0){
            count+=calculate(n-1, rem);
        }
        return count;
    }
}