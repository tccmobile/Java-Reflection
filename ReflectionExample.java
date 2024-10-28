import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // Get the Class object for the Person class
            Class<?> personClass = Class.forName("Person");

            // Create an instance of the Person class
            Object person = personClass.getDeclaredConstructor().newInstance();

            // Get the name field and set its value
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); // Make private field accessible
            nameField.set(person, "John Doe");

            // Get the getAge method and invoke it
            Method getAgeMethod = personClass.getDeclaredMethod("getAge");
            int age = (int) getAgeMethod.invoke(person);

            // Print the values
            System.out.println("Name: " + nameField.get(person));
            System.out.println("Age: " + age);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}