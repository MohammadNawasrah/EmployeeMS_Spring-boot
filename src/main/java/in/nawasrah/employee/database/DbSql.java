package in.nawasrah.employee.database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class DbSql implements DB {
    @Override
    public Connection connection(String connectionString) {
        try {
            Connection con = DriverManager.getConnection(connectionString);
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean createTable(String sql, Connection con) {
        try {
            Statement statement = con.createStatement();
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ResultSet select(String sql, Connection con) {
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insert(String sql, Connection con) {
        try {
            Statement statement = con.createStatement();
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String sql, Connection con) {
        try {
            Statement statement = con.createStatement();
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(String sql, Connection con) {
        try {
            Statement statement = con.createStatement();
            statement.execute(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
