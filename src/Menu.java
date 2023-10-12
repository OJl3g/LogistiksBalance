import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private static ArrayList<Route> routeArrayList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public void firstStart() {
        while (true) {
            System.out.println("1 Список Маршрутов");
            System.out.println("2 Добавить Маршрут");
            System.out.println("3 Редактировать Маршрут");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1" -> {
                    printListRoute();
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

    public void printListRoute() {
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

            System.out.println("------Список Точек-------");
            for (Cafe cafe : route.getCafes()) {
                if (cafe != null) {

                    System.out.println("cafe address " + cafe.getName());
                    System.out.println("cafe Address " + cafe.getAddress());
                    System.out.println("cafe LoadingTime " + cafe.getLoadingTime());
                    System.out.println("cafe CoffeeMachine " + answer(cafe.isCoffeeMachine()));
                    System.out.println("\n\n");

                }
            }
            System.out.println("************************************\n\n\n");
        }
    }

    private boolean examinationAnswer(String text) {
        System.out.println(text);
        System.out.println("1 да");
        System.out.println("2 нет");
        String result = scanner.nextLine();
        return result.equals("1") ? true : false;

    }

    public void addRoute() {
        System.out.println("Введите название маршрута");
        String nameRoute = scanner.nextLine();

        FreightForwarder freightForwarder = createFreightForwarder();


        Cafe[] cafes = new Cafe[50];

        if (examinationAnswer("Хотите ли сразу добавить  Магазины для этого маршрута")) {
            System.out.println("добавление точек");
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


        boolean refrigerator = examinationAnswer("Имеется ли у авто рефрижератор ? ");
        boolean medicalBook = examinationAnswer("Имеется ли у экспедитора мед.книга?");
        boolean sanitationOfTheBody = examinationAnswer("Имеется ли у экспедитора сан.обработка?");

        return new FreightForwarder(name, surname, modelAuto, refrigerator, medicalBook, sanitationOfTheBody);

    }

    public String answer(boolean b) {
        return b ? "есть" : "нету";
    }

    public void editRoute() {
        System.out.println("Список мартшрутов");
        for (Route route : routeArrayList) {
            System.out.println(route.getNameRoute());
        }

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
        System.out.println("2 - изменить информацию о маршруте");
        System.out.println("3 - редактировать сиписок кафе");

        String answer = scanner.nextLine();

        switch (answer) {
            case "1" -> {
                FreightForwarder freightForwarder = createFreightForwarder();
                route.setFreightForwarder(freightForwarder);
                System.out.println("вы успешно заменили водителя");
                return;
            }
            case "2" -> {
                //прнять новое название маршрута и присвоить маршруту
            }
            case "3" -> {
                //вывести список 3 пунктов добавить маршрут удалить маршрут или редактироваь маршрут
            }

        }

    }




}
