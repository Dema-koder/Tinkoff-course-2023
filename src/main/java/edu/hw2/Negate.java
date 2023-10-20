package edu.hw2;

@SuppressWarnings("redundantmodifier")
record Negate(Expr expr) implements Expr {

    public Negate(Expr expr) {
        this.expr = expr;
    }

    public Negate(double b) {
        this(new Constant(b));
    }

    @Override
    public double evaluate() {
        return -expr.evaluate();
    }

    @Override
    public String toString() {
        LOGGER.info("Выводим отрицательное");
        return "(-" + expr.toString() + ')';
    }
}
