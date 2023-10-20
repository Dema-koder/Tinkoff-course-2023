package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public sealed interface Expr permits Addition, Constant, Exponent, Multiplication, Negate {
    Logger LOGGER = LogManager.getLogger();

    double evaluate();
}
