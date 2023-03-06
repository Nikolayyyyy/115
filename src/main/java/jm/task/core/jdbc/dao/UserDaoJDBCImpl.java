//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    private final Connection connection = Util.getCon();
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        final String c_t = "CREATE TABLE IF NOT EXISTS `users` \n" +
//                "  (`id` INT NOT NULL AUTO_INCREMENT,\n" +
//                "  `name` VARCHAR(45) NOT NULL,\n" +
//                "  `lastname` VARCHAR(45) NOT NULL,\n" +
//                "  `age` INT(3) NOT NULL,\n" +
//                "  PRIMARY KEY (`id`))\n" +
//                "ENGINE = InnoDB;\n";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(c_t);
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    public void dropUsersTable() {
//        final String d_t = "DROP TABLE IF EXISTS users;";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(d_t);
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        final String s_u = "INSERT INTO `users` (name, lastName, age) VALUES(?,?,?);";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(s_u)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void removeUserById(long id) {
//        final String r_u = "DELETE FROM `users` WHERE `id`=?;";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(r_u)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        String g_a_u = "SELECT * FROM users;";
//
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(g_a_u);
//
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//
//    public void cleanUsersTable() {
//        String c_u = "TRUNCATE users";
//        try (Statement statement = connection.createStatement()){
//            statement.executeUpdate(c_u);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
