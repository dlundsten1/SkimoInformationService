package se.lundsten.controller;

import se.lundsten.model.Race;

import java.time.Duration;

public class ResultController {

    public static Race race(){
        Race race = new Race(1,2700, 15267, 1, 50);
        race.setVerticalPerMinute(race.getVerticals()/(race.getDuration()/(double)60));
        race.setDistanceVerticalRatio(race.getDistance()/race.getVerticals());
        System.out.println(race.getDistanceVerticalRatio());
        race.setName("David Lundsten");
        race.setDistance(28500);


        System.out.println("Ny ranking uträknad på "+race.getName()+" på tävling: "+race.getRaceID()+". Vertikala meter per minut var: "+race.getVerticalPerMinute()+", distans: "+race.getDistance()+" meter, höjdmeter: "+race.getVerticals()+" och tävlingens rank (0-100): "+race.getRaceRank());


    return null;
    }
}
