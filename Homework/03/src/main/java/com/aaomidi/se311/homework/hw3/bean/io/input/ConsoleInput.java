package com.aaomidi.se311.homework.hw3.bean.io.input;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;
import com.aaomidi.se311.homework.hw3.bean.io.Event;
import com.aaomidi.se311.homework.hw3.bean.io.actions.AddEvent;
import com.aaomidi.se311.homework.hw3.bean.io.actions.DeleteEvent;
import com.aaomidi.se311.homework.hw3.bean.io.actions.PrintEvent;
import com.aaomidi.se311.homework.hw3.bean.io.actions.QuitEvent;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleInput implements Input {
    private final InputStream input = System.in;
    private final List<Event> events = new LinkedList<>();
    private LineStorage lineStorage;

    @Override
    public Stream<String> getInput() {
        Scanner scanner = new Scanner(input);
        while (true) {
            System.out.print("Add, Delete, Print, Quit: ");
            String str = scanner.nextLine();
            events.forEach(a -> a.handle(str));
        }
    }

    public void registerActions(MasterControl masterControl) {
        lineStorage = new LineStorage();
        events.add(new AddEvent(masterControl, lineStorage));
        events.add(new PrintEvent(masterControl, lineStorage));
        events.add(new DeleteEvent(masterControl, lineStorage));
        events.add(new QuitEvent(masterControl, lineStorage));
    }
}
