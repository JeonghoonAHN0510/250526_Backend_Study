class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int tLength = t.length();
        int pLength = p.length();

        for ( int i = 0; i <= tLength - p.length(); i++ ){
            int intT = Integer.parseInt( t.substring( i , pLength++ ) );
            int intP = Integer.parseInt( p );
            if ( intT <= intP ){
                answer++;
            }
        } // for end
        return answer;
    }
}


public class test {
    public static void main(String[] args) {

        int answer1 = new Solution().solution("3141592", "271");            System.out.println( answer1 );
        int answer2 = new Solution().solution("500220839878", "7");         System.out.println( answer2 );
        int answer3 = new Solution().solution("10203", "15");               System.out.println( answer3 );
        int answer4 = new Solution().solution("1", "1");                    System.out.println( answer4 );

    } // main end
} // class end
