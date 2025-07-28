class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(' ');
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                idx++;
            }
        }
        return answer.toString();
    }
}

public class test {
    public static void main(String[] args) {

        String answer1 = new Solution().solution("try hello world");
        String answer2 = new Solution().solution(	"a          a    ");
        String answer3 = new Solution().solution("  TRy HElLo  WORLD ");
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

    } // main end
} // class end
