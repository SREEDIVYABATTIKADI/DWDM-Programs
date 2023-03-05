import java.util.Arrays;
import java.util.*;

public class Prgrm1{
    
    // Smooths the data by bin means
    public static double[] binMeans(double[] data, int numBins) {
        double[] smoothedData = new double[data.length];
        int binSize = data.length / numBins;
        for (int i = 0; i < numBins; i++) {
            int start = i * binSize;
            int end = (i + 1) * binSize;
            double binSum = 0.0;
            for (int j = start; j < end; j++) {
                binSum += data[j];
            }
            double binMean = binSum / (end - start);
            for (int j = start; j < end; j++) {
                smoothedData[j] = binMean;
            }
        }
        return smoothedData;
    }
    
    // Smooths the data by bin boundaries
    public static double[] binBoundaries(double[] Data, int numBins) {
        double[] smoothedData = new double[Data.length];
        int binSize =Data.length / numBins;
        for (int i = 0; i < numBins; i++) {
            double binMin = Data[i * binSize];
            double binMax = Data[(i + 1) * binSize - 1];
            int start = i * binSize;
            int end = (i + 1) * binSize;
            for (int j = start; j <end; j++) {
                if (Data[j]-binMin<=binMax-Data[j]) {
                    smoothedData[j] = binMin;
                }
                else
                {
                    smoothedData[j]=binMax;
                }
            }
        }
        return smoothedData;
    }
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter size of the data");
        int n=s.nextInt();
        double[] data=new double[n];
        System.out.println("enter data");
        for(int i=0;i<n;i++)
        data[i]=s.nextDouble();
        System.out.println("enter no. of bins");
        int numBins=s.nextInt();
        double [] sortedData=new double[data.length];
        sortedData = Arrays.copyOf(data, data.length);
        Arrays.sort(sortedData);
        
        // Smooth the data by bin means
        double[] smoothedData = binMeans(sortedData, numBins);
        System.out.println("Smoothed data by bin means:");
        for (double value : smoothedData) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Smooth the data by bin boundaries
        smoothedData = binBoundaries(sortedData, numBins);
        System.out.println("Smoothed data by bin boundaries:");
        for (double value : smoothedData) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}