


//Basic string based quick sort implementation.Compares strings
public class QuickSort {
	private static String[][] inputArray = null;
	

	public QuickSort(String[][] inputArray){
		QuickSort.inputArray = inputArray;	
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
		return QuickSort.inputArray;
	}
	
	int partition(int start,int end){


		int init = start;
		int length = end;

		String pivot = inputArray[start+(end-start)/2][1];


		while(true){
			while(inputArray[length][1].compareToIgnoreCase(pivot) > 0 && length > start){
				length--;
			}

			while(inputArray[init][1].compareToIgnoreCase(pivot) < 0 && init < end){
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