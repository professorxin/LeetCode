package algorithm._295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

class MedianFinder {

    /*中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。*/

    private int N = 0;
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public double findMedian() {
        if (N % 2 == 0) {
            return (double) (left.peek() + right.peek()) / 2;
        } else {
            return (double) right.peek();
        }
    }
}
