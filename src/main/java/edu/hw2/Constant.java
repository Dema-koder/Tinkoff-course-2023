package edu.hw2;

record Constant(double val) implements Expr {
    @Override
    public double evaluate() {
        return this.val;
    }

    @Override public String toString() {
        LOGGER.info("Выводим константу: " + val);
        Double value = val;
        return value.toString();
    }
}
