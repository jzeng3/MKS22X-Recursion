public class Recursion{
  public static void main(String[] args){
    System.out.println("Square root of 100: " + sqrt(100));
    System.out.println("Square root of 2: " + sqrt(2));
    System.out.println("Square root of 0: " + sqrt(0));
    System.out.println("Square root of 1: " + sqrt(1));
    System.out.println("Square root of 0.25: " + sqrt(0.25));
  }

  /*
 *@param n any non-negative value you want to take the sqrt of
 *@return the approximate sqrt of n within a tolerance of 0.001%
 */
public static double sqrt(double n){
  return sqrtH(n, 1.0, 0.001);
}
/*
*@param n any non-negative value you want to take the sqrt of
*@param guess initial approximation of the sqrt
*@param tolerance the percentage of error between actual sqrt and guess
*@returns approximate sqrt of n within given tolerance
*/
public static double sqrtH(double n, double guess, double tolerance){
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
