#!/bin/bash
# This is some secure program that uses security.

PID="ps -ef | grep mchoice-smsc | grep -v grep | awk '{print \$2}'"
FILE=/tmp/test.txt

eval $PID > $FILE

if [ -s /tmp/test.txt ]

then
    echo "Process is running..Going to kill.."
	while read line; do
	echo "kill process in $line"
	kill $line
	done < $FILE
else
    echo "Prosess is not running"
fi
