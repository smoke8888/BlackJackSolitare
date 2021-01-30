package bj_enum;

import java.util.Scanner;

/**
 * Class describe a mechanic of game. 
 * Like schow card, user input, put card, check a place and calculate score.
 */
class BlackjackSolitaire {
    /** Array field consist a cards on game field. */
    private Card[] field = new Card[20];

    
    /** Method fill arrays by default values. 
    *   By default insert tests Cards with rank_suit = number of place in field 
    *   and price = 0
    */
    private void init(){
        for(int i = 0; i < 20; ++i)
            field[i] = new Card("" + (i + 1), 0);
    }
    
    /** Method printing array field_name on a screen. */
    private void showField(){
        System.out.println("Game field: ");
        for(int i = 0; i < 16; ++i){
            if ((i == 4)|| (i == 9)||(i == 12)||(i == 15)) System.out.print(field[i].name + "\n");
            else if ((i == 10)||(i == 13)) System.out.print("\t" + field[i].name + "\t");
            else System.out.print(field[i].name + "\t");
        }
        System.out.println("\nDiscard pile: ");
        for(int i = 16; i < 20; ++i){
            System.out.print(field[i].name + "\t");
        }
    }
    
    /** Method recieve a card. 
     *  By Scanner class user writing place on the field. 
     *  Method checking input on wrong value.
     *  If there is a wrong walue it trows the Exception. 
     *  @param card consist unique instance of Card object
     *  @return True if no errors and card is puting on the field.
     *  False if user write wrong number or put a card on occupied place.
     */
    private boolean  putCard(Card card){ 
        Scanner sc = new Scanner(System.in);
        try{
            int pos = sc.nextInt();
            if ((pos < 1)||(pos > 20)) throw new Exception();
            if (field[pos - 1].price == 0) {
                field[pos - 1] = card;
                return true;
            }
            else {
                System.out.println("Already occupied by " + field[pos - 1].name + ". Pick another place.");
                return false;
            }
        }  
        catch(Exception ex){
            System.out.println("You whrite a wrong number, please whrite number between 1 and 20 inc."); 
            System.out.println("Current card is " + card.name + "; where do you want to place it?");
        }
        return false;
    }
    
    /** Method checking empty places on the field.
     * @return True if there are empty place.
     * False if there are no empty places.
     */
    private boolean isEmptyPlaceField(){
        boolean isEmptyPlace = false;
        for(int i = 0; i < 16; ++i){
            if (field[i].price == 0) isEmptyPlace = true;
        }
        return isEmptyPlace;
    }
    
    /**
     * Void method caclulate scores of game. 
     */
    private void scoreCalculate(){
        int summ;
        int num_Ace;
        int score = 0;
        int[][] arr = {{0, 1, 2, 3, 4},
                       {5, 6, 7, 8, 9},
                       {10, 11, 12},
                       {13, 14, 15},
                       {0, 5},
                       {1, 6, 10, 13},
                       {2, 7, 11, 14},
                       {3, 8, 12, 15},
                       {4, 9}};
        
        for(int m = 0; m < arr.length; ++m){
            num_Ace = 0;
            summ = 0;
            for(int n : arr[m]){
                summ += field[n].price;
                if (field[n].price == 11) ++num_Ace;               
            }
            if ((summ > 21)&&(num_Ace > 0)) {
                for(int k = 0; k < num_Ace; ++k) {
                    summ = summ - 10;
                    if (summ <= 21) break;
                }
            }
            if (((m == 4) || (m == 8))&&(num_Ace == 1)&&(summ == 21)) score += 10;
            else if (summ == 21) score += 7;
            else if (summ == 20) score += 5;
            else if (summ == 19) score += 4;
            else if (summ == 18) score += 3;
            else if (summ == 17) score += 2;
            else if (summ <= 16) score += 1;
        }    
        System.out.println("Game over");
        System.out.println("Your result is: " + score);    
    }
    
    /**
     * Void method define a game process. 
     * He call all needed methods for launch and playing game. 
    */
    void play(){
        Deck deck = new Deck();
        deck.shuffleDeck();
        init();
        System.out.println("\n");
                
        for(Card card : deck.card_array){
            
            showField();    
            System.out.println("\n**************************************************");
            if (isEmptyPlaceField() == false) break;
            System.out.println("Current card is " + card.name + "; where do you want to place it?");
            
            while (putCard(card) != true){}           
        }

        scoreCalculate();
      
    }
}
