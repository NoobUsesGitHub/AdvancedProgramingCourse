public class BinaryExpression implements Expression
{
    private Number left;
    private Number right;

    public BinaryExpression(Number left, Number right) {
        this.left = left;
        this.right = right;
    }

    public Number getLeft() {
        return left;
    }

    public void setLeft(Number left) {
        this.left = left;
    }

    public Number getRight() {
        return right;
    }

    public void setRight(Number right) {
        this.right = right;
    }
    
    @Override
    public double calulate(){}
}