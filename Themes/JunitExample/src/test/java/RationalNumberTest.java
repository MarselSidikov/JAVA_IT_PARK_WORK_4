import org.junit.Assert;
import org.junit.Test;

public class RationalNumberTest {

  @Test
  public void optimizeTest() {
    RationalNumber actual = RationalNumber.create(13, 169);

    actual.optimize();

    RationalNumber expected = RationalNumber.create(1, 13);

    Assert.assertEquals(expected, actual);
  }
}