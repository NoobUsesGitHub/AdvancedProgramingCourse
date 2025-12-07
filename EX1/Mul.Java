public class Mul extends BinaryExpression
{
    public Mul(Number left, Number right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double calulate(){
        return left.getValue() * right.getValue();
    }
}