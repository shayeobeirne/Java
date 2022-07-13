import java.util.ArrayList;
import java.util.Arrays;
/**
 * Filename: SkateRamp.java
 * Description: Estimating the area underneath a curve using Riemann Integration
 * Author: Shaye O'Beirne
 * Date:
 */

public class SkateRamp {
    public static double error = .01;
    public static double upperBound;
    public static double lowerBound;
    public static ArrayList<Double> function = new ArrayList<Double>();
    public static String functionType;
    public static double area;
    public static double newArea;
    private Function curve;

    interface Function {
        double getY(double x);
    }

    class Polynomial implements Function {
        public double getY(double x) {
            double total = 0;
            int power = 0;
            for (int i = 0; i < function.size(); i++) {
                double number = (function.get(i) * Math.pow(x, power));
                total += number;
                power += 1;
            }
            return total;
        }
    }

    class Sine implements Function {
        public double getY(double x) {
            double total = Math.sin(x);
            return total;
        }
    }

    public SkateRamp(String... args) throws NumberFormatException, IllegalArgumentException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Must provide at least 3 args");
        } else if (!args[0].equals("poly") && !args[0].equals("sine") && !args[0].equals("sin")) {
            throw new IllegalArgumentException("Unrecognized function");
        } 
        if ((args[args.length - 1]).endsWith("%")) {
            error = Double.valueOf(args[args.length - 1].replace("%", "")) / 100;
            functionType = args[0];
            lowerBound = Double.valueOf(args[args.length - 3]);
            upperBound = Double.valueOf(args[args.length - 2]);
            for (int i = 1; i < args.length - 3; i++) {
                function.add(Double.valueOf(args[i]));
            }
            if (Double.valueOf(args[args.length - 3]) > Double.valueOf(args[args.length - 2])) {
                throw new IllegalArgumentException("Upper bound must be > lower bound");
            } else if (args[0].equals("poly") && args.length < 5) {
                throw new IllegalArgumentException("Need at least 1 coeff for poly");
            } else if (args[args.length - 1].startsWith("-")) {
                throw new IllegalArgumentException("% must be positive");
            }
        } else {
            functionType = args[0];
            lowerBound = Double.valueOf(args[args.length - 2]);
            upperBound = Double.valueOf(args[args.length - 1]);
            for (int i = 1; i < args.length - 2; i++) {
                function.add(Double.valueOf(args[i]));
            }
            if (Double.valueOf(args[args.length - 2]) > Double.valueOf(args[args.length - 1])) {
                throw new IllegalArgumentException("Upper bound must be > lower bound");
            } else if (args[0].equals("poly") && args.length < 4) {
                throw new IllegalArgumentException("Need at least 1 coeff for poly");
            }

        }

    }

    public double estimateAreaUnderRamp() {
        double initialMidpoint = (upperBound - lowerBound) / 2;
        double area = 0;
        double newArea = 0;
        int numOfRectangles = 2;
        if (functionType.equals("poly")) {
            curve = new Polynomial();
            area = curve.getY(initialMidpoint);
            newArea = curve.getY(initialMidpoint / 2) + curve.getY(3 * (initialMidpoint / 2));
            while (Math.abs(newArea - area) / (area) > error) {
                area = newArea;
                double underCurve = 0;
                double rectWidth = (upperBound - lowerBound) / numOfRectangles;
                for (double i = lowerBound; i < numOfRectangles + 1; i += rectWidth) {
                    double midpoint = ((2 * i) + rectWidth) / 2;
                    if (midpoint > upperBound) {
                        break;
                    }
                    underCurve += (curve.getY(midpoint) * rectWidth);
                    System.out.println(midpoint + " " + (curve.getY(midpoint) * rectWidth));
                }
                System.out.println(" ");
                newArea = underCurve;
                numOfRectangles += 1;
            } 
        } else if (functionType.equals("sine") || functionType.equals("sin")) {
            curve = new Sine();
            area = curve.getY(initialMidpoint);
            newArea = curve.getY(initialMidpoint / 2) + curve.getY(3 * (initialMidpoint / 2));
            while (Math.abs(newArea - area) / (area) > error) {
                area = newArea;
                double underCurve = 0;
                double rectWidth = (upperBound - lowerBound) / numOfRectangles;
                for (double i = lowerBound; i < numOfRectangles + 1; i += rectWidth) {
                    double midpoint = ((2 * i) + rectWidth) / 2;
                    underCurve += (curve.getY(midpoint) * rectWidth);
                    if (curve.getY(midpoint) < 0) {
                        break;
                    }
                }
                newArea = underCurve;
                numOfRectangles += 1;
            }
        }
        return newArea;
    }

    public static void main(String[] args) {
        try {
            var newRamp = new SkateRamp(args);
            System.out.println(newRamp.estimateAreaUnderRamp());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}