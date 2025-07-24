import java.util.ArrayList;
import java.util.Objects;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        // 최대공약수 구하기
        ArrayList<Integer> n_max = new ArrayList<>();
        ArrayList<Integer> m_max = new ArrayList<>();
        int max = 0;
        for ( int i = 1; i <= n; i++ ){
            if ( n % i == 0 ){
                n_max.add(i);
            } // if end
        } // for end
        for ( int i = 1; i <= m; i++ ){
            if ( m % i == 0 ){
                m_max.add(i);
            } // if end
        } // for end
        for ( int i = 0; i < n_max.size(); i++ ){
            System.out.println( n_max.get(i) );
            for ( int j = 0; j < m_max.size(); j++ ){
                if (Objects.equals(n_max.get(i), m_max.get(j))){
                    max = m_max.get(j);
                    break;
                } // if end
            } // for end
        } // for end
        System.out.println( "최대공약수 : " + max );
        answer[0] = max;

        // 최소공배수 구하기
        int min = n * m / max;
        answer[1] = min;


        System.out.println( "최소공배수 : " + min );

        return answer;
    }
}


public class test {
    public static void main(String[] args) {

        new Solution().solution( 3 , 12 );
        new Solution().solution( 2 , 5 );

    } // main end
} // class end
