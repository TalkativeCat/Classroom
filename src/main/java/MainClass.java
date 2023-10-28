import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        getPersonsByGroup(10, 11);
        getPersonsByAge(14);
        getPersonsByFamilyBinary();
    }

    // Собираем в массивы данные учеников 10 и 11 классов, после чего склеиваем их в единый массив.
    // Поскольку для вычисления средней оценки нужно будет перебрать все записи, подойдет обычный цикл
    public static void getPersonsByGroup(int group1, int group2) {
        DataGroup<Integer> dataGroupGroup = new DataGroup<>();
        Person[] persons1 = dataGroupGroup.addPerson(Person::getGroup, group1);
        Person[] persons2 =dataGroupGroup.addPerson(Person::getGroup, group2);
        Person[] persons = new Person[persons1.length + persons2.length];
        System.arraycopy(persons1, 0, persons, 0, persons1.length);
        System.arraycopy(persons2, 0, persons, persons1.length, persons2.length);
        double number = 0;
        for (Person obj : persons) {
            number += (double) (obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics()) / 6;
        }
        double middle = (number / persons.length);
        String result = String.format("%.1f", middle);
        System.out.println("Средний балл в " + group1 + " и " + group2 + " классах: " + result + "\n");
    }

    // В методе используется отсортированный массив, полученный по индексу первой буквы имени студента из HashMap.
    // По нему быстрее будет выполняться бинарный поиск
    public static void getPersonsByFamilyBinary() {
        DataGroup<String> dataGroupName = new DataGroup<>();
        System.out.println("Введите фамилию студента: ");
        Scanner console = new Scanner(System.in);
        String family = console.nextLine();
        int left = 0;
        int right = dataGroupName.addPerson(Person::getFamily, family).length - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = dataGroupName.addPerson(Person::getFamily, family)[mid].getFamily().compareTo(family);

            if (compareResult == 0) {
                // Строка family найдена, выводим ее в консоль
                System.out.println(dataGroupName.addPerson(Person::getFamily, family)[mid].getFamily() + " " + dataGroupName.addPerson(Person::getFamily, family)[mid].getName());
                found = true;

                // Проверяем наличие дополнительных совпадающих строк слева
                int index = mid - 1;
                while (index >= 0 && dataGroupName.addPerson(Person::getFamily, family)[index].getFamily().equals(family)) {
                    System.out.println(dataGroupName.addPerson(Person::getFamily, family)[index].getFamily() + " " + dataGroupName.addPerson(Person::getFamily, family)[index].getName());
                    index--;
                }

                // Проверяем наличие дополнительных совпадающих строк справа
                index = mid + 1;
                while (index < dataGroupName.addPerson(Person::getFamily, family).length && dataGroupName.addPerson(Person::getFamily, family)[index].getFamily().equals(family)) {
                    System.out.println(dataGroupName.addPerson(Person::getFamily, family)[index].getFamily() + " " + dataGroupName.addPerson(Person::getFamily, family)[index].getName());
                    index++;
                }
                break;
            } else if (compareResult < 0) {
                // Строка family находится в правой половине
                left = mid + 1;
            } else {
                // Строка family находится в левой половине
                right = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Такая фамилия не найдена");
        }
    }

    //Поочередно получаем массивы данных студенов из HashMap по ключу - возрасту (начиная с 15 и до 17 лет).
    // Суммируем баллы по всем предметам у каждого ученика, при совпадении максимально возможной суммы выводим данные в консоль
    public static void getPersonsByAge(int age) {
        DataGroup<Integer> dataGroupAge = new DataGroup<>();
        System.out.println("Отличники среди студентов старше 14 лет:");
        age += 1;
        while ((age < 18)) {
            for (Person obj : dataGroupAge.addPerson(Person::getAge, age)) {
                int number = obj.getPhysics() + obj.getMathematics() + obj.getRus() + obj.getLiterature() + obj.getGeometry() + obj.getInformatics();
                if (number == 30) {
                    System.out.println(obj.getFamily() + " " + obj.getName());
                }
            }
            age++;
        }
        System.out.println();
    }
}
