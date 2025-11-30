package com.app.footballapispring.domain.player;

public class Player {

    private String id;
    private String name;
    private int age;
    private String position;
    private String nationality;
    private String photo;

    public Player(String id, String name, int age, String position, String nationality, String photo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.photo = photo;
    }

    public Player(String name, int age, String position, String nationality, String photo) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.nationality = nationality;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPhoto() {
        return photo;
    }

}
