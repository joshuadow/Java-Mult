import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joshua Dow, 101050588. Finished 30/10/2016
 */
public class Assignment22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner uin = new Scanner(System.in);                                   //Initialzing scanner
        //S1
        //Preconditions --> Must have scanner initialized, and no package errors
        //Postconditions --> Scanner correctly takes in and stores input
        //
        System.out.println("Please enter two strings below: ");                 //Prompt user for input
        String str1 = uin.next();                                               //Store first input
        String str2 = uin.next();                                               //Store second input
        long stime = System.currentTimeMillis();                                //Used only for time-keeping purposes
        List<String> list1 = new ArrayList<String>();                           //Initializing list
        List<String> list2 = new ArrayList<String>();                           //Initializig list
        List<String> partialProductList = new ArrayList<String>();              //Initializing list
        short carry = 0;                                                        //Set carry to 0
        short product;                                                          //Initialize product
        short k;                                                                //Initialize k
        short l;                                                                //Initialize l
        for(k = 0; k <= str1.length() - 1; k++) {                               //Beginning of for loop
            list1.add(str1.substring(k, k+1));                                  //Adding input into list
        }                                                                       //End of for loop
        for(l = 0; l <= str2.length() - 1; l++){                                //Beginning of for loop
            list2.add(str2.substring(l, l+1));                                  //Adding input into list
        }                                                                       //End of for loop
        short min;                                                              //Initializing min
        short max;                                                              //Initializing max
        if(str1.length() > str2.length()){                                      //Comparing length of inputs
            min = (short) str2.length();                                        //Setting shorter input to min
            max = (short) str1.length();                                        //Setting longer input to max
        }                                               
        else{                                                                   //Else
            min = (short) str1.length();                                        //Setting shorter input to min
            max = (short) str2.length();                                        //Setting longer input to max
        }
        short h = (short) (max - 1);                                            //Initializing h to be last index of longer input
        for(short j = (short) (min - 1); j >=0; j--){                           //Beginning of for loop
        String partialProduct="";                                               //Initializing partial product
        if(j < (min - 1)){                                                      //Comparison to length of shorter input
            for(short z = 1; z <= ((min - 1)-j); z++){                          //Beginning of inner for loop
            String zeroes = "0";                                                //Used to append zeroes when shifting place values (ones, tens, hundreds, etc..)
            partialProduct = partialProduct + zeroes;                           //Appending the zeroes
            }                                                                   //End of inner for loop
        }                                                                              
        carry = 0;                                                              //Setting carry to 0
        while(h >= 0){                                                          //Beginning of while
            //S2
            //Preconditions--> h must be >= 0, must have stored two inputs,
            //Postconditions --> No errors, a call to the addPartialProducts
            //function, stores results in string without error.
            short multiplier;                                                   //Initializing multiplier
            short multiplicand;                                                 //Initializing multiplicand
            if (str1.length() > str2.length()){                                 //Comparing length of strings
            multiplier = (Short.parseShort(list2.get(j)));                      //Setting multiplier to index of shorter input
            multiplicand = (Short.parseShort(list1.get(h)));                    //Setting multiplicand to index of longer input
            }
            else{
            multiplier = Short.parseShort(list1.get(j));                        //Setting multiplier to index of shorter input
            multiplicand = Short.parseShort(list2.get(h));                      //Setting multiplicand to index of shorter input
            }
            product = (short) (((multiplier * multiplicand)+ carry) % 10);      //Setting product

            carry = (short) (((multiplier * multiplicand) + carry) / 10);       //Setting carry
            
            partialProduct = product + partialProduct;                          //Appending product to the partial product
            h--;                                                                //Decrementing h
        }
        h = (short) (max - 1);                                                  //Set h to be last index of longer input
        if(carry > 0){                                                            //Comparison
        partialProduct = carry + partialProduct;                                //Appending the carry to partial product
        }
        partialProductList.add(partialProduct);                                 //Adding element to list
        }                                                                       //End of for loop
        
        //S3
        //Preconditions --> Correct contents in partialProductList
        //Postconditions --> final_sum sent to standard output without error,
        //Correct call to addPartialProducts without error
        String final_sum = addPartialProducts(partialProductList);              //Setting final sum by function call
        System.out.println("Final product: " + final_sum);                      //Print out of final product
        short x = 0;                                                            //Initialzing x
        short y = 1;                                                            //Initialzing y
        //S4
        //Preconditions --> S3 has been completed
        //Postconditions --> While loop executes without error, and indexing of
        //partialProductList goes without error
        while(x <= (short) (min - 1)){                                          //Beginning of while loop
            System.out.println("Partial Product " + y +") " + partialProductList.get(x)); //Results to standard output
            x++;                                                                //Increment x
            y++;                                                                //Decrement y
        }
        long ftime = System.currentTimeMillis();
        System.out.println("Total time(In Milliseconds): " + (ftime - stime) );
    }
    
    public static String addPartialProducts(List<String> list)                  //Function
    {
    	String res = "";                                                        //Initializing results string
    	short carry = 0;                                                        //Initializing carry
        short sum = 0;                                                          //Initialzing sum    
    	short max_len = (short) list.get(list.size()- 1).length();               //Last element in the list would have the largest length
    	
                                                                                //Vertically add the digits at the n-th place
    	for(short nth_digit=0; nth_digit<(short) (max_len); nth_digit++)        //Beginning of for loop
    	{
    		sum = 0;                                                        //Setting sum to 0
                                                                                //Iterate over each element by extracting its n-th digit
    		for(short index=0; index < list.size(); index++)                //Beginning of for loop
    		{
    			String num = list.get(index);                           //Setting num to list at index
    			if(nth_digit < num.length())                            //Comparison of digit to the length of the digit
    			{
    				short digit = Short.parseShort(num.charAt(num.length()-1-nth_digit)+"");//Get the n-th digit from right
    				sum += digit;                                   //Incrementing sum by digit
    			}
    		}                                                               //End of for loop
       		sum +=carry;                                                    //Incrementing sum by carry
    		carry = (short) (sum / 10);                                     //Setting carry to be result of integer division
    		res = (sum % 10) + res;                                         //Setting result to be result of modulo division
    	}
    	
                                                                                //Add any remaining residue into the final sum
    	if(carry > 0)                                                           //Comparing carry to 0
        res = carry + res;                                                      //If greater than, append carry to res
    	return res;                                                             //Returning res
        
    
    }
}
    