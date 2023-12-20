#!/bin/bash

weightScript=/usr/bin/readWeight.sh
prevWeight=$($weightScript)
counter=0

sounds=("sound1.wav" "sound2.wav" "sound3.wav" "sound4.wav" "sound5.wav" "sound6.wav" "sound7.wav")
num_sounds=${#sounds[@]}

amixer -D default sset PCM 40%

while [ 1 ]
do
    weight=$($weightScript)
    weightDiff=$((weight - prevWeight))

    if [ $weightDiff -ge 2 ] || [ $weightDiff -le -2 ]; then
        index=$((counter % num_sounds))
        sound_to_play="${sounds[index]}"
        aplay /etc/xmas-sounds/"$sound_to_play"
        counter=$((counter + 1))
        prevWeight=$weight
    fi

    usleep 30000
done
