package com.walking.intensive.chapter5.task21;

public class Sphere {
    final private double xAxisCoordinate;
    final private double yAxisCoordinate;
    final private double zAxisCoordinate;
    final private double radius;

    public Sphere(int xAxisCoordinate, int yAxisCoordinate, int zAxisCoordinate, int radius) {
        this.xAxisCoordinate = xAxisCoordinate;
        this.yAxisCoordinate = yAxisCoordinate;
        this.zAxisCoordinate = zAxisCoordinate;
        this.radius = radius;
    }

    public double x() {
        return xAxisCoordinate;
    }

    public double y() {
        return yAxisCoordinate;
    }

    public double z() {
        return zAxisCoordinate;
    }

    public double radius() {
        return radius;
    }
}
