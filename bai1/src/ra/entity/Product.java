package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float productPrice;
    private float importPrice;

    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float productPrice, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProduct,int sizeCount) {
        this.productId = inputId(scanner, arrProduct,sizeCount);
        this.productName = inputName(scanner, arrProduct,sizeCount);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuantity(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.status = inputStatus(scanner);

    }

    public String inputId(Scanner scanner, Product[] arrProduct,int sizeCount) {
        do {
            System.out.println("Nhập ID cho sản phẩm");
            String idProduct = scanner.nextLine();
            String regex = "^D.{3}$";
            boolean isExist = false;
            if (idProduct.matches(regex)) {
                for (int i = 0; i < sizeCount; i++) {
                    if (arrProduct[i] != null && arrProduct[i].getProductId().equals(idProduct)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.out.println("Sản phẩm đã tồn tại");
                } else {
                    return idProduct;
                }
            } else {
                System.out.println("Tên phải có định dạnh P___ ");
            }
        }
        while (true);
    }

    public String inputName(Scanner scanner, Product[] arrProduct, int sizeCount) {
        do {
            System.out.println("Nhập tên cho sản phẩm");
            String nameProduct = scanner.nextLine();
            boolean isExist = false;
            if (nameProduct.length() >= 6 && nameProduct.length() <= 50) {
                for (int i = 0; i < sizeCount; i++) {
                    if (arrProduct[i] != null && arrProduct[i].getProductName().equals(nameProduct)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.out.println("Sản phẩm đã tồn tại");
                } else return nameProduct;
            } else {
                System.out.println("Độ dài tên phải nằm trong khoảng 6-50 ký ");
            }
        }
        while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        do {
            System.out.println("Nhập giá mua vào: ");
            float productImportPrice = Float.parseFloat(scanner.nextLine());
            if (productImportPrice > 0) {
                return productImportPrice;
            } else {
                System.out.println("Giá nhập vào phải lớn hơn 0");
            }
        }
        while (true);
    }

    public float inputExportPrice(Scanner scanner) {
        do {
            System.out.println("Nhập giá bán ra: ");
            float productExportPrice = Float.parseFloat(scanner.nextLine());
            if (productExportPrice >= this.importPrice * 1.2) {
                return productExportPrice;
            } else {
                System.out.println("Giá bán ra phải lớn hơn ít nhất 20% giá nhập");
            }
        }
        while (true);
    }

    public float calProfit() {
        return exportPrice - importPrice;
    }

    public int inputQuantity(Scanner scanner) {
        do {
            System.out.print("Nhập số lượng sản phẩm:");
            int productQuantity = Integer.parseInt(scanner.nextLine());
            if (productQuantity > 0) {
                return productQuantity;
            } else {
                System.out.println("Số lượng sản phẩm phải lớn hơn 0, mời nhập lại");
            }
        }
        while (true);
    }

    public String inputDescriptions(Scanner scanner) {
        System.out.print("Nhập mô tả: ");
        return scanner.nextLine();
    }

    public boolean inputStatus(Scanner scanner) {
        do {
            System.out.println("Nhập trạng thái cho sản phẩm");
            String statusProduct = scanner.nextLine();
            if (statusProduct.equals("true") || statusProduct.equals("false")) {
                return Boolean.parseBoolean(statusProduct);
            } else {
                System.out.println("Trạng thái sản phẩm chỉ nhận giá trị true/false");
            }
        }
        while (true);
    }

    public void displayData() {
        System.out.printf("Mã sản phẩm: %s || Tên sản phẩm: %s", this.productId, this.productName);
        System.out.printf("Giá nhập: %f || Giá bán: %f || Lợi nhuận: %s", this.importPrice, this.exportPrice, this.profit);
        System.out.printf("Mô tả: %s || Trạng thái: %s", this.descriptions, this.status ? "Đang bán" : "Không bán");
    }
}


