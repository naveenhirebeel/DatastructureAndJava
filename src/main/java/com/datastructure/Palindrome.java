package com.datastructure;

import java.util.Scanner;
public class Palindrome
{
    public static void main(String args[])
    {
        int n, m, a = 0,r = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter any number:");
        n = s.nextInt();
        m = n;
        while(n > 0)
        {
            r = n % 10;
            n = n / 10;
            a = a * 10 + r;
        }
        if(a == m)
        {
            System.out.println("Given number "+m+" is com.datastructure.Palindrome");
        }
        else
        {
            System.out.println("Given number "+m+" is Not com.datastructure.Palindrome");
        }
    }
}