package ru.ac.uniyar.simplex.domain;

public class Row {

    private String[] strings;

    public Row(Integer variables) {
        this.strings = new String[variables];
    }

    public Row(String[] strings) {
        this.strings = strings;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }
}
