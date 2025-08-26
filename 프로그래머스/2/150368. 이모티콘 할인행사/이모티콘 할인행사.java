class Solution {
    int[] discount = {10,20,30,40};
    int[][] users;
    int[] emoticons;
    int maxJoin = 0;
    int maxSales = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        
        back(0, new int[emoticons.length]);
        return new int[]{maxJoin, maxSales};
    }
    
    public void back(int idx, int[] rates){
        if (idx == emoticons.length){
            int join = 0;
            int sales = 0;
            for (int[] user : users){
                int wantDiscount = user[0];
                int emoPlusBound = user[1];
                int sum = 0;
                for (int i = 0; i<emoticons.length; i++){
                    if (wantDiscount <= rates[i]){
                        sum += (emoticons[i] * (100 - rates[i]) / 100);
                    }
                }
                if (sum >= emoPlusBound){
                    sum=0;
                    join++;
                }
                sales += sum;
            }
            if (join > maxJoin){
                maxJoin = join;
                maxSales = sales;
            } else if (join == maxJoin){
                maxSales = Math.max(sales, maxSales);
            }
            return;
        }
        for (int rate : discount){
            rates[idx] = rate;
            back(idx+1, rates);
        }
    }
}