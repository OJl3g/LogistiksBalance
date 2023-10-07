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
            System.out.println("isRefrigerator " + route.getFreightForwarder().isRefrigerator());
            System.out.println("isMedicalBook " + route.getFreightForwarder().isMedicalBook());
            System.out.println("isSanitationOfTheBody " + route.getFreightForwarder().isSanitationOfTheBody());
            System.out.println("");

            System.out.println("------Список Точек-------");
            for (Cafe cafe : route.getCafes()) {
                if (cafe != null) {

                    System.out.println("cafe address " + cafe.getName());
                    System.out.println("cafe Address " + cafe.getAddress());
                    System.out.println("cafe LoadingTime " + cafe.getLoadingTime());
                    System.out.println("cafe isCoffeeMachine " + cafe.isCoffeeMachine());
                    System.out.println("\n\n");

                }
            }
            System.out.println("************************************\n\n\n");
        }
    }

    public void addRoute() {
        System.out.println("Введите название маршрута");
        String nameRoute = scanner.nextLine();

        FreightForwarder freightForwarder = createFreightForwarder();

        System.out.println("Хотите ли сразу добавить  Магазины для этого маршрута");
        System.out.println("1 да");
        System.out.println("2 нет");


        Cafe[] cafes = new Cafe[50];

        if (scanner.nextLine().equals("1")) {
            System.out.println("добавление точек");

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

        System.out.println("Имеется ли у авто рефрижератор ? 1 - Да   2 - Нет");
        boolean refrigerator = scanner.nextLine().equals("1") ? true : false;

        System.out.println("Имеется ли у экспедитора мед.книга? 1 - Да   2 - Нет");
        boolean medicalBook = scanner.nextLine().equals("1") ? true : false;

        System.out.println("Имеется ли у экспедитора сан.обработка? 1 - Да   2 - Нет");
        boolean sanitationOfTheBody = scanner.nextLine().equals("1") ? true : false;

        return new FreightForwarder(name, surname, modelAuto, refrigerator, medicalBook, sanitationOfTheBody);

    }


}
