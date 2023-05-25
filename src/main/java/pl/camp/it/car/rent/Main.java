package pl.camp.it.car.rent;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.model.Car;

public class Main {
    public static void main(String[] args) {
        String password = "adminBa7gPOCX3l4Kjd6PlgbT8^%XZGRia8LI";
        String hash = DigestUtils.md5Hex(password);

        System.out.println(hash);

        System.out.println("-------------");

        Car car = new Car("BMW", "3", 2015,
                300.0, "KR11");
        System.out.println(car.toCSV());
    }
}
