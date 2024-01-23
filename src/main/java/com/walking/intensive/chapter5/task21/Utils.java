package com.walking.intensive.chapter5.task21;

public class Utils {
    protected static boolean isPointInsideSphere(Sphere sphere, double x1, double y1, double z1) {

        return Math.pow(x1 - sphere.x(), 2) + Math.pow(y1 - sphere.y(), 2) + Math.pow(z1 - sphere.z(), 2) <=
                Math.pow(sphere.radius(), 2);
    }

    protected static boolean isSphereCenterInsideParallelepiped(Parallelepiped parallelepiped, Sphere sphere) {

        return sphere.x() >= Math.min(parallelepiped.x1(), parallelepiped.x2()) &&
                sphere.x() <= Math.max(parallelepiped.x1(), parallelepiped.x2()) &&
                sphere.y() >= Math.min(parallelepiped.y1(), parallelepiped.y2()) &&
                sphere.y() <= Math.max(parallelepiped.y1(), parallelepiped.y2()) &&
                sphere.z() >= Math.min(parallelepiped.z1(), parallelepiped.z2()) &&
                sphere.z() <= Math.max(parallelepiped.z1(), parallelepiped.z2());
    }
}
