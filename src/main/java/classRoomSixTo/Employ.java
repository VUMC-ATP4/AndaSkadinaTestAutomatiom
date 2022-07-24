package classRoomSixTo;

public class Employ {
    private String firstName;
    private String lastName;
    private int age;

    public Employ(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}


//Pasniedzēja variants
//package classroomSix;
//
//        import com.github.javafaker.Faker;
//
//public class Employee {
//    private String name;
//    private String position;
//    private double salary;
//
//    public Employee(String name, String position, double salary) {
//        this.name = name;
//        this.position = position;
//        this.salary = salary;
//    }
//
//    public Employee(){
//        Faker faker = new Faker();
//        this.name = faker.name().firstName();
//        this.position = faker.company().profession();
//        this.salary = faker.number().randomDouble(2,100,2000);
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", position='" + position + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//
//}