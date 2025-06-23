	
public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;

		System.out.println(myNum + " is the value stored in the myNum variable");
		System.out.println(website);

		// Arrays--
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 20;
		arr[2] = 33;
		arr[3] = 45;
		arr[4] = 53;

		int[] arr2 = { 11, 12, 33, 54, 75 };
		System.out.println(arr2[2]);

		// for loop
		for (int i = 0; i <arr.length; i++) {
			System.out.println(arr[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		String[] name = { "Rahul", "Shetty", "Selenium" };
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		

	}
}