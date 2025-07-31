class Solution {
    public String solution(int[] food) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for ( int i = 1; i < food.length; i++ ){
            int count = food[i] / 2;
            for ( int j = 1; j <= count; j++ ){
                sb.append(i);
            } // for end
        } // for end
        answer = sb + "0" + sb.reverse();
        return answer;
    } // func end
} // class end

public class test {
    public static void main(String[] args) {

        int[] food1 = { 1, 3, 4 ,6 };
        int[] food2 = { 1, 7, 1, 2 };
        String answer1 = new Solution().solution( food1 );
        String answer2 = new Solution().solution( food2 );
        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);

    } // main end
} // class end
