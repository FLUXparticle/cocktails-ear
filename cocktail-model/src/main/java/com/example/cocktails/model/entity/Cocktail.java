package com.example.cocktails.model.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cocktails")
@XmlRootElement(name = "cocktail")
public class Cocktail implements Comparable<Cocktail>, Serializable {

    @Id
    @Column(name = "cocktail_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @Column(name = "name")
    @XmlAttribute
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cocktail_id")
    @XmlElement(name = "instruction")
    private Collection<Instruction> instructions;

    protected Cocktail() {
        // Required by JAXB
    }

    public Cocktail(String name, List<Instruction> instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public Cocktail(Long id, String name, Collection<Instruction> instructions) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        out.printf("%d) %s", id, name);
//        getInstructions().forEach(out::println);

        return sw.toString();
    }

    @Override
    public int compareTo(Cocktail other) {
        return name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktail cocktail = (Cocktail) o;
        return id.equals(cocktail.id) && name.equals(cocktail.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Instruction> getInstructions() {
        return instructions;
    }

}