import java.util.ArrayList;
import java.util.Arrays;
//includes run functions
public class buildClass {

	private ArrayList<inputObj> input_list = new ArrayList<inputObj>();//stores parsed and sorted text files


	//starts program
	public void start(String input_name,int k, String search_key) throws Exception{


		int input_index = check_input(input_name);//checks if input is parsed already or not. if parsed, returns index
		if(input_index == -1)//input errors
			return;
		int key_index = search_key(search_key, input_index);//returns index of one matched query

		if(key_index == -1){//searched key cannot found in list
			System.out.println(search_key + " cannot found in " + input_name);
		}
		else{//key found in list
			String[][] query = find_query(search_key,key_index,input_index);//creates array with matched queries

			print_output(input_name, search_key, query, k);//prints output

		}
	}
	//checks if input is already exists and returns index of input 
	private int check_input(String new_input_name) throws Exception{
		
		int index;
		for (index = 0; index < input_list.size(); index++) {
			if(input_list.get(index).getInput_name().equals(new_input_name)){//if it is sorted already
				return index;
			}
		}

		//if it is not sorted and parsed
		int parse = parse_input(new_input_name); // if input is correct or not
		if(parse == -1)// when weight is negative
			index = -1;

		return index;
	}
	private int parse_input(String input_name) throws Exception{

		readFile read = new readFile();
		inputObj inp = new inputObj();

		String[][] input = read.read_file(input_name); //input file read, and sorted
		if(input == null)
			return -1;

		input = sort_list(input);//sorts terms alphabetically
		inp.setInput_name(input_name);//sets input name
		inp.setTerm_list(input);//sets input array
		input_list.add(inp);//adds input object to array

		return 1;

	}
	//sorts unsorted array and returns sorted array
	private String[][] sort_list(String[][] raw_input) {

		QuickSort qs = new QuickSort(raw_input);
		qs.start(0, raw_input.length-1);

		return qs.get_sorted_array();
	}
	//searches one query in sorted term list
	private int search_key(String search_key, int input_index){
		try{
			binarySearch bs = new binarySearch();
			int index = bs.binary_search(input_list.get(input_index).getTerm_list(), search_key);
			if(index == -1){
				throw new NullPointerException();//if there is no match
			}
			return index;
		}
		catch (Exception e) {
			return -1;
		}
	}
	//creates array with matched query list
	private String[][] find_query(String key,int key_index,int input_index){

		int size = input_list.get(input_index).getTerm_list().length;
		int lo_point = key_index-1;//low point index of matched query
		int hi_point = key_index+1;//high point index of matched query
		
		//searches substring in sorted array from index to zero
		while(lo_point >= 0 && input_list.get(input_index).getTerm_list()[lo_point][1].toLowerCase().startsWith(key.toLowerCase())){

			lo_point--;
		}
		//searches substring in sorted array from index to end of array
		while(hi_point >= 1  && hi_point < size && input_list.get(input_index).getTerm_list()[hi_point][1].toLowerCase().startsWith(key.toLowerCase()) ){

			hi_point++;
		}
		lo_point++;

		//copies matched strings to query list
		String[][] query = Arrays.copyOfRange(input_list.get(input_index).getTerm_list(), lo_point, hi_point);


		return sort_query(query);//sorts query list in descending order by weight.

	}
	////sorts query list in ascending order by weight
	private String[][] sort_query(String[][] unsorted_q){

		QuickSortInt qsi = new QuickSortInt(unsorted_q);
		qsi.start(0, unsorted_q.length-1);

		return qsi.get_sorted_array();
	}
	//prints output
	private void print_output(String input_name,String search_key,String[][] query,int k){

		System.out.println("% " + input_name + " " + k);
		System.out.println(search_key);
		for (int i = 0; i < k; i++) {
			if(i == query.length){
				System.out.println("There is only " + i +" term in query.");
				break;
			}
			System.out.println(query[query.length-i-1][0] + " " + query[query.length-i-1][1]);
		}


	}


}
