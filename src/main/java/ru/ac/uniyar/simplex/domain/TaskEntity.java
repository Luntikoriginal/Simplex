package ru.ac.uniyar.simplex.domain;

import java.util.ArrayList;

public class TaskEntity {

    private Fraction[][] matrix;

    private ArrayList<Integer> bases;

    public TaskEntity() {
        this.matrix = null;
        this.bases = null;
    }

    public TaskEntity(Fraction[][] matrix, ArrayList<Integer> bases) {
        this.matrix = matrix;
        this.bases = bases;
    }

    public Fraction[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Fraction[][] matrix) {
        this.matrix = matrix;
    }

    public ArrayList<Integer> getBases() {
        return bases;
    }

    public void setBases(ArrayList<Integer> bases) {
        this.bases = bases;
    }
}
