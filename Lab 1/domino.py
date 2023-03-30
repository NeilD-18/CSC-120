"""
Functions relating to the dominos
"""

def create(left, right):
    """
    Create a domino

    :param left: left integer of domino
    :param right: right integer of domino
    :return: tuple which represents domino
    """
    return (left,right)

def as_str(domino):
    """
    Translates domino into string

    :param domino: takes a domino as a tuple
    :return: string
    """
    return "[%d | %d]" % (get_left(domino), get_right(domino))

def get_left(domino):
    """
    Gets left integer of domino

    :param domino: takes a domino as a tuple
    :return: integer - left side of domino
    """
    return domino[0]

def get_right(domino):
    """
    Gets right integer of domino

    :param domino: takes a domino as a tuple
    :return: integer - right side of domino
    """
    return domino[1]

