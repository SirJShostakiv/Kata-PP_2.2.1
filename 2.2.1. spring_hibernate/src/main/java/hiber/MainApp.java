package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 1231)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("AudiA3", 527)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("LadaPriora", 626)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("FordMustang", 51515)));

      List<User> users = userService.listUsers();

      System.out.println("\nUser got by his Car Details: " + userService.getUserByCarDetails("BMW", 1231).getCar() + "\n");

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car : "+user.getCar());
         System.out.println();
      }

      context.close();
   }
}
