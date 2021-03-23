import java.util.ArrayList;
import java.util.HashMap;

class SearchCustomerAll{
	//顧客情報の全件検索

    private static HashMap<String,ArrayList<String>> customerMap = null;
    private static ArrayList<String> mailList = new ArrayList<String>();
    private static ArrayList<String> nameList = new ArrayList<String>();


	public static void main(String[] args){

		CustomerDAO obj1 = new CustomerDAO();

		//メールアドレスを全件表示
//		customerList = obj1.selectCustomerMail();
//
//		for(int i=0; i<customerList.size(); i++){
//			System.out.println(customerList.get(i));
//
//		}

		//メールアドレスと名前を全件表示
		customerMap = obj1.selectCustomerAll();
		mailList = customerMap.get("mail");
		nameList = customerMap.get("name");

		for(int i=0; i<mailList.size(); i++){
			System.out.print("Mail: " + mailList.get(i) + "  ");
			System.out.println("Name: "+ nameList.get(i));
		}


	}

}