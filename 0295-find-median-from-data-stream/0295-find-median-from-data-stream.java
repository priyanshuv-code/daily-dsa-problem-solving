class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    public MedianFinder() {
        // Default PriorityQueue = Min Heap
        minheap = new PriorityQueue<>();

        // Max Heap
        maxheap = new PriorityQueue<>((a, b) -> b - a);

    }
    
    public void addNum(int num) {
        maxheap.add(num);
        if(!maxheap.isEmpty() && !minheap.isEmpty() && maxheap.peek()> minheap.peek()){
            minheap.add(maxheap.poll());
        }
        if(maxheap.size()>minheap.size()+1){
            minheap.add(maxheap.poll());
        }
        if(minheap.size()>maxheap.size()+1){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()>minheap.size()){
            return maxheap.peek();
        }
        else if(minheap.size()>maxheap.size()){
            return minheap.peek();
        }
        else {
            return (maxheap.peek()+minheap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */