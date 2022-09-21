package hu.petrik.javaoop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Point {
    private double x, y;

    public static Point origin = new Point();

    enum Quadrant {
        q1,
        q2,
        q3,
        q4,
        x,
        y,
        origin
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double n) {
        // Ez a nyelv egy kalap szar
        double random = ThreadLocalRandom.current().nextDouble(-n, n);
        double rounded = new BigDecimal(random).setScale(1, RoundingMode.HALF_UP).doubleValue();
        this.x = rounded;

        random = ThreadLocalRandom.current().nextDouble(-n, n);
        rounded = new BigDecimal(random).setScale(1, RoundingMode.HALF_UP).doubleValue();
        this.y = rounded;
    }

    public static double distance(Point p1, Point p2) {
        double result = Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2);
        result = Math.sqrt(result);
        return result;
    }

    public double distanceFromOrigin() {
        return Point.distance(this, origin);
    }

    // A feladatban rosszul vannak számozva a síknegyedek...
    // És nincs meghatározva a viselkedés, amikor a pont egy tengelyen vagy az origo-n van...
    public Quadrant getQuadrant() {
        if (this.x == 0 && this.y == 0) {
            return Quadrant.origin;
        }

        if (this.x == 0){
            return Quadrant.x;
        }

        if (this.y == 0){
            return Quadrant.y;
        }

        if (this.x > 0 && this.y > 0) {
            return Quadrant.q1;
        }

        if (this.x < 0 && this.y > 0) {
            return Quadrant.q2;
        }

        if (this.x < 0 && this.y < 0) {
            return Quadrant.q3;
        }

        if (this.x > 0 && this.y < 0){
            return Quadrant.q4;
        }

        // Soha nem fut le.
        return Quadrant.origin;

    }

    @Override
    public String toString() {
        return String.format("[%.2f;%.2f]", this.x, this.y);
    }
}