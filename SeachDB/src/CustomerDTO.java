
public class CustomerDTO{

	private String mail;
	private String password;
	private String kana;
	private String name;
	private String telNo;
	private String postCode;
	private String address;
	private String birthday;

	//getter
	public String getMail(){
		return mail;
	}
	public String getPassword(){
		return password;
	}
	public String getKana(){
		return kana;
	}
	public String getName(){
		return name;
	}
	public String getTelNo(){
		return telNo;
	}
	public String getPostCode(){
		return postCode;
	}
	public String getAddress(){
		return address;
	}
	public String getBirthday(){
		return birthday;
	}

	//setter
	public void setMail(String mail){
		this.mail = mail;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setKana(String kana){
		this.kana = kana;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setTelNo(String telNo){
		this.telNo = telNo;
	}
	public void setPostCode(String postCode){
		this.postCode = postCode;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

}