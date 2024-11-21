package com.example.cocktails.model.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.io.*;
import java.util.*;

@Entity
@Table(name = "instructions")
@XmlRootElement(name = "instruction")
public class Instruction implements Serializable {

    @EmbeddedId
    private InstructionKey key;

    @Column(name = "amount_cl")
    @XmlAttribute(name = "cl")
    private Integer amountCL;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
    @XmlIDREF
    @XmlAttribute(name = "ingredient")
    private Ingredient ingredient;

    protected Instruction() {
        // empty
    }

    public Instruction(InstructionKey key, Integer amountCL, Ingredient ingredient) {
        this.key = key;
        this.amountCL = amountCL;
        this.ingredient = ingredient;
    }

    public Integer getAmountCL() {
        return amountCL;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (amountCL != null) {
            sb.append(amountCL);
            sb.append("cl ");
        }
        sb.append(ingredient.getName());

        return sb.toString();
    }

    public void setKey(InstructionKey key) {
        this.key = key;
    }

}