import java.util.*;

public class MyMinHeap implements MinHeapFace{
	private int[] Heap;
	private int heapsize;

	// construct the heap array by using capacity
	public MyMinHeap(){
    //set the value as 20
		Heap = new int[20];
    //set the counter
		heapsize = 0;
    //set the first one as min value of interger
		Heap[heapsize] = Integer.MIN_VALUE;
	}
	
	// position for leftchild
	private int leftchild(int position) {
		return position * 2;
	}
 
 	// position for rightchild
	private int rightchild(int position) {
		return position * 2 + 1;
	}
 
  	//  for parent
	private int parent(int position) {
		return position / 2;
	}

	// increase the heap sieze
	private void resize(){
		double incre = heapsize * 1.2;
		int[] increHeap = new int[(int)incre];
		System.arraycopy(Heap,0,increHeap,0,heapsize);
		Heap = increHeap;
	}

	// use to swap two number
	private void swap(int position1, int position2) {
		int temporary;
		temporary = Heap[position1];
		Heap[position1] = Heap[position2];
		Heap[position2] = temporary;
	}

	// push up
	private void upheap(int position){
		if(position == 0) return;
		if(Heap[position] < Heap[parent(position)]){
			swap(position, parent(position));
		}
		upheap(parent(position));
	}

	// push down
	private void downheap(int position){
    //if no child 
		if(leftchild(position) > heapsize) return;
    //has left child
		if(rightchild(position) > heapsize){
			if(Heap[position] > Heap[leftchild(position)]){
				swap(position,leftchild(position));
			}
			return;
		}
    //has two child
		if(Heap[position] > Heap[leftchild(position)] ||  Heap[position] > Heap[rightchild(position)]){
			if (Heap[leftchild(position)] < Heap[rightchild(position)]) { 
                swap(position, leftchild(position)); 
                downheap(leftchild(position)); 
            } 
            else 
            { 
                swap(position, rightchild(position)); 
                downheap(rightchild(position)); 
            } 
        }       
	}

	// add new elements int to MinHeap
	public void add(int elements){
		heapsize ++;
    //if oversize
		if(heapsize == Heap.length){
			resize();			
		}
		Heap[heapsize] = elements;
		upheap(heapsize);
	}


	// return the top of heap empty heap should display a warning message to System.err and return -1.
	public int get(){
    if(isEmpty() == true){
			System.err.println("Array is empty.");
			return -1;
		}
		else{
			return Heap[1];
		}
	}

	// return count of how many items in heap
	public int size(){
		return heapsize;
	}

	// return true if nothing in heap, false otherwise
	public boolean isEmpty(){
		return heapsize == 0;
	}

	// remove everything from heap
	public void clear(){
		heapsize = 0;
	}

	// remove top of heap
	public void remove(){
    if(isEmpty() == true) return;
		swap(1,heapsize);
		heapsize --;
		downheap(1);
	}

	// replace top of heap with int
	public void replace(int elements){
    if(isEmpty() == true) add(elements);
	  Heap[1] = elements;
    downheap(1);
	}
}
