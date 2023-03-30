"""
Models a boneyard -- a pile of dominoes.
"""

import domino as d
import random

def create():
    """
    Creates a pile of dominoes containing
    one copy of every possible domino

    :return: list of dominos
    """
    yard = []
    for i in range(0,7):
        for j in range(0, 7):
            tile = d.create(i, j)
            yard.append(tile)
    return yard

def draw(boneyard):
    """
    Removes a random domino from the boneyard

    :return: list of dominos without the drawn domino
    """
    n = random.randint(0, len(boneyard)-1)
    return boneyard.pop(n)

def tiles_remaining(boneyard):
    """
    The number of tiles left in the yard

    :return: integer - number of tiles left in the yard
    """
    return len(boneyard)
