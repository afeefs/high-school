import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class ManzoorLyric {
    public static void main(String[] args) {
        System.out.println("Song name: Hold Me Down by Hasley");
        System.out.println("");
        
        System.out.println("Would you want to");
        System.out.println("replace hold with pull,");
        System.out.println("take out all the 'o's in hold me down,");
      /*
        Scanner in = new Scanner(System.in);
        
        String a;
        String b;
 
        System.out.println("replace hold with pull,");
        a = in.nextLine();
        System.out.println("You entered string "+a);
 
        System.out.println("Enter an integer");
        b = in.nextInt();
        System.out.println("You entered integer "+b);
        */
  
        try {

            //String content = "This is the content to write into file";
            BufferedReader br = null;
            File file = new File("output.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            //bw.write(content);
           
             try {

                String sCurrentLine;

                br = new BufferedReader(new FileReader("input.txt"));

                while ((sCurrentLine = br.readLine()) != null) {
                      //System.out.println(sCurrentLine);
                      
                      bw.write(sCurrentLine);
                      bw.newLine();
                }

            } catch (IOException e) {
                 e.printStackTrace();
            } finally {
                try {
                    if (br != null)br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            bw.close();

            //System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}