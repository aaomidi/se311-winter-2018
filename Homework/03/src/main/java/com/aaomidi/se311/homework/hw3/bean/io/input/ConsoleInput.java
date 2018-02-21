package com.aaomidi.se311.homework.hw3.bean.io.input;

import com.aaomidi.se311.homework.hw3.MasterControl;
import com.aaomidi.se311.homework.hw3.bean.LineStorage;
import com.aaomidi.se311.homework.hw3.bean.io.Action;
import com.aaomidi.se311.homework.hw3.bean.io.actions.AddAction;
import com.aaomidi.se311.homework.hw3.bean.io.actions.DeleteAction;
import com.aaomidi.se311.homework.hw3.bean.io.actions.PrintAction;
import com.aaomidi.se311.homework.hw3.bean.io.actions.QuitAction;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleInput implements Input {
    private final InputStream input = System.in;
    private final List<Action> actions = new LinkedList<>();
    private LineStorage lineStorage;

    @Override
    public Stream<String> getInput() {
        Scanner scanner = new Scanner(input);
        while (true) {
            System.out.print("Add, Delete, Print, Quit: ");
            String str = scanner.nextLine();
            actions.forEach(a -> a.handle(str));
        }
    }

    public void registerActions(MasterControl masterControl) {
        lineStorage = new LineStorage();
        actions.add(new AddAction(masterControl, lineStorage));
        actions.add(new PrintAction(masterControl, lineStorage));
        actions.add(new DeleteAction(masterControl, lineStorage));
        actions.add(new QuitAction(masterControl, lineStorage));
    }
}
