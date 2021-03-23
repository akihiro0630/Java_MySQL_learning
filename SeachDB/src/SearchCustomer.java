class SearchCustomer{

	//顧客情報の一件検索
	public  static void main(String[] args){

		while(true){
		String mail = PConsole.inputString();
		CustomerDAO dao = new CustomerDAO();
		CustomerDTO dto = new CustomerDTO();
		dto = dao.searchCustomer(mail);

		if(dto.getMail() != null){
			System.out.println(dto.getMail());
			System.out.println(dto.getPassword());
			System.out.println(dto.getKana());
			System.out.println(dto.getName());
			System.out.println(dto.getTelNo());
			System.out.println(dto.getPostCode());
			System.out.println(dto.getAddress());
			System.out.println(dto.getBirthday());
			break;

		}

		}




	}
}