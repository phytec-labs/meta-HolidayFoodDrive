#!/bin/bash

#weightScript=/usr/bin/readWeight_dummy.sh
weightScript=/usr/bin/readWeight.sh
prevWeight=0

while [ 1 ]
do
        weight=$($weightScript)
	if [ "$weight" != "$prevWeight" ]; then
		clear > /dev/tty1
		echo "phyFoodDrive" > /dev/tty1
        	echo "$weight lbs" > /dev/tty1
		prevWeight=$weight
	fi
        usleep 300000
done
