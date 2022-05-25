import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Введите операцию с числами от 1 до 10 римскими или арабскими цифрами:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    static boolean contains(String text, String[] keywords)
    {
        for (String keyword : keywords)
        {
            if (text.contains(keyword))
            {
                return true;
            }
        }
        return false;
    }
    public static String calc(String input){
        String[] arabic = new String[]{"1","2","3","4","5","6","7","8","9","10"};
        String[] rome = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int result = -1;
        boolean ara = contains(input, arabic);
        boolean rom = contains(input, rome);
        if (ara) {                                                  // Арабские числа
            if (input.contains("+")){
                String[] strs = input.split("\\s*\\+\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if (Integer.parseInt(strs[0])<=10 & Integer.parseInt(strs[1])<=10 & strs.length<3) {
                        int a = Integer.parseInt(strs[0].trim());
                        int b = Integer.parseInt(strs[1].trim());
                        result = a + b;
                    }else throw new RuntimeException();
                }
            }
            else if (input.contains("-")){
                String[] strs = input.split("\\s*-\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if (Integer.parseInt(strs[0])<=10 & Integer.parseInt(strs[1])<=10 & strs.length<3) {
                        int a = Integer.parseInt(strs[0]);
                        int b = Integer.parseInt(strs[1]);
                        result = a - b;
                    }else throw new RuntimeException();
                }
            }
            else if (input.contains("*")){
                String[] strs = input.split("\\s*\\*\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if (Integer.parseInt(strs[0])<=10 & Integer.parseInt(strs[1])<=10 & strs.length<3) {
                        int a = Integer.parseInt(strs[0]);
                        int b = Integer.parseInt(strs[1]);
                        result = a * b;
                    }else throw new RuntimeException();
                }
            }
            else if (input.contains("/")){
                String[] strs = input.split("\\s*/\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if (Integer.parseInt(strs[0])<=10 & Integer.parseInt(strs[1])<=10 & strs.length<3) {
                        int a = Integer.parseInt(strs[0]);
                        int b = Integer.parseInt(strs[1]);
                        result = a / b;
                    }else throw new RuntimeException();
                }
            }else throw new RuntimeException();
        }
        else if (rom)                                                // Римские числа
            if (input.contains("+")){
                String[] strs = input.split("\\s*\\+\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if((contains(strs[0],rome) & contains(strs[1], rome)) & strs.length<3){
                    String a = strs[0];
                    String b = strs[1];
                    result = Rome.valueOf(a).number + Rome.valueOf(b).number;
                    }else throw new RuntimeException();
                }
                return String.valueOf(IntegerConverter.intToRoman(result));
            }
            else if (input.contains("-")){
                String[] strs = input.split("\\s*-\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if((contains(strs[0],rome) & contains(strs[1], rome))){
                        String a = strs[0];
                        String b = strs[1];
                        result = Rome.valueOf(a).number - Rome.valueOf(b).number;
                    }
                    if (result < 0){
                     throw new RuntimeException();
                    }
                }
                return String.valueOf(IntegerConverter.intToRoman(result));
            }
            else if (input.contains("*")){
                String[] strs = input.split("\\s*\\*\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if((contains(strs[0],rome) & contains(strs[1], rome))){
                        String a = strs[0];
                        String b = strs[1];
                        result = Rome.valueOf(a).number * Rome.valueOf(b).number;
                    }else throw new RuntimeException();
                }
                return String.valueOf(IntegerConverter.intToRoman(result));
            }
            else if (input.contains("/")){
                String[] strs = input.split("\\s*/\\s*");
                for (int i = 0; i <strs.length ; i++) {
                    if((contains(strs[0],rome) & contains(strs[1], rome))){
                        String a = strs[0];
                        String b = strs[1];
                        result = Rome.valueOf(a).number / Rome.valueOf(b).number;
                    }else throw new RuntimeException();
                }
                return String.valueOf(IntegerConverter.intToRoman(result));
            }else throw new RuntimeException();

        return String.valueOf(result);
    }
}
