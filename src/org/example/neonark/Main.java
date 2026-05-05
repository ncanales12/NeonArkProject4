package org.example.neonark;

import org.example.neonark.menu.MainMenu;

/*
 This is the main entry point for the program.
 It just starts the menu system.
 Nothing complicated happens here.
*/
public class Main {

    public static void main(String[] args) {

        // create menu and start the app
        MainMenu menu = new MainMenu();
        menu.start();
    }
}