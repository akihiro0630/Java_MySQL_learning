import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CustomerDAO {

	private Connection con = null;

	//顧客情報を一件検索
	public CustomerDTO searchCustomer(String mail) {


		CustomerDTO customerdto = new CustomerDTO();


		// SQL文作成
		String sql = "SELECT * FROM customer where mail = ?";
		// DBに接続
		con = DBConnection.getConnection();
		PreparedStatement ps = null;


		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mail);

			// SQL文発行
			ResultSet rs = ps.executeQuery();
			rs.next();

			// 検索結果をDTOに格納
			customerdto.setMail(rs.getString("mail"));
			customerdto.setPassword(rs.getString("password"));
			customerdto.setKana(rs.getString("kana"));
			customerdto.setName(rs.getString("name"));
			customerdto.setTelNo(rs.getString("telNo"));
			customerdto.setPostCode(rs.getString("postCode"));
			customerdto.setAddress(rs.getString("address"));
			customerdto.setBirthday(rs.getString("birthday"));


		}catch (SQLException e) {
			System.out.println("登録されていないメールアドレスです。");

		}finally {
			// リソースの開放
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return customerdto;
	}


	//顧客情報を全件検索
	public HashMap<String,ArrayList<String>> selectCustomerAll(){



	      // 変数宣言

	      Connection con = null;  // DBコネクション

	      Statement smt = null;   // SQLステートメント

	      // 配列宣言

	      HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

	      ArrayList<String> mailList = new ArrayList<String>();
	      ArrayList<String> nameList = new ArrayList<String>();

	      // SQL文作成
	      String sql = "SELECT * FROM customer ORDER BY mail";

	      try{
	          // DBに接続
	    	  DBConnection dbc = new DBConnection();
	          con = dbc.getConnection();
	          smt = con.createStatement();

	          // SQL文発行
	          ResultSet rs = smt.executeQuery(sql);


	          //検索した結果を一件ずつArrayListに格納
	          while(rs.next()){
	        	 mailList.add(rs.getString("mail"));
	        	 nameList.add(rs.getString("name"));

	          }


	          // 検索結果をHashMapに格納
	          map.put("mail",mailList);
	          map.put("name", nameList);


	      }catch(SQLException e){
	          System.out.println("Errorが発生しました！\n"+e);
	      }finally{
	          // リソースの開放
	          if(smt != null){
	              try{smt.close();}catch(SQLException ignore){}
	          }
	          if(con != null){
	              try{con.close();}catch(SQLException ignore){}
	          }
	      }
	      return map;
	  }


	//顧客の注文履歴を取得
	public List<OrdersDTO> serchOrders(String mail){

	    // 変数宣言

	    Connection con = null;  // DBコネクション

        PreparedStatement smt = null;

	    // 配列宣言
        List<OrdersDTO> list = new ArrayList<OrdersDTO>();



	    // SQL文作成
	    String sql = "SELECT * FROM orders where customer_mail = ?";

	    try{
	        con = DBConnection.getConnection();
	        smt = con.prepareStatement(sql);
	        smt.setString(1, mail);

	        // SQL文発行
	        ResultSet rs = smt.executeQuery();

	        // 検索結果をListに格納
	        while(rs.next()){
	    	    OrdersDTO ordersdto = new OrdersDTO();
	            ordersdto.setNo(rs.getString("no"));
	            ordersdto.setCustomer_Mail(rs.getString("customer_mail"));
	            ordersdto.setTax(rs.getString("tax"));
	            ordersdto.setOrderDate(rs.getString("orderDate"));
	            ordersdto.setSendDate(rs.getString("sendDate"));

	            list.add(ordersdto);
	        }

	    }catch(SQLException e){
	    	System.out.println("Errorが発生しました！\n"+e);
	    }finally{
	          // リソースの開放
	          if(smt != null){
	              try{smt.close();}catch(SQLException ignore){}
	          }
	          if(con != null){
	              try{con.close();}catch(SQLException ignore){}
	          }
	}
	    return list;
	}

}
