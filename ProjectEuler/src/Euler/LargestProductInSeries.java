package Euler;

public class LargestProductInSeries {

	public static void main(String[] args){
		String a = new String("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
		String c = "111111111111111111111111111";
		String d = "314539783121031453978312103145397831210314539783121031453978312103145397831216";
		String e = "99999999999999999999999999999999999999";
		char[] b = new char[a.length()];
		char[] C = new char[c.length()];
		char[] D = new char[d.length()];
		char[] E = new char[e.length()];
		b = a.toCharArray();
		C = c.toCharArray();
		D = d.toCharArray();
		E = e.toCharArray();
		
		System.out.println(findLargestProductInSeries(13, D));
		System.out.println(findLargestProductInSeries(13, b));
/*		for(int i = 0; i < b.length; i++){
		System.out.println(b[i]);
	}*/
	}
	
	public static long findLargestProductInSeries(int numberOfNumbers, char[] theNumber){
		return findLargestProduct(numberOfNumbers, theNumber, 0, 0);
	}
	public static long findLargestProduct(int numberOfNumbers, char[] theNumber, long max, int index){
		if(index + numberOfNumbers >= theNumber.length){return max;}
		
		int indexOfNumberContainingZero = doesArrayHaveZero(numberOfNumbers, theNumber, index);
		if(indexOfNumberContainingZero != -1){
			return findLargestProduct(numberOfNumbers, theNumber, max, indexOfNumberContainingZero + 1);
		}
		
		if(theNumber[index] == '1' && numberOfNumbers + index < theNumber.length){
			if(theNumber[index + numberOfNumbers] != '0' && theNumber[index + numberOfNumbers] != '1'){
			return findLargestProduct(numberOfNumbers, theNumber, max, index + 1);
			}
		}
		
		if(theNumber[index] < theNumber[index + numberOfNumbers]){
		return findLargestProduct(numberOfNumbers, theNumber, max, index + 1);	
		}
		
		
		long a = 1;
		for(int i = index; i < numberOfNumbers + index; i++){
			a = a * (theNumber[i] - 48);//converting from ascii to int. 0 is 48th ascii value
		}
		max = Math.max(max, a);
		return findLargestProduct(numberOfNumbers, theNumber, max, index + 1);
	}
	
	public static int doesArrayHaveZero(int numberOfNumbers, char[] theNumber, int index){
		for(int i = index + numberOfNumbers - 1; i >= index; i--){
			if(theNumber[i] == '0'){
				return i;	
			}
		}
		return -1;
	}
}
