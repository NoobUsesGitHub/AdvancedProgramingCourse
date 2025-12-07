public class Plus extends BinaryExpression
{
    public Plus(Number left, Number right) {
        super(left, right);
    }
    
    @Override
    public double calculate(){
        return this.getLeft().getValue() + this.getRight().getValue();
    }
}