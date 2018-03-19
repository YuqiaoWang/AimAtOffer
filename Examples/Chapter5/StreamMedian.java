import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Override;

/**
 * 面试题41：数据流中的中位数
 */
public class StreamMedian {
    int count = 0;
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        if((count & 1) == 0) {  //存储序列为基数个元素时
            if(!maxheap.isEmpty() && num < maxheap.peek()) {
                maxheap.offer(num);
                num = maxheap.poll();
            }
        }else {                 //存储序列为偶数个元素时
            if(!minheap.isEmpty() && num > minheap.peek()) {
                minheap.offer(num);
                num = minheap.poll();
            }
            maxheap.offer(num);
        }
    }

    public double getMedian() {
        if(count == 0) {
            throw new RuntimeException("Invalid");
        }
        double median = 0;
        if((count & 1) == 1) {
            median = maxheap.peek();
        }else {
            median = (maxheap.peek() + minheap.peek()) /2.0;
        }
        return median;
    }

}
