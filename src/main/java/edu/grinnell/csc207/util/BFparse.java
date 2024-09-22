package edu.grinnell.csc207.util;

/**
 * An added util class that parses through user inputted commands
 * separating values from operators and evaluating them.
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
  * ParseAndEval parses the operator and evaluates the expression.
  *
  * @param expr The expr to parse and evaluate.
  *
  * @return BigFraction
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

  private BigFraction parseOperator(String input) {
    if (input.matches("[a-zA-z]")) {
      return this.registerSet.get(input.charAt(0));
    } else if (input.contains("/")) {
      String[] fractionParts = input.split("/");
      int numerator = Integer.parseInt(fractionParts[0]);
      int denominator = Integer.parseInt(fractionParts[1]);
      return new BigFraction(numerator, denominator);
    } else {
      int wholenumber = Integer.parseInt(input);
      return new BigFraction(wholenumber, 1);
    } // else
  } //BigFraction parseOperator(String input)

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
} //BFparse
