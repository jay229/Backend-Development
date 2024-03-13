package services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public static int sum(int a,int b){
        return a+b;
    }
    public static int subtract(int a,int b){
        return a-b;
    }
    public static int product(int a,int b){
        return a*b;
    }
    public static int divide(int a,int b){
        return a/b;
    }
    public static int sumAnyNumbers(int ...a){
        int result=0;
       for(int n:a){
           result+=n;
       }
       return result;
    }
}
