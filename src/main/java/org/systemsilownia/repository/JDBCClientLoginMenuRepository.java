package org.systemsilownia.repository;

import org.systemsilownia.repository.entity.Client;

import java.sql.*;

public class JDBCClientLoginMenuRepository implements ClientLoginMenuRepository {

    public static final String USER = "postgres";
    public static final String PASSWORD = "peviwo08";
    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/gymSystemDB";

    @Override
    public boolean save(Client client) {
        boolean saveSuccessfully = false;
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)){
            final String name = client.getName();
            final String surname = client.getSurname();
            final String email = client.getEmail();
            final String password = client.getPassword();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, surname, email, password) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            saveSuccessfully = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saveSuccessfully;
    }
    @Override
    public Client findByEmail(String email) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT NAME, SURNAME, EMAIL, PASSWORD FROM users WHERE EMAIL =?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                final String name = resultSet.getString("NAME");
                final String surname = resultSet.getString("SURNAME");
                final String mail = resultSet.getString("EMAIL");
                final String password = resultSet.getString("PASSWORD");
                return new Client(name, surname, mail, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
