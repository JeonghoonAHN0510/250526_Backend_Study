import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 보석 개수 N
        int K = Integer.parseInt(st.nextToken());       // 가방 개수 K
        PriorityQueue<String> pq = new PriorityQueue<>(new  Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st1 = new StringTokenizer(o1);
                StringTokenizer st2 = new StringTokenizer(o2);
                int weight1 = Integer.parseInt(st1.nextToken());
                int price1 = Integer.parseInt(st1.nextToken());
                int weight2 = Integer.parseInt(st2.nextToken());
                int price2 = Integer.parseInt(st2.nextToken());
                if (weight1 > weight2){
                    return -1;
                } else if (weight1 < weight2){
                    return 1;
                } else {
                    if (price1 > price2){
                        return -1;
                    } else {
                        return 1;
                    } // if end
                } // if end
            } // func end
        });


        Map<Integer, Integer> jewelMap = new TreeMap<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            jewelMap.put(a, Math.max(jewelMap.getOrDefault(a, 0), b));
        } // for end
        PriorityQueue<Integer> bagPQ = new PriorityQueue<>();
        for (int i = 0; i < K; i++){
            bagPQ.offer(Integer.parseInt(br.readLine()));
        } // for end
        long totalWeight = 0;
        for (int weight : bagPQ){
            int maxWeight = 0;
            int maxKey = 0;
            for (Integer key : jewelMap.keySet()){
                if (key <= weight){
                    maxWeight = Math.max(maxWeight, jewelMap.get(key));
                    maxKey = key;
                } else {
                    break;
                } // if end
            } // for end
            totalWeight += maxWeight;
            jewelMap.remove(maxKey);
        } // for end

        answer.append(totalWeight);

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    } // main end
} // class end