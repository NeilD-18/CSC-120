"""
File containing class of Die

:Author: Neil Daterao
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

import random as r


class Die:
    """
    Class for a Die
    """

    def __init__(self, number_of_sides_of_die=6):
        """
        constructor
        """
        self.__num_of_sides = number_of_sides_of_die
        self.__current_val = 1

    def roll(self):
        """
        Rolls the die to a random side
        """
        random_num = r.randrange(1, self.__num_of_sides)
        self.__current_val = random_num

    def get_value(self):
        """
        Returns the current value of the side the die rolled on
        """
        return self.__current_val

    def get_number_of_sides(self):
        """
        Return the number of sides of the die
        """
        return self.__num_of_sides


if __name__ == "__main__":
    dice6 = Die(6)
    dice12 = Die(12)
    print(dice6.get_value())
    print(dice12.get_value())
    dice12.roll()
    dice6.roll()
    print(dice6.get_value())
    print(dice12.get_value())
    test_die = Die()
    test_die1 = Die(3)
    print(test_die.get_number_of_sides())
    print(test_die1.get_number_of_sides())
