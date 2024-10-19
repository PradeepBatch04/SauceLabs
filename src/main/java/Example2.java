import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example2 {

	public static void main(String[] args) {
		
		Integer[] input = {12, 9, 17, 3, 2, 6};
        List<Integer> list = Arrays.asList(input);
        
        // Sort the list in descending order
        Collections.sort(list, Collections.reverseOrder());

        Integer[] output = new Integer[input.length];
        int left = 0;
        int right = list.size() - 1;

        // Fill the output array
        for (int i = 0; i < output.length; i++) {
            if (i % 2 == 0) {
                output[i] = list.get(left++);
            } else {
                output[i] = list.get(right--);
            }
        }

        System.out.println(Arrays.toString(output));
	}

}
