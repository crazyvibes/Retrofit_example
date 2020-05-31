# Retrofit_example
##RETROFIT CRASH COURSE:

*Rest APIs:

-One is SOAP protocol (Simple Object Access Protocol) 
 and the other being REST for Representational State Transfer.
 
-REST is an Architectural style in which a web service can only 
 be treated as a RESTful service if it follows the constraints of being
 
-An application implementing a RESTful API will define one or more 
 URL endpoints with a domain, port, path, and/or querystring — 
 for example, https://mydomain/user/123?format=json .

* Retrofit:

-most of the app need to communicate with Rest APIs or web services
 that is they need to get data from backend servers as well as send data to 
 backed servers.

-Most of the app use a back end web services for authentication. to implement 
 complex functionality such as online payments  we need to deal with backends apis.
 Android has provided us , classes like http  and async task to handle network connections.
 But its very complex and time consuming.
 so retrofit is a solution of this problem.

-Retrofit is a type safe Rest client for android and java by square.

-Retrofit is the best tool for handling network request and responses in android applications.

-The best supporting library android community have, to work with json/xml REST APIs.
 
-it is much fatser than async task and http manager.

-we only need to worry about the queries that you send over the network.
 All other tasks such as specifying parameters, constructing urls, writing data to the server,
 muli threading, will be handled by the Retrofit.
 
-https://square.github.io/retrofit

-convert java object into json data, we use Gson.

-convert xml data to java object or vice-versa we can use simple xml convertor.

@SerializedName annotration:

-@Serialized name annotation tells to Gson converter, 
 that this member should be serialized to Json with the provided name as its field name.

Example:

@SerializedName("country_name")
private String name;

- in the above example when GSON convertor converts this to JSON, "name" field
 will be converted into "country_name".
 
 same will apply when converting from JSON to JAVA.
 
@Expose 

- This annotation is optional. we don't have always specify this.
- Comes with two parameters Serialize and deserialize.

Example:

@Expose (Serialize = false)
private String name;
 
- it will not be converted into json when Gson converter convert data from java objects to json

@Expose (Serialize = false,  deserialize = false)
private String name;

- it will not be converted into json when Gson converter convert data from java objects to json and vice versa.


**INTERFACE WITH APIs END POINT:

-we define all endpoint of apis in this interface class.

https://square.github.io/retrofit/2.x/retrofit/

-An invocation of a Retrofit method that sends a request to a webserver and returns a response. 
 Each call yields its own HTTP request and response pair. Use clone() to make multiple calls with the same parameters to the same webserver; 
 this may be used to implement polling or to retry a failed call.
 Calls may be executed synchronously with execute(), or asynchronously with enqueue(retrofit2.Callback<T>).
-In either case the call can be canceled at any time with cancel(). A call that is busy writing its request or reading its response may 
 receive a IOException; this is working as designed.
 
enqueue
void enqueue(Callback<T> callback)
-Asynchronously send the request and notify callback of its response or if an error occurred talking to the server, 
 creating the request, or processing the response.
 
 
http://services.groupkt.com/country/get/all


@Body annotation: it is used with POST and PUT request method.
- Retrofit introduced this annotation to offer the ability to pass objects wuithin the request body.

Header Request:

-HTTP headers carry information about the client app, about the requested data, about the server.
- to implement this we use @Headers annotation.

Example:

@Headers({

"Accept: application/Json",
"User-Agent:DemoApp",
"Cache-Control: max-age=640000"

})

-we can also pass it as dynamic headers with get or post methods.

@HeaderMap annotation:

- by creating insatnce of hashmap and pass value in interface methods.

-When Do We Use OkHttp ?
 OkHttp and Retrofit, Both of them are excellent supporting libraries created by Square.

 With with OkHttp you can make HTTP requests and  get responses from the server .If you use only OkHttp you will have to write codes to convert data , set URLs , etc.

 In simple terms ,Retrofit is just an API adapter wrapped over okHTTP.  It makes your works much easier by automating many coding parts.

 OkHTTP is inbuilt with Retrofit 2 . But we also use it when we need to customize.

 as an example default  time out is 15 seconds . But if you want to change it you can do it in this way.


 Here I have created an okHttpClient instance and set the time out as 2 minutes.

ModelClass:

@SerializedName:

-tells to gson converter, this member should be seriealized to JSON with the provided name as its field name.


**Sigleton Retrofit Instance class:

-this is for communicate with rest apis.
-we usually define a private static refference variable for the class which is going to hold only instance of the class.
-And after that we create a public static method which returns the instance of the class.
-the return type should be interface, why is that?, why is not just retrofit?, because we are using retrofit instance through interface,
thats whywe use interface name here.


http://jsonplaceholder.typicode.com for post params example.\
http://www.jsonschema2pojo.org/
