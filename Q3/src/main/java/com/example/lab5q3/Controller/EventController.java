package com.example.lab5q3.Controller;

import com.example.lab5q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/lab5/q3")
public class EventController {
    ArrayList<Event> events = new ArrayList<Event>();

    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        events.add(event);
        return "event added";
    }

    @GetMapping("/displayAll")
    public ArrayList<Event> displayAllEvents() {
        return events;
    }

    @PutMapping("/update/{index}")
    public String updateEvent(@PathVariable int index, @RequestBody Event event) {
        if (index < events.size()) {
            events.set(index, event);
            return "event updated";
        }
        return "event not found";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteEvent(@PathVariable int index) {
        if (index < events.size()) {
            events.remove(index);
            return "event deleted";
        }
        return "event not found";
    }

    @PutMapping("/changeCapacity/{index}/{newCapacity}")
    public String changeCapacity(@PathVariable int index, @PathVariable int newCapacity) {
        if (index < events.size()) {
            events.get(index).setCapacity(newCapacity);
            return "event updated";
        }
        return "event not found";
    }

    @GetMapping("/eventById/{id}")
    public Event getEventById(@PathVariable int id) {
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }
}
