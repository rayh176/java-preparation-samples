package org.example.patterns;

public class LocalStringBuilder {
    String name;
    int size = 0;
    boolean type;

    public StringAnimal build() {
        return new StringAnimal(name, size, type);
    }

    public LocalStringBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public LocalStringBuilder withSize(int size) {
        this.size = size;
        return this;
    }

    public LocalStringBuilder withType(boolean type) {
        this.type = type;
        return this;
    }
}

class StringAnimal {

    private final String name;
    private final int size;
    private final boolean type;

    public StringAnimal(String name, int size, boolean type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }
}
