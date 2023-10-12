package edu.hw2;

import edu.hw2.Expr.Addition;
import edu.hw2.Expr.Constant;
import edu.hw2.Expr.Exponent;
import edu.hw2.Expr.Multiplication;
import edu.hw2.Expr.Negate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"magicnumber", "hideutilityclassconstructor", "uncommentedmain"})
public class Task1 {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var multi = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(multi, 2);
        var res = new Addition(exp, new Constant(1));

        LOGGER.info(res + " = " + res.evaluate());
    }
}
