import java.util.*;

public class Recursion{
  public static void main(String[] args){
    System.out.println("Square root of 100, tolerance of 0.00001 (0.001%): " + sqrt(100, 0.00001));
    System.out.println("Square root of 2, tolerance of 0.00001 (0.001%): " + sqrt(2, 0.00001));
    System.out.println("Square root of 0, tolerance of 0.00001 (0.001%): " + sqrt(0, 0.00001));
    System.out.println("Square root of 1, tolerance of 0.00001 (0.001%): " + sqrt(1, 0.00001));
    System.out.println("Square root of 0.25, tolerance of 0.00001 (0.001%): " + sqrt(0.25, 0.00001));
    for (int i = 0; i < 10; i++){
      System.out.println("fib term "+ i + ": " + fib(i));
    }
    for (int i = 0; i < 5; i++){
      System.out.println("make all sums " + i + ": " + makeAllSums(i));
    }
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
      return 0; // handle case of n being 0, i.e. sqrt(0) = 0
    }
    else{
      // while difference between guess squared and n is within tolerance
      while (Math.abs( (Math.pow(guess,2) - n) / n * 100) > tolerance){
        // update the guess
        guess = (n/guess+guess)/2;
      }
      return guess;
    }
  }

  /*Recursively find the n'th fibbonaci number in linear time
  *fib(0) = 1; fib(1) = 1; fib(5) = 5
  *precondition: n is non-negative
  */
  public static int fib(int n){
    // call helper function
    return fibH(n, 0, 1);
  }
  // helper function keeps track of previous two terms
  private static int fibH(int n, int term1, int term2){
    // base case
    if (n <= 0){
      return 0;
    }
    // return sum of previous two terms
    if (n <= 2){
      return term1 + term2;
    }
    // sum up the two terms and update term1 and term2
    else{
      int newTerm = term1 + term2;
      term1 = term2;
      term2 = newTerm;
      return fibH(n-1, term1, term2);
    }
  }
  // returns an arrayList of all possible sums from 1 to n inclusive
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> listOfSums = new ArrayList<Integer>();
    makeAllSumsH(n, listOfSums, 0);
    return listOfSums;
  }

  private static void makeAllSumsH(int n, ArrayList<Integer> ary, int ans){
    // if reached end of numbers, return the arraylist
    if (n == 0){
      // add the number if it has not been included yet (after finishing one branch of the sum tree)
        ary.add(ans);
      }
    // otherwise, recursively call method for the next number
    // including or not including it in the sum
    else{
        makeAllSumsH(n-1, ary, ans+n);
        makeAllSumsH(n-1, ary, ans);
      }
    }

}
