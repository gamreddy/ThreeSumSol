import java.util.Set;
import java.util.*;


class ThreeSumSol {


    public Set<int[]> find(int numbers[]){

        //sort first
        Arrays.sort(numbers);

        Set<int[]> output = new HashSet<>();

        //find triplets for every element starting from the first
        for(int i=0; i<numbers.length; i++){

            //to avoid duplicates
            if(i>0 && numbers[i] == numbers[i-1]){
                continue;
            }

            int j=i+1, k=numbers.length - 1;
            int sumNumbers;

            //proceed till j=k
            while(j<k){

                sumNumbers = numbers[i] + numbers[j] + numbers[k];

                if(sumNumbers == 0){
                    //triplet found, add to the output
                    output.add(new int[]{numbers[i], numbers[j], numbers[k]});
                    //move j to find other triplets
                    j++;
                    //to avoid duplicates
                    while(j<k && numbers[j] == numbers[j-1]){
                        j++;
                    }
                }else if(sumNumbers < 0){
                    //move j so that the sum can increase
                    j++;
                }else{
                    //move k so that the sum can decrease
                    k--;
                }
            }
        }

        return output;
    }

    public static void main(String args[]){
        int[] data = {-1, 0, 1, 2, -1, -4};
        ThreeSumSol sol = new ThreeSumSol();
        Set<int[]> triplets = sol.find(data);
        if(triplets.size() > 0){
            System.out.println(triplets.size());
        }        
    }

}