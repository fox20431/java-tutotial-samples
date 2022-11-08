import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void test()  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // static code block will be executed when load driver class, it will register driver to manager.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try( // after JDK 1.7, you can type code here if resource need to invoke close() method in finally.
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (username) VALUES (?)");
            ) {
                preparedStatement.setObject(1, "admin");
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
