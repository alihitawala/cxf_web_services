package com.example.cxfdemo;

import javax.jws.WebService;

import com.example.cxfdemo.v1.*;
import com.example.cxfdemo.v1_1.HelloPort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@javax.jws.WebService(
        serviceName = "CXFHelloExampleService",
        portName = "CXFHelloExampleService",
        targetNamespace = "http://cxfdemo.example.com/v1.1",
        endpointInterface = "com.example.cxfdemo.v1_1.HelloPort")
public class HelloPortImpl implements HelloPort
{

    public SayHelloResponse sayHelloOperation(SayHello sayHello) {
        SayHelloResponse hello = new SayHelloResponse();
        hello.setGreeting("Howdy!");
        return hello;
    }

    public static void main(String[] args) {
        System.out.println(smallestMultiple(23));

    }

    public static String smallestMultiple(int n)
    {
        int count =1, rem=1;
        while(rem !=0 )
        {
            rem = (rem*10+1)%n;count++;
        }
        String result = "";
        System.out.println(count);
        while(count != 0)
        {
            count--;
            result+="1";
        }

        return result;
    }

    private static int numberDigit(int n) {
        int result = 0;
        while(n != 0)
        {
            n=n/10;
            result++;
        }

        return result;
    }

    static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    static String isanagram(String a, String b) {
        for(int i=0;i<a.length();i++)
        {
            char c = a.charAt(i);
            if (map.get(c) == null)
            {
                map.put(c, 1);
            }
            else
            {
                map.put(c, map.get(c) + 1);
            }
        }
        int result = check(b);
        if (result == -1)
            return "NONE";
        String s="";
        for (int i=result - a.length()+1; i<= result;i++)
            s+=b.charAt(i);
        return s;
    }

    static int check(String b)
    {
        HashMap<Character, Integer> temp = (HashMap<Character, Integer>) map.clone();

        for (int i=0 ;i<b.length();i++)
        {
            char c = b.charAt(i);
            if (temp.get(c) != null)
            {
                int x = temp.get(c);
                if (x == 1)
                {
                    temp.remove(c);
                    if (temp.isEmpty())
                    {
                        return i;
                    }
                }
                else
                {
                    temp.put(c, temp.get(c) - 1);
                }
            }
            else
            {
                temp = (HashMap<Character, Integer>) map.clone();
            }
        }
        return -1;
    }


    static int leastGreaterEven(int number) {
        boolean flag = false;
        int original = number;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (number !=0)
        {
            array.add(number%10);
            number = number/10;
        }
        int last = 0;
        for (int i=0 ;i <array.size()-1; i++)
        {
            if (!flag)
                flag = array.get(i) %2 == 0;
            if (array.get(i) > array.get(i+1) && flag)
            {
                last = i+1;
                break;
            }
        }

        System.out.println(array.get(last) +  " and " + array.get(0));
        return 0;
    }

}