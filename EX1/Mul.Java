public class Mul extends BinaryExpression
{
    public Mul(Number left, Number right) {
        super(left, right);
    }
    
    @Override
    public double calculate(){
        return this.getLeft().getValue() * this.getRight().getValue();
    }
}