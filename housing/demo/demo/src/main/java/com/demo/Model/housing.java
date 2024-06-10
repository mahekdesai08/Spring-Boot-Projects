package com.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name="housing")
public class housing {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Bedrooms")
    private int bedrooms;

    @Column(name = "Bathrooms")
    private double  bathrooms;

    @Column(name="SquareFootage")
    private int squarefootage;

    @Column(name = "Location")
    private char location;

    @Column(name="salePrice")
    private int sale_price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getSquarefootage() {
        return squarefootage;
    }

    public void setSquarefootage(int squarefootage) {
        this.squarefootage = squarefootage;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }

    public int getSaleprice() {
        return sale_price;
    }

    public void setSaleprice(int saleprice) {
        this.sale_price = saleprice;
    }

    public housing(int id, int bedrooms, double bathrooms, int squarefootage, char location, int sale_price) {
        this.id = id;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.squarefootage = squarefootage;
        this.location = location;
        this.sale_price = sale_price;
    }
}
