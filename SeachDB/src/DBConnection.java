import java.sql.Connection;
import java.sql.DriverManager;

//DB接続クラス
class DBConnection{
	  private static final String url = "jdbc:mysql://localhost:3306/shoppingdbnishiyama";
	  /** ユーザー名 */
	  private static final String user = "root";
	  /** パスワード */
	  private static final String password = "";

	  public static Connection getConnection(){

		    try {
		    // JDBCドライバのロード
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection con = DriverManager.getConnection(url,user,password);
		      return con;
		    } catch(Exception e) {
		      throw new IllegalStateException(e);
		    }
		  }
}