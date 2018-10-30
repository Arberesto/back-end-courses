package sevenbits.RougelikeGame.Main;

import sevenbits.RougelikeGame.Exceptions.ContainerOverloadException;
import sevenbits.RougelikeGame.GameObjects.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Monster monster = new Monster();
        Chest chest = new Chest();
        IGameContainer playerInventory = player.getCharacterContainer();
        IGameContainer monsterInventory = monster.getCharacterContainer();
        System.out.println(monsterInventory.toString());
        System.out.println(playerInventory.toString());
        System.out.println(chest.toString());
        try {
            playerInventory.moveItemIntoContainer(chest.getItemFromContainer(0), playerInventory.getSize() - playerInventory.getEmptySlots());
        }
        catch(ContainerOverloadException e){
            System.out.println(e.getMessage());
        }
        System.out.println(playerInventory.toString());
        System.out.println(chest.toString());
        try {
            monsterInventory.moveItemIntoContainer(playerInventory.getItemFromContainer(0), monsterInventory.getSize() - monsterInventory.getEmptySlots());
        }
        catch(ContainerOverloadException e){
            System.out.println(e.getMessage());
        }

        System.out.println(monsterInventory.toString());
        System.out.println(playerInventory.toString());

        try {
            monsterInventory.moveItemIntoContainer(chest.getItemFromContainer(1), monsterInventory.getSize() - monsterInventory.getEmptySlots());
        }
        catch(ContainerOverloadException e){
            System.out.println(e.getMessage());
        }

        System.out.println(monsterInventory.toString());
        System.out.println(chest.toString());

        try {
            chest.moveItemIntoContainer(monsterInventory.getItemFromContainer(0),chest.getSize() - chest.getEmptySlots());
        }
        catch(ContainerOverloadException e){
            System.out.println(e.getMessage());
        }

        System.out.println(monsterInventory.toString());
        System.out.println(chest.toString());

        try {
            chest.moveItemIntoContainer(playerInventory.getItemFromContainer(0),chest.getSize() - chest.getEmptySlots());
        }
        catch(ContainerOverloadException e){
            System.out.println(e.getMessage());
        }

        System.out.println(playerInventory.toString());
        System.out.println(chest.toString());

    }
}
