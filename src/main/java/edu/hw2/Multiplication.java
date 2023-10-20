package edu.hw2;

@SuppressWarnings("redundantmodifier")
record Multiplication(Expr expr1, Expr expr2) implements Expr {
    public Multiplication(double a, double b) {
        this(new Constant(a), new Constant(b));
    }

    public Multiplication(double a, Expr b) {
        this(new Constant(a), b);
    }

    public Multiplication(Expr a, double b) {
        this(a, new Constant(b));
    }

    @Override
    public double evaluate() {
        return expr1.evaluate() * expr2.evaluate();
    }

    @Override
    public String toString() {
        LOGGER.info("Выводим произведение");
        return '(' + expr1.toString() + '*' + expr2.toString() + ')';
    }
}
