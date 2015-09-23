package Euler;

public class EvenFibonacci {

public static long sumOfFibEven(long upperLimit, long previousNumber, long previousPreviousNumber){
	if(previousNumber + previousPreviousNumber > upperLimit){
		return 0;
	}
	else if((previousNumber + previousPreviousNumber) <= upperLimit && (previousNumber + previousPreviousNumber) % 2 == 0){
		return previousNumber + previousPreviousNumber + sumOfFibEven(upperLimit, previousNumber + previousPreviousNumber, previousNumber);
	}
	else{
		return sumOfFibEven(upperLimit, previousNumber + previousPreviousNumber, previousNumber);
	}
}

public static long AnswerToEvenFib(long upperLimit){
	if(upperLimit <= 0){
		return 0;
		}
	return 2 + sumOfFibEven(upperLimit, 2, 1);
}

public static void printInteger(long answer){
	System.out.println("The answer is: " + answer);
}
	
public static void main(String[] args){
printInteger(AnswerToEvenFib(10));	
printInteger(AnswerToEvenFib(400000000));
printInteger(AnswerToEvenFib(90));//1,2,3,5,8,13,21,34,55,89
}
}
	