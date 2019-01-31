public class Recursion{
  public static void main(String[] args){
    System.out.println("Square root of 100, tolerance of 0.00001 (0.001%): " + sqrt(100, 0.00001));
    System.out.println("Square root of 2, tolerance of 0.00001 (0.001%): " + sqrt(2, 0.00001));
    System.out.println("Square root of 0, tolerance of 0.00001 (0.001%): " + sqrt(0, 0.00001));
    System.out.println("Square root of 1, tolerance of 0.00001 (0.001%): " + sqrt(1, 0.00001));
    System.out.println("Square root of 0.25, tolerance of 0.00001 (0.001%): " + sqrt(0.25, 0.00001));
  }

  /*
 *@param n any non-negative value you want to take the sqrt of
 *@return the approximate sqrt of n within a tolerance of 0.001%
 Recursively find the sqrt using Newton's approximation
     *tolerance is the allowed percent error the squared answer is away from n.
     *precondition: n is non-negative
 */
public static double sqrt(double n, double tolerance){
  return sqrtH(n, 1.0, tolerance);
}
/*
*@param n any non-negative value you want to take the sqrt of
*@param guess initial approximation of the sqrt
*@param tolerance the percentage of error between actual sqrt and guess
*@returns approximate sqrt of n within given tolerance
*/
private static double sqrtH(double n, double guess, double tolerance){
   if (n == 0){
     return 0;
  }
  else{
    while (Math.abs( (Math.pow(guess,2) - n) / n * 100) > tolerance){
      // System.out.println(guess);
    guess = (n/guess+guess)/2;
    }
    return guess;
  }
}
}
