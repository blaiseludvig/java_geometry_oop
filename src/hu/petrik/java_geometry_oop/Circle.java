package hu.petrik.java_geometry_oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Circle {
    Point center = new Point();
    double radius;

    // radius only, origin center constructor
    public Circle(double r) {
        this.center = Point.origin;
        this.radius = r;
    }

    public Circle(double x, double y, double r) {
        this.center.setX(x);
        this.center.setY(y);
        this.radius = r;
    }

    // random constructor
    public Circle() {
        final double CENTER_RANGE = 10;
        final double RADIUS_RANGE = 5;

        // Ez a nyelv egy kalap szar
        double random = ThreadLocalRandom.current().nextDouble(-CENTER_RANGE, CENTER_RANGE);
        double rounded = new BigDecimal(random).setScale(1, RoundingMode.HALF_UP).doubleValue();
        this.center.setX(rounded);

        random = ThreadLocalRandom.current().nextDouble(-CENTER_RANGE, CENTER_RANGE);
        rounded = new BigDecimal(random).setScale(1, RoundingMode.HALF_UP).doubleValue();
        this.center.setY(rounded);

        random = ThreadLocalRandom.current().nextDouble(0, RADIUS_RANGE);
        rounded = new BigDecimal(random).setScale(1, RoundingMode.HALF_UP).doubleValue();
        this.radius = random;
    }

    // change radius by n
    public void changeRadius(double n) {
        this.radius += n;
    }

    public double circumference() {
        return 2 * radius * Math.PI;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("(%.2f,%.2f,%.2f)", this.center.getX(), this.center.getY(), this.radius);
    }
}
