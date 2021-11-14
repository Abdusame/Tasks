package thinking_in_java.innerclasses.controller;
import java.util.*;

/**
 * Глава 11. Коллекции объектов. Итераторы. 13.
 * В примере innerclasses/GreenhouseController.java класс Controller использует ArrayList.
 * Измените код так, чтобы в нем использовался класс LinkedList,
 * и организуйте перебор множества событий с использованием Iterator.
 * */
public class Controller {
    // A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        while(eventList.size() > 0) {
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            List<Event> events = new LinkedList<>(eventList);
            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event e = iterator.next();
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
            /*for(Event e : new LinkedList<Event>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }*/
        }
    }
}
