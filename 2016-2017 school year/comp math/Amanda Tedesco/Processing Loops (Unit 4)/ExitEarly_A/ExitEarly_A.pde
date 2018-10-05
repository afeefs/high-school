String name = "Amanda";
int count = 0;
while(count<4)
{ 
  count++;
  if(name.charAt(count)=='a')
     continue;
  println(name.charAt(count));

}
println("Name with no a's.");
