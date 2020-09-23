#!/bin/bash
# make sure to modify the file path for your system
if [ ! -f /mnt/d/Study/Pennx_Software\ Development/Data-Structures-and-Software-Design/PlagiarismDetector/src/main/java/PlagiarismDetector.java ]; then
    echo "Could not find PlagiarismDetector.java. Please be to update the 'source' folder."
    exit 1;
fi
# copy source to test directory
echo "Copying code to test/ directory"
cp /mnt/d/Study/Pennx_Software\ Development/Data-Structures-and-Software-Design/PlagiarismDetector/src/main/java/PlagiarismDetector.java .
# delete the old .class file
if [ -e PlagiarismDetector.class ]; then
    rm PlagiarismDetector.class
fi

# compile the code
echo "Attempting to compile your code"
javac PlagiarismDetector.java
# did it compile?
if [ $? -ne 0 ]; then 
    #echo "uh oh didn't compile"
    exit 1; 
fi
echo "Successfully compiled code"

# delete the old output files
if [ -e base.txt ]; then
    rm base.txt
fi
if [ -e new.txt ]; then
    rm new.txt
fi
if [ -e output.txt ]; then
    rm output.txt
fi
if [ -e time.txt ]; then
    rm time.txt
fi


echo "Running original program to get baseline execution time (should take around 95 seconds)"
(time java Baseline ../resources) &> time.txt
more time.txt | grep user > base.txt
java PrintTime base.txt

echo "Running your program (must not take more than 40% of baseline execution time)"
(time java PlagiarismDetectorTest ../resources > output.txt) &> time.txt
more time.txt | grep user > new.txt
java PrintTime new.txt

echo "Comparing outputs and execution times"
java Compare new.txt base.txt output.txt
