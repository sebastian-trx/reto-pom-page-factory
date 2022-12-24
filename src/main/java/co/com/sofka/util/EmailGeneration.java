package co.com.sofka.util;

import com.github.javafaker.Faker;

public class EmailGeneration {

    private static Integer flag = 0;
    public static String email = "";
    public static String getEmail() {
        flag ++;
        if(flag <= 1){
            Faker faker = new Faker();

            String emailFirstPart = faker.dragonBall().character();

            String emailFirstPartNoSpace = emailFirstPart.replaceAll("\\s","");

            email = emailFirstPartNoSpace+"@yopmail.com";

            return email;
        }
        else {
            return email;
        }
    }
}
