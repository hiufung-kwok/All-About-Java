package designPattern.visitor;

public class House {

    private int floor;

    private int room;

    private boolean onGrid;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public boolean isOnGrid() {
        return onGrid;
    }

    public void setOnGrid(boolean onGrid) {
        this.onGrid = onGrid;
    }
}
