import java.util.Map;

public class RationalNumber {
  private int numerator;
  private int denominator;

  public static RationalNumber create(int numerator, int denominator) {
    RationalNumber instance = new RationalNumber();
    instance.numerator = numerator;

    if (denominator != 0) {
      instance.denominator = denominator;
    } else {
      throw new ArithmeticException("Divide by zero");
    }

    return instance;
  }

  public void optimize() {
    int nod = calcNod(numerator, denominator);
    this.numerator = this.numerator / nod;
    this.denominator = this.denominator / nod;
  }

  private int calcNod(int x, int y) {
    while (x != 0 && y != 0) {
      if (x > y) {
        x = x % y;
      } else {
        y = y % x;
      }
    }

    return x + y;
  }

  public String toString() {
    return numerator + "/" + denominator;
  }

  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof RationalNumber)) {
      return false;
    }

    if (obj == this) {
      return true;
    }

    RationalNumber that = (RationalNumber)obj;
    return this.numerator == that.numerator
        && this.denominator == that.denominator;
  }
}
