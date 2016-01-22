package models;
        //William Mays 1-22
    public class Remove {

    public static void remove(String[] column1,String[] column2,String[] column3,String[] column4){

        int valueOne;
        int valueTwo;
        int valueThree;
        int valueFour;
        int index1;
        int index2;
        int index3;
        int index4;

        //Find the cards at the top of each column
        for (int i=0; i > 13; i++){
            if (column1[i] != null){
                valueOne = column1[i];
                index1 = i;
                break;
            }
        }
        for (int i=0; i > 13; i++){
            if (column2[i] != null){
                valueTwo = column2[i];
                index2 = i;
                break;
            }
        }
        for (int i=0; i > 13; i++){
            if (column3[i] != null){
                valueThree = column3[i];
                index3 = i;
                break;
            }
        }
        for (int i=0; i > 13; i++){
            if (column4[i] != null){
                valueFour = column4[i];
                index4 = i;
                break;
            }
        }

        //get the suit of the card at that column
        suit1 = valueOne.charAt(1);
        suit2 = valueTwo.charAt(1);
        suit3 = valueThree.charAt(1);
        suit4 = valueFour.charAt(1);

        //get the value of each card in the game
        value1 = valueOne.charAt(0);
        value2 = valueTwo.charAt(0);
        value3 = valueThree.charAt(0);
        value4 = valueFour.charAt(0);

        //check to see if the suits match, if they do, remove the lowest card
        if (suit1 == suit2){
            if (value < value2)
                column1[index1] = null;
            else
                column2[index2] = null;
        }
        else if(suit1 == suit3){
            if (value1 < value3)
               column1[index1] = null;
            else
                column3[index3] = null;
        }
        else if(suit1 == suit4){
            if (value1 < value4)
                column1[index1] = null;
            else
                column4[index4] = null;
        }
        else if(suit2 == suit3){
            if (value2 < value3)
                column2[index2] = null;
            else
                column3[index3] = null;
        }
        else if(suit2 == suit4){
            if (value2 < value4)
                column2[index2] = null;
            else
                column4[index4] = null;
        }
        else if(suit3 == suit4){
            if (value3 < value4)
                column3[index3] = null;
            else
                column4[index4] = null;
        }
    }
}
