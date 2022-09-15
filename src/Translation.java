public class Translation {
    public static int[] translationAr(String[] mass) {
        int[] massOperands = new int[2];
        for (int i = 0; i < 2; i++) {
            int j = Integer.parseInt(mass[i]);
            massOperands[i] = j;
        }
        return massOperands;
    }

    public static int[] translationRimInt(String[] mass) throws Exception {
        int[] massOperands = new int[2];
        int j = 0;
        for (int i = 0; i < 2; i++) {
            j = switch (mass[i]) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> throw new Exception();
            };
            massOperands[i] = j;
        }
        return massOperands;
    }

    public static String splittingANumberIntoDigits(int answer){
        int dozens = 0;
        int units = 0;
        dozens = answer/10;
        String dozensRim = translationIntRim(dozens, 0);
        units = answer - dozens*10;
        String unitsRim = translationIntRim(units, 1);
        return dozensRim + unitsRim;
    }

    public static String translationIntRim(int amount, int flag){
        String answer = "";
        if(amount == 0){
            answer += "";
        }else if(amount < 4){
            for(int i = 0; i < amount; i++){
                switch (flag) {
                    case 0 -> answer += "X";
                    case 1 -> answer += "I";
                }
            }
        }else if(amount == 4){
            switch (flag) {
                case 0 -> answer += "XL";
                case 1 -> answer += "IV";
            }
        } else if(amount < 9){
            switch (flag) {
                case 0 -> {
                    answer = "L";
                    for (int j = 0; j < amount - 5; j++) {
                        answer += "X";
                    }
                }
                case 1 -> {
                    answer = "V";
                    for (int k = 0; k < amount - 5; k++) {
                        answer += "I";
                    }
                }
            }
        } else if(amount == 9){
            switch (flag) {
                case 0 -> answer += "XC";
                case 1 -> answer += "IX";
            }
        }
        else if(amount == 10){
            switch (flag) {
                case 0 -> answer += "C";
                case 1 -> answer += "X";
            }
        }
        return answer;
    }
}
