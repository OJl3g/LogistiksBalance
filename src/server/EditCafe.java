package server;

import entity.Cafe;
import entity.Route;

import java.util.ArrayList;
import java.util.Scanner;

public class EditCafe {

    private Scanner scanner = new Scanner(System.in);

    public void getAllInfo(Cafe[] cafes) {
        System.out.println("1 - Добавить маршрут");
        System.out.println("2 - Удалить маршрут");
        System.out.println("3 - Редактировать кафе");
        String answer = scanner.nextLine();


        switch (answer) {
            case "1" -> {
                addCafe(cafes);
            }

            case "2" -> {
                deleteCafe(cafes);
            }

            case "3" -> {
                editCafeInfo(cafes);
            }

        }
    }

    public void deleteCafe(Cafe[] cafes) {
        printListCafes(cafes);
        System.out.println("Какое кафе требуется удалить?");
        String cafe = scanner.nextLine();

        for (int i = 0; i < cafes.length; i++) {
            if (cafes[i].getName().equals(cafe)) {
                cafes[i] = null;
                System.out.println("Кафе было удалено");
                return;
            }
        }

        System.out.println("Такое кафе не найдено");

    }

    public void editCafeInfo(Cafe[] cafes) {
        printListCafes(cafes);

        System.out.println("Какое кафе требуется редактировать?");
        String cafe = scanner.nextLine();

        for (int i = 0; i < cafes.length; i++) {
            if (cafes[i] != null) {
                if (cafes[i].getName().equals(cafe)) {

                    System.out.println("кафе найденно");
                    printInfoCafe(cafes[i]);
                    editCafe(cafes[i]);
                }
            }
        }
    }


    private Cafe editCafe(Cafe cafe) {
        while (true) {
            System.out.println("Что именно нужно изменить?");
            int number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 1 -> {
                    System.out.println("ввдите новое название");
                    cafe.setName(scanner.nextLine());
                }

                case 2 -> {
                    System.out.println("ввдите новое адрес");
                    cafe.setAddress(scanner.nextLine());
                }

                case 3 -> {
                    cafe.setCoffeeMachine(examinationAnswer("Есть ли кофемашина?"));
                }

                case 4 -> {
                    System.out.println("Введите время загрузки кафе в формате 08,00(пример)");
                    cafe.setLoadingTime(scanner.nextDouble());
                }
            }

            if (!examinationAnswer("Продолжить редактирование?")) {
                return cafe;
            }

        }
    }

    public Cafe[] addCafe(Cafe[] cafes) {
        while (true) {
            System.out.println("Ведите название кафе");
            String name = scanner.nextLine();

            System.out.println("Введите адрес кафе");
            String address = scanner.nextLine();


            boolean coffeeMachine = examinationAnswer("Имеется ли кофемашина в кафе?");

            System.out.println("Какое время загрузки кафе?");
            double loadingTime = scanner.nextDouble();
            scanner.nextLine();

            Cafe cafe = new Cafe(address, name, coffeeMachine, loadingTime);

            for (int i = 0; i < cafes.length; i++) {
                if (cafes[i] == null) {
                    cafes[i] = cafe;
                    break;
                }


            }

            if (!examinationAnswer("Добавить еще кафе?")) {
                break;
            }

        }
        return cafes;
    }

    public boolean examinationAnswer(String text) {
        System.out.println(text);
        System.out.println("1 да");
        System.out.println("2 нет");
        String result = scanner.nextLine();
        return result.equals("1");

    }

    private void printInfoCafe(Cafe cafe) {
        int n = 1;
        System.out.println(n++ + " cafe name " + cafe.getName());
        System.out.println(n++ + " cafe Address " + cafe.getAddress());
        System.out.println(n++ + " cafe LoadingTime " + cafe.getLoadingTime());
        System.out.println(n++ + " cafe CoffeeMachine " + (cafe.isCoffeeMachine() ? "есть" : "нету"));
        System.out.println("\n\n");
    }

    public void printListRoute(ArrayList<Route> routeArrayList) {
        for (Route route : routeArrayList) {
            System.out.println("----- Маршрут " + route.getNameRoute() + "--------");
            System.out.println("Водитель -----------");
            System.out.println("имя " + route.getFreightForwarder().getName());
            System.out.println("фамилия " + route.getFreightForwarder().getSurname());
            System.out.println("модель авто " + route.getFreightForwarder().getModelAuto());
            System.out.println("Refrigerator " + answer(route.getFreightForwarder().isRefrigerator()));
            System.out.println("MedicalBook " + answer(route.getFreightForwarder().isMedicalBook()));
            System.out.println("SanitationOfTheBody " + answer(route.getFreightForwarder().isSanitationOfTheBody()));
            System.out.println("");

            printListCafes(route.getCafes());

        }
    }

    public String answer(boolean b) {
        return b ? "есть" : "нету";
    }

    private void printListCafes(final Cafe[] cafes) {
        System.out.println("------Список Точек-------");
        for (Cafe cafe : cafes) {
            if (cafe != null) {
                printInfoCafe(cafe);
            }
        }
        System.out.println("************************************\n\n\n");
    }


}
