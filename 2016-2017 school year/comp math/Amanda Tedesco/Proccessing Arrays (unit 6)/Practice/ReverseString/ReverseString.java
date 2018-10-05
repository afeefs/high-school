import java.lang.StringBuilder;

public class ReverseString {
 public static void main(String[] args) {

	// A StringBuilder can be reversed.
	StringBuilder builder = new StringBuilder();
	builder.append("abc");
	builder.reverse();
	System.out.println(builder);
    }
}
    

