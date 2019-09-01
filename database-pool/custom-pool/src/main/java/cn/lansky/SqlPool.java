package cn.lansky;

import java.sql.*;
import java.util.Vector;

/**
 * @author onlyo
 * @since 2019/7/28 21:38
 */
public class SqlPool {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SqlPool() throws SQLException {
        for (int i = 0; i < initCount; i++) {
            MyPoolConnection myPoolConnection = new MyPoolConnection();
            myPoolConnection.setCon(getConnetion());
            vectorCon.add(myPoolConnection);
        }
    }

    public static Connection getConnetion() throws SQLException {
        currentCount++;
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

    }

    private static String url = "jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=GMT";

    private static String user = "root";

    private static String password = "root";

    private static int initCount = 3;

    private static int maxCount = 5;

    private static int currentCount;

    private Vector<MyPoolConnection> vectorCon = new Vector<>();

    public Connection getMyPoolConnection() throws Exception {
        Connection con = null;
        for (int i = 0; i < vectorCon.size(); i++) {
            if (!vectorCon.get(i).isBusi()) {
                con = vectorCon.get(i).getCon();
                vectorCon.get(i).setBusi(true);
                break;
            }
        }
        if (con == null) {
            if (currentCount > maxCount) {
                System.out.println(currentCount);
                throw new Exception("超出连接最大值:" + maxCount);
            }
            con = getConnetion();
        }
        return con;
    }

    public static void main(String[] args) throws Exception {
        SqlPool sqlPool = new SqlPool();
        Connection connection = sqlPool.getMyPoolConnection();
        sqlPool.getMyPoolConnection();
        sqlPool.getMyPoolConnection();
        sqlPool.getMyPoolConnection();
        sqlPool.getMyPoolConnection();
        sqlPool.getMyPoolConnection();
        sqlPool.getMyPoolConnection();

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
