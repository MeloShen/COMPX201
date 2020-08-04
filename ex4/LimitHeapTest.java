// LimitHeapTest:  (min)heap stress tests for add/replace/remove/size
//
// Expects an integer argument specifying how many (seeded) random integers to
// insert into the heap, with periodic replacements and removals, and then 
// attempts to remove too many after heap has been loaded.
//     Random int x % 1000, such -1000 < x < 1000
// Test replacement operation on an empty heap
// Test clear operation
//
// Multiple runs with the same argument should always yield the same output.
//
// @author: Tony C Smith
// @date: 11/6/2020
//
import java.util.Random;

public class LimitHeapTest{
    public static void main(String [] args){
		Random rg = new Random();
		int count=0;
		int x;
	
		MyMinHeap mmh = new MyMinHeap();
		try{
			count = Integer.parseInt(args[0]);
			if(count<0) count *= -1;
		}catch(Exception e){
			System.err.println("Usage: java LimitHeapTest <int>");
			System.err.println("\t<int> is how many random ints to add into heap");
			System.err.println("\t"+e);
		}
		try{
			// seed random number generator for reproducible test
			rg.setSeed((long)123456789);
			int has=0;
			// load heap, with periodic replace and remove operations
			System.out.println(">>> Loading ...");
			for(int i = count;i>0;i--){
				x = rg.nextInt() %1000;
				//System.out.println("Add "+x);
				mmh.add(x);has++;
				if(i%7==0)mmh.replace(rg.nextInt() % 1000);
				if(i%11==0){mmh.remove();has--;}
			}
	    
			// Remove too many from heap
			int limit = mmh.size();
			if(limit==has)System.out.println("  Count is "+limit);else System.out.println("Count NOT correct.");
			System.out.println(">>> Excess removal test ...");
			for(int j=(limit+1);j>=0;j--){
				System.out.print("  remove["+j+"]\ttop = "+mmh.get());
				mmh.remove();
				System.out.println("\t   size: "+mmh.size());
			}
	    
			// Replace on empty heap
			System.out.println(">>> Replacement test on empty ...");
			mmh.replace(rg.nextInt()%1000);
			System.out.println("  Size: "+mmh.size()+"\ttop: "+mmh.get());
			mmh.replace(rg.nextInt()%1000);
			System.out.println("  Size: "+mmh.size()+"\ttop: "+mmh.get());

			// Check that clear works
			System.out.println(">>> Clear tests ...");
			for(int i=100;i>0;i--)
				mmh.add(rg.nextInt()%100);
			System.out.print("  start size = "+mmh.size());
			mmh.clear();
			System.out.println("\t end size = "+mmh.size());
			mmh.add(50);
			System.out.println("  Final size: "+mmh.size()+"\ttop: "+mmh.get()+"\tstate: "+mmh.isEmpty());
		}catch(Exception e){
			System.err.println("Failed something :-P ... "+e);
		}
    }
}