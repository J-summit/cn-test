package cn.lansky;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author onlyo
 * @since 2019/7/27 20:20
 */
public class JdbcUtils {
    private static String url = "jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=GMT";

    private static String user = "root";

    private static String password = "root";

    private static int initCount = 3;

    private static int maxCount = 5;

    private Vector<Connection> con = new Vector<>();

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from test";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("---");
        while (resultSet.next()) {
            final String id = resultSet.getString(

                    "id");
            System.out.println("id:" + id);
            String nums = resultSet.getString("nums");
            System.out.println("nums:" + nums);
            String name = resultSet.getString("name");
            System.out.println("name:" + name);
        }
    }
}
