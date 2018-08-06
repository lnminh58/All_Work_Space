/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session03;

/**
 *
 * @author ndt
 */
public class session03_enumerations {
    enum Direction {
        East, West, North, South
}
    public static void main(String[] args) {
        Direction direction;
// Instantiate the enum Direction
        direction = Direction.East;
// Prints the value of enum
        System.out.println("Value: " + direction);
        if(direction!=Direction.North){
            System.out.println("Not North");
        }
        else{
            System.out.println("North");
        }
        switch(direction){
            case East:
                System.out.println("East");
                break;
            default:
                System.out.println("Not East");
        }
    }
}
