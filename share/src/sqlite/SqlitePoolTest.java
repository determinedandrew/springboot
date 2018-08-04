package sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import org.sqlite.SQLiteConfig;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

public class SqlitePoolTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new org.sqlite.SQLiteConfig();
			config.setReadOnly(false);
			config.setPageSize(8192); //in bytes
			SQLiteConnectionPoolDataSource ds = new SQLiteConnectionPoolDataSource(config);
			ds.setDatabaseName("myDatabase");
			ds.setUrl("jdbc:sqlite:myDatabase");//去掉数据库名字，即是内存模式，不会写入磁盘
			final PooledConnection pool = ds.getPooledConnection();
			conn = pool.getConnection();
			stat = conn.createStatement();
			
			stat.executeUpdate("drop table if exists people1;");
			stat.executeUpdate("create table people1 (id , name, occupation);");
			stat.executeUpdate("drop table if exists people2;");
			stat.executeUpdate("create table people2 (pid , name, occupation);");
			PreparedStatement prep = conn
					.prepareStatement("insert into people1 values (?,?,?);");

			prep.setString(1, "1");
			prep.setString(2, "asd");
			prep.setString(3, "politics");
			prep.addBatch();
			prep.setString(1, "2");
			prep.setString(2, "bnm");
			prep.setString(3, "manager");
			prep.addBatch();
			

			conn.setAutoCommit(false);
			prep.executeBatch();
			
			PreparedStatement prep2 = conn
					.prepareStatement("insert into people2 values (?,?,?);");
			prep2.setString(1, "1");
			prep2.setString(2, "c1");
			prep2.setString(3, "stu");
			prep2.addBatch();
			prep2.setString(1, "1");
			prep2.setString(2, "c2");
			prep2.setString(3, "teacher");
			prep2.addBatch();
			prep2.executeBatch();
			
			
			conn.setAutoCommit(true);
			
			rs = stat.executeQuery("select p1.id c1 ,p1.name c2, p1.occupation c3,p2.pid c4 ,p2.name c5, p2.occupation c6 from "
					+ "people1 p1,people2 p2 where p1.id = p2.pid and p1.id = '1';");
			while (rs.next()) {
				System.out.println("id = " + rs.getString("c1"));
				System.out.println("name = " + rs.getString("c2"));
				System.out.println("job = " + rs.getString("c3"));
				System.out.println("pid = " + rs.getString("c4"));
				System.out.println("name = " + rs.getString("c5"));
				System.out.println("job = " + rs.getString("c6"));
			}
			System.out.println("===========================================");
			rs = stat.executeQuery("select * from people1;");
			while (rs.next()) {
				System.out.println("id = " + rs.getString("id"));
				System.out.println("name = " + rs.getString("name"));
				System.out.println("job = " + rs.getString("occupation"));
			}
			rs = stat.executeQuery("select * from people2;");
			while (rs.next()) {
				System.out.println("pid = " + rs.getString("pid"));
				System.out.println("name = " + rs.getString("name"));
				System.out.println("job = " + rs.getString("occupation"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

}
