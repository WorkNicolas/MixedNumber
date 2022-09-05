import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Assignment_4 is an object for FractionM.<br>
 * <b>FractionM</b> - an object that represents parts of a whole number. A FractionM is created by supplying a numerator and a deninator.<br>
 * <b>Instance related actions</b><br>
 * 1. add - mutates this FractionM by adding the anotherFractionM FractionM value<br>
 * 2. subtract - mutates this FractionM by subtracting the anotherFractionM FractionM value<br>
 * 3. multiply - mutates this FractionM by multiplying with the anotherFractionM FractionM value<br>
 * 4. divide - mutates this FractionM by dividing by the anotherFractionM FractionM value<br>
 * 5. toString - represents the FractionM in a form of "numerator/deninator"<br>
 * 6. equals - returns the following values<br>
 * &empsp0 when this FractionM is equal with the anotherFractionM FractionM<br>
 * &emsp1 when this FractionM is greater than the anotherFractionM FractionM<br>
 * &emsp-1 when this FractionM is less than the anotherFractionM FractionM<br>
 * <b>Class related actions</b><br>
 * 1. add - adds 2 FractionMs creating a new FractionM<br>
 * 2. subtract - subtracts FractionM 2 from FractionM 1 creating a new FractionM<br>
 * 3. multiply - multiplies FractionM 1 with FractionM 2 creating a new FractionM<br>
 * 4. divide - divides FractionM 1 into FractionM 2 pieces<br>
 * 5. greaterThen - checks whether FractionM 1 is larger than FractionM2<br>
 * 6. lessThan - checks whether FractionM 1 is smaller than FractionM2<br>
 * 7. equals - checks if both FractionM has the same value<br>
 * <b>Honor Pledge for Graded Assignments</b><br> 
 * “I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own.”<br>
 * @author Carl Nicolas Mendoza, Kurt Charles Gonzales
 * @version 05/31/2022
 */
class FractionM
{
    //numerator and deninator respectively
    private int num, den;

    //Constructor
    public FractionM(){}
    
    //FractionM
    public FractionM(int n, int d)
    {
        num = n;
        den = d;        
    }

    //Another FractionM
    public FractionM(FractionM anotherFractionM)
    {
        num   = anotherFractionM.num;
        den = anotherFractionM.den;        
    }

    // toString
    public String toString()
    {
        return "" + num + "/" + den;
    }

    //Comparison
    public int compareTo(FractionM  anotherFractionM)
    {
        FractionM newFractionM = new FractionM(num, den);
        double FractionMDecimal = (double) num/den, anotherFractionMDecimal = (double) anotherFractionM.num/anotherFractionM.den;
        if (FractionMDecimal > anotherFractionMDecimal)
        {
            return 1;
        }
        else if (FractionMDecimal < anotherFractionMDecimal)
        {
            return -1;
        }
        else return 0;
    }    
    public static boolean greaterThan(FractionM FractionM, FractionM anotherFractionM)
    {
        double FractionMDecimal = (double) FractionM.num/FractionM.den;
        double anotherFractionMDecimal = (double) anotherFractionM.num/anotherFractionM.den;
        //System.out.println("FractionMDecimal"+FractionMDecimal);
        //System.out.println("anotherFractionMDecimal"+anotherFractionMDecimal);
        if (FractionMDecimal > anotherFractionMDecimal)
        {
            return true;
        }
        else return false;
    }
    public static boolean lessThan(FractionM FractionM, FractionM anotherFractionM)
    {
        double FractionMDecimal = (double) FractionM.num/FractionM.den;
        double anotherFractionMDecimal = (double) anotherFractionM.num/anotherFractionM.den;
        //System.out.println("FractionMDecimal"+FractionMDecimal);
        //System.out.println("anotherFractionMDecimal"+anotherFractionMDecimal);
        if (FractionMDecimal < anotherFractionMDecimal)
        {
            return true;
        }
        else return false;
    }
    public static boolean equals(FractionM FractionM, FractionM anotherFractionM)
    {
        double FractionMDecimal = (double) FractionM.num/FractionM.den;
        double anotherFractionMDecimal = (double) anotherFractionM.num/anotherFractionM.den;
        //System.out.println("FractionMDecimal"+FractionMDecimal);
        //System.out.println("anotherFractionMDecimal"+anotherFractionMDecimal);
        if (FractionMDecimal == anotherFractionMDecimal)
        {
            return true;
        }
        else return false;
    }
    // Addition
    public FractionM add(FractionM anotherFractionM)
    {
        FractionM finalFractionM = new FractionM(((den * anotherFractionM.den)/num) + ((den * anotherFractionM.den)/anotherFractionM.num), (den * anotherFractionM.den));
        finalFractionM.simplify();
        return finalFractionM;
    }
    
    // Subtraction
    public FractionM subtract(FractionM anotherFractionM)
    {
        FractionM finalFractionM = new FractionM(((den * anotherFractionM.den)/num) - ((den * anotherFractionM.den)/anotherFractionM.num), (den * anotherFractionM.den));
        finalFractionM.simplify();
        return finalFractionM;
    }
    
    // Multiplication
    public FractionM multiply(FractionM anotherFractionM)
    {
        FractionM finalFractionM = new FractionM(num * anotherFractionM.num, den * anotherFractionM.den);
        finalFractionM.simplify();
        return finalFractionM;
    }

    // Division
    public FractionM divide(FractionM anotherFractionM)
    {
        FractionM finalFractionM = new FractionM(num * anotherFractionM.den, den * anotherFractionM.num);
        finalFractionM.simplify();
        return finalFractionM;
    } 
    
    // Support Methods
    
    //Simplify
    private void simplify()
    {
        int xSimplify = Math.min(Math.abs(num), Math.abs(den));
        if (xSimplify == 0)
        {
            return;        
        }
        while ((num % xSimplify != 0) || (den % xSimplify != 0))
        {
            xSimplify--;
        }
        num /= xSimplify;
        den /= xSimplify;    
    }
}

public class FractionMM
{
    public static void main(String [] args)
    {
        //Options
        boolean isNumber = false, exit = false;
        int input;
        FractionM f1 = new FractionM(1, 1);
        FractionM f2 = new FractionM(1, 1);
        Scanner sc = new Scanner(System.in);
        System.out.printf("Set a FractionM First\n\n");
        do
        {
            do
            {
                System.out.printf("FractionM Options\n1. Addition\n2. Subraction\n3. Multiplication\n4. Division\n5. compareTo\n6. greaterThan\n7. lessThan\n8. equals\n9. Set FractionM\n10. Default Example\n11. Exit\n");
                System.out.printf("Enter Input: ");
                if(sc.hasNextInt())
                {
                    input = sc.nextInt();
                    //Remove if-else statement if negative values are supported.
                    if (input > 0)
                    {
                        isNumber = true;
                        boolean fSet = false;
                        if (input == 1) //Addition
                        {
                            FractionM fSum = f1.add(f2);
                            stringCreation(0, f1, f2, fSum);
                        }
                        else if (input == 2) //Subtraction
                        {
                            FractionM fDif = f1.subtract(f2);
                            stringCreation(1, f1, f2, fDif);
                        }
                        else if (input == 3) //Multiplication
                        {
                            FractionM fPro = f1.multiply(f2);
                            stringCreation(2, f1, f2, fPro);
                        }
                        else if (input == 4) //Division
                        {
                            FractionM fQuo = f1.divide(f2);
                            stringCreation(3, f1, f2, fQuo);
                        }
                        else if (input == 5) //compareTo
                        {
                            f1.compareTo(f2);
                            int comparison = f1.compareTo(f2);
                            System.out.println("compareTo: " + comparison);
                        }
                        else if (input == 6) //greaterThan
                        {
                            System.out.println("greaterThan: " + FractionM.greaterThan(f1,f2));
                        }
                        else if (input == 7) //lessThan
                        {
                            System.out.println("lessThan: " + FractionM.lessThan(f1,f2));
                        }
                        else if (input == 8) //equals
                        {
                            System.out.println("equals: " + FractionM.equals(f1,f2));
                        }
                        else if (input == 9) //Set FractionM
                        {
                            int xNum = 0, yDen = 0;
                            boolean validFractionM = false;
                            Scanner fs = new Scanner(System.in);
                            //FractionM 1
                            do {
                                try{
                                    System.out.print("FractionM 1, Enter Numerator: ");
                                    xNum = fs.nextInt();
                                    System.out.print("FractionM 1, Enter Denominator: ");
                                    yDen = fs.nextInt();
                                    if (yDen != 0)
                                    {
                                        validFractionM = true;
                                    }
                                    else validFractionM = false;
                                    f1 = new FractionM(xNum, yDen);
                                }
                                catch(InputMismatchException ex)
                                {
                                    iInput();
                                    sc.next();
                                }
                            } while (!(validFractionM));
                            validFractionM = false;
                            do {
                                try{
                                    System.out.print("FractionM 2, Enter Numerator: ");
                                    xNum = fs.nextInt();
                                    System.out.print("FractionM 2, Enter Denominator: ");
                                    yDen = fs.nextInt();
                                    if (yDen != 0)
                                    {
                                        validFractionM = true;
                                    }
                                    else validFractionM = false;
                                    f2 = new FractionM(xNum, yDen);
                                }
                                catch(InputMismatchException ex)
                                {
                                    iInput();
                                    sc.next();
                                }
                                System.out.println("FractionM 1: " + f1);
                                System.out.println("FractionM 2: " + f2);
                            } while (!(validFractionM));
                            fSet = true;
                        }
                        else if (input == 10) //Default Example
                        {
                            FractionM FractionM1  = new FractionM(1, 2);
                            FractionM FractionM2  = new FractionM(3, 4);     
                    
                            FractionM FractionMSum = FractionM1.add(FractionM2); 
                            stringCreation(0, FractionM1, FractionM2, FractionMSum);
                            
                            FractionM FractionMDifference = FractionM1.subtract(FractionM2);
                            stringCreation(1, FractionM1, FractionM2, FractionMDifference);
                            
                            FractionM FractionMProduct = FractionM1.multiply(FractionM2);       
                            stringCreation(2, FractionM1, FractionM2, FractionMProduct);
                            
                            FractionM FractionMQuotient = FractionM1.divide(FractionM2);
                            stringCreation(3, FractionM1, FractionM2, FractionMQuotient);
                            
                            int comparison = FractionM1.compareTo(FractionM2);
                            System.out.println("compareTo: " + comparison);
                            System.out.println("greaterThan: " + FractionM.greaterThan(FractionM1,FractionM2));
                            System.out.println("lessThan: " + FractionM.lessThan(FractionM1,FractionM2));
                            System.out.println("equals: " + FractionM.equals(FractionM1,FractionM2));
                        }
                        else if (input == 11) //exit
                        {
                            exit = true;
                        }
                    }
                    else System.out.printf("Invalid input. Please read the terminal.\n");
                    //isNumber = true;
                }
                else
                {
                    iInput();
                    sc.next();
                }
            } while(!(isNumber));
        } while(!(exit));
        
    }
    
    public static void iInput()
    {
        System.out.printf("Invalid input. Please read the terminal.\n");
    }
    
    public static void stringCreation(int type, FractionM FractionM1, FractionM FractionM2, FractionM newFractionM)
    {
        String[] operation = {" + ", " - ", " * ", " / ", " = "};
        System.out.println(FractionM1 + operation[type] + FractionM2 + operation[4] + newFractionM);
    }
}
