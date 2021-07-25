package renderer.entity.builder;

import renderer.entity.Entity;
import renderer.entity.IEntity;
import renderer.point.MyPoint;
import renderer.shapes.MyPolygon;
import renderer.shapes.Tetrahedron;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicEntityBuilder {
    private static int s = 100;
    private Color color = Color.green;

    public BasicEntityBuilder() {
        this.color = color;
    }

    private BasicEntityBuilder setColor(Color color) {
        this.color = color;
        return this;
    }

    private BasicEntityBuilder changeSize(int size) {
        s = size;
        return this;
    }

    public static IEntity createCube(double centerX, double centerY, double centerZ) {
        MyPoint p1 = new MyPoint(centerX + s / 2, centerY + -s / 2, centerZ + -s / 2);
        MyPoint p2 = new MyPoint(centerX + s / 2, centerY + s / 2, centerZ + -s / 2);
        MyPoint p3 = new MyPoint(centerX + s / 2, centerY + s / 2, centerZ + s / 2);
        MyPoint p4 = new MyPoint(centerX + s / 2, centerY + -s / 2, centerZ + s / 2);
        MyPoint p5 = new MyPoint(centerX + -s / 2, centerY + -s / 2, centerZ + -s / 2);
        MyPoint p6 = new MyPoint(centerX + -s / 2, centerY + s / 2, centerZ + -s / 2);
        MyPoint p7 = new MyPoint(centerX + -s / 2, centerY + s / 2, centerZ + s / 2);
        MyPoint p8 = new MyPoint(centerX + -s / 2, centerY + -s / 2, centerZ + s / 2);

        Tetrahedron tetra = new Tetrahedron(
                new MyPolygon(p5, p6, p7, p8).changeColor(Color.CYAN),
                new MyPolygon(p1, p2, p6, p5).changeColor(Color.YELLOW),
                new MyPolygon(p1, p5, p8, p4).changeColor(Color.BLUE),
                new MyPolygon(p2, p6, p7, p3).changeColor(Color.RED),
                new MyPolygon(p4, p3, p7, p8).changeColor(Color.ORANGE),
                new MyPolygon(p1, p2, p3, p4).changeColor(Color.WHITE)
        );

        List<Tetrahedron> tetras = new ArrayList<>();
        tetras.add(tetra);

        return new Entity(tetras);
    }

    public static IEntity createDiamond(double centerX, double centerY, double centerZ) {
        List<Tetrahedron> tetras = new ArrayList<>();

        int edges = 10;
        double inFactor = 0.8;

        MyPoint bottom = new MyPoint(centerX, centerY, centerZ - s / 2);
        MyPoint[] outerPoints = new MyPoint[edges];
        MyPoint[] innerPoints = new MyPoint[edges];

        double zPos = s / 2;
        double calc = 2 * Math.PI / edges;

        for (int i = 0; i < edges; i++) {
            double theta = calc * i;
            double xPos = Math.sin(theta) * s /2;
            double yPos = Math.cos(theta) * s /2;

            outerPoints[i] = new MyPoint(centerX + xPos, centerY + yPos, centerZ + zPos);
            innerPoints[i] = new MyPoint(centerX + xPos * inFactor, centerY + yPos * inFactor, centerZ + zPos / inFactor);
        }

        MyPolygon polygons[] = new MyPolygon[2 * edges + 1];

        for (int i = 0; i < edges; i++) {
            polygons[i] = new MyPolygon(outerPoints[i], bottom, outerPoints[(i + 1) % edges]);
        }
        for (int i = 0; i < edges; i++) {
            polygons[i + edges] = new MyPolygon(outerPoints[i], outerPoints[(i + 1) % edges], innerPoints[(i + 1) % edges], innerPoints[i]);
        }

        polygons[edges * 2] = new MyPolygon(innerPoints);

        Tetrahedron tetra = new Tetrahedron(polygons);
        tetras.add(tetra);

        return new Entity(tetras);
    }
}
