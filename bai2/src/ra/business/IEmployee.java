package ra.business;

import java.util.Scanner;

public interface IEmployee {
    float BASIC_SALARY = 1300000F;
    void inputData(Scanner scanner);
    void displayData();


    float calSalary();

}
