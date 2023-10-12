package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public sealed interface Expr {
    Logger LOGGER = LogManager.getLogger();
    double evaluate();

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
}
