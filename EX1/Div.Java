public class Div extends BinaryExpression
{
    public Div(Number left, Number right) {
        super(left, right);
    }
    
    @Override
    public double calculate(){
        return this.getLeft().getValue() / this.getRight().getValue();
    }
}