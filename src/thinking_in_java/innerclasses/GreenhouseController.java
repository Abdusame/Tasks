package thinking_in_java.innerclasses;

import thinking_in_java.innerclasses.controller.Event;

/**
 *
 * */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(6),
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(
                    new Integer(args[0])));
            gc.run();
        }
    }
}
