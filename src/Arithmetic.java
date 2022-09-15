public class Arithmetic {
    public static int arithmetic(String[] mass, int[] massOperands){
        return switch (mass[2]) {
            case "+" -> massOperands[0] + massOperands[1];
            case "-" -> massOperands[0] - massOperands[1];
            case "*" -> massOperands[0] * massOperands[1];
            default -> massOperands[0] / massOperands[1];
        };
    }
}
