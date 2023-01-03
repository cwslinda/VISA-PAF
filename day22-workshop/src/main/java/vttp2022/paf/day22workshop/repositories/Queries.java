package vttp2022.paf.day22workshop.repositories;

public class Queries {

    public static final String SQL_SELECT_RSVPS = "select * from rsvp";

    public static final String SQL_SELECT_RSVP_BY_NAME = "select * from rsvp where guest_name like ?";

    public static final String SQL_SELECT_RSVP_BY_EMAIL = "select * from rsvp where email like ?";

    public static final String SQL_INSERT_NEW_RSVP = 
        "insert into rsvp(guest_name, email, phone, confirmation_date, comments)" +
        "values(?,?,?,?,?)";

    public static final String SQL_UPDATE_RSVP = 
        "update rsvp set guest_name = ?, phone = ?, confirmation_date = ?, comments = ? where email = ?";

}
