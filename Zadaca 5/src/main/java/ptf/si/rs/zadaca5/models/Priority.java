package ptf.si.rs.zadaca5.models;

public enum Priority {
    LOW("Nisko"),
    MEDIUM("Srednje"),
    HIGH("Visoko"),
    URGENT("Hitno");

    private final String name;

    Priority(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
