package renderer.entity;

import renderer.entity.builder.BasicEntityBuilder;
import renderer.entity.builder.ComplexEntityBuilder;
import renderer.input.ClickType;
import renderer.input.Mouse;
import renderer.point.PointConverter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private int initialX, initialY;
    List<IEntity> entities;

    public EntityManager() {
        this.entities = new ArrayList<IEntity>();

    }

    public void init() {
        this.entities.add(BasicEntityBuilder.createDiamond(0,0,0));
//        this.entities.add(BasicEntityBuilder.createCube(0, 0, 0));
//            this.entities.add(ComplexEntityBuilder.createRubikCube(0,0,0));
    }

    public void update(Mouse mouse) {
        int x = mouse.getX();
        int y = mouse.getY();

        if (mouse.getButton() == ClickType.LeftClick) {
            int xDif = x - initialX;
            int yDif = y - initialY;
            this.rotate(true, 0, -yDif, -xDif);
        }

        if (mouse.isScrollDown()) {
            PointConverter.zoomOut();
        } else if (mouse.isScrollUp()) {
            PointConverter.zoomIn();
        }
        mouse.resetScroll();

        initialY = y;
        initialX = x;
    }

    public void render(Graphics g) {
        for (IEntity entity : this.entities) {
            entity.render(g);
        }
    }

    private void rotate(boolean direction, double xAngle, double yAngle, double zAngle) {
        for (IEntity entity : this.entities) {
            entity.rotate(direction, xAngle, yAngle, zAngle);
        }
    }
}
