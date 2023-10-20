package edu.hw2;

@SuppressWarnings("redundantmodifier")
record Exponent(Expr expr1, Expr pow) implements Expr {
    public Exponent(Expr expr, double dbl) {
        this(expr, new Constant(dbl));
    }

    public Exponent(double dbl, Expr expr) {
        this(new Constant(dbl), expr);
    }

    public Exponent(double dbl1, double dbl2) {
        this(new Constant(dbl1), new Constant(dbl2));
    }

    @Override
    public double evaluate() {
        return Math.pow(expr1.evaluate(), pow.evaluate());
    }

    @Override
    public String toString() {
        LOGGER.info("Выводим экспоненту: " + expr1.evaluate() + '^' + pow.evaluate());
        return '(' + expr1.toString() + '^' + pow.toString() + ')';
    }
}
