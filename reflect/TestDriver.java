package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestDriver {

	public static void main(String[] args){
		testEmployee();

	}
//String.class, String.class, int.class
	public static void testTransaction(){
		try{
			Class<?> classType = AccountServiceImpl.class;
			Constructor cstr = classType.getConstructor();
			AccountService as = (AccountServiceImpl)cstr.newInstance();
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void testEmployee(){
		try {
			Class<?> classType = Class.forName("reflect.Employee");
			System.out.println(classType.getName());
			Constructor<?> cons = Employee.class.getDeclaredConstructor(String.class, int.class);
			
			Employee instance = (Employee) cons.newInstance("eee", 33 );
			
			Method[] methods = classType.getMethods();
			for(Method m : methods){
				System.out.println(m.getName());
			}
			Method sayHelloMethod = classType.getDeclaredMethod("sayHello");
			sayHelloMethod.invoke(instance);
			
			Method getIdMethod = classType.getDeclaredMethod("getID");
			getIdMethod.setAccessible(true);
			getIdMethod.invoke(instance);
			
			Field[] fields = classType.getDeclaredFields();
			for(Field f : fields){
				System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getName() + " " + f.getName());
				Class fc = f.getType();
				
			}
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
