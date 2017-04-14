
//basic binary search class. it searches substring in strings
public class binarySearch
{
	
	public int binary_search(String[][] array, String name) {
		int begin = -1;
		int end = array.length;
		while (end-begin>1) {
			int middle = (begin + end) / 2; 
			if (array[middle][1].toLowerCase().startsWith(name.toLowerCase())) { //if substring equals string
				return middle;
			}
			if (name.compareToIgnoreCase(array[middle][1]) > 0) {//if substring greater than string
				begin = middle;
			}
			else {//if substring less than string
				end = middle;
			}
		}
		return -1;//if there is no match, function returns -1
	}
}