package com.ms.utils;
public class NumericUtils {
	
	 public static void main(String[] args) {
	        // Integer conversion
	        Integer num1 = 42;
	        String numString = NumericUtils.integerToString(num1);
	        System.out.println("numString: " + numString);

	        String str1 = "123";
	        Integer num2 = NumericUtils.stringToInteger(str1);
	        System.out.println("num2: " + num2);

	        Integer num3 = null;
	        int num3Converted = NumericUtils.toInt(num3, 0);
	        System.out.println("num3Converted: " + num3Converted);

	        int num4 = 456;
	        Integer num4Converted = NumericUtils.toInteger(num4);
	        System.out.println("num4Converted: " + num4Converted);

	        // Float conversion
	        Float float1 = 3.14f;
	        String floatString = NumericUtils.floatToString(float1);
	        System.out.println("floatString: " + floatString);

	        String str2 = "2.718";
	        Float float2 = NumericUtils.stringToFloat(str2);
	        System.out.println("float2: " + float2);

	        Float float3 = null;
	        float float3Converted = NumericUtils.toFloat(float3, 0.0f);
	        System.out.println("float3Converted: " + float3Converted);

	        float float4 = 1.23f;
	        Float float4Converted = NumericUtils.toFloat(float4);
	        System.out.println("float4Converted: " + float4Converted);

	        // Double conversion
	        Double double1 = 3.14159;
	        String doubleString = NumericUtils.doubleToString(double1);
	        System.out.println("doubleString: " + doubleString);

	        String str3 = "2.71828";
	        Double double2 = NumericUtils.stringToDouble(str3);
	        System.out.println("double2: " + double2);

	        Double double3 = null;
	        double double3Converted = NumericUtils.toDouble(double3, 0.0);
	        System.out.println("double3Converted: " + double3Converted);

	        double double4 = 1.2345;
	        Double double4Converted = NumericUtils.toDouble(double4);
	        System.out.println("double4Converted: " + double4Converted);

	        // Long conversion
	        Long long1 = 9876543210L;
	        String longString = NumericUtils.longToString(long1);
	        System.out.println("longString: " + longString);

	        String str4 = "1234567890";
	        Long long2 = NumericUtils.stringToLong(str4);
	        System.out.println("long2: " + long2);

	        Long long3 = null;
	        long long3Converted = NumericUtils.toLong(long3, 0L);
	        System.out.println("long3Converted: " + long3Converted);

	        long long4 = 987654321;
	        Long long4Converted = NumericUtils.toLong(long4);
	        System.out.println("long4Converted: " + long4Converted);
	    }

    public static String integerToString(Integer value) {
        return value != null ? String.valueOf(value) : "";
    }

    public static Integer stringToInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static int toInt(Integer value, int defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static Integer toInteger(int value) {
        return value;
    }

    public static String floatToString(Float value) {
        return value != null ? String.valueOf(value) : "";
    }

    public static Float stringToFloat(String value) {
        try {
            return Float.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static float toFloat(Float value, float defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static Float toFloat(float value) {
        return value;
    }

    public static String doubleToString(Double value) {
        return value != null ? String.valueOf(value) : "";
    }

    public static Double stringToDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static double toDouble(Double value, double defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static Double toDouble(double value) {
        return value;
    }

    public static String longToString(Long value) {
        return value != null ? String.valueOf(value) : "";
    }

    public static Long stringToLong(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static long toLong(Long value, long defaultValue) {
        return value != null ? value : defaultValue;
    }

    public static Long toLong(long value) {
        return value;
    }
}
