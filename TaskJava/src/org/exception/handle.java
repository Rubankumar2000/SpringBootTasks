package org.exception;

public class handle {
	public static void main (String[] args)
    {
        int[] arr = new int[4];

        try
        {
            int i = arr[4];
            System.out.println(arr[4]);
            System.out.println("Inside try block");
        }
         
        catch(NullPointerException ex)
        {
            System.out.println("Exception has been caught");
        }
         
        finally
        {
            System.out.println("finally block executed");
        }
         
    }

}
