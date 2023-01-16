package ptf.si.rs.zadaca4.models;

public enum Status {
    NEW("Novi"),
    OPENED("Otvoren"),
    PENDING("Na čekanju"),
    RESOLVED("Riješen"),
    CLOSED("Zatvoren"),
    WAITING_CUSTOMER("Čeka kupca"),
    WAITINTG_THIRD_PARTY("Čeka treću stranu");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
