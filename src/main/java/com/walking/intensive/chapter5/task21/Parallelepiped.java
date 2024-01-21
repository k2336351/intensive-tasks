package com.walking.intensive.chapter5.task21;

public class Parallelepiped {
    private double xAxisCoordinate1;
    private double yAxisCoordinate1;
    private double zAxisCoordinate1;
    private double xAxisCoordinate2;
    private double yAxisCoordinate2;
    private double zAxisCoordinate2;

    public Parallelepiped(double xAxisCoordinate1, double yAxisCoordinate1, double zAxisCoordinate1,
                          double xAxisCoordinate2, double yAxisCoordinate2, double zAxisCoordinate2) {
        this.xAxisCoordinate1 = xAxisCoordinate1;
        this.yAxisCoordinate1 = yAxisCoordinate1;
        this.zAxisCoordinate1 = zAxisCoordinate1;
        this.xAxisCoordinate2 = xAxisCoordinate2;
        this.yAxisCoordinate2 = yAxisCoordinate2;
        this.zAxisCoordinate2 = zAxisCoordinate2;
    }

    public double x1() {
        return xAxisCoordinate1;
    }

    public double y1() {
        return yAxisCoordinate1;
    }

    public double z1() {
        return zAxisCoordinate1;
    }

    public double x2() {
        return xAxisCoordinate2;
    }

    public double y2() {
        return yAxisCoordinate2;
    }

    public double z2() {
        return zAxisCoordinate2;
    }

    public void setX1(double xAxisCoordinate1) {
        this.xAxisCoordinate1 = xAxisCoordinate1;
    }

    public void setY1(double yAxisCoordinate1) {
        this.yAxisCoordinate1 = yAxisCoordinate1;
    }

    public void setZ1(double zAxisCoordinate1) {
        this.zAxisCoordinate1 = zAxisCoordinate1;
    }

    public void setX2(double xAxisCoordinate2) {
        this.xAxisCoordinate2 = xAxisCoordinate2;
    }

    public void setY2(double yAxisCoordinate2) {
        this.yAxisCoordinate2 = yAxisCoordinate2;
    }

    public void setZ2(double zAxisCoordinate2) {
        this.zAxisCoordinate2 = zAxisCoordinate2;
    }
}
