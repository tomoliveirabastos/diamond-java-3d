package renderer.entity.builder;

import renderer.entity.Entity;
import renderer.entity.IEntity;
import renderer.point.MyPoint;
import renderer.shapes.MyPolygon;
import renderer.shapes.Tetrahedron;

import java.awt.*;
import java.util.ArrayList;

public class ComplexEntityBuilder {

    private static int s = 10;

    public static IEntity createRubikCube(double centerX, double centerY, double centerZ) {
        var tetras = new ArrayList<Tetrahedron>();

        double cubeSpacing = 1;
        for (int i = 0; i < 2; i++) {
            double cubeCenterX = i * (s + cubeSpacing) + centerX;

            for (int j = 0; j < 2; j++) {
                double cubeCenterY = j * (s + cubeSpacing) + centerY;

                for (int k = 0; k < 2; k++) {
                    if (i == 0 && j == 0 && k == 0) continue;

                    double cubeCenterZ = k * (s + cubeSpacing) + centerZ;

                    MyPoint p1 = new MyPoint(cubeCenterX + s / 2, cubeCenterY + -s / 2, cubeCenterZ + -s / 2);
                    MyPoint p2 = new MyPoint(cubeCenterX + s / 2, cubeCenterY + s / 2, cubeCenterZ + -s / 2);
                    MyPoint p3 = new MyPoint(cubeCenterX + s / 2, cubeCenterY + s / 2, cubeCenterZ + s / 2);
                    MyPoint p4 = new MyPoint(cubeCenterX + s / 2, cubeCenterY + -s / 2, cubeCenterZ + s / 2);
                    MyPoint p5 = new MyPoint(cubeCenterX + -s / 2, cubeCenterY + -s / 2, cubeCenterZ + -s / 2);
                    MyPoint p6 = new MyPoint(cubeCenterX + -s / 2, cubeCenterY + s / 2, cubeCenterZ + -s / 2);
                    MyPoint p7 = new MyPoint(cubeCenterX + -s / 2, cubeCenterY + s / 2, cubeCenterZ + s / 2);
                    MyPoint p8 = new MyPoint(cubeCenterX + -s / 2, cubeCenterY + -s / 2, cubeCenterZ + s / 2);

                    MyPolygon polyRed = new MyPolygon(p5, p6, p8, p7).changeColor(Color.RED);
                    MyPolygon polyWhite = new MyPolygon(p2, p4, p8, p6).changeColor(Color.WHITE);
                    MyPolygon polyBlue = new MyPolygon(p3, p4, p8, p7).changeColor(Color.BLUE);
                    MyPolygon polyYellow = new MyPolygon(p1, p2, p4, p3).changeColor(Color.YELLOW);
                    MyPolygon polyOrange = new MyPolygon(p1, p3, p7, p5).changeColor(Color.ORANGE);

                    Tetrahedron tetrahedron = new Tetrahedron(false, polyOrange,polyBlue,polyRed, polyYellow,polyWhite);
                    tetras.add(tetrahedron);
                }
            }
        }

        return new Entity(tetras);
    }


}
