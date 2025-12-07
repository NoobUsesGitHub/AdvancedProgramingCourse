public class Minus extends BinaryExpression
{
    public Minus(Number left, Number right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double calulate(){
        return left.getValue() - right.getValue();
    }
}