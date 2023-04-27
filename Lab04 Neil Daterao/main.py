from die import *
"""
Game comparing two die until one die is twice the value of the other 
"""

def main():
    """
    Game comparing two die
    """

    die6 = Die()
    die12 = Die(12)
    die6.roll()
    die12.roll()

    while (die6.get_value() != (2 * die12.get_value())) and ((2 * die6.get_value()) != die12.get_value()):
        print("Die of 6 sides value is:", die6.get_value())
        print("Die of 12 sides value is:", die12.get_value())
        user_press_return = input("Press return to roll again \n")

        die6.roll()
        die12.roll()

    print("You won! Game Over!")
    print("Die of 6 sides value is:", die6.get_value())
    print("Die of 12 sides value is:", die12.get_value())


if __name__ == "__main__":
    main()
