package com.walking.intensive.chapter5.task21;

import java.util.ArrayList;
import java.util.List;

import static com.walking.intensive.chapter5.task21.Utils.isPointInsideParallelepiped;
import static com.walking.intensive.chapter5.task21.Utils.isPointInsideSphere;

public class Main {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(0, 0, 0, 2);
        Sphere sphere2 = new Sphere(10, 10, 10, 3);

        List <Parallelepiped> parallelepipeds = new ArrayList<>();
        parallelepipeds.add(new Parallelepiped(1, 1, 1,
                3, 5, 4));
        parallelepipeds.add(new Parallelepiped(0, 0, 0,
                1, 1, 1));
        parallelepipeds.add(new Parallelepiped(0, 2, 1,
                -2.4, 3.5, 1.8));
        parallelepipeds.add(new Parallelepiped(1.408, 0.9, 2,
                3.8, -2, 3));
        parallelepipeds.add(new Parallelepiped(4, 10, 3,
                2, 12, 1));

        for (Parallelepiped parallelepiped : parallelepipeds) {
            System.out.println(isIntersectingSphereAndParallelepiped(sphere1, parallelepiped));
        }

        System.out.println();

        for (Parallelepiped parallelepiped : parallelepipeds) {
            System.out.println(isIntersectingSphereAndParallelepiped(sphere2, parallelepiped));
        }
    }

    public static boolean isIntersectingSphereAndParallelepiped(Sphere sphere, Parallelepiped parallelepiped) {
        if (isPointInsideSphere(sphere,
                (parallelepiped.x1() + parallelepiped.x2()) / 2,
                (parallelepiped.y1() + parallelepiped.y2()) / 2,
                (parallelepiped.z1() + parallelepiped.z2()) / 2)) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x1(), parallelepiped.y1(), parallelepiped.z1())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x1(), parallelepiped.y1(), parallelepiped.z2())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x1(), parallelepiped.y2(), parallelepiped.z2())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x1(), parallelepiped.y2(), parallelepiped.z1())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x2(), parallelepiped.y2(), parallelepiped.z2())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x2(), parallelepiped.y2(), parallelepiped.z1())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x2(), parallelepiped.y1(), parallelepiped.z1())) {
            return true;
        }

        if (isPointInsideSphere(sphere, parallelepiped.x2(), parallelepiped.y1(), parallelepiped.z2())) {
            return true;
        }

        Parallelepiped xQuadrantsParallelepiped = new Parallelepiped(
                parallelepiped.x1() - sphere.radius(), parallelepiped.y1(), parallelepiped.z1(),
                parallelepiped.x2() + sphere.radius(), parallelepiped.y2(), parallelepiped.z2());
        if (parallelepiped.x1() > parallelepiped.x2()) {
            xQuadrantsParallelepiped.setX1(parallelepiped.x1() + sphere.radius());
            xQuadrantsParallelepiped.setX2(parallelepiped.x2() - sphere.radius());
        }

        if (isPointInsideParallelepiped(xQuadrantsParallelepiped, sphere.x(), sphere.y(), sphere.z())) {
            return true;
        }

        Parallelepiped yQuadrantsParallelepiped = new Parallelepiped(
                parallelepiped.x1(), parallelepiped.y1() - sphere.radius(), parallelepiped.z1(),
                parallelepiped.x2(), parallelepiped.y2() + sphere.radius(), parallelepiped.z2());
        if (parallelepiped.y1() > parallelepiped.y2()) {
            xQuadrantsParallelepiped.setY1(parallelepiped.x1() + sphere.radius());
            xQuadrantsParallelepiped.setY2(parallelepiped.x2() - sphere.radius());
        }

        if (isPointInsideParallelepiped(yQuadrantsParallelepiped, sphere.x(), sphere.y(), sphere.z())) {
            return true;
        }

        Parallelepiped zQuadrantsParallelepiped = new Parallelepiped(
                parallelepiped.x1(), parallelepiped.y1(), parallelepiped.z1() - sphere.radius(),
                parallelepiped.x2(), parallelepiped.y2(), parallelepiped.z2() + sphere.radius());
        if (parallelepiped.z1() > parallelepiped.z2()) {
            xQuadrantsParallelepiped.setZ1(parallelepiped.x1() + sphere.radius());
            xQuadrantsParallelepiped.setZ2(parallelepiped.x2() - sphere.radius());
        }

        return isPointInsideParallelepiped(zQuadrantsParallelepiped, sphere.x(), sphere.y(), sphere.z());
    }
}