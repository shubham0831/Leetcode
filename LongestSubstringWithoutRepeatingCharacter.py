'''
    Given a string s, find the length of the longest substring without repeating characters.
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
'''

def func(s):
    i = 0 
    j = 0
    charSet = set()
    currentCount = 0
    maxCount = 0

    while (j < len(s)):
        # print(f'count {currentCount} --- max {maxCount}')
        if (s[j] not in charSet):
            charSet.add(s[j])
            currentCount = (j-i+1)
        else :
            print(f'{i} + {j}')

            if (s[i] == s[j]):
                i += 1
            else :
                while (s[i] != s[j]):
                    print(f'{i} - {j}')
                    charSet.remove(s[i])
                    i += 1
                while (s[i] == s[j] and i < j):
                    i += 1
                currentCount = j-i+1
        j += 1
        # print(f'count {currentCount} max {maxCount}')
        # print('----')
        maxCount = max(maxCount, currentCount)
    return maxCount

'''
    Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
    https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
'''

def func2 (s, k):
    i = 0 
    j = 0
    charSet = set()
    currentCount = 0
    maxCount = 0
    setSize = 0

    if (k == 0):
        return 0


    while (j < len(s)):
        # print(f'count {currentCount} --- max {maxCount}')
        # currentCount = (j-i+1)
        if (s[j] not in charSet):
            charSet.add(s[j])
            setSize += 1
            currentCount = (j-i+1)
            # print(f'added new char, charset size is {charSet}')

        if (setSize == k):
            # print(f"in this current size {j} {i}")
            currentCount = (j-i+1)
            maxCount = max(maxCount, currentCount)
            j += 1
        elif (setSize > k):
            charSet.remove(s[i])
            setSize = len(charSet)
            # print(f"removed new char, charset size is {charSet}, '---' {setSize}")
            l = 0
            for m in range(i,j):
                if (s[m] != s[i]):
                    l = m
                else :
                    l += 1
                    charSet.remove(s[l])
            i = l
            # print(i)
            currentCount = (j-i+1)
            j += 1
        else :
            currentCount = (j-i+1)
            maxCount = max(maxCount, currentCount)
            j += 1
            

        
        # maxCount = max(maxCount, currentCount)
    return maxCount

s = "eceba"
s = "aba"
k = 1
# print(func2(s,k))

a = 'abaab'
b =  ''

for c in a:
    if c == "a":
        b += "b"
    else :
        b += "a"

print(b)


# s = "tmmzuxt"
# print(func(s))