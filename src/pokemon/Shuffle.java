import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Shuffle
{
  public static void main(String args[])
  {
    int[] Deck = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };

    shuffleArray(Deck);
    for (int i = 0; i < Deck.length; i++)
    {
      System.out.print(Deck[i] + " ");
    }
    System.out.println();
  }

  // Implementing Fisher–Yates shuffle
  static void shuffleArray(int[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
}
