import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());        // 테스트케이스 T
        for (int i = 0; i < T; i++){
            int M = Integer.parseInt(br.readLine());    // 수열 크기 M
            answer.append(M / 2 + 1).append("\n");
            // 큰 우선순위큐와 작은 우선순위큐를 나눠서 생각해보기
            PriorityQueue<Integer> 중앙값기준작은큐 = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> 중앙값기준큰큐 = new PriorityQueue<>();
            for (int j = 0; j < M / 10 + 1; j++){
                int count = 1;
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    int num = Integer.parseInt(st.nextToken());
                    // 각 큐의 size를 비교해서 짝수일때는 항상 같은 size를 유지하게
                    // size가 다르면, 각 peek를 비교해서 넣기
                    if (중앙값기준작은큐.isEmpty() && 중앙값기준큰큐.isEmpty()){
                        중앙값기준작은큐.add(num);
                    } else if (중앙값기준작은큐.isEmpty() && !중앙값기준큰큐.isEmpty()){
                        if (중앙값기준큰큐.peek() > num){
                            중앙값기준작은큐.add(num);
                        } else {
                            중앙값기준작은큐.add(중앙값기준큰큐.poll());
                            중앙값기준큰큐.add(num);
                        } // if end
                    } else if (!중앙값기준작은큐.isEmpty() && 중앙값기준큰큐.isEmpty()){
                        if (중앙값기준작은큐.peek() > num){
                            중앙값기준큰큐.add(중앙값기준작은큐.poll());
                            중앙값기준작은큐.add(num);
                        } else {
                            중앙값기준큰큐.add(num);
                        } // if end
                    } else {
                        if (중앙값기준작은큐.peek() > num){
                            중앙값기준큰큐.add(중앙값기준작은큐.poll());
                            중앙값기준작은큐.add(num);
                        } else if (중앙값기준큰큐.peek() < num){
                            중앙값기준작은큐.add(중앙값기준큰큐.poll());
                            중앙값기준큰큐.add(num);
                        } else {
                            if (중앙값기준작은큐.size() > 중앙값기준큰큐.size()){
                                중앙값기준큰큐.add(num);
                            } else {
                                중앙값기준작은큐.add(num);
                            } // if end
                        } // if end
                    } // if end
                    System.out.println("중앙값기준작은큐 = " + 중앙값기준작은큐);
                    System.out.println("중앙값기준큰큐 = " + 중앙값기준큰큐);
                    System.out.println("====================");
                    if (count % 2 == 1){        // 홀수면
                        if (중앙값기준작은큐.size() > 중앙값기준큰큐.size()){
                            answer.append(중앙값기준작은큐.peek()).append(" ");
                        } else {
                            answer.append(중앙값기준큰큐.peek()).append(" ");
                        } // if end
                    } // if end
                    count++;
                } // while end
            } // for end
            answer.append("\n");
        } // for end

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end