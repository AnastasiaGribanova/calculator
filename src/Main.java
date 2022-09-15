import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class Main {

     public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();
         System.out.println(calc(input));
     }
     public static String calc(String input) throws Exception {
         boolean isArab = testArab(input);
         boolean isRim = false;
         if(!isArab){
             isRim = testRim(input);
         }
         if(!isArab && !isRim){
             throw new Exception();
         }
         String inputDelSpaces = Separation.delete(input);
         String[] mass = Separation.separation(inputDelSpaces);
         int[] massOperands;
         if(isArab){
             massOperands = Translation.translationAr(mass);
         } else {
             massOperands = Translation.translationRimInt(mass);
         }
         int answer = Arithmetic.arithmetic(mass, massOperands);
         String finalAnswer = "";
         if(isRim){
             finalAnswer = Translation.splittingANumberIntoDigits(answer);
             if (finalAnswer.equals("")){
                 throw new Exception();
             }
         } else {
             finalAnswer = Integer.toString(answer);
         }
         return finalAnswer;
     }

     public static boolean testArab(String input){
         String regex = "^[\\s]*+(10|[1-9]){1}+[\\s]*+[\\+|\\-|\\*|\\\\]{1}+[\\s]*+(10|[1-9]){1}+[\\s]*$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(input);
         return matcher.matches();
     }
     public static boolean testRim(String input){
         String regex = "^[\\s]*+(IX|X|I|II|III|IV|V|VI|VII|VIII)+[\\s]*+[\\+|\\-|\\*|////]{1}+[\\s]*+(IX|X|I|II|III|IV|V|VI|VII|VIII)+[\\s]*$";
         Pattern pattern2 = Pattern.compile(regex);
         Matcher matcher2 = pattern2.matcher(input);
         return matcher2.matches();
     }


}
