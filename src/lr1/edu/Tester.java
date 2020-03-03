package lr1.edu;

import java.util.*;
import java.lang.String.*;

public class Tester{
    private Stack<Double> numbers = new Stack<Double>();    //Stack numbers store the numbers to be calculated.
    private Stack<String> operators = new Stack<String>();  //Stack operators store the operators to be used.
    String number = ""; //Use the number string to temporarily store the number.

    //Compare the priority between two operators,return true if and only if the former is more weighted.(The same priority will return false.)
    public boolean prior(String former, String latter){
        if((former.equals("*")||former.equals("/")) && (latter.equals("+")||latter.equals("-")||latter.equals("(")))
            return true;
        else if((former.equals("+") || former.equals("-")) && latter.equals("("))
            return true;
        else
            return false;
    }
    //Calculate the two numbers.
    public double figureout(double former, String operator, double latter){
        if(operator.equals("+"))
            return former+latter;
        else if(operator.equals("-"))
            return former-latter;
        else if(operator.equals("*"))
            return former*latter;
        else if(operator.equals("/"))
            return former/latter;
        else return 0;
    }

    //identify the char.
    public int classifyOperator(String operator){
        if(operator.equals("0")||operator.equals("1")||operator.equals("2")||
           operator.equals("3")||operator.equals("4")||operator.equals("5")||
           operator.equals("6")||operator.equals("7")||operator.equals("8")||
           operator.equals("9")||operator.equals("."))
            return 0;
        if(operator.equals("+")||operator.equals("-")||operator.equals("*")||
           operator.equals("/"))
            return 1;
        if(operator.equals("("))
            return 2;
        if(operator.equals(")"))
            return 3;
        else
            return 4;
    }

    //Calculate the String.
    public double cal(String sentense){
        sentense = "("+sentense+")";    //Add parentheses ahead.
        for(int i = 0;i<sentense.length();i++){
            if(classifyOperator(""+sentense.charAt(i)) == 0){   //If  we meet a number character we just add it behind the number string.
                number = number+sentense.charAt(i);
            }
            else{
                if(!number.equals(""))
                    numbers.push(Double.parseDouble(number));   //Whenever it comes to character which isn't a number, parse the whole number string and push it to the stack.
                number = "";    //Reset the string to null every time we push the number to the stack.
                //System.out.println("Now the numbers stack is"+numbers);
                if(classifyOperator(""+sentense.charAt(i)) == 2)    //Push the "(" to the stack directly.
                    operators.push(""+sentense.charAt(i));
                if(classifyOperator(""+sentense.charAt(i)) == 3){   //When it comes to ")".
                    while(!operators.peek().equals("(")){   //Do the math with all the operators stored in the operators stack until we meet "("
                        double latter = numbers.pop();
                        double former = numbers.pop();
                        numbers.push(figureout(former,operators.pop(),latter));
                    }
                    operators.pop();    //Pop the "(" left.
            }
                if(classifyOperator(""+sentense.charAt(i)) == 1){   //When it comes to +-*/

                    if(prior((""+sentense.charAt(i)),operators.peek()))     //If the present char has priority over the one at the top of the stack, just push it in.
                        operators.push(""+sentense.charAt(i));
                    else{                                                   //else, we repeatedly do the math until we find some operator in the operators stack that is less weighted.
                        double latter = numbers.pop();
                        double former = numbers.pop();
                        do{
                            numbers.push(figureout(former,operators.pop(),latter));
                        }while(!(prior((""+sentense.charAt(i)),operators.peek())));
                        operators.push(""+sentense.charAt(i));              //Push the current char into the stack.
                    }
                }
            }
//            System.out.println("The number String is "+number);
//            System.out.println("The numbers stack is "+numbers);
//            System.out.println("The operators stack is"+operators);
//            System.out.println("The charAt  is "+sentense.charAt(i));
            //System.out.println("-----------");
        }
        while(!operators.empty()){                                      //In the end there may be some numbers left to be calculate.
            double latter = numbers.pop();
            double former = numbers.pop();
            numbers.push(figureout(former,operators.pop(),latter));
        }
        return numbers.pop();
    }


    public static void main(String[] args){
        String sentense = "(17+25)*15";
        Tester calculate = new Tester();
        System.out.println(calculate.cal(sentense));
    }
}
