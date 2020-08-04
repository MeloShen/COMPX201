public void check(String[] strings){
  int account;
  String transaction;
  double balance;
  if(strings[].length != 3) return false;
  try{
   account = Integer.parseInt(strings[0]);
  }
  catch{
    return false;
  }
  try{
   account = Double.parseDouble(strings[2]);
  }
  catch{
    return false;
  }
  if(strings[1].equals("w") || strings[1].equals("d") || strings[1].equals("c")) return true;
}