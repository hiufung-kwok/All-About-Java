package designPattern.visitor;

public class FloorVisitor implements Visitor{
    @Override
    public void visit(House house) {
        System.out.println("Visiting house with floor: " + house.getFloor());
    }
}
