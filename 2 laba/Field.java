package org.example;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Modificator> modificaters;
    private String name;
    private Type type;
    private String value;
    private String endOfString;

    public Field(List<Modificator> modificaters, String name, Type type, String value, String endOfString) {
        this.modificaters = modificaters;
        this.name = name;
        this.type = type;
        this.value = value;
        this.endOfString = endOfString;
    }

    public static class Builder {
        private List<Modificator> modificaters = new ArrayList<>();
        private String name;
        private Type type;
        private String value = "";
        private String endOfString = ";";

        public Builder setModificaters(List<Modificator> modificaters) {
            this.modificaters = modificaters;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder endOf(String s) {
            this.endOfString = s;
            return this;
        }

        public Field build() {
            return new Field(modificaters, name, type, value, endOfString);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String symbol = validate(type);

        for (Modificator m : modificaters) {
            str.append(m.getValue()).append(" ");
        }
        str.append(type.getValue()).append(" ").append(name);
        if (!value.isEmpty()) {
            str.append(" = ").append(symbol).append(value).append(symbol).append(endOfString);
        } else {
            str.append(endOfString);
        }

        return str.toString();
    }

    private String validate(Type type) {
        return switch (type) {
            case STRING -> "\"";
            case CHAR -> "'";
            default -> "";
        };
    }
}