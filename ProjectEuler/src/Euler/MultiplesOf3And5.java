package Euler;

public class MultiplesOf3And5 {
	
public static int findSumOf3And5(int upperLimit, int numberWeAreOn){
if(numberWeAreOn > upperLimit){
	return 0;
}
if(numberWeAreOn % 3 == 0 || numberWeAreOn % 5 == 0){
	return numberWeAreOn + findSumOf3And5(upperLimit, numberWeAreOn + 1);
}
return findSumOf3And5(upperLimit, numberWeAreOn + 1);
}

public static int findSummationOfThreesAndFives(int upperLimit){
	return findSumOf3And5(upperLimit, 0);
}

public static void printInteger(int answer){
	System.out.println("The answer is: " + answer);
}
public static void main(String[] args){
printInteger(findSummationOfThreesAndFives(10));	
printInteger(findSummationOfThreesAndFives(999));
	
	
}
}
