class SList{	
	private SNode head;

	
	public SList(){
		head = new SNode("");
	}
	
	public void add(String text){
		SNode next = head.next;
		head.next = new SNode(text);
		head.next.next = next;
	}
	
	public void remove(String text){
		SNode current = head;
		if(current == null){
			return;
		}
		else{ 
			if(current.key.equals(text)){
				current = current.next;
			}
			else{			
				while(current != null && current.next != null){
					if(current.next.key.equals(text)){
						current.next = current.next.next;
					}
					current = current.next;					
				}
			}
		
		}
	}

	public boolean has(String text){
		SNode current = head.next;
		while(current != null){
			if(current.key.equals(text)){
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public int length(){
		int count = 0;
		SNode current = head.next;
		while(current!=null){
			count++ ;
			current = current.next;
		}
		return count;
	}

	public boolean isEmpty(){
		if(head.next == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void dump(){
		SNode current = head.next;
		while(current != null){
			System.out.println(current.key);
			current = current.next;
		}
	}

	private class SNode{
		private String key;
		private SNode next;
		private SNode(String key){
			this.key = key;
			next = null;
		}		
	}	
}



