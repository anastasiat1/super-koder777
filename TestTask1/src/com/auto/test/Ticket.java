package com.auto.test;
public class Ticket {
    private final int id;
    private final String question;

    public Ticket(int id, String question) {
        this.id = id;
        this.question = question;
    }

    @Override
    public String toString() {
        return "№" + id + " (" + question + ")";
    }
}
