import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Double> arr = makeArray((double) k);
        double[] prefix = new double[arr.size()];
        prefix[0] = 0.0;
        for (int i=0; i<arr.size()-1; i++){
            double area = (arr.get(i)+arr.get(i+1))/2;
            prefix[i+1] = prefix[i] + area;
        }
        for (int i=0; i<ranges.length; i++){
            int end = arr.size()+ranges[i][1]-1;
            int start = ranges[i][0];
            if (start>end){
                answer[i] = -1;
            } else{
                answer[i] = prefix[end]-prefix[start];
            }
        }
        return answer;
    }
    
    public List<Double> makeArray(double k){
        List<Double> answer = new ArrayList<>();
        answer.add(k);
        while (k != 1){
            if (k%2==0){
                k /= 2;
            } else {
                k =k*3 + 1;
            }
            answer.add(k);
        }
        return answer;
    }
}