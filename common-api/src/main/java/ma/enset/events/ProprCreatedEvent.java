package ma.enset.events;

import lombok.Getter;

import java.util.Date;

public class ProprCreatedEvent extends BaseEvent<String> {
    @Getter public String name;
    @Getter public Date dateOfBirth;
    @Getter public String email;

    public ProprCreatedEvent(String id, String name, Date dateOfBirth, String email) {
        super(id);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
}
