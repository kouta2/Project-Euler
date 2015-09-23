package Euler;

public class SmallestMultiple {
	
public static void main(String[] args){
	//System.out.println(smallestMultiple(10));
	System.out.println(smallestMultiple(12));
}


			

public static int smallestMultiple(int number){
	return smallMultiple(number, (int)number *(int)(number - 1));

}

public static int smallMultiple(int number, int answer){
	int i;
	for(i = 1; i <= number; i++){
		if(answer % (int)i != 0){
			i = number + 2;
		}
	}
	if((int)i < number + 2){return answer;}
	else{answer+= number;
		return smallMultiple(number, answer);}
		
}
}
