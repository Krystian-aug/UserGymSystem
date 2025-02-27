package org.systemsilownia.repository;

import org.systemsilownia.repository.entity.Client;

import java.sql.*;

public class JDBCClientLoginMenuRepository implements ClientLoginMenuRepository {

    public static final String USER = "postgres";
    public static final String PASSWORD = "peviwo08";
    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/gymSystemDB";

    @Override
    public Client save(Client client) {
        Client client1 = null;
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)){
            final String name = client.getName();
            final String surname = client.getSurname();
            final String email = client.getEmail();
            final String password = client.getPassword();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, surname, email, password) VALUES (?, ?, ?, ?) RETURNING id, name, surname, email, amount, pasword");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                client1 = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("password") // opcjonalnie, jeśli chcesz to zwracać
                );
                return client1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Client findByEmail(String email) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NAME, SURNAME, EMAIL, AMOUNT, PASSWORD FROM users WHERE EMAIL =?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                final Long id = resultSet.getLong(1);
                final String name = resultSet.getString("NAME");
                final String surname = resultSet.getString("SURNAME");
                final String mail = resultSet.getString("EMAIL");
                final double amount = resultSet.getDouble("AMOUNT");
                final String password = resultSet.getString("PASSWORD");
                return new Client(id, name, surname, mail, amount, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkMembershipExistsById(Long id) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM membership WHERE USER_ID =?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
