class test{

 	public static void main(String[] args){
		SList list = new SList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
	
		list.dump();
	
		System.out.println("Contains G: " + list.has("G"));
		System.out.println("Contains D: " + list.has("D"));
		System.out.println("Contains A: " + list.has("A"));
		System.out.println("isEmpty: " + list.isEmpty());
		System.out.println("length: " + list.count());

		list.remove("A");
		list.dump();
		list.remove("C");
		list.remove("E");
		list.remove("G");

		list.dump();
	
		System.out.println("Contains G: " + list.has("G"));
		System.out.println("Contains D: " + list.has("D"));
		System.out.println("Contains A: " + list.has("A"));
		System.out.println("isEmpty: " + list.isEmpty());
		System.out.println("length: " + list.count());

		list.add("X");
		list.add("Y");
		list.add("Z");

		list.dump();

		System.out.println("Contains X: " + list.has("X"));
		System.out.println("Contains Y: " + list.has("Y"));
		System.out.println("Contains Z: " + list.has("Z"));
		System.out.println("isEmpty: " + list.isEmpty());
		System.out.println("length: " + list.count());
		
	}
}
