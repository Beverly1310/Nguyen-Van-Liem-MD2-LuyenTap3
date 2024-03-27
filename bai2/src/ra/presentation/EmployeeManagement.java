package ra.presentation;
import ra.businessImp.Employee;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagement employeeManagement = new EmployeeManagement();
        Employee[] arrEmployee = new Employee[100];
        int sizeCount = 0;
        do {
            System.out.println("********************MENU*********************\n" +
                    "1. Nhập thông tin cho n nhân viên\n" +
                    "2. Hiển thị thông tin nhân viên\n" +
                    "3. Tính lương cho các nhân viên\n" +
                    "4. Tìm kiếm nhân viên theo tên nhân viên\n" +
                    "5. Cập nhật thông tin nhân viên\n" +
                    "6. Xóa nhân viên theo mã nhân viên\n" +
                    "7. Sắp xếp nhân viên theo lương tăng dần (Comparable)\n" +
                    "8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)\n" +
                    "9. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)\n" +
                    "10. Thoát" +
                    "Mời nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeManagement.createEmployee(scanner,arrEmployee,sizeCount);
                    break;
                case 2:
                    employeeManagement.displayEmployee(arrEmployee,sizeCount);
                    break;
                case 3:
                    employeeManagement.calSalry(arrEmployee,sizeCount);
                    break;
                case 4:
                    employeeManagement.searchEmplyeeByName(scanner,arrEmployee,sizeCount);
                    break;
                case 5:
                    employeeManagement.updateEmployee(scanner,arrEmployee,sizeCount);
                    break;
                case 6:
                    employeeManagement.deleteEmployee(scanner,arrEmployee,sizeCount);
                    break;
                case 7:
                    employeeManagement.sortWithiComparable(arrEmployee,sizeCount);
                    break;
                case 8:
                    Arrays.sort(arrEmployee,(o1, o2) -> {
                        if (o1!=null && o2!=null){
                            return (int) (o1.getSalary()- o2.getSalary());
                        }else return 0;
                    });
                    break;
                case 9:
                    Arrays.sort(arrEmployee,(o1, o2) -> {
                        if (o1!=null && o2!=null){
                            return (int) (o1.getYear()- o2.getYear());
                        }else return 0;
                    });
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập lại");
            }
        }
        while (true);
    }

    public void createEmployee(Scanner scanner, Employee[] arrEmployee, int sizeCount) {
        System.out.println("Nhập số nhân viên muốn thêm");
        int numberOfEmployee = Integer.parseInt(scanner.nextLine());
        for (int i = sizeCount; i < sizeCount + numberOfEmployee; i++) {
            Employee newEmployee = new Employee();
            arrEmployee[i] = newEmployee;
            arrEmployee[i].inputData(scanner);
        }
        sizeCount += numberOfEmployee;
    }

    public void displayEmployee(Employee[] arrEmployee, int sizeCount){
        for (int i = 0; i < sizeCount; i++) {
            arrEmployee[i].displayData();
        }
    }
    public void calSalry(Employee[] arrEmployee, int sizeCount){
        for (int i = 0; i < sizeCount; i++) {
            arrEmployee[i].calSalary();
        }
    }
    public void searchEmplyeeByName(Scanner scanner,Employee[] arrEmployee, int sizeCount){
        System.out.println("Nhập tên nhân viên: ");
        String nameEmployee = scanner.nextLine();
        for (int i = 0; i < sizeCount; i++) {
            if (arrEmployee[i].getName().equals(nameEmployee)){
                arrEmployee[i].displayData();
                break;
            }
        }
    }
    public void updateEmployee(Scanner scanner,Employee[] arrEmployee, int sizeCount){
        System.out.println("Nhập mã nhân viên muốn chỉnh sửa: ");
        String idEmployee = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < sizeCount; i++) {
            if (arrEmployee[i].getId().equals(idEmployee)){
                arrEmployee[i].inputData(scanner);
                isExist=true;
                break;
            }
        }
        if (!isExist){
                System.out.println("Nhân viên không tồn tại");
        }
    }
    public void deleteEmployee(Scanner scanner,Employee[] arrEmployee, int sizeCount){
        System.out.println("Nhập mã nhân viên muốn chỉnh sửa: ");
        String idEmployee = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < sizeCount; i++) {
            if (arrEmployee[i].getId().equals(idEmployee)){
                index=i;
                break;
            }
        }
        if (index!=-1){
            for (int i = index; i < sizeCount-1; i++) {
                arrEmployee[i]=arrEmployee[i+1];
            }
            arrEmployee[sizeCount-1]=null;
            sizeCount--;
        }else {
            System.out.println("Nhân viên không tồn tại");
        }
    }
    public Employee[] cloningArray(Employee[] arrEmployee,int sizeCount){
        Employee[] cloneArrEmployee = new Employee[sizeCount];
        for (int i = 0; i < sizeCount; i++) {
            cloneArrEmployee[i]=arrEmployee[i];
        }
        return cloneArrEmployee;
    }
    public void sortWithiComparable(Employee[] arrEmployee,int sizeCount){
      Employee[] sortArr = cloningArray(arrEmployee,sizeCount);
      Arrays.sort(sortArr);
        for (int i = 0; i < sizeCount; i++) {
            arrEmployee[i]=sortArr[i];
        }
    }
}
