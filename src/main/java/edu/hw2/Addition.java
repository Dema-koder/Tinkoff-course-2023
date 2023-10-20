package edu.hw2;

@SuppressWarnings("redundantmodifier")
record Addition(Expr expr1, Expr expr2) implements Expr {
    public Addition(double a, double b) {
        this(new Constant(a), new Constant(b));
    }

    public Addition(Expr a, double b) {
        this(a, new Constant(b));
    }

    public Addition(double a, Expr b) {
        this(new Constant(a), b);
    }

    @Override
    public double evaluate() {
        return expr1.evaluate() + expr2.evaluate();
    }

    @Override
    public String toString() {
        LOGGER.info("Выводим сумму: " + expr1.evaluate() + '+' + expr2.evaluate());
        return '(' + expr1.toString() + '+' + expr2.toString() + ')';
    }
}
