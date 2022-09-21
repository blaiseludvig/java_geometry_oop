package hu.petrik.javaoop;

import java.util.ArrayList;

public class TestCircle {
    static ArrayList<Circle> circles = new ArrayList<Circle>();

    public static void run() {
        generateTestData();
        printCircles();
        printLargestCircle();
    }

    static void generateTestData() {
        circles.add(new Circle(1));
        circles.add(new Circle(3));
        circles.add(new Circle(2.5, 2.5, 2));
        circles.add(new Circle(-5.5, -7.5, 3));
        circles.add(new Circle(0, 0, 1));

        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());

    }

    static void printCircles() {
        for (int i = 0; i < circles.size(); i++) {
            System.out.printf("circles %d: %s%n", i + 1, circles.get(i));
        }
    }

    static Circle largestArea(ArrayList<Circle> circles) {
        Circle greatest = circles.get(0);

        for (Circle circle : circles) {
            if (circle.area() > greatest.area()) {
                greatest = circle;
            }
        }

        return greatest;
    }

    static void printLargestCircle() {
        System.out.printf("largest circle: %s%n", largestArea(circles));
    }

}
