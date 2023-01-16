package ptf.si.rs.zadaca5.models;

public enum Method {
    EMAIL("Email"),
    PHONE("Telefon"),
    WEB_PAGE("Web stranica");

    private final String name;

    Method(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
