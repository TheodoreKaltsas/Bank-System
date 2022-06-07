
public class Tester {

	public static void main(String[] args) {
		Date d = new Date(01, 22, 2012);
		System.out.println("D" + d);
		
		Date d1 = new Date("02/22/2021");
		System.out.println("D " + d1);
		
		Client c1 = new Client();
		c1.setDob("05/11/2001");
		System.out.println("Age of c1 is " + c1.getAgeOfClient(c1.getDob()));
		

	}
}
