package api.endpoints;
/*Swagger URI ---> https://petstore.swagger.io
	
	Creat user(post): https://petstore..swagger.io/v2/user
	Get user (Get): https://petstore.swagger.io/v2/{username}
	Update user (Put): 	https://petstore.swagger.io/v2/{username}
	Delete  user (Delete): 	https://petstore.swagger.io/v2/{username}
			*/
		
public class Routes {
public static String base_url="https://petstore.swagger.io/v2";
	
//User module

public static String post_url=base_url+"/user";
public static String get_url=base_url+"/user/{username}";
public static String update_url=base_url+"/user/{username}";
public static String delete_url=base_url+"/user/{username}";


//Store module

//Here you will creat Store module URL's

//Pet module

//Here you will creat Pet module URL's
	
	
	
	
}
