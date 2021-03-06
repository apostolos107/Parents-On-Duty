package webapp.database;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eventsgroup database table.
 * 
 */
@Entity
@NamedQuery(name="Eventsgroup.findAll", query="SELECT e FROM Eventsgroup e")
public class Eventsgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//this annotation is for the elastic search key used in repositories
	@org.springframework.data.annotation.Id
	private int idEventsGroup;

	private String name;

	private String type;

	@ManyToOne
	private Organiser organiser;

	private String imagePath;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventsgroup")
	private List<Event> events;

	//bi-directional many-to-one association to Organiser

	private String description;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	private int ageFrom;
	private int ageTo;


	public Eventsgroup() {
	}

	public Eventsgroup(int idEventsGroup, String name, String type, String description, List<Event> events, Organiser organiser) {
		this.idEventsGroup = idEventsGroup;
		this.name = name;
		this.type = type;
		this.description = description;
		this.events = events;
		this.organiser = organiser;
	}

	public int getIdEventsGroup() {
		return this.idEventsGroup;
	}

	public void setIdEventsGroup(int idEventsGroup) {
		this.idEventsGroup = idEventsGroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEventsgroup(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventsgroup(null);

		return event;
	}

	public Organiser getOrganiser() {
		return this.organiser;
	}

	public void setOrganiser(Organiser organiser) {
		this.organiser = organiser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}