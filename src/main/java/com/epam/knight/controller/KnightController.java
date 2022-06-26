package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.view.ConsoleView;

/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {
    private static final int PRINT_STATS = 1;
    private static final int SHOW_AMMUNITION = 2;
    private static final int EQUIP_AMMUNITION = 3;
    private static final int SORT_AMMUNITION = 4;
    private static final int SEARCH_AMMUNITION = 5;
    private static final int EXIT = 6;
    private final KnightGenerator generatorKnight = new KnightGenerator();
    private Knight knight = generatorKnight.generateKnight();
    private final ConsoleView consoleView = new ConsoleView();
    private final KnightAmmunitionManager manager = new KnightAmmunitionManager(knight);

    private void equipAmmunition(int choiceExtraMenu, AmmunitionGenerator generator) {
        AmmunitionType[] types = AmmunitionType.values();
        AmmunitionType type = types[choiceExtraMenu - 1];
        int[] stats = consoleView.scanStats(type);
        manager.equipAmmunitionToKnight(generator.generateAmmunition(type, stats));
    }

    private void searchAmmunition(int choiceExtraMenu) {
        Ammunition[] ammunition =  manager.searchAmmunition(
                consoleView.scanMinValueForSearch(choiceExtraMenu),
                consoleView.scanMaxValueForSearch(choiceExtraMenu),
                choiceExtraMenu);
        consoleView.printSearchAmmunition(ammunition);
    }

    public void startMenu() {
        int userChoice = 0;
        int choiceExtraMenu;
        AmmunitionGenerator generator = new AmmunitionGenerator();

        manager.updateStats();
        while (userChoice != EXIT) {
            ConsoleView.printMenu();
            userChoice = ConsoleView.scanMenu();

            switch (userChoice) {
                case PRINT_STATS:
                    consoleView.printStats(knight);
                    break;
                case SHOW_AMMUNITION:
                    consoleView.showAmmunition(knight.getAmmunition());
                    break;
                case EQUIP_AMMUNITION:
                    choiceExtraMenu = consoleView.scanExtraChoice();
                    equipAmmunition(choiceExtraMenu, generator);
                    break;
                case SORT_AMMUNITION:
                    choiceExtraMenu = consoleView.printMenuSortAmmunition();
                    manager.sortAmmunition(choiceExtraMenu);
                    break;
                case SEARCH_AMMUNITION:
                    choiceExtraMenu = consoleView.menuSearchAmmunition();
                    searchAmmunition(choiceExtraMenu);
                    break;
                default:
                    break;
            }
        }
        consoleView.printExit();
    }
}
