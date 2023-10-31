package commands;

import dataGroup.*;

public class GetPersonsByFamilyCommand implements Command {
    private final String family;

    public GetPersonsByFamilyCommand(String family) {
        this.family = family;
    }

    @Override
    public void execute() {
        DataGroup<String> dataGroupName = new DataGroup<>();
        int left = 0;
        int right = dataGroupName.getPersons(Person::getFamily, family).length - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = dataGroupName.getPersons(Person::getFamily, family)[mid].getFamily().compareTo(family);

            if (compareResult == 0) {
                // Строка family найдена, выводим ее в консоль
                System.out.println(dataGroupName.getPersons(Person::getFamily, family)[mid].getFamily() + " " + dataGroupName.getPersons(Person::getFamily, family)[mid].getName());
                found = true;

                // Проверяем наличие дополнительных совпадающих строк слева
                int index = mid - 1;
                while (index >= 0 && dataGroupName.getPersons(Person::getFamily, family)[index].getFamily().equals(family)) {
                    System.out.println(dataGroupName.getPersons(Person::getFamily, family)[index].getFamily() + " " + dataGroupName.getPersons(Person::getFamily, family)[index].getName());
                    index--;
                }

                // Проверяем наличие дополнительных совпадающих строк справа
                index = mid + 1;
                while (index < dataGroupName.getPersons(Person::getFamily, family).length && dataGroupName.getPersons(Person::getFamily, family)[index].getFamily().equals(family)) {
                    System.out.println(dataGroupName.getPersons(Person::getFamily, family)[index].getFamily() + " " + dataGroupName.getPersons(Person::getFamily, family)[index].getName());
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
}
