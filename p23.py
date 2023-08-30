#approach
# for n < 28124 
#  find all proper divisors
#  identify numbers as abundant or deficient 
# 
# for n < 28124
#   identify if n can be written as sum of two abundant numbers
#
# sum up all those numbers

LIMIT = 28124
sum_proper_divisors = [0 for i in range(LIMIT)]

#work through a sieve like algorithm
for i in range(2,LIMIT):
    j = i+i  # is not its own proper divisor
    while(j < LIMIT):
        sum_proper_divisors[j]=sum_proper_divisors[j]+i
        j = j + i

#find the abundant numbers
abundant = {i for i in range(len(sum_proper_divisors)) if sum_proper_divisors[i] > i }

print("{} abundant elements".format(len(abundant)))

#find all the sum of all pairs of abundant less than the LIMIT

#SLOOOOOOOOOOOOOOOOOOWW
#python3 p23.py  1.68s user 0.09s system 98% cpu 1.794 total
#all_pairs_of_abundant = list(set([abundant[i] + abundant[j] for i in range(len(abundant)) for j in range(len(abundant)) if i <= j and abundant[i] + abundant[j] < LIMIT ]))
#print ( sum(range(LIMIT)) - sum(all_pairs_of_abundant) )

#MUCH FASTER (is it because the set of abundant's is small?)
#python3 p23.py  0.22s user 0.01s system 96% cpu 0.239 total
def is_sum_of_two_abundant(n: int):
    for num in abundant:
        if num > n:
            break
        if (n - num) in abundant:
            return True
    return False

non_sum = [integer for integer in range(1, LIMIT) if not is_sum_of_two_abundant(integer)]
print(sum(non_sum))

all_pairs_of_abundant = [a for a in abundant] 

