package com.epam.knight.view;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;

import java.util.Scanner;

public class ConsoleView {
    private static final Scanner SCANNER = new Scanner(System.in);

    @SuppressWarnings("checkstyle:MultipleStringLiterals")
    public static void printMenu() {
        System.out.println("Main menu:\n"
                + "1. Print knight stats\n"
                + "2. Show ammunition\n"
                + "3. Equip ammunition\n"
                + "4. Sort ammunition\n"
                + "5. Search ammunition\n"
                + "6. Exit\n"
                + "Choose option:");
    }

    public static int scanMenu() {
        return SCANNER.nextInt();
    }

    public void showAmmunition(final Ammunition[] ammunition) {
        for (int i = 0; i < ammunition.length; i++) {
            System.out.println(ammunition[i].getClass().getSimpleName() + "{"
                    + ammunition[i].getTypeAmmunition()
                    + "=" + ammunition[i].getValueProperty()
                    + ", weight=" + ammunition[i].getWeight()
                    + ", cost=" + ammunition[i].getCost() + "}"
            );
        }
    }

    public void printStats(final Knight knight) {
        System.out.printf("Ammunition cost: %d%nAmmunition weight: %d%n"
                + "Ammunition damage: %d%nAmmunition protection: %d%n",
                knight.getCost(), knight.getWeight(),
                knight.getDamage(), knight.getProtection()
        );
    }

    public int scanExtraChoice() {
        AmmunitionType[] types = AmmunitionType.values();
        int choiceFromExtraMenu;
        System.out.println("What kind of ammunition do you want to equip?");
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i]);
        }
        System.out.println("Choose option:");
        choiceFromExtraMenu = scanMenu();
        return choiceFromExtraMenu;
    }

    public int[] scanStats(AmmunitionType type) {
        final int amountStats = 3;
        final int indexCost = 2;
        final int indexWeight = 1;
        final String strInput = "Input ";
        int[] stats = new int[amountStats];
        System.out.println(strInput
                + type + " weight:");
        stats[indexWeight] = scanMenu();
        System.out.println(strInput
                + type + " cost:");
        stats[indexCost] = scanMenu();
        if (AmmunitionType.HELMET == type) {
            System.out.println(strInput
                    + type + " protection:");
        } else {
            System.out.println(strInput
                    + type + " damage:");
        }
        stats[0] = scanMenu();
        return stats;
    }

    public int printMenuSortAmmunition() {
        int userChoice;
        System.out.print("Choose sort type:\n1. Cost\n2."
                + " Weight\nChoose option:");
        userChoice = scanMenu();
        return userChoice;
    }

    public void printSearchAmmunition(Ammunition[] ammunition) {
        for (Ammunition item : ammunition) {
            System.out.printf("%s{%s=%d, weight=%d, cost=%d}%n",
                    item.getClass().getSimpleName(),
                    item.getTypeAmmunition(),
                    item.getValueProperty(),
                    item.getWeight(),
                    item.getCost());
        }
    }

    public int menuSearchAmmunition() {
        int userChoice;
        System.out.println("Choose search field:"
                + "\n1. Cost\n2. Weight\nChoose option:");
        userChoice = scanMenu();
        return  userChoice;
    }

    public  int scanMinValueForSearch(int userChoice) {
        int min;
        if (userChoice == 1) {
            System.out.println("Input minimum cost:");
        } else {
            System.out.println("Input minimum weight:");
        }
        min = scanMenu();
        return min;
    }

    public int scanMaxValueForSearch(int userChoice) {
        int max;
        if (userChoice == 1) {
            System.out.println("Input maximum cost:");
        } else {
            System.out.println("Input maximum weight:");
        }
        max = scanMenu();
        return max;
    }


    public void printExit() {
        System.out.println("Bye!");
    }
}
