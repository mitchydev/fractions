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
    if (parts.length == 0 || parts[0].isEmpty()) {
      return null;
    } // if statement
    BigFraction result = parseOperator(parts[0]);
    if (result == null) {
      return null;
    } // if statement
    for (int i = 1; i < parts.length; i += 2) {
      if (i + 1 >= parts.length) {
        return null;
      } // if statment
      String operator = parts[i];
      BigFraction ontothenext = parseOperator(parts[i + 1]);
      if (ontothenext == null) {
        return null;
      } // if statement
      result = evaluate(result, operator, ontothenext);
      if (result == null) {
        return null;
      }
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
      if (denominator == 0) {
        return null;
      }
      return new BigFraction(numerator, denominator);
    } else {
      return null;
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
        return null;
    } // switch
  } // BigFraction evaluate(BigFraction left, String operator, BigFraction right)
} //BFparse
