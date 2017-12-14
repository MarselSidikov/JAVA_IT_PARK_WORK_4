public class Main {
  public static void main(String[] args) {
    RationalNumber a = RationalNumber.create(11, 121);
    RationalNumber b = RationalNumber.create(36, 182);
    a.optimize();
    b.optimize();
    System.out.println(a);
    System.out.println(b);
  }
}
