import java.util.List;

public class SearchOrders{

	//顧客の注文履歴
	public  static void main(String[] args){


		String mail = PConsole.inputString();
		CustomerDAO dao = new CustomerDAO();
		List<OrdersDTO> list = dao.serchOrders(mail);


		//タイトル行を表示
		System.out.println("----------------------------------------------------");
		System.out.println("No   メールアドレス      合計金額 注文日    送付日");
		System.out.println("----------------------------------------------------");

		//履歴の数分ループして表示
		if(!(list.isEmpty())){
			for(int i=0;i<list.size();i++){
				System.out.printf("%-5s",list.get(i).getNo());
				System.out.printf("%-20s",list.get(i).getCustomer_Mail());
				System.out.printf("%-9s",list.get(i).getTax());
				System.out.printf("%-10s",list.get(i).getOrderDate());
				System.out.printf("%-10s",list.get(i).getSendDate());
				System.out.println();
			}
			System.out.println("----------------------------------------------------");

		}


	}
}
