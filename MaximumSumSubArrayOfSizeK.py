'''
    Given an array and a size k, find the maximum sum of a window the size of k
'''

'''
    Logic, have two pointers i and j, representing the ends of the window
    the length of the window will be j-i+1 since if i = 0 and j = 5, we have a total of 6 elements 
    so 5-0+1 = 6

    so while we do not have a window of size k, we have to keep increasing j
    once we do that, we can update the maximum sum

    then since window is about to change now, we need to subtract a[i] from the current tempSum and add a[j]

    a[j] will be added at the start of the while loop anyways, so we remove a[i] and do i++ and j++

    the loop will break when j <= size-1 then we have to do one more iteration to get the max
    sum of the last k elements so since we have already subtracted a[i] from temp, all we have
    to do is add a[j] to it and then find the max
'''

def func (a: list, k: int):
    size: int = len(a)
    i: int = 0
    j: int = 0
    maxsum: int = 0
    tempsum: int = 0
    
    while (j < size-1):
        tempsum += a[j]
        if (j-i+1 != k):
            j += 1
        elif (j-i+1 == k):
            maxsum = max(tempsum, maxsum)
            tempsum -= a[i]
            i += 1
            j += 1

    tempsum = tempsum + a[j]
    maxsum = max(tempsum, maxsum)
    return maxsum

a = [100,200,300,400]
k = 2

print(func(a,k))




