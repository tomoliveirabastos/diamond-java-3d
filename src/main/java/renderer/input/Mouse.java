package renderer.input;

import java.awt.event.*;

public class Mouse implements MouseListener, MouseWheelListener, MouseMotionListener {
    private int mouseX = -1;
    private int mouseY = -1;
    private int mouseB = -1;
    private int scroll = 0;

    public int getX() {
        return this.mouseX;
    }

    public void resetButton(){
        this.mouseB = -1;
    }
    public ClickType getButton() {
        switch (this.mouseB){
            case 1:
                return ClickType.LeftClick;
            case 2 :
                return ClickType.ScrollClick;
            case 3:
                return ClickType.RightClick;
            default:
                return ClickType.Nothing;
        }
    }

    public boolean isScrollDown(){
        return this.scroll == -1;
    }

    public boolean isScrollUp(){
        return this.scroll == 1;
    }

    public void resetScroll(){
        this.scroll = 0;
    }
    public int getY(){
        return this.mouseY;
    }
    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseB = e.getButton();

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        this.mouseB = -1;
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Invoked when the mouse wheel is rotated.
     *
     * @param e the event to be processed
     * @see MouseWheelEvent
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        this.scroll = e.getWheelRotation();
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {

        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {

        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }
}
