'''
    Question: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    Solution: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
    Time Complexity: O(logN)
    Space Complexity: O(1)
'''


def get_minimum_element(numbers, starting_index, ending_index):
    middle_element_index = (starting_index + ending_index) // 2

    if middle_element_index != len(numbers) - 1:
        # Condition to find out the minimum element.
        # [3,4,5,1,2]
        if numbers[middle_element_index] > numbers[middle_element_index+1]:
            return numbers[middle_element_index+1]
    # Case where minimum element is present at the end of the array.
    # [7, 8, 0]
    elif numbers[middle_element_index] < numbers[0]:
        return numbers[middle_element_index]

    if numbers[middle_element_index] > numbers[0]:
        return get_minimum_element(numbers, middle_element_index + 1, ending_index)
    else:
        return get_minimum_element(numbers, 0, middle_element_index)


if __name__ == "__main__":
    numbers = [4, 5, 6, 7, 0, 1, 2]
    # Case where there is only one element in the array.
    if len(numbers) == 1:
        print(numbers[0])
    # Case where the array is still sorted after rotation is completed.
    elif numbers[len(numbers)-1] > numbers[0]:
        print(numbers[0])
    else:
        minimum_element = get_minimum_element(numbers, 0, len(numbers) -1)
        print(minimum_element)
