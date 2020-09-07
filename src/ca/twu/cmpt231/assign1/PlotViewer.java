package ca.twu.cmpt231.assign1;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * CMPT 231 - Assignment 1.
 * 
 * This class contains the main entry point (start() method) of this JavaFX
 * applications. It performs runtime complexity experiment with two different
 * sorting algorithm and plot the results in a scatter plot.
 * 
 * @author Samuel Leung
 */
public class PlotViewer extends Application {

	public static final int NUM_TEST = 10;

	private int[] n; // capture the input size
	private int[][] rt; // capture the algorithm run time
						// [test set][algorithm #]

	/**
	 * setup sorting algorithm experiment
	 */
	public void setupTest() {
		/**
		 * Instantiate an instance of AlgorithmProfiler to get the runtime complexity of
		 * various sorting algorithm
		 */
		AlgorithmProfiler ap = new AlgorithmProfiler();

		// random number generator
		Random rn = new Random();

		/**
		 * For our test data sets, we are going to have collections of random integers. n
		 * is an array that captures the length of these collections. We are going to
		 * start with a collection of 10 elements and increase by increment of 10 all
		 * the way up to NUM_TEST * 10
		 */
		n = new int[NUM_TEST];
		rt = new int[NUM_TEST][2];
		for (int i = 0; i < NUM_TEST; i++) {
			n[i] = 10 + 10 * i;
			int[] data = new int[n[i]];
			for (int j = 0; j < n[i]; j++) {
				data[j] = rn.nextInt();
			}
			
			// do quick sort
			ap.quickSort(data.clone());
			rt[i][0] = ap.getCount();
			ap.resetCount();
			
			// do bubble sort
			ap.bubbleSort(data.clone());
			rt[i][1] = ap.getCount();
			ap.resetCount();
		}
	}

	/**
	 * Creates and displays a chart in a JavaFX window. reference:
	 * https://docs.oracle.com/javafx/2/charts/line-chart.htm
	 */
	public void start(Stage stage) {
		stage.setTitle("Line Chart Sample");
		// defining the axes
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Size of Collection");
		yAxis.setLabel("Number of Comparisons");
		// creating the chart
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		lineChart.setTitle("CMPT 231 experiment - [PLEASE ENTER YOUR NAME] (student #: [PLEASE ENTER YOUR STUDENT NUMBER])");

		// define a series for showing runtime of bubble sort
		XYChart.Series bSeries = new XYChart.Series();
		bSeries.setName("Bubble Sort");
		
		// define another series for showing runtime of quick sort
		XYChart.Series qSeries = new XYChart.Series();
		qSeries.setName("Quick Sort");

		// do the experiment! try sorting collections of random integer
		// and observe time complexity of various algorithms
		setupTest();

		// populating the series with data
		for (int i = 0; i < NUM_TEST; i++) {
			bSeries.getData().add(new XYChart.Data(n[i], rt[i][0]));
			qSeries.getData().add(new XYChart.Data(n[i], rt[i][1]));
		}

		// do the plot
		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(bSeries);
		lineChart.getData().add(qSeries);

		// show the plot
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Launches the JavaFX application. This method is not required in IDEs that
	 * launch JavaFX applications automatically.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
