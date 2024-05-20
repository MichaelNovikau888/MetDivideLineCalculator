import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Input: ");
        String str3 = s.nextLine();
        Main mn= new Main();
        mn.sumLine(str3);
        mn.subtractingLine(str3);
        mn.multiplicationLine(str3);
        mn.divideLine(str3);
    }
    String sumLine(String input1) throws Exception {
        if (input1.contains("+")) {
            String[] oper = input1.split("[+]");
            oper[0]=oper[0].trim();
            oper[1]=oper[1].trim();
            char[] charArray2 = oper[0].toCharArray();
            char[] charArray3 = oper[1].toCharArray();
            if (charArray2[0] != '"' || charArray2[oper[0].length() - 1] != '"') {
                throw new Exception("Первый введённый оператор не соответсвует формату строчного калькулятора");
            }
            if (charArray3[0] != '"' || charArray3[oper[1].length() - 1] != '"') {
                throw new Exception("Второй введённый оператор не соответсвует формату строчного калькулятора");
            }
            String opera3;
            String opera4;
            opera3 = oper[0].replace("\"", "");
            opera4 = oper[1].replace("\"", "");
            if (opera3.length() > 10 || opera4.length() > 10) {
                throw new Exception("Количество символов введённых оператора(ов) больше 10, что не соответсвует формату строчного калькулятора");
            }
            String sum = opera3.concat(opera4);
            System.out.println();
            System.out.println("Output + :");
            System.out.println("\"" + sum + "\"");

        }
        return input1;
    }
    String subtractingLine(String input3) throws Exception {
        int k = 0, j = 0;
        String[] oper = input3.split("[+*/]");
        if (input3.indexOf("-")==input3.lastIndexOf("-")&&oper.length==1) {
            String[] strings6 = input3.split("");
            for (String element : strings6) {
                if (element.equals("-")) {
                    k=k+1;
                }
                if (element.equals("\"")) {
                    j=j+1;
                }
            }
            if (j==2 && k==1) {
                throw new Exception("Не введён операнд умножения или деления.");
            }
            String[] data = input3.split("-");
            data[0]=data[0].trim();
            data[1]=data[1].trim();
            char [] charArray=data[0].toCharArray();
            char [] charArray1=data[1].toCharArray();
            if ( charArray[0]!='"' || charArray[data[0].length()-1]!='"') {
                throw new Exception("Первый введённый оператор не соответсвует формату строчного калькулятора");
            }
            if ( charArray1[0]!='"' || charArray1[data[1].length()-1]!='"') {
                throw new Exception("Второй введённый оператор не соответсвует формату строчного калькулятора");
            }
            String opera1;
            String opera2;
            opera1=data[0].replace("\"","");
            opera2=data[1].replace("\"","");
            if (opera1.length()>10|| opera2.length()>10) {
                throw new Exception("Количество символов введённых оператора(ов) больше 10, что не соответсвует формату строчного калькулятора");
            }
            int index = opera1.indexOf(opera2);
            if(index == -1){
                System.out.println();
                System.out.println("Output:");
                System.out.println(data[0]);
            }else {
                String result = opera1.substring(0, index);
                result += opera1.substring(index + opera2.length());
                System.out.println();
                System.out.println("Output:");
                System.out.println("\"" + result + "\"");
            }

        }
        if (input3.indexOf("-")!=input3.lastIndexOf("-")&&oper.length==1) {
            String[] strings2 = input3.split("");
            for (String element : strings2) {
                if (element.equals("-")) {
                    k=k+1;
                }
                if (element.equals("\"")) {
                    j=j+1;
                }
            }
            if (j!=4&&k>1) {
                throw new Exception("Формат операторов не соответсвует формату строчного калькулятора");
            }
            String opera3=input3.substring(1,input3.length()-1);
            String[] operands1= new String[2];
            if(k>=2){

                operands1[0]=opera3.substring(0,opera3.indexOf("\""));
                operands1[1]=opera3.substring(opera3.indexOf("\"")+2);
            }
            operands1[1]=operands1[1].trim();
            String[] strings5 = operands1[1].split("");
            if(strings5[0].equals("-")){
                operands1[1]=operands1[1].substring(1);
                operands1[1]=operands1[1].trim();
            }
            int z=0, y=0;
            String[] strings3 = operands1[0].split("");
            for (String element : strings3) {
                if (element.equals("-")) {
                    z = z + 1;
                }
            }
            String[] strings4 = operands1[1].split("");
            for (String element : strings4) {
                if (element.equals("-")) {
                    y = y + 1;
                }
            }
            int x=y+z;
            if(k==x){
                throw new Exception("Отсутствует операнд операции");
            }
            operands1[0]=operands1[0].replace("\"","");
            operands1[1]=operands1[1].replace("\"","");
            if (operands1[0].length()>10|| operands1[1].length()>10) {
                throw new Exception("Количество символов введённых оператора(ов) больше 10, что не соответсвует формату строчного калькулятора");
            }
            int index = operands1[0].indexOf(operands1[1]);
            if(index == -1){
                System.out.println();
                System.out.println("Output:");
                System.out.println("\""+operands1[0]+"\"");
            }else {
                String result = operands1[0].substring(0, index);
                result += operands1[0].substring(index + operands1[1].length());
                System.out.println();
                System.out.println("Output:");
                System.out.println("\"" + result + "\"");
            }
        }
        return input3;
    }
    String multiplicationLine(String input2) throws Exception {
        if (input2.contains("*")) {
            String[] oper = input2.split("[*]");
            oper[0]=oper[0].trim();
            oper[1]=oper[1].trim();
            char[] charArray4 = oper[0].toCharArray();
            char[] charArray5 = oper[1].toCharArray();
            if (charArray4[0] != '"' || charArray4[oper[0].length() - 1] != '"') {
                throw new Exception("Первый введённый оператор не соответсвует формату строчного калькулятора");
            }
            if (charArray5[0] == '"' || charArray5[oper[1].length() - 1] == '"') {
                throw new Exception("Умножать и делить строку можно только на число");
            }
            int multiplier = Integer.parseInt(oper[1]);
            if (multiplier > 10) {
                throw new Exception("Множитель строки не может быть больше 10");
            }
            oper[0] = oper[0].replace("\"", "");
            if (oper[0].length() > 10) {
                throw new Exception("Количество символов введённого строчного оператора больше 10, что не соответсвует формату строчного калькулятора");
            }
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result = String.join("", result, oper[0]);
            }
            if (result.length() > 40) {
                System.out.println();
                System.out.println("Output *:");
                System.out.println("\"" + result.substring(0, 40) + "... " + "\"");
            } else {
                System.out.println();
                System.out.println("Output *:");
                System.out.println("\"" + result + "\"");
            }
        }
        return input2;
    }
     String divideLine(String input) throws Exception {
        if (input.contains("/")) {
            String[] oper = input.split("/");
            oper[0] = oper[0].trim();
            oper[1] = oper[1].trim();
            char[] charArray4 = oper[0].toCharArray();
            char[] charArray5 = oper[1].toCharArray();
            if (charArray4[0] != '"' || charArray4[oper[0].length() - 1] != '"') {
                throw new Exception("Первый введённый оператор не соответсвует формату строчного калькулятора");
            }
            if (charArray5[0] == '"' || charArray5[oper[1].length() - 1] == '"') {
                throw new Exception("Умножать и делить строку можно только на число");
            }
            int multiplier = Integer.parseInt(oper[1]);
            if (multiplier > 10) {
                throw new Exception("Делитель строки не может быть больше 10");
            }
            oper[0] = oper[0].replace("\"", "");
            if (oper[0].length() > 10) {
                throw new Exception("Количество символов введённого строчного оператора больше 10, что не соответсвует формату строчного калькулятора");
            }
            int div = oper[0].length() / multiplier;
            String result1 = oper[0].substring(0, div);
            System.out.println();
            System.out.println("Output / :");
            System.out.println("\"" + result1 + "\"");
        }
        return input;
    }
}