// All input / output is handled through methods of this static class.
// If we ever want to change the UI, this gives us one single place to do it.

import java.util.Scanner;

public class Io {
static Scanner sc = new Scanner(System.in);
		public static void out(String str){
			
			// Splits long lines apart into two lines at a space character.
			int linebrk;
			if (str.length()>80){
				linebrk = str.indexOf(' ',80);
				if (linebrk!=-1){
				System.out.println(str.substring(0,linebrk));
				Io.out(str.substring(linebrk+1));
				}
				else{System.out.println(str);}
			}
			else{
			System.out.println(str);
			}
		}
		public static String in(){
			System.out.print(">");
			return sc.nextLine();
		}
		
		public static String a(String str){
		String r;
		if (str.matches("^[aeiou].*")){r="an "+str;}
		else{r="a "+str;}
		return r;
		}
}
