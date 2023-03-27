package in.nawasrah.employee.database.data;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DB {
    Connection connection(String connectionString);
    boolean createTable(String sql,Connection con);
    ResultSet select(String sql, Connection con);
    boolean insert(String sql,Connection con);
    boolean delete(String sql,Connection con);
    boolean update(String sql,Connection con);

}
