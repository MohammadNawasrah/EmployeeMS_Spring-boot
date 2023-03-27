package in.nawasrah.employee.database;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;

@Repository
public interface DB {
    Connection connection(String connectionString);
    boolean createTable(String sql,Connection con);
    ResultSet select(String sql, Connection con);
    boolean insert(String sql,Connection con);
    boolean delete(String sql,Connection con);
    boolean update(String sql,Connection con);

}
