package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        int sizeCount = 0;
        Scanner scanner = new Scanner(System.in);
        Product[] arrProduct = new Product[100];
        ProductImp productManagement = new ProductImp();
        do {
            System.out.println("***********************MENU**************************\n" +
                    "1. Nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Tính lợi nhuận các sản phẩm\n" +
                    "4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần\n" +
                    "5. Thống kê các sản phẩm theo giá\n" +
                    "6. Tìm các sản phẩm theo tên sản phẩm\n" +
                    "7. Nhập sản phẩm\n" +
                    "8. Bán sản phẩm\n" +
                    "9. Cập nhật trạng thái sản phẩm\n" +
                    "10. Thoát\n" +
                    "Nhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManagement.createProduct(scanner,arrProduct,sizeCount);
                    break;
                case 2:
                    productManagement.displayProduct(arrProduct,sizeCount);
                    break;
                case 3:
                    productManagement.calProfitProduct(arrProduct,sizeCount);
                    break;
                case 4:
                    productManagement.sortedProduct(arrProduct,sizeCount);
                    break;
                case 5:
                    productManagement.searchWithin(scanner,arrProduct,sizeCount);
                    break;
                case 6:
                    productManagement.searchProductByName(scanner,arrProduct,sizeCount);
                    break;
                case 7:
                    productManagement.insertProduct(scanner,arrProduct,sizeCount);
                    break;
                case 8:
                    productManagement.buyProduct(scanner,arrProduct,sizeCount);
                    break;
                case 9:
                    productManagement.changeProductStatus(scanner,arrProduct,sizeCount);
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

    public void createProduct(Scanner scanner, Product[] arrProduct, int sizeCount) {
        System.out.println("Nhập số lượng sản phẩm muốn thêm mới");
        int numberOfProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfProduct; i++) {
            sizeCount++;
            for (int j = 0; j < sizeCount; j++) {
                Product newProduct = new Product();
                newProduct.inputData(scanner, arrProduct, sizeCount);
                arrProduct[j] = newProduct;
                break;
            }
        }
    }

    public void displayProduct(Product[] arrProduct, int sizeCount) {
        System.out.println("Danh sách sản phẩm: ");
        for (int i = 0; i < sizeCount; i++) {
            arrProduct[i].displayData();
        }
    }


    public void calProfitProduct(Product[] arrProduct, int sizeCount) {
        for (int i = 0; i < sizeCount; i++) {
            arrProduct[i].calProfit();
        }
    }

    public void sortedProduct(Product[] arrProduct, int sizeCount) {
        for (int i = 0; i < sizeCount; i++) {
            for (int j = i + 1; j < sizeCount; j++) {
                if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                    Product tg = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = tg;
                }
            }
        }
        displayProduct(arrProduct, sizeCount);
    }

    public void searchWithin(Scanner scanner, Product[] arrProduct, int sizeCount) {
        System.out.println("Nhập giá tối thiểu: ");
        float fromPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá tối đa: ");
        float toPrice = Float.parseFloat(scanner.nextLine());
        for (int i = 0; i < sizeCount; i++) {
            if (arrProduct[i].getExportPrice() >= fromPrice && arrProduct[i].getExportPrice() <= toPrice) {
                arrProduct[i].displayData();
            }
        }
    }
    public void searchProductByName(Scanner scanner,Product[] arrProduct, int sizeCount){
        System.out.println("Nhập tên sản phẩm cần tìm");
        String nameProduct = scanner.nextLine();
        boolean checkExist = true;
        for (int i = 0; i < sizeCount; i++) {
            if (arrProduct[i].getProductName().equals(nameProduct)){
                arrProduct[i].displayData();
                checkExist = false;
                break;
            }
        }
        if (checkExist){
            System.out.println("Sản phẩm không tồn tại");
        }
    }
    public void insertProduct(Scanner scanner, Product[] arrProduct, int sizeCount){
        System.out.println("Nhập mã sản phẩm muốn nhập:");
        String idProduct = scanner.nextLine();
        System.out.println("Nhập số lượng nhập vào");
        int numberOfQuantity = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeCount; i++) {
            if (arrProduct[i].getProductId().equals(idProduct)){
                arrProduct[i].setQuantity(arrProduct[i].getQuantity()+numberOfQuantity);
                break;
            } else {
                System.out.println("Sản phẩm không tồn tại");
            }
        }
    }
    public void buyProduct(Scanner scanner, Product[] arrProduct, int sizeCount){
        System.out.println("Nhập tên sản phẩm muốn mua:");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập số lượng mua ");
        int numberOfQuantity = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeCount; i++) {
            if (arrProduct[i].getProductName().equals(nameProduct)){
                arrProduct[i].setQuantity(arrProduct[i].getQuantity()-numberOfQuantity);
                break;
            } else {
                System.out.println("Sản phẩm không tồn tại");
            }
        }
    }
    public  void changeProductStatus(Scanner scanner, Product[] arrProduct, int sizeCount){
        System.out.println("Nhập mã sản phẩm muốn thay đổi trạng thái: ");
        String idProduct = scanner.nextLine();
        for (int i = 0; i < sizeCount; i++) {
            if (arrProduct[i].getProductId().equals(idProduct)){
                arrProduct[i].setStatus(!arrProduct[i].isStatus());
            }
        }
    }
}
