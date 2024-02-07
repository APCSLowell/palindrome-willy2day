import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(isPalindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public String reverse(String sWord) {
  String reverse = "";
  for (int i = sWord.length() - 1; i >= 0; i--) {
    reverse = reverse + sWord.substring(i, i + 1);
  }
  return reverse;
}

public boolean isPalindrome(String sWord){
  String w = new String();
  w = noSpaces(sWord);
  w = noCapitals(w);
  w = onlyLetters(w);
  if (w.equals(reverse(w)))
    return true;
  return false;
}
public String noSpaces(String sWord) {
    String w = "";
    for (int i = 0; i < sWord.length(); i++) {
        if (!sWord.substring(i, i + 1).equals(" ")) {
            w += sWord.substring(i, i + 1);
        }
    }
    return w;
}
public String noCapitals(String sWord){
  return sWord.toLowerCase();
}
public String onlyLetters(String sString){
  String w= "";
  for (int i=0; i<sString.length(); i++)
    {
      if(Character.isLetter(sString.charAt(i)))
        w+=sString.substring(i,i+1);
    }
  return w;
}




}
