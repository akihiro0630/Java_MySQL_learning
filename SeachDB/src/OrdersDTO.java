
public class OrdersDTO{

	private String no;
	private String customer_mail;
	private String tax;
	private String orderDate;
	private String sendDate;

	//getter
	public String getNo(){
		return no;
	}
	public String getCustomer_Mail(){
		return customer_mail;
	}
	public String getTax(){
		return tax;
	}
	public String getOrderDate(){
		return orderDate;
	}
	public String getSendDate(){
		return sendDate;
	}

	public void setNo(String no){
		this.no = no;
	}
	public void setCustomer_Mail(String customer_mail){
		this.customer_mail = customer_mail;
	}
	public void setTax(String tax){
		this.tax = tax;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}
	public void setSendDate(String sendDate){
		this.sendDate = sendDate;
	}

}