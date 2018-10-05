void texts(){
  
   //How many Ants you can miss until you lose
  fill(0);
  textSize(20);
  text("You have "+lives+" lives left.",width-200,0+50);
  
  //How may Ants you've already killed
  fill(0);
  textSize(20);
  text("You killed "+score+" ants.",5,50);
  
   //If you have lives and there are no ants left you win
 boolean a = ant.size()-1 == 0;
 boolean d = opplives <=4;
 if(a ==true && d == true){
    background(0);
    textSize(35);
    textAlign(CENTER);
    fill(#28E83F);
    text("You WIN",width/2,height/2);
       
  }
  //If You run out of lives and there are still ants you lose
  boolean b = lives <= 0;
  boolean c = ant.size() >=2;
  if(b == true && c == true){
    background(0);
    fill(#F5160A);
    textSize(35);
    textAlign(CENTER);
    text("YOU LOSE", width/2, height/2);
    
  }
}
