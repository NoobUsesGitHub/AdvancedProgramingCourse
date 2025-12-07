public class Div extends BinaryExpression
{
    public Div(Number left, Number right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double calulate(){
        return left.getValue() / right.getValue();
    }
}