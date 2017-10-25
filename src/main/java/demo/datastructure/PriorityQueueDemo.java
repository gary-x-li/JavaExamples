package demo.datastructure;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<String> minHeap = new PriorityQueue<>();
		minHeap.add("Alaska");
		minHeap.add("New Hampshire");
		minHeap.add("Hawaii");
		
		System.out.println("Min Heap:");
		int size = minHeap.size();
		for (int i = 0; i < size; i++) {
			System.out.println(minHeap.remove());
		}
		
		PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.add("Alaska");
		maxHeap.add("New Hampshire");
		maxHeap.add("Hawaii");
		
		System.out.println("Max Heap:");
		size = maxHeap.size();
		for (int i = 0; i < size; i++) {
			System.out.println(maxHeap.remove());
		}
	}

}
