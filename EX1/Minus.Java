public class Minus extends BinaryExpression
{
    public Minus(Number left, Number right) {
       super(left, right);
    }
    
    @Override
    public double calculate(){
        return this.getLeft().getValue() - this.getRight().getValue();
    }
}