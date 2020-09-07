# CMPT 231 Assignment 1.

## Part 1. Java and Java FX setup

You are free to use the development environment of your choice.  The following are setup instructions for those who do not have one setup already.

### Java Installation

Java Development Kit (JDK) can be downloaded at:
- https://www.oracle.com/java/technologies/javase-downloads.html
- https://adoptopenjdk.net/

*Please download 8 or above.*

### Integrated Development Environment (IDE) 

There are a number of choices:

*The following is not an exhaustive list*

1. Eclipse
https://www.eclipse.org/

2. Netbeans
https://netbeans.org/

3. IntelliJ
https://www.jetbrains.com/idea/

### JavaFX
Please note, Java 8 seems to have JavaFX included.  So, may not need to do the following.

1. please download from: https://gluonhq.com/products/javafx/
    - please download sdk
    - unzip the folder and put the content to somewhere you won't likely to accidentally delete

2. setup enviroment/path.  please see https://openjfx.io/openjfx-docs/#install-javafx

3. setup IDE:

If you are using Eclipse, follow the instructions in the following link to add JavaFX library to your project:

https://www.javatpoint.com/javafx-with-eclipse
- with the following deviation: instead of looking for JavaFX jar files under your jdk or jre folder, these are available under the Gluon download.  They are also named differently.  These jar files are:
- javafx.base.jar
- javafx.controls.jar
- ... etc ... need to add all jars in the lib folder


### to run JavaFX application 
Eclipse
- add the JavaFX modules to the VM arguments:
"--module-path [path to JavaFX lib folder] --add-modules javafx.controls"

tutorial
http://tutorials.jenkov.com/javafx/your-first-javafx-application.html


## Part 2. Analysis of Algorithm Experiment

In class, we went over the runtime complexity of BubbleSort and QuickSort by analyzing the pseudocodes.  In this assignment, we are going to observe for ourselves the run time difference between BubbleSort and QuickSort in actual implementations of these algorithm. 
 
Please modify AlgorithmProfiler.java.  This class contains a field “count” of type int.  This class also contains two methods for sorting: BubbleSort and QuickSort.  The objective of this assignment is to insert statements into appropriate parts of the sorting algorithm codes so that the "count" field will be reflective of the NUMBER OF COMPARISONS a sorting algorithm has done.

After you have done so, run PlotViewer.java.  This file will execute the BubbleSort and QuickSort method of an AlgorithmProfiler object on several collections (i.e. arrays) of random integers.  The size of these collections will be recorded as well as the number of comparisons performed by BubbleSort and QuickSort.  These data will be plotted on a line chart (see figure 1).  The idea is to observe, empirically, the difference in run time (in this case, the number of comparisons) between an O(n2) algorithm and an O(nlog(n)) algorithm.


