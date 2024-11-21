package com.example.cocktails.model.entity;

import com.example.cocktails.model.util.*;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "ingredients")
@XmlRootElement(name = "ingredient")
public class Ingredient implements Comparable<Ingredient>, Serializable {

    @Id
    @Column(name = "ingredient_id")
    @XmlJavaTypeAdapter(LongXmlAdapter.class)
    @XmlAttribute
    @XmlID
    private Long id;

    @Column(name = "name")
    @XmlAttribute
    private String name;

    protected Ingredient() {
        // empty
    }

    public Ingredient(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Ingredient other) {
        return name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}