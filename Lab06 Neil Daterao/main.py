"""
Driver for testing different sorting functions

:author: Neil Daterao
"""

import random
import sys
from sorts import *

def __list_generator(kind, length):
    """
    creates a <kind> list with <length> numbers
    :param kind: data type like "random", "identical", "reverse-sorted", "sorted"
    :param length: number of numbers that should be placed into list
    :return: the finished list
    """
    data = []
    if kind == "random":
        for i in range(length):
            data.append(random.randint(1,length))
    elif kind == "identical":
        value = random.randint(1,length)
        for i in range(length):
            data.append(value)
    elif kind == "sorted_list":
        for count in range(length):
            data.append(count)
    elif kind == "reverse_sorted_list":
        for count in range(length, 0, -1):
            data.append(count)

    return data


def run_sort(func, kinds, lengths):
    """
    Run the given sort function with different sizes of lists
    filled with different kinds of data. Prints results of each run.

    :param func: name of sort function to run (sort1 or sort2)
    :param kinds: list of data types (e.g. ['random','identical'])
    :param lengths: list of input sizes to test on (e.g. [50,100])
    """
    for kind in kinds:
        for length in lengths:
            sys.setrecursionlimit(2*length)
            original = __list_generator(kind, length)
            finished, steps = func(original)
            if not __is_sorted(finished):
                print("*** FAIL -- does not sort")
            __log_data(func.__name__,kind,length,steps)


def __log_data(sorter_name,kind,size,opCount):
    """
    prints the result of one call to a sort function
    :param sorter_name: name of sort function (sort1 or sort2)
    :param kind: kind of data ('random', etc.)
    :param size: number of inputs
    :param opCount: number of times list was accessed in sort function
    """
    print("%s,%s,%d,%d" % (sorter_name,kind,size,opCount))


def __is_sorted(List):
    """returns True if List sorted, else False"""
    if List == []:
        return True
    for i in range(0,len(List) - 1):
        if List[i] > List[i + 1]:
            print("List[" + str(i) + "] = " + List[i] + " and List[" + str(i + 1) + "] = " + List[i + 1])
            return False
    return True


def main():
    # adjust the following three lines as per the instructions on the lab description
    print("Sort1 Data: \n")

    sort = sort1
    kinds=["random","identical", "sorted_list", "reverse_sorted_list"]
    lengths=[10, 100, 200, 500, 1000, 2000, 2250, 3000, 5000, 10000, 20000]

    run_sort(sort,kinds,lengths)

    print("Sort2 Data: \n")
    sort = sort2
    run_sort(sort, kinds, lengths)
    #type = __list_generator("reverse_sorted_list", 100)
    #print(type)

main()
