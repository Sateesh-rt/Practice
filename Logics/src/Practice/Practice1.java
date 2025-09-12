package Practice;

public class Practice1 {
public static void main(String[] args) {
   String empty="";
   String name="java";
   for(int i=name.length()-1;i>=0;i--) {
	   empty+=name.charAt(i);
   }
   System.out.println(empty);
}
}
