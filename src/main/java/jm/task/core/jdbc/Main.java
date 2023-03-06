package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user1 = new User("Igor", "Petrov", (byte) 23);
        User user2 = new User("Oleg", "Antonov", (byte) 27);
        User user3 = new User("Andrey", "Vlasov", (byte) 93);
        User user4 = new User("Viktor", "Nikolayev", (byte) 19);

        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем" + user1.getName() + "добавлен в базу данных");

        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем" + user2.getName() + "добавлен в базу данных");

        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем" + user3.getName() + "добавлен в базу данных");

        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем" + user4.getName() + "добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}