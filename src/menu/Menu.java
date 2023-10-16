package menu;

import server.EditCafe;
import entity.Cafe;
import entity.FreightForwarder;
import entity.Route;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static ArrayList<Route> routeArrayList = new ArrayList<>();
    private EditCafe editCafe = new EditCafe();

    private static Scanner scanner = new Scanner(System.in);

    public void firstStart() {
        initializingRoutes();
        while (true) {
            System.out.println("1 Список Маршрутов");
            System.out.println("2 Добавить Маршрут");
            System.out.println("3 Редактировать Маршрут");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> {
                    editCafe.printListRoute(routeArrayList);
                }
                case "2" -> {
                    addRoute();

                }
                case "3" -> {
                    editRoute();

                }

            }
        }

    }


    public void addRoute() {
        System.out.println("Введите название маршрута");
        String nameRoute = scanner.nextLine();

        FreightForwarder freightForwarder = createFreightForwarder();


        Cafe[] cafes = new Cafe[50];

        if (editCafe.examinationAnswer("Хотите ли сразу добавить  Магазины для этого маршрута")) {
            System.out.println("добавление точек");
            cafes = editCafe.addCafe(cafes);


        }
        Route route = new Route(nameRoute, freightForwarder, cafes);
        routeArrayList.add(route);

    }

    public FreightForwarder createFreightForwarder() {
        System.out.println("ведите имя экспедитора");
        String name = scanner.nextLine();

        System.out.println("Введите фамилия экспедитора");
        String surname = scanner.nextLine();

        System.out.println("Введите модель авто экспедитора");
        String modelAuto = scanner.nextLine();


        boolean refrigerator = editCafe.examinationAnswer("Имеется ли у авто рефрижератор ? ");
        boolean medicalBook = editCafe.examinationAnswer("Имеется ли у экспедитора мед.книга?");
        boolean sanitationOfTheBody = editCafe.examinationAnswer("Имеется ли у экспедитора сан.обработка?");

        return new FreightForwarder(name, surname, modelAuto, refrigerator, medicalBook, sanitationOfTheBody);

    }


    public void printRoute() {
        System.out.println("Список мартшрутов");
        for (Route route : routeArrayList) {
            System.out.println(route.getNameRoute());
        }

    }

    public void editRoute() {
        printRoute();

        System.out.println("введите название маршрута котрый хотите редактировать");
        String name = scanner.nextLine();

        boolean b = false;
        Route route = null;
        for (Route r : routeArrayList) {
            if (r.getNameRoute().equals(name)) {
                b = true;
                route = r;

            }
        }

        if (b == false) {
            System.out.println("маршрут не найден ");
            return;
        }

        System.out.println("что необходимо изменить?");
        System.out.println("1 - изменить экспедитора");
        System.out.println("2 - изменить название маршрута");
        System.out.println("3 - редактировать сиписок кафе");

        String answer = scanner.nextLine();

        switch (answer) {
            case "1" -> {
                System.out.println(route.getFreightForwarder());
                FreightForwarder freightForwarder = createFreightForwarder();
                route.setFreightForwarder(freightForwarder);
                System.out.println("вы успешно заменили водителя");
                return;
            }
            case "2" -> {
                System.out.println("Введите новое название" + route.getNameRoute());
                String name1 = scanner.nextLine();
                route.setNameRoute(name1);
                System.out.println("Вы изменили название");


            }
            case "3" -> {
                editCafe.getAllInfo(route.getCafes());

            }

        }

    }

    public  void initializingRoutes() {
        FreightForwarder freightForwarder = new FreightForwarder("Дмитрий", "Любицкий", "Ford",
                true, true, true);
        Cafe cafe = new Cafe("Химки 24", "ФМлог", true , 08.00);
        Cafe cafe1 = new Cafe("Химки 44", "Ферронордик", false , 06.00);
        Cafe cafe2 = new Cafe("Химки 56", "Икеа", true , 02.00);
        Cafe cafe3 = new Cafe("Химки 77", "Элвис", false , 03.30);
        Cafe[] cafes = {cafe, cafe2, cafe3, cafe1};

        Route routes = new Route("Хаки", freightForwarder, cafes);
        routeArrayList.add(routes);

    }


}
