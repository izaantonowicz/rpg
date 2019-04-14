package places;

public interface Place {
    PlaceEventOutput doSomething(PlaceEventInput input);
    String getEventDescription();
    PlaceType getType();
}
