import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder result = new StringBuilder();

        char[] XList = X.toCharArray();
        char[] YList = Y.toCharArray();

        Arrays.sort(XList);
        Arrays.sort(YList);
        System.out.println("XList = " + Arrays.toString(XList));
        System.out.println("YList = " + Arrays.toString(YList));

        // check로 구별해가며 for문 진행해보기
        int check = YList.length - 1;
        for ( int i = XList.length - 1; i >= 0; i-- ){
            char x =  XList[i];
            for ( int j = check; j >= 0 ; j-- ){
                char y =  YList[j];
                if ( x == y ){
                    result.append(x);
                    check = j - 1;
                    break;
                } // if end
            } // for end
        } // for end

        String answer = result.toString();
        if ( answer.isEmpty() ) return "-1";
        if ( answer.charAt(0) == '0' ) return "0";

        return answer;
    } // func end
} // class end

public class test {
    public static void main(String[] args) {

        String answer1 = new Solution().solution( "100", "2345" );
        String answer2 = new Solution().solution( "100", "203045" );
        String answer3 = new Solution().solution( "100", "123450" );
        String answer4 = new Solution().solution( "12321", "42531" );
        String answer5 = new Solution().solution( "5525", "1255" );
        System.out.println("answer1 = " + answer1);     // -1
        System.out.println("answer2 = " + answer2);     // 0
        System.out.println("answer3 = " + answer3);     // 10
        System.out.println("answer4 = " + answer4);     // 321
        System.out.println("answer5 = " + answer5);     // 552

    } // main end
} // class end
