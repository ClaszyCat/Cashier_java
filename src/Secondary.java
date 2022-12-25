import java.util.Scanner;

public class Secondary implements dataWriter{

    String[] stuffNames = {"Jacket","PDH-D","T-shirt"};
    int[] stuffPrices = {150000, 100000, 75000};
    int userChoice;
    int amountPdh = 0;
    int amountJacket = 0;
    int amountTshirt = 0;
    double tempTotal;
    double discount;
    float payment;
    char answer;
    Scanner userInput = new Scanner(System.in);

    public void listMenuPage(){
        for (int i = 0; i < stuffNames.length; i++) {
            String stuffName = stuffNames[i];
            System.out.println(i+1+ "|\t" + stuffName + "\t\t| "+ "\t" + stuffPrices[i]+ "\t|");
        }
    }

    /**
     * This method gets the customer data and the things they want to buy
     * @throws Exception handling error if something happen
     * @see Exception example IOException
     */
    public void orderInput() throws Exception {
        System.out.print("What you want to order (input code/number) : ");
        userChoice = userInput.nextInt();
       if (userChoice == 1){
           System.out.print("Input amount of PDH : ");
           amountPdh = amountPdh +  userInput.nextInt();
           System.out.println("Total PDH you ordered : " + amountPdh);
           System.out.println("Total : "+ totalFormula(amountPdh,stuffPrices[0]));
           System.out.print("Wanna buy more(y/t) : ");
           answer = userInput.next().charAt(0);
           if (answer == 'y'){
               orderInput();
           }else{
             showTotal();
           }
       }else if(userChoice == 2){
           System.out.print("Input amount of Jacket : ");
           amountJacket = amountJacket + userInput.nextInt();
           System.out.println("Total PDH you ordered : " + amountJacket);
           System.out.println( "Total : "+ totalFormula(amountJacket,stuffPrices[1]));
           System.out.print("Wanna buy more(y/t) : ");
           answer = userInput.next().charAt(0);
           if (answer == 'y'){
               orderInput();
           }else{
               showTotal();
           }
       }else if(userChoice == 3){
           System.out.print("Input amount of T-Shirt : ");
           amountTshirt = amountTshirt + userInput.nextInt();
           System.out.println("Total PDH you ordered : " + amountTshirt);
           System.out.println( "Total : "+ totalFormula(amountTshirt,stuffPrices[2]));
           System.out.print("Wanna buy more(y/t) : ");
           answer = userInput.next().charAt(0);
           if (answer == 'y'){
               orderInput();
           }else{
             showTotal();
           }
       }else{
           orderInput();
       }
    }
    /**
     * This method show the customer data and the total prices
     * @throws Exception handling error if something happen
     * @see Exception example IOException
     */
    public void showTotal()throws Exception{
        System.out.println("\nYou bought " + amountPdh + " PDH | " + amountJacket + " Jacket |" + amountTshirt + " T-shirt|");
        System.out.printf("\nTotal : %d ", (totalFormula(amountJacket ,stuffPrices[1])) + totalFormula(amountTshirt,stuffPrices[2]) + totalFormula(amountPdh,stuffPrices[0]));
        tempTotal = (totalFormula(amountJacket ,stuffPrices[1])) + totalFormula(amountTshirt,stuffPrices[2]) + totalFormula(amountPdh,stuffPrices[0]);
        if(tempTotal > 350000){
            System.out.println("You get a 20% discount!");
            discount =  tempTotal * 0.2;
            tempTotal = tempTotal -discount;
            System.out.println("Total : " + tempTotal);
            System.out.print("Input your cash : ");
            payment = userInput.nextFloat();
            if (payment >= discount){
                System.out.println("Your change : " +  (payment-tempTotal));
                System.out.println("Thanks for coming!");
                dataMaker(amountPdh, amountJacket, amountTshirt, tempTotal);
            }else{
                amountTshirt = 0;
                amountJacket = 0;
                amountPdh = 0;
                discount = 0;
                payment = 0;
                orderInput();
            }
        }else {
            System.out.print("\nInput your cash : ");
            payment = userInput.nextFloat();
            if (payment >= (totalFormula(amountJacket ,stuffPrices[1])) + totalFormula(amountTshirt,stuffPrices[2]) + totalFormula(amountPdh,stuffPrices[0])){
                double noDiscount = payment - tempTotal;
                System.out.println("Your change : " + noDiscount);
                System.out.println("Thanks for coming!");
                dataMaker(amountPdh, amountJacket, amountTshirt, noDiscount);
            }else{
                System.out.println("Check your money first");
                amountTshirt = 0;
                amountJacket = 0;
                amountPdh = 0;
                discount = 0;
                payment = 0;
                orderInput();
            }
        }
    }

    /**
     * This method is a formula to check tht total prices
     * @param theInput this param got by amount of each data
     * @param price this param getting prices data
     * @return the total of the formula/prices
     */
    public int totalFormula(int theInput, int price){
        return theInput*price;
    }


}
