package sevenbits.RougelikeGame.Main;

import sevenbits.RougelikeGame.Exceptions.ContainerSpaceException;
import sevenbits.RougelikeGame.GameObjects.*;
import sevenbits.RougelikeGame.GameObjects.Characters.Monster;
import sevenbits.RougelikeGame.GameObjects.Characters.Player;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IGameContainer;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(1,1,10,2);
        Monster monster = new Monster(4,4,20,1);
        Chest chest = new Chest(2,2,12);
        IGameContainer playerInventory = player.getCharacterContainer();
        IGameContainer monsterInventory = monster.getCharacterContainer();
        System.out.println(monster.toString());
        System.out.println(player.toString());
        System.out.println(chest.toString());
        try {
            playerInventory.moveItemIntoContainer(chest.getItemFromContainer(0),
                    playerInventory.getSize() - playerInventory.getEmptySlots());
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }
        System.out.println(player.toString());
        System.out.println(chest.toString());
        try {
            monsterInventory.moveItemIntoContainer(playerInventory.getItemFromContainer(0),
                    monsterInventory.getSize() - monsterInventory.getEmptySlots());
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }

        System.out.println(monster.toString());
        System.out.println(player.toString());

        try {
            monsterInventory.moveItemIntoContainer(chest.getItemFromContainer(1),
                    monsterInventory.getSize() - monsterInventory.getEmptySlots());
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }

        System.out.println(monsterInventory.toString());
        System.out.println(chest.toString());

        try {
            chest.moveItemIntoContainer(monsterInventory.getItemFromContainer(0),
                    chest.getSize() - chest.getEmptySlots());
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }

        System.out.println(monsterInventory.toString());
        System.out.println(chest.toString());

        try {
            chest.moveItemIntoContainer(playerInventory.getItemFromContainer(0),
                    chest.getSize() - chest.getEmptySlots());
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }

        System.out.println(playerInventory.toString());
        System.out.println(chest.toString());

    }
}
