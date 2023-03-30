"""
A really simple domino game.
"""

import domino as doms
import boneyard as yard
# domino must have these functions:

the_yard = yard.create()
game_over = False

while not game_over:
    if yard.tiles_remaining(the_yard) == 0:
        print('Ran out of dominoes')
        game_over = True
    else:
        input('Press return to continue')
        tile = yard.draw(the_yard)
        print('Got tile %s' % (doms.as_str(tile)))
        if doms.get_left(tile) == 6 or doms.get_right(tile) == 6:
            print('Got a SIX!!!')
            game_over = True

print("Game Over.")    
