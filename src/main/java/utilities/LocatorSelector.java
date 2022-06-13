package utilities;

import org.openqa.selenium.By;

import locatorInterface.AmazonPrimeLocator;

import java.lang.reflect.Field;

public class LocatorSelector implements AmazonPrimeLocator {
    private static Object LocatorSelector;

    public static By select(String value) {

        Field field;
        try {
            field = LocatorSelector.class.getField(value);
            return (By) field.get(LocatorSelector);
        } catch (Exception e) {
            return null;
        }

    }
}
