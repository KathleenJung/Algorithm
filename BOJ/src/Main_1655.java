import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 최대 힙 : 중간 값 이하의 값 저장 (왼)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙 : 중간 값 이상의 값 저장 (오)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(br.readLine());
            if(maxHeap.isEmpty() || n < maxHeap.peek()) {
                // 중간 값보다 작은 값들이 비어있거나 중간 값보다 작으면 최대 힙에 넣기
                maxHeap.offer(n);
            } else {
                // 최소 힙에 넣기
                minHeap.offer(n);
            }

            if(maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            System.out.println(maxHeap.peek());
        }
    }
}
