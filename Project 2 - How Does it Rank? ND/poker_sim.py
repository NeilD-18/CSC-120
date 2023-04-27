from card import *
from deck import *
from poker_hand import *
"""
Simple game where the user chooses which poker hand they think is stronger.

:author: Neil Daterao
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty, in
accordance with the Union College Honor Code and the course syllabus.
"""

def poker_simulation_game():
    """
    Simple game where the user chooses which poker hand they think is stronger.
    """
    
    start_message = input("Welcome to the poker strength test game! Press return to get your first set of hands!")
    deck_of_cards = Deck()
    deck_of_cards.shuffle()
    total_points = 0
    
    while deck_of_cards.size() >= (max_cards_in_hand * 2):
        poker_hand = []
        other_poker_hand = []
        for dealing_card_count in range(max_cards_in_hand):
            poker_hand.append(deck_of_cards.deal())
            other_poker_hand.append(deck_of_cards.deal())
        poker_hand = PokerHand(poker_hand)
        other_poker_hand = PokerHand(other_poker_hand)
        expected_winner = poker_hand.compare_to(other_poker_hand)
        
        print("    Hand #1 \n")
        print("---------------")
        print(poker_hand)
        print("---------------")
        print("    Hand #2 \n")
        print("---------------")
        print(other_poker_hand)
        print("---------------")
        #print("Cheat:", expected_winner) -> If you want to cheat 
        
        answer = input("Which hand do you think is stronger, 1 or 2? If you think it's a tie enter 0! \n")
        
        accepted_answers = ["0", "1", "2"]
        while answer not in accepted_answers:
            print("Invalid Input! \n")
            answer = input("Which hand do you think is stronger, 1 or 2? If you think it's a tie enter 0! \n")
        
        if int(answer) == 1 and expected_winner > 0:
            total_points += 1
            print("\nGood job you got it right! Let's see if you can get the next set of hands right too! \n")
        
        elif int(answer) == 2 and expected_winner < 0:
            total_points += 1
            print("\nGood job you got it right! Let's see if you can get the next set of hands right too! \n")
       
        elif int(answer) == 0 and expected_winner == 0:
            total_points += 1
            print("\nGood job you got it right! Let's see if you can get the next set of hands right too! \n")
       
        else:
            print("Incorrect! Game Over!")
            print("Total Points: ", total_points)
            return 0
    print("Game Over! You got the whole deck right, good job!")
    print("Total Points: ", total_points)
    
    return 0 
             

def main():
    play_again = "Y"
    while play_again == "Y":
        poker_simulation_game()
        play_again = input("Would you like to play again (Y/N) ")
        if play_again == "N":
            print("Awh Bummer! Have a nice day!")
            return 0

if __name__ == "__main__":
    main()