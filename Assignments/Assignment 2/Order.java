//Sai Konduru 

import java.util.Scanner;

public class Order
{
	public static void main(String[] args)
	{
		
		//Declare and Instantiate varibles to be used. 
		boolean moreCustomers = true;
		int pieCard = -1; 
		int customers = -1; 
		Scanner sc = new Scanner(System.in);
		int order = -1;
		int plainPizza = 0;
		int pepperonriPizza = 0; 
		int numCherry = 0; 
		int numWholeCherry = 0; 
		int numCharms = 0; 
		double totalCost = 0.00; 
		double payment = 0.00; 
		
		do 
		{
			//Ask if the customer has a Pie card.
			//Store the answer.
			System.out.println("Hello and Welcome to PP&P! Do you have a Pie Card?");
			System.out.println("Press 1 If Yes");
			System.out.println("Press 2 If No");
			pieCard = sc.nextInt();
			
			//Check to see if the customer entered a 1 or a 2. 
			//If they didn't ask until they do.
			while(pieCard != 1 && pieCard != 2)
			{
				System.out.println("Please enter an appropriate number.");
				System.out.println("Press 1 If Yes");
				System.out.println("Press 2 If No");
				pieCard = sc.nextInt();
			}
			
			//Ask if more customers are waiting.
			//Store the answer. 
			System.out.println("Ok and are there any more custormers?");
			System.out.println("Press 1 If Yes");
			System.out.println("Press 2 If No");
			customers = sc.nextInt();
			
			//Check to see if the customer entered a 1 or a 2. 
			//If they didn't ask until they do.
			while(customers != 1 && customers != 2)
			{
				System.out.println("Please enter an appropriate number.");
				System.out.println("Press 1 If Yes");
				System.out.println("Press 2 If No");
				customers = sc.nextInt();	
			}
			
			//Ask for their order. 
			System.out.println("What would you like to do? ");
			System.out.println("     1) Pizza Order");
			System.out.println("     2) Cherry Pie Order");
			System.out.println("     3) Charms Order");
			System.out.println("     4) Checkout");
			System.out.println("Press the number next to the desired item.");
			order = sc.nextInt();
			
			
			while(order != 4)
			{
				//Fill out all orders. 
				switch(order)
				{	
					//Do this if the customer wants a Pizza. 
					case 1: 
					{
						//Ask how many plain and how many pepperonri is wanted.
						//Store each number.	
						System.out.println("How many plain pizzas would you like?");
						plainPizza = sc.nextInt(); 
						System.out.println("How many pepperonri pizzas would you like?");
						pepperonriPizza = sc.nextInt();
						break;

					}
					
					//Do this if the Customer wants Pie.
					case 2: 
					{
						//Ask how many slices the customer wants. 
						System.out.println("How many cherry pie slices would you like?");
						numCherry = sc.nextInt();
						
						//Split the number of slices into Whole pies and remaining slices making sure 
						//we have 6 slices of pie per whole pie. 
						//Tell them how many whole pies and slices they ordered. 
						if (numCherry > 6)
						{
							if(numCherry % 6 == 0)
							{
								numWholeCherry = numCherry / 6; 
								System.out.println("That will be " + numWholeCherry + " whole pies.");
							}
							else 
							{
								do{
									numCherry -= 6;
									numWholeCherry++; 
								}while(numCherry % 6 != 0 && numCherry >= 6);
								
								System.out.println("That will be " + numWholeCherry + " whole pies and " + numCherry + " slices.");
							}		
							
						}
						else if (numCherry < 6)
						{
							System.out.println("That will be " + numCherry + " slices.");
						}
						else 
						{
							numWholeCherry++; 
							numCherry = 0; 
							System.out.println("That will be " + numWholeCherry + " whole pie.");
						}
						break;

					}
					
					//Do this if the customer picks Charms.
					case 3: 
					{
						//Ask how many charms they want and store the number.
						//Tell them how many they ordered. 
						System.out.println("How many Pi Charms would you like?");
						numCharms = sc.nextInt();
						System.out.println("You ordered " + numCharms + " charms.");
						break;
					}
					
					//Do this if the Customer doesn't pick an appropriate number. 
					default:
					{
						System.out.println("Please pick an appropriate number.");
					}
				}
				
				//Ask customer what they want until they press 4 for check out. 
				order = 0;
				System.out.println("What would you like to do? ");
				System.out.println("     1) Pizza Order");
				System.out.println("     2) Cherry Pie Order");
				System.out.println("     3) Charms Order");
				System.out.println("     4) Checkout");
				System.out.println("Press the number next to the desired item.");
				order = sc.nextInt();
				
			}
			
			//Do this if the customer wants to check out. 
			
			if( pieCard == 1)
			{
				//Check each order for a value not equal to 0. 
				//Print out the number of each product ordered 
				//with the prices for a pie card holder. 
				//Calculate and show the cost of each item. 
				if(plainPizza != 0)
				{
					System.out.printf("%d plain pizzas at $10.00 each                                $%-5.2f \n", plainPizza, (double)(plainPizza * 10));
				}
				
				if(pepperonriPizza != 0)
				{
					System.out.printf("%d pepperonri pizzas at $10.00 each                           $%-5.2f \n", pepperonriPizza, (double)(pepperonriPizza*10));
				}
				
				if(numWholeCherry != 0)
				{
					System.out.printf("%d whole cherry pies at $8.00 each                            $%-5.2f \n", numWholeCherry, (double)(numWholeCherry*8));
				}
					
				if(numCherry != 0)
				{
					System.out.printf("%d Cherry Pie Slices at $1.75 each                            $%-5.2f \n", numCherry, (double)(numCherry*1.75));
				}
					
				if(numCharms != 0)
				{
					System.out.printf("%d Gold Charms at $45.00 each                                 $%-5.2f \n", numCharms, (double)(numCharms * 45));
				}
					
				
				//Calculate and show the subtotal cost of the order. 
				totalCost += (double)(plainPizza * 10); 
				totalCost += (double)(pepperonriPizza*10);
				totalCost += (double)(numWholeCherry * 8);
				totalCost += (double)(numCherry * 1.75); 
				totalCost += (double)(numCharms * 45); 
				System.out.println("                                                            --------");
				System.out.printf("SubTotal                                                     $%-5.2f \n", totalCost);
				
				//Check to see if the customer's order qualifies for the 10% of bonus discount. 
				if(totalCost > 100)
				{
					//Show them the discount amount and subtract it from the subtotal cost. 
					System.out.printf("Bonus Discount of 10%%      	                             $%-5.2f \n", (totalCost / 10.00)); 
					totalCost -= (totalCost * .1); 
					
					//Calculate and show tax for their order. 
					System.out.printf("Tax                                                          $%-5.2f \n", (totalCost *.06));
					System.out.println("                                                            --------");
					totalCost += (totalCost * .06); 
					
					//Print out total cost after all discounts and tax. 
					System.out.printf("Total                                                        $%-5.2f \n", totalCost);
				}
				else 
				{
					//Calculate and show tax for their order. 
					System.out.printf("Tax                                                          $%-5.2f \n", (double)(totalCost *.06));
					totalCost -= (totalCost * .06); 
					
					//Print out total cost after tax. 
					System.out.printf("Total                                                        $%-5.2f \n", (double)totalCost);
				}
				
				
			}
			else 
			{
				//Check each order for a value not equal to 0. 
				//Print out the number of each product
				//with the correct prices for a non-Pie card holder. 
				//Calculate and show the price of each product. 
				if(plainPizza != 0)
				{
					System.out.printf("%d plain pizzas at $10.00 each                                $%-5.2f \n", plainPizza, (double)(plainPizza * 10));
				}
					
				if(pepperonriPizza != 0)
				{
					System.out.printf("%d pepperonri pizzas at $12.00 each                           $%-5.2f \n", pepperonriPizza, (double)(pepperonriPizza*12));
				}
					
				if(numWholeCherry != 0)
				{
					System.out.printf("%d whole cherry pies at $10.00 each                           $%-5.2f \n", numWholeCherry, (double)(numWholeCherry*10));
				}
					
				if(numCherry != 0)
				{
					System.out.printf("%d Cherry Pie Slices at $2.00 each                            $%-5.2f \n", numCherry, (double)(numCherry*2));
				}
					
				if(numCharms != 0)
				{
					System.out.printf("%d Gold Charms at $50.00 each                                 $%-5.2f \n", numCharms, (double)(numCharms * 50));
				}
					
				
				//Calculate and show the subtotal.
				totalCost += (double)(plainPizza * 10); 
				totalCost += (double)(pepperonriPizza*12);
				totalCost += (double)(numWholeCherry * 10);
				totalCost += (double)(numCherry * 2); 
				totalCost += (double)(numCharms * 50); 
				System.out.println("                                                            ---------");
				System.out.printf("SubTotal                                                     $%-5.2f \n", totalCost);
				
				//Calculate and print out the tax for the order. 
				System.out.printf("Tax                                                          $%-5.2f \n", (totalCost *.06));
				System.out.println("                                                            ---------");
				totalCost += (totalCost * .06); 
				
				//Print out the total cost after tax.
				System.out.printf("Total                                                        $%-5.2f \n", (double)totalCost);
		
			}
			
			System.out.println("");
			System.out.println("");
			
			//Ask for the customer's payment. 
			System.out.print("Please enter your payment amount:                            $");
			payment = sc.nextDouble(); 
			
			//Ask for payment until they enter a value equal to or high than the total cost. 
			while(totalCost - payment > 0)
			{
				System.out.print("Please enter your payment amount:                            $");
				payment = sc.nextInt(); 
			}
			
			//Calculate and show the customer's change.
			System.out.printf("Your Change                                                  $%-5.2f \n", payment - totalCost);
			System.out.println("Thank Your for Eatting at PP&P!");
			
			//Set the totals to be ready for next customer. 
			totalCost = 0; 
			
			//Continue to loop if their are more customers. 
			if(customers == 1)
				moreCustomers = true;
			else 
				moreCustomers = false; 
			
		}while(moreCustomers);
	}
}