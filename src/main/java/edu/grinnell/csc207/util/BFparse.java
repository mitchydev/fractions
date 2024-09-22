package edu.grinnell.csc207.util;

/**
 * An added util class that parses through user inputted commands
 * separating values from operators and evaluating them. Includes several
 * classes that work together to do this.
 *
 * @author Mitch Paiva
 */
public class BFparse {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** Declares the registers. */
  private final BFRegisterSet registerSet;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  /** Initializes the registers for BFparse with the provided BFRegisterset.
  * @param registers The register set to be used.
  */
  public BFparse(BFRegisterSet registers) {
    this.registerSet = registers;
  } // BFparse (BFRegisterSet registers)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  /**
  * ParseAndEval parses expression itself and then evaluates.
  * @param expr The expr to parse and evaluate.
  *
  * @return The final result.
  */
  public BigFraction parseAndeval(String expr) {
    String[] parts = expr.split(" ");

    BigFraction result = parseOperator(parts[0]);

    for (int i = 1; i < parts.length; i += 2) {
      String operator = parts[i];
      BigFraction ontothenext = parseOperator(parts[i + 1]);

      result = evaluate(result, operator, ontothenext);
    } // For loop
    return result;
  } //parseAndeval (String expr)

  /**
  * ParseOperator is specifically for parsing the specific operator/
  * stored value.
  *
  * @param input The string, which is passed from parseandEval, to
  * be parsed.
  *
  * @return BigFraction that represented the parsed operator.
  */
  private BigFraction parseOperator(String input) {
    // checks if input is a letter so it can be replaced with a value.
    if (input.matches("[a-zA-z]")) {
      return this.registerSet.get(input.charAt(0));
    // checks if input is a fraction so the program can evaluate it
    } else if (input.contains("/")) {
      String[] fractionParts = input.split("/");
      int numerator = Integer.parseInt(fractionParts[0]);
      int denominator = Integer.parseInt(fractionParts[1]);
      return new BigFraction(numerator, denominator);
      // checks if the integer is a whole number.
    } else {
      int wholenumber = Integer.parseInt(input);
      return new BigFraction(wholenumber, 1);
    } // else
  } //BigFraction parseOperator(String input)

  /**
  * ParseOperator is specifically for parsing the specific operator/
  * stored value.
  *
  * @param left the fraction on the left side.
  *
  * @param operator the operator that was sorted by the parseoperator function.
  *
  * @param right the fraction on the right side.
  *
  * @return The result of left side by operator right side.
  */
  private BigFraction evaluate(BigFraction left, String operator, BigFraction right) {
    switch (operator) {
      case "+":
        return left.add(right);
      case "-":
        return left.subtract(right);
      case "/":
        return left.divide(right);
      case "*":
        return left.multiply(right);
      default:
        throw new IllegalArgumentException("Unknown operator: " + operator);
    } // switch
  } // BigFraction evaluate(BigFraction left, String operator, BigFraction right)
} // class BFparse
