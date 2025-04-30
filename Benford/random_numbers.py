
#Section 3 1D20: homework "random_numbers.py" 
#import random library to do 3.1:
import random
#3.2
from typing import Callable
#3.3
import statistics



#3.1: do "random20" function that returns int
def random20(r: random.Random) -> int:
    #generate random num
    randomFloat:float = r.random()
    #scale random number - how we did in class
    random_number:int = int(randomFloat *20) + 1

    return random_number

#3.4 INPUTS: random int: 20, num elements: 20, n = 20,000,000 with a seed of 42
#
#3.4 OUTPUTS: results I got from stats_random (section 3.4)
# mean:  1000000
# median:  1000109.5
# standard dev:  997.7344336044537



#3.2 function: do "hist_random" return integer n
#skeleton from homework PDF
def hist_random(n: int, r: random.Random, f: Callable[[random.Random], int], num_elements: int) -> list[int]:
    # Initialize "frequency distribution" list
    frequencies:list[int] = [0] * num_elements
    
    # Run function 'f' n amount of times with ramdom value r
    for _ in range(n):
        result:int = f(r)  
        #book keeping - keep track of index
        #subtrcat the offset
        frequencies[result - 1] += 1 
    
    return frequencies


#3.3: Make stats_random: takes funtion f, along with "histogram" numbers
#then: creates random number generatior reusing seed and generate frequency distribution from previos step 
#Use: f, num of elemenst and n. (return mean, median, standard deviation)

#Skeleton from homework pdf
def stats_random(f: Callable[[random.Random], int], num_elements: int, n: int, seed: int) -> tuple[float, float, float]:
    #initailize values  for num elemenst, range,  int n and a seed. 
    #seed = can get same outout values as long as it is used consitently
    random_val: random = random.Random(seed)

    #can generate "frequecy distribution using last function from 3.2"
    frequency_distribution = hist_random(n,random_val,f,num_elements)


    #How to return mean/stand. deviation and distribution?
    #place "frequency_distribution" inisde library functuions for statistics:
    mean = statistics.mean(frequency_distribution)
    #median
    median = statistics.median(frequency_distribution)
    #standard deviation
    standard_dev = statistics.stdev(frequency_distribution)
    #distribution = mean, median stddev?


    #return all values 
    return (mean, median, standard_dev)


# #test 3.4: 
# print ("testing ststs_random from section 3.4\n")
# #values: num of elements, n, seed
# num_elements: int = 20
# n:int = 20000000
# seed:int = 42
# #stats_random should take: random number, elements in histogram, integer n and a seed
# #print the values of ststs_random

# mean:tuple = stats_random (random20, num_elements, n, seed)
# median:tuple = stats_random (random20, num_elements, n, seed)
# standard_dev:tuple = stats_random (random20, num_elements, n, seed)
# #print each value separetly
# print (f"mean: ", mean[0])
# print (f"median: ", median[1])
# print (f"standard dev: ", standard_dev[2])
# print("\n")



#4.1 dieroll function: modifies random20 using modulo. return num from 1 to 6
#r = input for random 20 function 
def dieroll(r: random.Random) -> int:
    randomNum:int = random20(r)

    #modulo from 1-6
    die:int = (randomNum) % 6 + 1

    return die

    #4.2 RESULT: (mean, median, standard dev)
    #(3333333.3333333335, 3000833.5, 516827.8187968084)


    # 4.3 - ANSWER: When it comes to the individial numbers you can create the argument that they are indeed random and there is no way 
    # for the programmer to guess what numbers will appear in the sequence. But since the seed can be used to in another system to get out 
    # the same outputs from the functions then my answer is that the collection of numbers is NOT random. 





# #4.2 testing ()
# print("\n4.2:")
# #4.2 inputs: f = dieroll, num_elements = 6, n = 20,000,000, seed = 42
# print(stats_random(dieroll, 6, 20000000, 42))


