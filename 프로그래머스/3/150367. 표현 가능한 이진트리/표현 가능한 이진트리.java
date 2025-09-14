class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            int treeHeight = 0;
            while(Math.pow(2,treeHeight)-1 < binary.length()) {
                treeHeight++;
            }
            int treeSize = (int) Math.pow(2,treeHeight) - 1;
            while (treeSize>binary.length()){
                binary = "0"+binary;
            }
            if (isBinary(binary)){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    public boolean isBinary(String binary) {
        int mid = binary.length()/2;
        char parent = binary.charAt(mid);
        
        String left = binary.substring(0,mid);
        String right = binary.substring(mid+1, binary.length());
        
        if (parent=='0' && (left.contains("1")||right.contains("1"))) {
            return false;
        }
        boolean leftOK = (left.length()<3) || isBinary(left);
        boolean rightOK = (right.length()<3) || isBinary(right);
        
        return leftOK && rightOK;
    }
}