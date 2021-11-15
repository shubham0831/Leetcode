'''
    Given an array and a window size k, print the first negative number of in the window
'''

from typing import Deque


def func (a: list, k: int):
    size = len(a)
    #queue which has the indices of all the negatuve numbers
    di = Deque()
    answer = []

    #entering the indices of the negative numbers in the first k element (or first window)
    for i in range(k):
        if (a[i] < 0):
            di.append(i)
    
    #handling for the rest of the cases, except the last one
    for i in range(k,size):
        #if we have a negative number in the first window, the first of those
        #is going to be the first negative number in that window
        if (len(di) != 0):
            answer.append(a[di[0]])
        else :
            #else we append 0
            answer.append(0)
        
        #removing all the negative numbers in the earlier window
        #since di has the indicies, and the start start of the window is i
        #i-k+1 will give us all the elemnts which were in the previous window
        '''
            example, if k = 3, and the first window has a negative element at index 0

            the next window will be from 1-3 (els 1,2,3)
            so element 0 will not be considered in this window
            so to remove it, we can do i-k+1 = 3-3+1 = 1 which is greater than 0,
            so we remove that element from di 
        '''
        while (len(di) != 0 and di[0] < i - k + 1):
            di.popleft()
        
        if (a[i] < 0):
            di.append(i)
    
    #doing the same thing, but for the last window
    if (len(di) != 0):
        answer.append(a[di[0]])
    
    return answer  
     

a = [-8,5,8,-15]
a = [-8,2,3,-6,10]
# a = [12,-1,-1]
k = 2
print(func(a,k))

'''
    windows will be 
    [12,-1,-7] first negative number = -1
    [-1,-7, 8] first negative number = -1
    [-7,8,-15] first negative number = -7
    and so on    
'''