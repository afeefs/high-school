int [][] square = {{16,3,2,13},{5,11,10,8},{9,7,6,12},{4,15,14,1}};

int sum0 = 0;
int sum2 =0;
int sum3 = 0; 
int sum4 = 0;
int sum5 = 0;
int sum8 =0;
int sum9 = 0; 
int sum7 = 0;
int sum10 = 0;
for(int i = 0; i < 4; i++)
{
 sum0+=square[i][i];
 sum2+= square[0][i];
 sum3+= square[1][i];
 sum4+= square[2][i];
 sum5+= square[3][i];
 sum7+= square[i][0];
 sum8+= square[i][1];
 sum9+= square[i][2];
 sum10+= square[i][3];
  
}
print(sum0+" ");
print(sum2+" ");
print(sum3+" ");
print(sum4+" ");
print(sum5+" ");
print(sum7+" ");
print(sum8+" ");
print(sum9+" ");
println(sum10+" ");
//Checks First diagnol and the rows

int sum6 = 0;
int ok = 4;
for(int j = 0; j < 4; j++)
{
  ok--;
  sum6+=square[j][ok];
}
print(sum6+" ");
//Checks second diagnol

if((sum0==34)&&(sum2==34)&&(sum3==34)&&(sum4==34)&&(sum5==34)&&(sum6==34)&&(sum7==34)&&(sum8==34)&&(sum9==34)&&(sum10==34))
println("This is a magic square");
else
println("this is not a magic square");

