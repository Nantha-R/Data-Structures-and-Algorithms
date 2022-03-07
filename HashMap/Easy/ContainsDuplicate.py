'''
Question: https://leetcode.com/problems/contains-duplicate/
Solution: https://leetcode.com/problems/contains-duplicate/discuss/1825830/C%2B%2B-solution-using-maps-oror-Easy-to-understand-oror-Simple-solution
Time Complexity: O(n)
Space Complexity: O(n)
'''


def check_for_duplicates(numbers):
    hash_map = dict()
    for number in numbers:
        if hash_map.get(number) is not None:
            return True
        hash_map[number] = True
    return False


if __name__ == "__main__":
    numbers = [1, 2, 3, 1]
    result = check_for_duplicates(numbers)
    print(result)
