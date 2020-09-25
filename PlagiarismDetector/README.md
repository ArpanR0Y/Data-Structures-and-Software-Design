# Plagiarism Detection - Efficiency

### Background

Plagiarism detection is a very difficult problem to solve, but a simple approach is to just look for 
common words and phrases between documents. If two (or more) documents contain many of the same phrases, 
then there is a good possibility that one author copied from the other.

The program you will improve detects common phrases of size windowSize in a corpus of documents, and 
then report pairs of documents for which the number of common phrases is greater than some threshold, 
sorted by the number of common phrases.

### Implementation

The detectPlagiarism method takes the name of the directory containing the corpus of documents, as 
well as the windowSize and threshold parameters, and returns a Map that lists the pairs of documents, 
with the Map keys sorted by the number of matches. If two or more pairs have the same number of matches, 
the order in which they are stored is not specified.

Aside from the detectPlagiarism method, the PlagiarismDetector also has helper methods to:

* Read a file and store its contents in a List of Strings
* Create the distinct phrases, each of which is of size windowSize
* Find the common phrases between two documents
* Sort the results

### Objective

The objective of this project is to implement the program and test the efficiency of it against a
baseline implementation so that my program is at least 60% faster than it using the techniques 
discussed in the lessons to improve the efficiency of code, such as:

* Using the best Data Structure for the given task.
* Implementing a better algorithm.
* Simplifying the common parts of the program to make it faster.
* Micro-optimization techniques to shave a couple more seconds i.e avoiding unnecessary checks and 
method calls, lazy evaluation, avoiding unnecessary object creation, avoiding re-inventing the wheel 
and using Java API whenever possible etc.

### Result

My final implementation was ~99% faster than the baseline. 