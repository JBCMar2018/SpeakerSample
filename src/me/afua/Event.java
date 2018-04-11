package me.afua;

import java.util.ArrayList;

public class Event {
    private String title;
    ArrayList <Speaker> speakers;

    public Event() {
        speakers = new ArrayList<>();
    }

    public Event(String title) {
        this.title = title;
        speakers = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(ArrayList<Speaker> speakers) {
        this.speakers = speakers;
    }

    public void addSpeaker(Speaker s)
    {
        this.speakers.add(s);
    }
}
