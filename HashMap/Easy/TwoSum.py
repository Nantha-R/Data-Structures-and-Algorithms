'''
Question: https://leetcode.com/problems/two-sum/
Solution: https://leetcode.com/problems/two-sum/discuss/1821115/Java-or-Explaination-or-HashMap-or-CodersTea.com
Time Complexity: O(n)
Space Complexity: O(n)
'''

def print_two_sums(numbers, target):
    values = {}
    for index in range(0, len(numbers)):
        num = numbers[index]
        expected_element = target - num
        if values.get(expected_element) is not None:
            print(values.get(expected_element), index)
            return
        else:
            values[num] = index
    print("No two sum entries found")


if __name__ == "__main__":
    numbers = [2, 7, 11, 15, 0, 5]
    target = 7
    print_two_sums(numbers, target)
