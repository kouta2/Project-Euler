package Euler;


public class LargestPrimeFactor {


public static boolean isPrime(long numberToCheck){
	if((long)numberToCheck <= 3){
		return (long)numberToCheck > 1;
	}
	if((long)numberToCheck % 2 == 0 || (long)numberToCheck % 3 == 0){
		return false;
	}
	for(long i = 5; i * i <= (long)numberToCheck; i += 6){
		if((long)numberToCheck % i == 0 || (long)numberToCheck % (i + 2) == 0){
			return false;
		}
	}
	return true;
	
}
	
public static long checkIfPrimeIsAFactor(long biggestPrimeInThisNumber, long biggestPrimeSoFar, long numberToCheck){
	if((long)numberToCheck > (long)biggestPrimeInThisNumber){
		return (long)biggestPrimeSoFar;
	}
	if(isPrime((long)numberToCheck)){
	if((long)(biggestPrimeInThisNumber) % (long)(numberToCheck) == 0){
		return checkIfPrimeIsAFactor((long)biggestPrimeInThisNumber, (long)numberToCheck, (long)(numberToCheck + 1));
	}
	}

	return checkIfPrimeIsAFactor((long)biggestPrimeInThisNumber,(long)biggestPrimeSoFar, (long)(numberToCheck + 1));
	
}

public static long biggestPrimeInThisNumber(long biggestPrimeInThisNumber){
	return checkIfPrimeIsAFactor((long)biggestPrimeInThisNumber, 0L, 1L);
}
public static void printLong(long answer){
	System.out.println("The answer is: " + (long)answer);
}
public static void main(String[] args){
printLong(biggestPrimeInThisNumber(6919));
printLong(biggestPrimeInThisNumber(4301));
//printLong(biggestPrimeInThisNumber(13195L));
//printLong(biggestPrimeInThisNumber(600851475143L));
}
}
