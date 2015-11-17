import java.util.ArrayList;
import java.util.Scanner;


public class PaperFold {
	
	private static Scanner scan;

	//recursive method that takes in n for number of folds and returns 
	//an int array for left or right, 1 or 0, respectively
	private static int[] getDirections(int n){
		//create int[] to be returned of size 2^n-1
		int size = (int)Math.pow(2,n);
		size--;
		int dirs[] = new int[size];
		
		//base case 
		if(n==1){
			dirs[0] = 1;
			return dirs;
		}
		
		//take the previous int[], add a left to the end, and add the mirror image 
		//to the other side recursively
		else{
			
			int prevSize = (int)Math.pow(2,n-1);
			prevSize--;
			int prevDirs[] = new int[prevSize];
			prevDirs = getDirections(n-1);
			
			//put the first half of the previous list into dirs
			for(int i=0;i<prevSize;i++){
				dirs[i] = prevDirs[i];
			}
			//assign a left to the middle
			dirs[prevSize] = 1;
			
			//change prevDirs to its opposite
			for(int j=0;j<prevSize;j++){
				if(prevDirs[j]==1)
					prevDirs[j]=0;
				else
					prevDirs[j]=1;
			}
			
			int index = 0;
			
			//set the second half of dirs to flipped mirror image of prevDirs
			for(int k=size-1;k>size/2;k--){
				dirs[k] = prevDirs[index];
				index++;
			}
			
			return dirs;
		}
		
	}
			
	public static void main(String[] args){
	System.out.println("Enter a number of folds");
	scan = new Scanner(System.in);
	String num = scan.nextLine();
	int n = Integer.parseInt(num);
	
	int size = (int) Math.pow(2,n);
	size--;

	int[] directions = new int[size];
	directions = getDirections(n);
	
	//traverse through directions array and print LEFT for 1 and RIGHT for 0
	for(int i=0;i<size;i++){
		if(directions[i]==1)
			System.out.print("LEFT ");
		else
			System.out.print("RIGHT ");
	}
	
	}
}
