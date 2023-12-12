#!/bin/bash

# Main loop
m=0.000229   # Constant value
b=-1987.8    # Changed back to -1987.8

# Read values
value0=$(cat /sys/bus/iio/devices/iio:device0/in_voltage0_raw)
value1=$(cat /sys/bus/iio/devices/iio:device0/in_voltage1_raw)

# Store values in the array
valAvg=$(( ($value0 + $value1) / 2))

# Calculate the final result by multiplying the average by m, rounding, and then adding b
result=$(echo "scale=10; $valAvg * $m + $b" | bc)
result_rounded=$(printf "%.0f" "$result")  # Round to the nearest integer

echo $result_rounded
