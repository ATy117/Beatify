package view_builders;

public class Director {
    private static Director ourInstance = new Director();

    private Builder builder;

    private Director() {
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.build();
    }

    public static Director getInstance() {
        return ourInstance;
    }
}
