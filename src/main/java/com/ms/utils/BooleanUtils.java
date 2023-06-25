package com.ms.utils;
public class BooleanUtils {
	
	public static void main(String[] args) {
        Boolean value1 = null;
        Boolean value2 = true;
        Boolean value3 = false;

        System.out.println("Is value1 null or false? " + BooleanUtils.isNullOrEmpty(value1));
        System.out.println("Is value2 not null and true? " + BooleanUtils.isNotNullAndTrue(value2));
        System.out.println("Is value3 not null and false? " + BooleanUtils.isNotNullAndFalse(value3));
    }
    
    public static boolean isNullOrEmpty(Boolean bool) {
        return bool == null || !bool;
    }
    
    public static boolean isNotNullAndTrue(Boolean bool) {
        return bool != null && bool;
    }
    
    public static boolean isNotNullAndFalse(Boolean bool) {
        return bool != null && !bool;
    }
}
