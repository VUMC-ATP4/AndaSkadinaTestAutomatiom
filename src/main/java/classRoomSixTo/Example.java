package classRoomSixTo;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        Employ employ1 = new Employ("Anda","Skadina", 50);
        Faker faker = new Faker();
        //String animalName = faker.animal().name();
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(1,100);
        //faker.address().zipCode();
        Employ employ2 = new Employ(name,lastName,age);
        Employ employ3 = new Employ(faker.name().firstName(),faker.name().lastName(),faker.number().numberBetween(1, 100));

        System.out.println(employ2.toString());
        System.out.println(employ1.toString());
        System.out.println(employ3.toString());
        System.out.println(faker.letterify("12131??????445464456544wdaswdaswdfasfsa"));
    }
}
