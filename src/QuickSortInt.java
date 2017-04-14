
// Basic integer based quick sort implementation. Compares integers.
public class QuickSortInt {
	private static String[][] inputArray = null;
	

	public QuickSortInt(String[][] inputArray){
		QuickSortInt.inputArray = inputArray;
		
	}

	public void start(int start,int end){
		int q;
		
		if(start<end){
			q = partition(start, end);
			start(start, q);
			start(q+1, end);
		}
	}
	public String[][] get_sorted_array(){
		return QuickSortInt.inputArray;
	}
	
	int partition(int start,int end){


		int init = start;
		int length = end;

		Long pivot = Long.parseLong(inputArray[start+(end-start)/2][0]);


		while(true){
			while(Long.parseLong(inputArray[length][0]) > pivot && length > start){
				length--;
			}

			while(Long.parseLong(inputArray[init][0]) < pivot && init < end){
				init++;
			}

			if(init<length){
				String [] temp = inputArray[init];
				inputArray[init] = inputArray[length];
				inputArray[length] = temp;
				length--;
				init++;

			}else{
				return length;
			}
		}

	}
}