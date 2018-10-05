import edu.cmu.ri.createlab.terk.robot.finch.*;

Finch myFinch = new Finch();

float weather;
double temp=myFinch.getTemperature();

if(temp <=  -6.6666667 )
{
  myFinch. saySomething("I'm so cold my wings are falling off. It's less than twenty degrees and conditions are cloudy skies.");
}

else if(temp <= 4.4444444)
{
  myFinch.saySomething("It's kinda cold, but...i'll adjust.");

}

else if( temp <= 15.5555556)
{
  myFinch.saySomething("It's the perfect temperature outside.");
}
else if(temp <= 26.6666667)
{
  myFinch.saySomething("It's getting a little warm outside.");
}
else if(temp<=37.7777778)
{
  myFinch.saySomething("It's hot.");
}
  
else if(temp >37.7777778)
{
  myFinch.saySomething("This weather is hotter than hell. I'm moving north!");
}

 myFinch.saySomething("The temperature is about"+ temp + "degrees");

  


