package com.ms.utils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class User1 {
    private String firstName;
    private String lastName;
	public User1(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

class UserDTO1 {
	 private String firstName;
	    private String lastName;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
}


public class GenericDtoMapper {
	
	public static void main(String[] args) {
		User1 user = new User1("sahil", "patil");
		UserDTO1 userDTO = GenericDtoMapper.map(user, UserDTO1.class);
		System.out.println(userDTO.getFirstName() + " -- " + userDTO.getLastName());
	}

    public static <T, D> List<D> mapList(List<T> sourceList, Class<D> destinationClass) {
        return sourceList.stream()
                .map(source -> map(source, destinationClass))
                .collect(Collectors.toList());
    }

    public static <T, D> D map(T source, Class<D> destinationClass) {
        try {
            D destination = destinationClass.getDeclaredConstructor().newInstance();
            Map<String, Field> sourceFields = getFieldMap(source.getClass());
            Map<String, Field> destinationFields = getFieldMap(destinationClass);

            for (Map.Entry<String, Field> entry : destinationFields.entrySet()) {
                String destinationField = entry.getKey();
                Field destinationFieldObj = entry.getValue();
                Field sourceFieldObj = sourceFields.get(destinationField);

                if (sourceFieldObj != null) {
                    sourceFieldObj.setAccessible(true);
                    destinationFieldObj.setAccessible(true);

                    Object value = sourceFieldObj.get(source);
                    destinationFieldObj.set(destination, value);
                }
            }
            return destination;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while mapping objects.", e);
        }
    }

    private static Map<String, Field> getFieldMap(Class<?> clazz) {
        Map<String, Field> fieldMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            fieldMap.put(field.getName(), field);
        }
        return fieldMap;
    }
}
