package me.afua;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner keyboard = new Scanner(System.in);
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Speaker> speakers = new ArrayList<>();
        Event e;
        Speaker s;
         boolean stop=false;
        boolean addanother=true;
        boolean stopspeakers=false;

     do{
         addanother=true;
         stopspeakers=false;
         showMenu();
         System.out.println("Enter a menu number");

         switch(Integer.valueOf(keyboard.nextLine()))
         {
             case 1:
                 do{
                     System.out.println("Add an event");
                     e = addEvent(keyboard.nextLine());
                     events.add(e);
                     System.out.println("Add another event?");
                     if(keyboard.nextLine().equalsIgnoreCase("no"))
                         addanother=false;
                 }while(addanother);
                 break;
             case 2:
                 do{
                     System.out.println("Add a speaker");
                     s = addSpeaker(keyboard.nextLine());
                     speakers.add(s);
                     System.out.println("Add another speaker?");
                     if(keyboard.nextLine().equalsIgnoreCase("no"))
                         addanother=false;
                 }while(addanother);
                 break;
             case 3:
                 System.out.println("Add speaker to event");
                 System.out.println("*** Events ***");
                 showEvents(events);
                 System.out.println("Select event:");
                 String eventName = keyboard.nextLine();
                 Event theEvent = new Event();
                 for(Event eachEvent: events)
                 {
                     if(eachEvent.getTitle().equalsIgnoreCase(eventName))
                         theEvent = eachEvent;
                 }

                 events.remove(theEvent); //Removes the event so it can be added below.
                 System.out.println("*** Speakers ***");
                 showSpeakers(speakers);
                 System.out.println("Enter speaker name:");
                 String speaker = keyboard.nextLine();
                 Speaker theSpeaker = new Speaker();
                 boolean found = false; //Check to see if speaker is in the list
                 for(Speaker eachSpeaker: speakers)
                 {
                     if(eachSpeaker.getName().equalsIgnoreCase(speaker))
                     {
                         theSpeaker = eachSpeaker;
                         found = true;
                     }

                 }
                 if(!found)
                 {
                     System.out.println("Unable to find speaker in list");
                 }
                 else{
                     theEvent.addSpeaker(theSpeaker);
                 }
                 events.add(theEvent); //Adds an event to the arraylist
                 break;
             case 4:
                 System.out.println("Show everything");
                 System.out.println("----------------");
                 System.out.println("*** Speakers ***");
                 for (Speaker sp:speakers
                         ) {
                     System.out.println(sp.getName());

                 }

                 //Speakers
                 System.out.println("*** Events ***");
                 for (Event anEvent:events)
                 {
                     System.out.println(anEvent.getTitle());
                     if(anEvent.getSpeakers().size()>0){ //As long as there are speakers for the event
                         System.out.println("Speakers for "+anEvent.getTitle());
                         System.out.println("**********************************-");
                         for (Speaker eachSpeaker:anEvent.getSpeakers()) {
                             System.out.println(eachSpeaker.getName());
                         }

                     }
                 }
                 break;
         }
         System.out.println("Return to main menu?");
         if(keyboard.nextLine().equalsIgnoreCase("n"))
             stop = true;
     }while(!stop);
    }

    public static Event addEvent(String name)
    {
        Event e = new Event(name);
        return e;

    }


    public static Speaker addSpeaker(String name)
    {
        Speaker s = new Speaker(name);
        return s;
    }

    public static void showMenu()
    {
        System.out.println("1. Add an event");
        System.out.println("2. Add a speaker");
        System.out.println("3. Add a speaker to an event");
        System.out.println("4. Show everything");
    }

    public static void showSpeakers(ArrayList<Speaker> speakers)
    {
        for (Speaker speaker:speakers
             ) {
            System.out.println(speaker.getName());

        }
    }

    public static void showEvents(ArrayList<Event> events)
    {
        for (Event event:events
                ) {
            System.out.println(event.getTitle());

        }
    }

}
