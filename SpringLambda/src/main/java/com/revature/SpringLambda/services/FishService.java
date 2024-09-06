package com.revature.SpringLambda.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FishService {

    public List<String> getFish(){

        //...pretend we called a DAO method here or something
        List<String> fish = new ArrayList<>();

        fish.add("Salmon");
        fish.add("Tilapia");
        fish.add("Cod");
        fish.add("Butterfish");
        fish.add("Tuna");
        fish.add("Swordfish");
        fish.add("Koi");

        return fish;

    }

    public String insertFish(String fish){

        String result = "Added " + fish + " to the database that definitely exists!";

        System.out.println(result);

        return result;

    }

}
