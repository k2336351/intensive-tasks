package com.walking.intensive.chapter5.task21;

import java.util.ArrayList;
import java.util.List;

import static com.walking.intensive.chapter5.task21.Utils.isPointInsideSphere;
import static com.walking.intensive.chapter5.task21.Utils.isSphereCenterInsideParallelepiped;

public class Main {
    public static void main(String[] args) {
        Sphere sphere1 = new Sphere(0, 0, 0, 2);

        List<Parallelepiped> parallelepipeds = new ArrayList<>();
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

        Parallelepiped parallelepiped = new Parallelepiped(0, 0, 0,
                10, 10, 10);

        List<Sphere> spheres = new ArrayList<>();
        spheres.add(new Sphere(5, 12, 5, 2));
        spheres.add(new Sphere(-1, -1, -1, 1.8));
        spheres.add(new Sphere(5, 11, 11, 4));
        spheres.add(new Sphere(5, 5, 5, 3));
        spheres.add(new Sphere(11, 11, 11, 100));
        spheres.add(new Sphere(-5.5, -6.4, -4.2, 3.7));

        for (Sphere sphere : spheres) {
            System.out.println(isIntersectingSphereAndParallelepiped(sphere, parallelepiped));
        }
    }

    public static boolean isIntersectingSphereAndParallelepiped(Sphere sphere, Parallelepiped parallelepiped) {
        // Проверка на пересечение шаром одной из граней параллелепипеда,
        // а также проверка случая, когда шар находится внутри параллелепипеда
        Parallelepiped xQuadrantsParallelepiped = new Parallelepiped(
                parallelepiped.x1() - sphere.radius(), parallelepiped.y1(), parallelepiped.z1(),
                parallelepiped.x2() + sphere.radius(), parallelepiped.y2(), parallelepiped.z2());
        if (parallelepiped.x1() > parallelepiped.x2()) {
            xQuadrantsParallelepiped.setX1(parallelepiped.x1() + sphere.radius());
            xQuadrantsParallelepiped.setX2(parallelepiped.x2() - sphere.radius());
        }
        if (isSphereCenterInsideParallelepiped(xQuadrantsParallelepiped, sphere)) {
            return true;
        }

        Parallelepiped yQuadrantsParallelepiped = new Parallelepiped(
                parallelepiped.x1(), parallelepiped.y1() - sphere.radius(), parallelepiped.z1(),
                parallelepiped.x2(), parallelepiped.y2() + sphere.radius(), parallelepiped.z2());
        if (parallelepiped.y1() > parallelepiped.y2()) {
            yQuadrantsParallelepiped.setY1(parallelepiped.y1() + sphere.radius());
            yQuadrantsParallelepiped.setY2(parallelepiped.y2() - sphere.radius());
        }
        if (isSphereCenterInsideParallelepiped(yQuadrantsParallelepiped, sphere)) {
            return true;
        }

        Parallelepiped zQuadrantsParallelepiped = new Parallelepiped(
                parallelepiped.x1(), parallelepiped.y1(), parallelepiped.z1() - sphere.radius(),
                parallelepiped.x2(), parallelepiped.y2(), parallelepiped.z2() + sphere.radius());
        if (parallelepiped.z1() > parallelepiped.z2()) {
            zQuadrantsParallelepiped.setZ1(parallelepiped.z1() + sphere.radius());
            zQuadrantsParallelepiped.setZ2(parallelepiped.z2() - sphere.radius());
        }
        if (isSphereCenterInsideParallelepiped(zQuadrantsParallelepiped, sphere)) {
            return true;
        }

        // Поиск координат ближайшей к центру шара вершины параллелепипеда
        double xSphereCenterClosestVertexCoordinate = parallelepiped.x1();
        if (Math.abs(parallelepiped.x1() - sphere.x()) > Math.abs(parallelepiped.x2() - sphere.x())) {
            xSphereCenterClosestVertexCoordinate = parallelepiped.x2();
        }

        double ySphereCenterClosestVertexCoordinate = parallelepiped.y1();
        if (Math.abs(parallelepiped.y1() - sphere.y()) > Math.abs(parallelepiped.y2() - sphere.y())) {
            ySphereCenterClosestVertexCoordinate = parallelepiped.y2();
        }

        double zSphereCenterClosestVertexCoordinate = parallelepiped.z1();
        if (Math.abs(parallelepiped.z1() - sphere.z()) > Math.abs(parallelepiped.z2() - sphere.z())) {
            zSphereCenterClosestVertexCoordinate = parallelepiped.z2();
        }

        // Проверка на пересечение шаром вершин параллелепипеда
        if (isPointInsideSphere(sphere,
                xSphereCenterClosestVertexCoordinate,
                ySphereCenterClosestVertexCoordinate,
                zSphereCenterClosestVertexCoordinate)) {
            return true;
        }

        // Проверка на пересечение шаром рёбер параллелепипеда
        if (sphere.x() >= Math.min(parallelepiped.x1(), parallelepiped.x2()) &&
                sphere.x() <= Math.max(parallelepiped.x1(), parallelepiped.x2())) {
            return isPointInsideSphere(sphere,
                    sphere.x(),
                    ySphereCenterClosestVertexCoordinate,
                    zSphereCenterClosestVertexCoordinate);
        }

        if (sphere.y() >= Math.min(parallelepiped.y1(), parallelepiped.y2()) &&
                sphere.y() <= Math.max(parallelepiped.y1(), parallelepiped.y2())) {
            return isPointInsideSphere(sphere,
                    xSphereCenterClosestVertexCoordinate,
                    sphere.y(),
                    zSphereCenterClosestVertexCoordinate);
        }

        if (sphere.z() >= Math.min(parallelepiped.z1(), parallelepiped.z2()) &&
                sphere.z() <= Math.max(parallelepiped.z1(), parallelepiped.z2())) {
            return isPointInsideSphere(sphere,
                    xSphereCenterClosestVertexCoordinate,
                    ySphereCenterClosestVertexCoordinate,
                    sphere.z());
        }

        return false;
    }
}