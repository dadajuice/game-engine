package engine;

public abstract class ControllableEntity extends MovableEntity {

    private MovementController controller;

    public ControllableEntity(MovementController controller) {
        this.controller = controller;
    }

    public void moveWithController() {
        if (controller.isDownPressed()) {
            moveDown();
        } else if (controller.isUpPressed()) {
            moveUp();
        } else if (controller.isLeftPressed()) {
            moveLeft();
        } else if (controller.isRightPressed()) {
            moveRight();
        }
    }
}
