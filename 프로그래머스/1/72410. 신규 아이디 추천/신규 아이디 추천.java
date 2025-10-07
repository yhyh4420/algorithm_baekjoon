class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isLowerCase(c) || c=='-' || c=='_' || c=='.' || Character.isDigit(c)) {
                if (sb.length()>0 && c=='.' && sb.charAt(sb.length()-1)=='.'){
                    continue;
                }
                sb.append(c);
            }
        }
        deleteDot(sb);
        if (sb.length() == 0) {
            sb.append('a');
        }
        
        if (sb.length() >= 16) {
            sb.setLength(15);
        }
        deleteDot(sb);
        if (sb.length() <= 2) {
            char c = sb.charAt(sb.length()-1);
            while (sb.length() != 3) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public void deleteDot(StringBuilder sb) {
        if (sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
        }
        if (sb.length() != 0 && sb.charAt(sb.length()-1)=='.') {
            sb.deleteCharAt(sb.length()-1);
        }
    }
}