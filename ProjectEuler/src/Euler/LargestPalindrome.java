package Euler;

public class LargestPalindrome{


public static void main(String[] args){
long a = Palindrome();
if(a == -1){System.out.println("No number Exists");
}
else{System.out.println(a);
}
}
public static boolean isPalindrome(long number){
long[] numberArray;

int count = 0;
long checker = number;

while(checker > 0){
checker = checker/10;
count++;
}

numberArray = new long[count];
int i = count - 1;

while(i >= 0){

numberArray[i] = number % 10;
number = number/10;
i--;
}

int beginIndex = 0;
i = count - 1;
while(beginIndex <= i){
if(numberArray[i] != numberArray[beginIndex]){return false;}
i--;
beginIndex++;
}
return true;
}

public static long numberToCheck(long first, long second, long currentNumber){
if(second == 9){return currentNumber;}
if(isPalindrome(first * second) && first*second > currentNumber){
	currentNumber = first*second;
}
if(first < 10){return numberToCheck(99,second - 1, currentNumber);}
return numberToCheck(first - 1, second,currentNumber);
}

public static long Palindrome(){
return numberToCheck(999,999,-1);
}
}
