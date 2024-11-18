package HEAPS;

import java.util.ArrayList;

class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Insert an element into the heap
    public void insert(int value) {
        heap.add(value); // Add at the end
        int index = heap.size() - 1;

        // Heapify up
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) <= heap.get(parentIndex)) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // Remove and return the maximum element
    public int extractMax() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty!");

        int max = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastValue);
            heapifyDown(0);
        }
        return max;
    }

    // Heapify down
    private void heapifyDown(int index) {
        while (index < heap.size()) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
                largest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (largest == index) break;
            swap(index, largest);
            index = largest;
        }
    }

    // Swap utility
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display the heap
    public void displayHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(50);
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(16);

        System.out.println("Heap:");
        maxHeap.displayHeap();

        System.out.println("Extract Max: " + maxHeap.extractMax());
        System.out.println("Heap After Extraction:");
        maxHeap.displayHeap();
    }
}
