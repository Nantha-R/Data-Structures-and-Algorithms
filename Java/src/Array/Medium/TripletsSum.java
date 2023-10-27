package Array.Medium;

/*
    Question: https://leetcode.com/problems/3sum/submissions/
    Solution: https://www.code-recipe.com/post/three-sum
    Time Complexity: O(n^2)
    Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TripletsSum {

    private static HashSet<ArrayList<Integer>> getTriplets(final int[] numbers) {
        // Triplets needs to be unique, Hence using HashSet here.
        final HashSet<ArrayList<Integer>> triplets = new HashSet<>();

        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++) {
            final int firstElement = numbers[i];
            // Since FirstElement + SecondElement +ThirdElement = 0, If FirstElement is positive then
            // second and third elements are also positive and their sum will be greater than 0.
            if(firstElement > 0) {
                break;
            }
            final HashMap<Integer, Boolean> elements = new HashMap();

            for (int j=i+1;j<numbers.length;j++) {
                final int secondElement = numbers[j];
                final int requiredThirdElement = - firstElement - secondElement;
                if(elements.get(requiredThirdElement) != null) {
                    final ArrayList<Integer> triplet = new ArrayList<Integer>();
                    Collections.addAll(triplet, firstElement, secondElement, requiredThirdElement);
                    triplet.sort(Comparator.naturalOrder());
                    triplets.add(triplet);
                }
                elements.put(secondElement, Boolean.TRUE);
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        final int[] numbers = {-1,0,1,2,-1,-4};
        if (numbers.length <= 2) {
            System.out.println("NO TRIPLETS FOUND.");
        }
        final Set<ArrayList<Integer>> triplets =  getTriplets(numbers);
        for(final ArrayList<Integer> triplet : triplets) {
            System.out.println(triplet.toString());
        }
    }
}
