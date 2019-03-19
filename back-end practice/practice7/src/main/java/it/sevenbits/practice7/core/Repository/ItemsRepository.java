package it.sevenbits.practice7.core.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ItemsRepository {

    private HashMap<String,Item> repository;

    public ItemsRepository() {
        repository = new HashMap<>();
    }

    public Item create(String newItem) {
        if (newItem == null) {
            return null;
        }
        Item createdItem = new Item(getNewID(),newItem);
        repository.put(createdItem.getId(),createdItem);
        return createdItem;
    }

    public ArrayList<Item> getAllTasks() {
        ArrayList<Item> tasksList = new ArrayList<>();
        for (String id :repository.keySet()){
            tasksList.add(repository.getOrDefault(id, new Item("null","null")));
        }
        return tasksList;
    }

    public String getNewID() {
        return UUID.randomUUID().toString();
    }
}
