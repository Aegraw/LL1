package ll1new;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 
 *LL1 Parser Program
 * @author Tony McGraw
 * September 15, 2019
 * 
 */
public class LL1 {

	public static String tokens;
	public static StringTokenizer mathExpression;
	

	/**
	 * 
	 * String tokenizer
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
	
			
		mathExpression = new StringTokenizer(args[0] + "$", "+-*/()$", true);
		

		
	

		LL1 user = new LL1();
		user.grabToken();
		user.E();
	
	}
		
	/*
	 * This method is used to parse the equations.
	 * It comes in handy when switch detects 
	 * terminal symbols
	 * 
	 */
	public void grabToken()
	{
		tokens = mathExpression.nextToken();

	}

//Rule E Methods and all of its options
	public void E ()
    {
        switch(tokens)
        {
        case "+":
        	System.out.println("no");
        	System.exit(0);
        	break;
        case "-":
        	System.out.println("no");
        	System.exit(0);
        	break;
        case "*":
        	System.out.println("no");
        	System.exit(0);
        	break;
        case "/":
        	System.out.println("no");
        	System.exit(0);
       
        case ")":
        	System.out.println("no");
        	System.exit(0);
        case "$":
        	System.out.println("no");
        	System.exit(0);
        
         case "(":
	            this.T();
	            this.Eprime();
	            break;
        
         default:
                try{
                	int num = Integer.parseInt(tokens);
                    if(num>=0 && num<32767)
                    {
                    	this.T();
                    	this.Eprime();
                    }
                	else
                		break;
                }
                catch (Exception e){
                	
                }
                break;
        
    	}
    }

	//Rule Eprime and all of its'options
	public void Eprime() {
		switch (tokens) {
		
		case "*":
			System.out.println("no");
			System.exit(0);
			break;
		
		case "/":
			System.out.println("no");
			System.exit(0);
			break;
		case "(":
			System.out.println("no");
			System.exit(0);
			break;
	
		case "+":
			this.grabToken();
			T();
			Eprime();
			break;
		case "-":
			this.grabToken();
			T();
			Eprime();
			break;

		case ")":
			break;

		case "$":
			System.out.println("Yes");
			System.exit(0);
			break;
			
		default: 
			System.out.println("no");
			System.exit(0);
			break;

		}

	}

	//Rule T and all of it's options
	public void T() {
    	switch(tokens)
    	{
    	case "(":
   		this.F();
    	this.Tprime();
    		break;
    	case "+":
    	System.out.println("No");
    	System.exit(0);
    	break;
    	
    	case "-":
    		System.out.println("No");
    		System.exit(0);
    		break;
    	case "*":
    		System.out.println("No");
    		System.exit(0);
    		break;
    	case "/":
    		System.out.println("No");
    		System.exit(0);
    		break;
    	
    	case ")":
    		System.out.println("No");
    		System.exit(0);
    		break;
    	case "$":
    	System.out.println("No");
    	System.exit(0);
    	break;
    	
    		 default:
                 
                 try{
                 int num = Integer.parseInt(tokens);
                         if(num>=0 && num<32767)
                         {
                              F();
                             Tprime();
                         
                         }
                         else 
                             break;
                 }
                 
                 catch (Exception b)
                 {
          
             break;
    			
    		
                 }
    	}
    		
        
	}


//Rule Tprime and all of its options
	public void Tprime() {
		switch (tokens) {
		case "+": 
			break;
		case "-":
			break;
		case "*":
			this.grabToken();
			F();
			Tprime();
			break;
		case "/":
			this.grabToken();
			F();
			Tprime();
			break;
		
		case "(":
		System.out.println("No");
		System.exit(0);
		break;
		
		case ")":
			break;
		
		case "$":
		System.out.println("Yes");
		System.exit(0);
			break;
			
		default:
			System.out.println("no");
			System.exit(0);
			break;


		}
	}

	//Rule F and all of its options
	public void F() {
		switch (tokens) {
		
		
		case "+": 
			System.out.println("No");
			System.exit(0);
			break;
		case "-":
			System.out.println("No");
			System.exit(0);
			break;
		case "*":
			System.out.println("No");
			System.exit(0);
			break;
		case "/":
			System.out.println("No");
			System.exit(0);
			break;
		
	
		case "(":
			this.grabToken();
			E();
			this.grabToken();
			break;
			
		case ")":
			System.out.println("No");
			System.exit(0);
			break;
		case "$":
			System.out.println("No");
			System.exit(0);
			break;
		

		default:

			try {
				int num = Integer.parseInt(tokens);
				if (num >= 0 && num < 32767) {
					this.grabToken();

				} else
					break;
			}

			catch (Exception b) {

				break;

			}

		}
	}

}
