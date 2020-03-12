package utils.generators;

import java.util.Random;

public class DataGenerator {
    public static void generateRandomData(){
        Random random = new Random();
        System.out.println(random.nextInt(6));  // [0...5] [min = 0, max = 5]
        System.out.println(Math.random());
        System.out.println(random.ints(0, 10).findFirst().getAsInt());

    }

    public static void generateData(String table, String column1, String column2, String value1 , int value2){
//        System.out.println("INSERT INTO " + table + " (" + column1 + ", " + column2 + ")"
//                + " VALUES (" + value1 + ", " + value2 + ");" );
    }

    public static void generateSalaryData(int value1, int value2, String value3, int value4){
//        System.out.println("INSERT INTO company.salary (salary_id, payment, payment_date, employee)"
//                + " VALUES (" + value1 + ", " + value2 + ", '" + value3 + "' "+ value4 + ");" );
    }


    public static void main(String[] args) {
        generateData("company.firm","name", "branch" ,"Samsung" , 1);
        generateSalaryData(1, 100, "2020/03/10/03", 1 );
        generateRandomData();
    }


}