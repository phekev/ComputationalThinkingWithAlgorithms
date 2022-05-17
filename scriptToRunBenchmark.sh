#!/bin/bash

var=0

var="0"
while [ $var -le 10 ]
	do
	java ctaProject/ComputationalThinkingWithAlgorithms/Controller
	sleep 1800
	(( var++ ))
	   
done
