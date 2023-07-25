
import math
import time

def time_function(fun, *args):
    time_before = time.time()
    fun(*args) 
    return time.time() - time_before

def sieve_of_eratosthenes(n):
    is_prime = [True] * (n+1) #init array of length n+1 to True
    is_prime[0] = is_prime[1] = False #0 and 1 are not primes

    # for all items up to sqrt(n)+1
    for p in range(2, int(n**0.5)+1): 
        if is_prime[p]:
            for i in range(p+p, n+1, p): #for p+p up until end of array and stepping by p, these are all not prime
                is_prime[i] = False

    #return all primes
    return [i for i in range(2,n+1) if is_prime[i]]

#did not complete n=500 after 554s
#n=200 in 23.45s
def find_num_divisors_slow(n, primes=[]):
    is_divisor = [False] * (n+1)
    is_divisor[0] = False
    is_divisor[1] = True
    is_divisor[n] = True
    
    for p in range(2, int(n**0.5)+1):
        if n % p == 0:
            is_divisor[p] = True
            is_divisor[int(n/p)] = True

    return len([i for i in range(1,n+1) if is_divisor[i]])

#n=200 in 69s
def find_num_divisors_sieve(n, primes=[]):
    is_divisor = [None] * (n+1)
    is_divisor[0] = False
    is_divisor[1] = True
    is_divisor[n] = True
    
    for p in range(2, int(n**0.5)+1):
        if is_divisor[p] is None:
            if n % p == 0:
                is_divisor[p] = True
                is_divisor[int(n/p)] = True
            else:
                for i in range(p+p, n+1, p):
                    is_divisor[i] = False
            
    return len([i for i in range(1,n+1) if is_divisor[i]])

def find_prime_factorization(n, primes=[]):
    factors = []

    i = 0
    while i < len(primes) and n >= primes[i]:
        if n % primes[i] == 0:
            factors.append(primes[i])
            n = n / primes[i]
        else:
            i = i + 1 
        
    return factors

def find_num_divisors_try(n, primes=[]):
    factors = find_prime_factorization(n,primes)

    num_divisors = 1
    prior_factor = -1
    factor_count = 1
    
    for n in factors:
        if n == prior_factor:
            factor_count = factor_count + 1
        else:
            num_divisors = num_divisors * (factor_count+1)
            factor_count = 1
            prior_factor = n
        
    return num_divisors

def find_triangle(n=5):

    #generate triangle numbers
    found = False
    next_number = 1 
    current_triangle = 0
    primes = sieve_of_eratosthenes(765765000)

    
    while(not found):
        current_triangle = current_triangle + next_number
        num_divisors = find_num_divisors_try(current_triangle, primes)
                
        #stop iterating?
        if(num_divisors > n):
            print("{}: = {}".format(current_triangle, num_divisors))
            found=True

        #iterate 
        next_number=next_number + 1


#benchmark
def benchmark():

    bench = [find_num_divisors_slow, find_num_divisors_sieve, find_num_divisors_try]
    test_num = 2031120 
    primes = sieve_of_eratosthenes(test_num)
    sqrt_primes = [x for x in primes if x <= test_num**0.5]
    
    correct = bench[0](test_num)
    print("Correct {}".format(correct))
    for f in bench:
        print("{}: {}".format(f, time_function(f, test_num, primes)))
        if f(test_num, primes) != correct:
            print(" -> {} returns wrong data = {}".format(f, f(test_num, primes))) 

find_triangle(5)



