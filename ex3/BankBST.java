import java.text.DecimalFormat;  
class BankBST{
	private Account root;
	private BankBST left;
	private BankBST right;
 //constructor for BST
	public BankBST(){
		root = null;
		left = null;
		right = null;
	}
  //method for insert a new BST 
	public void insert(Account account){
    //if root is null than creat 
		if(root == null){
			root = account;
			left = new BankBST();
			right = new BankBST();
		}
    //compare the account and if is bigger the go right else go right
		else{
			if(account.getkey() < root.getkey()){
				left.insert(account);
			}
			else if(account.getkey() > root.getkey()){
				right.insert(account);
			}
      //if alread exist than return
      else{
        return;
      }
		}
	}
	//find the BST and print the path
	public Account find(int account){
    //if is empty tree then return
		if(root == null ) return null;
    //print the path
		System.out.print(String.valueOf(root.getkey())+" ");
    //return the account 
		if(root.getkey() == account) return root;
		if(account<root.getkey())
			return left.find(account);
		return right.find(account);
	}	
  //this method is to save 2dp number
  public String formatDouble(double s) {
		DecimalFormat fmt = new DecimalFormat("##0.00");
		return fmt.format(s);
	}
  //to print the BST in order
	public void traverse(){
		if(root == null) return;
	  left.traverse();
		System.out.println(root.getkey()+" "+formatDouble(root.getBalance()));
		right.traverse();
	}
  //to remove the BST
	public void remove(int account){
    //if is empty tree then return
		if (root == null){
			return;
		}
    //compare the account and if is bigger the go right else go right
		if (account > root.getkey()){
			right.remove(account);
		}
		else if (account < root.getkey()){
			left.remove(account);
		}
  //if find then start to remove
		else {
      //if has two child than find a tree to instead
			if (right.root != null && left.root != null){
				BankBST minRight = right;
				while (minRight.left.root != null){
					minRight = minRight.left;
				}
        //copy the BST's root we find and to delete it
				root = minRight.root;
				right.remove(minRight.root.getkey());
			}
      //if has left child
			else if (right.root != null){
				root = right.root;
        left = right.left;       
        right = right.right;

			}
      //if has right child
			else if (left.root != null){
				root = left.root;
        right = left.right;
        left = left.left;

			}
      //if is no child
			else{
				root = null;
        left = null;
        right = null;
			}
		}
	}
}

