package bj_enum;

/**
 * Class described a card.
 * The card have a name and a price.
 */
class Card{
    /** Name field. It consist rank + suit. For Example: Ace Diamands = AD, 4 Clubs = 4C and so on.  */
    protected String name;
    /** Price field. Consist a value of card in Black Jack. For example: King and Queen and Jack and 10 equals 10, Ace by default equal 11, and so on. */
    protected int price;

    
    /** Constructor of class Card.*/
    Card(String name, int price){
//       this.name = name;
        this.name = name;
        this.price = price; 
    }
    
    
    
}
