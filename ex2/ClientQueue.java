class ClientQueue{
	private Client head;
	private Client prev;

	public ClientQueue(){
		head = null;
		prev = null;
	}

	//takes an int arrival time t, and a usage time u, creates a Client node with that information and puts it on the end of a linked list queue.
	public void enqueue(int arrTime, int useTime){
		Client current = new Client(arrTime,useTime);
		if(prev == null){
			head = prev = current;
		}
		else{
			prev.next=current ;
			prev = current ;
		}
	}

	//removes the head of the queue (the Client that has been in the queue the longest)
	public void dequeue(){
		if(head == null){
			return;
		}
		else{
			Client current = head;
			head = current.next;
			current.next=null;
			if(head == null){
				prev = null;
			} 
		}	
	}

	//returns the int value of arrTime for the Client at the head of the queue
	public int peekArrive(){
		if(head == null){
      return 0;
    }
    else{
       return head.arrTime;
    }  
	}

	//returns the int value of useTime for the Client at the head of the queue
	public int peekUsage(){
		if(head == null){
      return 0;
    }
    else{
       return head.useTime;
    }  
	}

	//returns an int count of the number of Clients currently in the queue
	public int length(){
		//set the counter as 0
		int count = 0;
		Client current = head;
		//for all the node in the list
		while(current!=null){
			//add one
			count++ ;
			//point to next node
			current = current.next;
		}
		return count;
	}

	//returns boolean value true if the queue is empty, false otherwise
	public boolean isEmpty(){
		//if is empty than print true
		if(head == null){
			return true;
		}
		//if is not empty than print flase
		else{
			return false;
		}
	}	

	//the structrue to creat the ClientQueue 
	private class Client{
		//an int to store the arrival time of the client
		private int arrTime;
		//an int to store how much time the client will need to use the server when it gets to the head of the queue
		private int useTime;
		//a reference to another Client so that a linked list of Clients can be formed
		private Client next;
		//creat the node
		private Client(int arrTime, int useTime){
			this.arrTime = arrTime;
			this.useTime = useTime;
			next = null;
		}
	}
}
