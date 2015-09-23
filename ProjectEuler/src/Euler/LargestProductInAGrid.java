package Euler;

import java.lang.Math;

public class LargestProductInAGrid
{

public static void main(String[] args)
{
long[][] a = new long[5][5];
for(int i = 0; i < a.length; i ++)
{
for(int j = 0; j < a[0].length; j++)
{
a[i][j] = Math.max(10,(long)(Math.random()*100));
}
}

for(int i = 0; i < a.length; i ++)
{
for(int j = 0; j < a[0].length; j++)
{
System.out.print(a[j][i] + " ");
}
System.out.println();
}

System.out.println(findLargestProductInGrid(a, 0, 0, 0));
}


public static long findLargestProductInGrid(long[][] a, int xIndex, int yIndex, long max)
{
if(xIndex + 3 >= a.length && yIndex + 3 >= a[0].length){return max;}

if(xIndex >= a.length){return findLargestProductInGrid(a, 0, yIndex + 1, max);}

else
{
	if(xIndex + 4 < a.length && yIndex + 4 < a[0].length && xIndex - 4 >= 0)
	{
		if(a[xIndex][yIndex] <= a[xIndex + 4][yIndex] && a[xIndex][yIndex] <= a[xIndex][yIndex + 4] && a[xIndex][yIndex] <= a[xIndex + 4][yIndex + 4] && a[xIndex][yIndex] <= a[xIndex - 4][yIndex + 4])
		{
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
		}	
		else
		{
		max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
		Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
		Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3],
		a[xIndex][yIndex]*a[xIndex - 1][yIndex + 1]*a[xIndex - 2][yIndex + 2]*a[xIndex - 3][yIndex + 3]))));
		
		return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
		}
	}

	else if(xIndex + 4 < a.length && yIndex + 4 < a[0].length)
	{
		if(a[xIndex][yIndex] <= a[xIndex + 4][yIndex] && a[xIndex][yIndex] <= a[xIndex][yIndex + 4] && a[xIndex][yIndex] <= a[xIndex + 4][yIndex + 4])
		{
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
		}
		else
		{
		max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
		Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
		a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3])));
		
		return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
		}
	}
	else if(xIndex + 4 < a.length && xIndex - 4 >= 0)
	{
		if(yIndex + 3 >= a[0].length)
		{
			if(a[xIndex][yIndex] <= a[xIndex + 4][yIndex])
			{
				return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
			}
			else
			{
				max = Math.max(max, a[xIndex][yIndex]*a[xIndex+1][yIndex]*a[xIndex+2][yIndex]*a[xIndex+3][yIndex]);
				
				return findLargestProductInGrid(a, xIndex + 1, yIndex, max);	
			}
		}
		else
		{
			if(a[xIndex][yIndex] <= a[xIndex + 4][yIndex] && a[xIndex][yIndex] <= a[xIndex + 4][yIndex + 4] && a[xIndex][yIndex] <= a[xIndex - 4][yIndex + 4] && a[xIndex][yIndex] <= a[xIndex][yIndex + 4])
			{
				return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
			}
			else
			{
			max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
				Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
				Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3],
				a[xIndex][yIndex]*a[xIndex - 1][yIndex + 1]*a[xIndex - 2][yIndex + 2]*a[xIndex - 3][yIndex + 3]))));
			
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);	
			}
		}
	}
	else if(yIndex + 4 < a[0].length && xIndex - 4 >= 0)
	{
		if(xIndex + 3 >= a.length)
		{
			if(a[xIndex][yIndex] <= a[xIndex - 4][yIndex] && a[xIndex][yIndex] <= a[xIndex][yIndex + 4])
			{
				if(xIndex < a.length - 1)
				{
					return findLargestProductInGrid(a, xIndex + 1, yIndex, max);	
				}
				else
				{
					return findLargestProductInGrid(a, 0, yIndex + 1, max);
				}
			}
			else
			{
				max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex][yIndex+1]*a[xIndex][yIndex+2]*a[xIndex][yIndex+3],
						a[xIndex][yIndex]*a[xIndex-1][yIndex+1]*a[xIndex-2][yIndex+2]*a[xIndex-3][yIndex+3]));
				if(xIndex < a.length - 1)
				{
					return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
				}
				else
				{
					return findLargestProductInGrid(a, 0, yIndex + 1, max);
				}
			}

		}
		else
		{
			max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
				Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
				Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3],
				a[xIndex][yIndex]*a[xIndex - 1][yIndex + 1]*a[xIndex - 2][yIndex + 2]*a[xIndex - 3][yIndex + 3]))));
			
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);		
		}
	}
	else if(xIndex + 4 < a.length)
	{
		if(yIndex + 3 >= a[0].length)
		{
			if(a[xIndex][yIndex] <= a[xIndex + 4][yIndex])
			{
				return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
			}
			else
			{
				max = Math.max(max, a[xIndex][yIndex]*a[xIndex+1][yIndex]*a[xIndex+2][yIndex]*a[xIndex+3][yIndex]);
				
				return findLargestProductInGrid(a, xIndex + 1, yIndex, max);	
			}
		}
		else
		{
			if(a[xIndex][yIndex] <= a[xIndex + 4][yIndex])
			{
				return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
			}
			else
			{
			max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
				Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
				a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3])));
			
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);	
			}
		}
	}

	else if(yIndex + 4 < a[0].length)
	{
		if(xIndex + 3 >= a.length)
		{
			if(a[xIndex][yIndex] <= a[xIndex][yIndex + 4])
			{
				if(xIndex < a.length - 1)
				{
					return findLargestProductInGrid(a, xIndex + 1, yIndex, max);	
				}
				else
				{
					return findLargestProductInGrid(a, 0, yIndex + 1, max);
				}
			}
			else
			{
				max = Math.max(max, a[xIndex][yIndex]*a[xIndex][yIndex+1]*a[xIndex][yIndex+2]*a[xIndex][yIndex+3]);
				if(xIndex < a.length - 1)
				{
					return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
				}
				else
				{
					return findLargestProductInGrid(a, 0, yIndex + 1, max);
				}
			}

		}
		else
		{
			max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
				Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
				a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3])));
			
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);		
		}
	}


	else//I can't check anything before I do my calculation
	{
		if(xIndex + 3 < a.length && yIndex + 3 < a[0].length && xIndex - 3 >= 0)
		{
			max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
					Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
					Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3],
					a[xIndex][yIndex]*a[xIndex - 1][yIndex + 1]*a[xIndex - 2][yIndex + 2]*a[xIndex - 3][yIndex + 3]))));
			
			return findLargestProductInGrid(a, xIndex + 1, yIndex, max);
		}
		else if(xIndex + 3 < a.length && yIndex + 3 < a[0].length)
		{
			max = Math.max(max, Math.max(a[xIndex][yIndex]*a[xIndex + 1][yIndex]*a[xIndex + 2][yIndex]*a[xIndex + 3][yIndex], 
					Math.max(a[xIndex][yIndex]*a[xIndex][yIndex + 1]*a[xIndex][yIndex + 2]*a[xIndex][yIndex + 3],
					a[xIndex][yIndex]*a[xIndex + 1][yIndex + 1]*a[xIndex + 2][yIndex + 2]*a[xIndex + 3][yIndex + 3])));

		}
	}
	
	


}
}




}



