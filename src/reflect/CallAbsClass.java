package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallAbsClass {
	public void doCall(Object aClass){
		Class<?> clz = aClass.getClass();
		try {
			Method m = clz.getMethod("onResult", boolean.class);
			m.invoke(aClass, false);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Field[] fields = clz.getFields();
		System.out.println("get here, fields size: " + fields.length);
		for(Field f : fields){
			
			System.out.println("field: " + f.getName());
			try {
				Object value = f.get(aClass);
				if(value == null) {
					System.out.println("field: " + f.getName() + " is null");
				}else {
					System.out.println("field: " + f.getName() + " is " + value);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Method[] methods = clz.getDeclaredMethods();
		for(Method m : methods){
			if(m.getName().startsWith("get")){
				try {
					Object value = m.invoke(aClass);
					
					String fieldName = m.getName().substring(3);
					char[] nameChar = fieldName.toCharArray();
					nameChar[0] = Character.toLowerCase(nameChar[0]);
					fieldName = new String(nameChar);
					if(value != null) System.out.println("return non null method: " + m.getName().substring(3)); 
					if(value == null) System.out.println("return null method: " + m.getName().substring(3)); 
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
