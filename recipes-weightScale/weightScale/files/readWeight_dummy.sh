#!/bin/bash

# This file contains some methods for getting dummy weight values for testing the display. 

# Only one "echo" should be uncommented at a time.

###################################
# random numbers between 1 and 10 #
###################################

echo $((($(hexdump -n 4 -e '1/4 "%u"' /dev/random) % 10) + 1))






######################################################################
# edge case test: max weight that can fit on screen without wrapping #
# with FONT_10x18 is (100 million lbs - 1)                           #
######################################################################

# echo 99999999
