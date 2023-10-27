'''
    Question: https://leetcode.com/problems/search-in-rotated-sorted-array/
    Solution: -
    Time Complexity: O(logN)
    Space Complexity: O(1)
'''


def get_element_index(numbers, starting_index, ending_index, target):

    if starting_index > ending_index:
        return -1

    middle_element_index = (starting_index + ending_index)//2
    if numbers[middle_element_index] == target:
        return middle_element_index

    # 1234567 Search for 6
    if numbers[middle_element_index] < numbers[ending_index] and target >= numbers[middle_element_index] and target <= numbers[ending_index]:
        return get_element_index(numbers, middle_element_index+1, ending_index, target)

    # 3456712 Search for 1
    if numbers[middle_element_index] > numbers[ending_index] and target <= numbers[middle_element_index] and target <= numbers[ending_index]:
        return get_element_index(numbers, middle_element_index+1, ending_index, target)

    # 3456712 Search for 7
    if numbers[middle_element_index] > numbers[ending_index] and target >= numbers[middle_element_index] and target >= numbers[ending_index]:
        return get_element_index(numbers, middle_element_index+1,ending_index, target)

    return get_element_index(numbers, starting_index, middle_element_index-1, target)


if __name__ == "__main__":
    numbers = [4, 5, 6, 7, 0, 1, 2]
    target = 5
    element_index = get_element_index(numbers, 0, len(numbers)-1, target)
    print(element_index)
