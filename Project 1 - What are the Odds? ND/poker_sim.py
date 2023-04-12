"""
Poker Simulator to determine liklihood of getting a certain hand

:author: Neil Daterao
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

""":self-reflection-on-refactoring: Again, I didn't refactor much within this module. I utilized helper and getter 
functions to ensure I maintained information hiding. In terms of storing the data from each of the simulations, 
I used a dictionary again. I believe this keeps the data nice and organized to access and work with. In my opinion, 
it makes the code more readable since the keys for the dictionary are actual words. Formatting the table was a little 
tricky, I had to check if the float for the percentages was less than 10 because if it was I would have to add 
leading 0s to fit the criteria. Getting everything to line up took a bit of research. I ended up using .rjust() for 
most of it since the amounts were right aligned and the centers of the percentages seemed to line up with this as 
well. Overall, this module was fairly easy to create and it was fun putting the whole project together to get a nice 
table of data revolving around the likelihood of certain poker hands. 

"""

from cards import *
from hand import *

def simulation(num_of_hands):
    """
    Simulates a given number of poker hands and determines the amount of each type of hands in a given number of
    hands, as well as a percentage.

    :param num_of_hands: Integer of number of hands you want to simulate
    :return: A dictionary which holds the data for each handtype
    """
    deck = create_deck_of_cards()
    shuffle_cards(deck)
    
    total_flushes = 0
    total_pairs = 0
    total_two_pairs = 0
    total_high_card = 0
    
    hand_num = 1
    while hand_num <= num_of_hands:
        
        if get_deck_size(deck) < 5:
            deck = create_deck_of_cards()
            shuffle_cards(deck) 

        hand = create_hand(deck)
        hand_type = determine_classification_of_hand(hand)

        if hand_type == "Flush":
            total_flushes += 1
        if hand_type == "Pair":
            total_pairs += 1
        if hand_type == "Two pair":
            total_two_pairs += 1
        if hand_type == "High card":
            total_high_card += 1
        hand_num += 1
    return {"pairs": (total_pairs, (total_pairs/num_of_hands) * 100), "2 pairs":(total_two_pairs, (total_two_pairs/num_of_hands) * 100), "flushes": (total_flushes, (total_flushes/num_of_hands * 100)), "high card": (total_high_card, (total_high_card/num_of_hands * 100))  }
            
def get_amount_of_hand_type(data_from_sim, handtype):
    """
    return the total amount of a hand type from a simulation

    :param data_from_sim: A dictionary of the data from the simulation
    :param handtype: The hand type of the data you want  
    :return: An integer of the amount of the given hand_type
    """
    return data_from_sim[handtype][0]

def get_percentage_of_hand_type(data_from_sim, handtype):
    """
    return the percentage of a hand type from a simulation

    :param data_from_sim: A dictionary of the data from the simulation
    :param handtype: The hand type of the data you want  
    :return: An integer of the amount of the given hand_type
    """
    return data_from_sim[handtype][1]

def create_table():
    """
    Create heading for table to represent data of amount/percentage of poker hands

    :param: None
    :return: None
    """
    print("# of hands      pairs    %       2 pairs    %      flushes    %      high card    % ")

def add_row_to_table(num_of_hands, simulation):
    """
    Add a row to the table given the new simulation data

    :param num_of_hands: Amount of hands in simulation
    :param simulation: Data from simulation
    :return: None
    """
    
    
    num_of_hands = str((format (num_of_hands , ',d'))).rjust(10, " ")
    
    
    num_of_pairs = str((format (get_amount_of_hand_type(simulation, "pairs") , ',d'))).rjust(10, " ")
    percentage_of_pairs = get_percentage_of_hand_type(simulation, "pairs")
    percentage_of_pairs = f"{percentage_of_pairs: .2f}"
    if float(percentage_of_pairs) < 10:
        percentage_of_pairs = str(percentage_of_pairs).lstrip(" ").rjust(5, "0")
        

    num_of_2pairs = str((format (get_amount_of_hand_type(simulation, "2 pairs") , ',d'))).rjust(11, " ")
    percentage_of_2pairs = get_percentage_of_hand_type(simulation, "2 pairs")
    percentage_of_2pairs = f"{percentage_of_2pairs: .2f}"
    if float(percentage_of_2pairs) < 10:
        percentage_of_2pairs = str(percentage_of_2pairs).lstrip(" ").rjust(5, "0").rjust(6, " ")
        

    num_of_flushes = str((format (get_amount_of_hand_type(simulation, "flushes") , ',d'))).rjust(10, " ")
    percentage_of_flushes = get_percentage_of_hand_type(simulation, "flushes")
    percentage_of_flushes = f"{percentage_of_flushes: .2f}"
    if float(percentage_of_flushes) < 10:
        percentage_of_flushes = str(percentage_of_flushes).lstrip(" ").rjust(5, "0").rjust(6, " ")
        

    num_of_high_card = str((format (get_amount_of_hand_type(simulation, "high card") , ',d'))).rjust(12, " ")
    percentage_of_high_card = get_percentage_of_hand_type(simulation, "high card")
    percentage_of_high_card = f"{percentage_of_high_card: .2f}"
    if float(percentage_of_high_card) < 10:
        percentage_of_high_card = str(percentage_of_high_card).lstrip(" ").rjust(5, "0")
        
    print(num_of_hands, num_of_pairs, percentage_of_pairs, num_of_2pairs, percentage_of_2pairs, num_of_flushes, percentage_of_flushes,  num_of_high_card, percentage_of_high_card)



def play_rounds():

    create_table()
    simulation_trial_amount = 10000
    
    while simulation_trial_amount <= 100000:
        obtain_simulation_data = simulation(simulation_trial_amount)
        add_row_to_table(simulation_trial_amount, obtain_simulation_data)
        simulation_trial_amount += 10000
    

if __name__ == '__main__':
    play_rounds()
