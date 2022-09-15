
import java.lang.String;


public class Separation {
    public static String delete(String input){
        String inputDelSpaces = input.replaceAll("\\s*", "");
        separation(inputDelSpaces);
        return inputDelSpaces;
    }

    static String[] separation(String inputDelSpaces){
        String[] mass = inputDelSpaces.split("[\\+|\\-|\\*|////]");
        String[] mass1 = new String[3];
        mass1[0] = mass[0];
        mass1[1] = mass[1];
        char[] massOper = new char[]{'+', '-', '*', '/'};
        int flag;
        int indexOper = -1;
        for (char c : massOper) {
            flag = inputDelSpaces.indexOf(c);
            if(flag > -1){
                indexOper = flag;
            }
        }
        char oper = inputDelSpaces.charAt(indexOper);
        mass1[2] = Character.toString(oper);
        return mass1;
    }
}
