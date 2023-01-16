package ptf.si.rs.zadaca4.models;

public enum Service {
    QUESTION("Pitanje"),
    INCIDENT("Incident"),
    PROBLEM("Problem"),
    CHANGE_REQUEST("Zahtjev za promjenom");

    private final String name;

    Service(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
