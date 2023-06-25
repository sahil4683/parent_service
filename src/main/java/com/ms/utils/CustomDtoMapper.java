package com.ms.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class User {
    private String firstName;
    private String lastName;
	public User(String firstName, String lastName) {
		super();
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

class UserDTO {
    private String name;
    private String sirName;
    private String fullName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSirName() {
		return sirName;
	}
	public void setSirName(String sirName) {
		this.sirName = sirName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}

public class CustomDtoMapper<T, D> {
	
	public static void main(String[] args) {
		 List<User> userList = new ArrayList<>();
		 userList.add(new User("sahil", "patil"));
		 userList.add(new User("milind", "patil"));
		 userList.add(new User("sanjay", "thale"));
		 userList.add(new User("pramod", "hivra"));
	        // Populate the userList...

	        Map<String, String> fieldMapping = new HashMap<>();
	        fieldMapping.put("firstName", "name");
	        fieldMapping.put("lastName", "sirName");

	        CustomDtoMapper<User, UserDTO> mapper = new CustomDtoMapper<>();
	        
	        // To Map Single Object
	        UserDTO userDTO1 = mapper.map(new User("Sahil", "patil" ), UserDTO.class, fieldMapping);
	        System.out.println(userDTO1.getName() + " -- " + userDTO1.getSirName() + " -- " + userDTO1.getFullName());
	        
	        // To Map List Of Objects
	        List<UserDTO> userDTOList = mapper.mapList(userList, UserDTO.class, fieldMapping);
	        for (UserDTO userDTO : userDTOList) {
				System.out.println(userDTO.getName() + " -- " + userDTO.getSirName() + " -- " + userDTO.getFullName());
			}
	}

    public List<D> mapList(List<T> sourceList, Class<D> destinationClass, Map<String, String> fieldMapping) {
        return sourceList.stream()
                .map(source -> map(source, destinationClass, fieldMapping))
                .collect(Collectors.toList());
    }

    public D map(T source, Class<D> destinationClass, Map<String, String> fieldMapping) {
        try {
            D destination = destinationClass.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, String> entry : fieldMapping.entrySet()) {
                String sourceField = entry.getKey();
                String destinationField = entry.getValue();
                Object value = getProperty(source, sourceField);
                setProperty(destination, destinationField, value);
            }
            return destination;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while mapping objects.", e);
        }
    }

    private Object getProperty(Object object, String field) {
        try {
            Class<?> clazz = object.getClass();
            java.lang.reflect.Field declaredField = clazz.getDeclaredField(field);
            declaredField.setAccessible(true);
            return declaredField.get(object);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while getting property: " + field, e);
        }
    }

    private void setProperty(Object object, String field, Object value) {
        try {
            Class<?> clazz = object.getClass();
            java.lang.reflect.Field declaredField = clazz.getDeclaredField(field);
            declaredField.setAccessible(true);

            String capitalizedField = field.substring(0, 1).toUpperCase() + field.substring(1);
            String setterName = "set" + capitalizedField;
            java.lang.reflect.Method setter = clazz.getDeclaredMethod(setterName, declaredField.getType());
            setter.setAccessible(true);
            setter.invoke(object, value);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while setting property: " + field, e);
        }
    }
}
