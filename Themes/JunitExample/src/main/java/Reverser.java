public class Reverser {
  public String reverse(String text) {
//    char array[] = text.toCharArray();
//
//    for (int i = 0; i < array.length / 2; i++) {
//      char temp = array[i];
//      array[i] = array[array.length - 1 - i];
//      array[array.length - 1 - i] = temp;
//    }

    return new StringBuilder(text).reverse().toString();
  }
}
