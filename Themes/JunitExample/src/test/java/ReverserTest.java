import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverserTest {
  @Test
  public void reverseTest() {
    Reverser reverser = new Reverser();

    String actual = reverser.reverse("privet");
    String expected = "tevirp";

    Assert.assertEquals(expected, actual);
  }
}