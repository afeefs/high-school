int[] sneakers = new int[3];
sneakers[0] = 10;
sneakers[1] = 22;
sneakers[2] = 15;

double [] sneakerPrice = {64.45,87.35,93.98};
print("The total number of sneakers we have in stock =");
println((sneakers[0] +sneakers[1] +sneakers[2])+".");

print("\nWe have" +sneakers[1]+"available pairs of sneakers which cost$");
println(sneakerPrice[1]+"per pair");

double total = sneakers[0]* sneakerPrice[0];
total+= sneakers[1] * sneakerPrice[1];
total+= sneakers[2] * sneakerPrice[2];

println("Our total store investment in sneakers is $" + total+".");
