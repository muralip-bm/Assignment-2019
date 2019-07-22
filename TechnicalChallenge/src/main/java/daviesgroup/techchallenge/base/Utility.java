package daviesgroup.techchallenge.base;

public class Utility extends Base {
	
	int rand = (int) Math.random();
	public String newMailID() {
		
		return (prop.getProperty("createAccountMailID")+rand+"@gmail.com");
	}
	
	

}
