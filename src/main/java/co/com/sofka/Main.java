package co.com.sofka;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        String emailFirstPart = faker.dragonBall().character();

        String emailFirstPartNoSpace = emailFirstPart.replaceAll("\\s","");

        String email = emailFirstPartNoSpace+"@yopmail.com";

        System.out.println(email);

    }
}