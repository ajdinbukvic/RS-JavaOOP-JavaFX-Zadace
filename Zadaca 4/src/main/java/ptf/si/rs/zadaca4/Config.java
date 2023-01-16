package ptf.si.rs.zadaca4;

import ptf.si.rs.zadaca4.models.Ticket;
import ptf.si.rs.zadaca4.repository.CRUDRepository;
import ptf.si.rs.zadaca4.repository.MapRepository;

public class Config {
    public static final CRUDRepository<Ticket> tickets = new MapRepository<>();
}
