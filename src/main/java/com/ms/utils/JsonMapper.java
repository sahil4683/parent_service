package com.ms.utils;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
	
//	<dependencies>
//    <dependency>
//        <groupId>com.fasterxml.jackson.core</groupId>
//        <artifactId>jackson-core</artifactId>
//        <version>2.13.0</version>
//    </dependency>
//    <dependency>
//        <groupId>com.fasterxml.jackson.core</groupId>
//        <artifactId>jackson-databind</artifactId>
//        <version>2.13.0</version>
//    </dependency>
//    </dependencies>

	
	
//	import com.fasterxml.jackson.annotation.JsonProperty;
//	public class UserDto {
//	    @JsonProperty("name")
//	    private String name;
//	    @JsonProperty("age")
//	    private int age;
//	}
	

//	public static void main(String[] args) {
//        try {
//        	String jsonString = "{\"name\":\"John Doe\",\"age\":30}";
//            UserDto userDto = JsonMapper.fromJson(jsonString, UserDto.class);
//            System.out.println("DTO object: " + userDto);
//            
//            String convertedJsonString = JsonMapper.toJson(userDto);
//            System.out.println("Converted JSON string: " + convertedJsonString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
	
	
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    public static <T> T fromJson(String jsonString, Class<T> dtoClass) throws Exception {
//        return objectMapper.readValue(jsonString, dtoClass);
//    }
//
//    public static <T> String toJson(T dtoObject) throws Exception {
//        return objectMapper.writeValueAsString(dtoObject);
//    }
}
