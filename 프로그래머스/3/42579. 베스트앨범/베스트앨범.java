import java.util.*;

class Solution {
    
    Map<String, Integer> genrePlayTimeMap = new HashMap<>();
    Map<String, List<Integer>> albumTimeMap = new HashMap<>();
    Map<String, List<Integer>> albumSongMap = new HashMap<>();
    
    /* 
    1. 장르별로 얼마나 재생되었는지, 각 장르별 곡 시간, 각 장르별 곡 고유번호 맵을 구현
    2. value 기준 내림차순하여 어느 장르부터 수록할지 결정
    3. 각 장르별 value로 저장된 리스트를 꺼내서 반복문 두 번 돌아서 상위 두개 곡 뽑음
    4. answer에 저장 후 answer 배열로 변환하여 리턴
    */
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<genres.length; i++) {
            genrePlayTimeMap.put(genres[i], genrePlayTimeMap.getOrDefault(genres[i],0)+plays[i]);
            
            List<Integer> list = albumTimeMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(plays[i]);
            albumTimeMap.put(genres[i], list);
            
            List<Integer> list2 = albumSongMap.getOrDefault(genres[i], new ArrayList<>());
            list2.add(i);
            albumSongMap.put(genres[i], list2);
        }
        
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genrePlayTimeMap.entrySet());
        genreList.sort((a,b) -> b.getValue()-a.getValue());
        for (Map.Entry<String, Integer> e : genreList) {
            String g = e.getKey();
            for (int idx : getSong(g)) {
                answer.add(idx);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    public List<Integer> getSong(String g) {
        int MAX = -1;
        int value = 0;
        int idx = 0;
        List<Integer> albumTime = new ArrayList<>(albumTimeMap.get(g));
        List<Integer> song = new ArrayList<>(albumSongMap.get(g));
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<albumTime.size(); i++) {
            if (albumTime.get(i) > MAX) {
                MAX = albumTime.get(i);
                value = song.get(i);
                idx = i;
            }
        }
        answer.add(value);
        MAX = -1;
        value = 0;
        albumTime.remove(idx);
        song.remove(idx);
        if (albumTime.isEmpty()){
            return answer;
        }
        for (int i=0; i<albumTime.size(); i++) {
            if (albumTime.get(i) > MAX) {
                MAX = albumTime.get(i);
                value = song.get(i);
            }
        }
        answer.add(value);
        return answer;
    }
}