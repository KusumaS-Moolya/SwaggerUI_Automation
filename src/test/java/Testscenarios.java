import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.testng.TestRunner.PriorityWeight.priority;


public class Testscenarios {
    static String access_token ;

    public void main(String args[]) {
        String payload = "{\n" +
                "    \"username\":\"upskills_admin\",\n" +
                "    \"password\":\"Talent4$$\"\n" +
                "}";
        String payload1="{\n" +
                "  \"model\": \"Lenovo Ideapad Laptop\",\n" +
                "  \"quantity\": \"1000\",\n" +
                "  \"price\": \"440000.00\",\n" +
                "  \"tax_class_id\": \"1\",\n" +
                "  \"manufacturer_id\": \"20\",\n" +
                "  \"sku\": \"demo sku\",\n" +
                "  \"product_seo_url\": [\n" +
                "    {\n" +
                "      \"keyword\": \"demo-keyword\",\n" +
                "      \"language_id\": \"1\",\n" +
                "      \"store_id\": \"0\"\n" +
                "    }    \n" +
                "  ],\n" +
                "  \"status\": \"1\",\n" +
                "  \"points\": 0,\n" +
                "  \"reward\": 0,\n" +
                "  \"image\": \"\",\n" +
                "  \"other_images\": [\n" +
                "    \"\"\n" +
                "  ],\n" +
                "  \"shipping\": \"1\",\n" +
                "  \"stock_status_id\": 0,\n" +
                "  \"upc\": \"\",\n" +
                "  \"ean\": \"\",\n" +
                "  \"jan\": \"\",\n" +
                "  \"isbn\": \"\",\n" +
                "  \"mpn\": \"\",\n" +
                "  \"location\": \"\",\n" +
                "  \"date_available\": \"2017-05-12\",\n" +
                "  \"weight\": 0,\n" +
                "  \"weight_class_id\": 0,\n" +
                "  \"length\": 0,\n" +
                "  \"width\": 0,\n" +
                "  \"height\": 0,\n" +
                "  \"length_class_id\": 0,\n" +
                "  \"subtract\": 0,\n" +
                "  \"minimum\": 0,\n" +
                "  \"sort_order\": \"\",\n" +
                "  \"product_store\": [\n" +
                "    \"0\"\n" +
                "  ],\n" +
                "  \"product_related\": [\n" +
                "    \"34\"\n" +
                "  ],\n" +
                "  \"product_filter\": [\n" +
                "    \"34\"\n" +
                "  ],\n" +
                "  \"product_description\": [\n" +
                "    {\n" +
                "      \"language_id\": \"1\",\n" +
                "      \"name\": \"Lenovo Ideapad s100\",\n" +
                "      \"description\": \"Description of the product\",\n" +
                "      \"meta_title\": \"Lenovo Ideapad s100\",\n" +
                "      \"meta_description\": \"Meta description of the product\",\n" +
                "      \"meta_keyword\": \"demo, keyword, demo2\",\n" +
                "      \"tag\": \"Product's tag, comma separeted\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_category\": [\n" +
                "    \"25\"\n" +
                "  ],\n" +
                "  \"product_special\": [\n" +
                "    {\n" +
                "      \"customer_group_id\": \"1\",\n" +
                "      \"price\": \"200\",\n" +
                "      \"priority\": \"1\",\n" +
                "      \"date_start\": \"2015-02-23\",\n" +
                "      \"date_end\": \"2019-02-23\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_discount\": [\n" +
                "    {\n" +
                "      \"name\": \"demo name\",\n" +
                "      \"customer_group_id\": \"1\",\n" +
                "      \"price\": \"200\",\n" +
                "      \"priority\": \"1\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"date_start\": \"2015-02-23\",\n" +
                "      \"date_end\": \"2019-02-23\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_attribute\": [\n" +
                "    {\n" +
                "      \"attribute_id\": \"16\",\n" +
                "      \"product_attribute_description\": [\n" +
                "        {\n" +
                "          \"text\": \"demo name\",\n" +
                "          \"language_id\": \"1\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_option\": [\n" +
                "    {\n" +
                "      \"type\": \"radio\",\n" +
                "      \"option_id\": \"11\",\n" +
                "      \"required\": \"1\",\n" +
                "      \"product_option_value\": [\n" +
                "        {\n" +
                "          \"price\": \"10.00\",\n" +
                "          \"price_prefix\": \"+\",\n" +
                "          \"subtract\": \"1\",\n" +
                "          \"points\": \"0\",\n" +
                "          \"points_prefix\": \"+\",\n" +
                "          \"weight\": \"0\",\n" +
                "          \"weight_prefix\": \"+\",\n" +
                "          \"option_value_id\": \"46\",\n" +
                "          \"quantity\": \"0\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    @Test (priority=1)
    public void FetchAccessToken() {
        Response responsePost = RestAssured.given().header("Authorization", "Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
                .given().header("Accept", "application/json")
                .given().param("grant_type", "client_credentials").contentType(ContentType.JSON).log().all()
                .post("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials");

        String store_response = responsePost.getBody().asString();
        System.out.println(store_response);
        //The response is a raw text so we use the below method
        System.out.println(store_response.substring(Integer.parseInt("260")));
        System.out.println(store_response.substring(Integer.parseInt("276"), Integer.parseInt("316")));
        access_token = responsePost.body().asString().substring(Integer.parseInt("276"),Integer.parseInt("316"));

    }

    @Test (priority = 2)
    public void  Authorization() {

        Response res = given().headers("Authorization", "Bearer "+access_token)
                .contentType("application/json").when().post("http://rest-api.upskills.in/doc/admin/#/");
        System.out.println("The Status code for authorization is: "+res.getStatusCode());
        System.out.println("the access token is:" + access_token);
    }

    @Test (priority = 3)
    public void Login() {
        String payload =  "{\n" +
                "    \"username\":\"upskills_admin\",\n" +
                "    \"password\":\"Talent4$$\"\n" +
                "}";
        //login
        Response reslogin =given().headers("Authorization", "Bearer "+access_token).given().headers("Content-Type", "application/json").body(payload).when()
                .post("http://rest-api.upskills.in/api/rest_admin/login");
        System.out.println("The status code for login is: " + reslogin.getStatusCode());

    }
    @Test (priority =4)
    public void GetUserDetails() {
        Response responseGet = given().header("Authorization", "Bearer " + access_token)
                .given().get("http://rest-api.upskills.in/api/rest_admin/user");

        System.out.println(responseGet.getBody().asString());
    }
    @Test (priority = 5)
    public void  Product(){
        Response resProduct = given().header("Authorization", "Bearer " + access_token)
                .pathParams("category_id","20","limit","2","page","1")
                .given().get("http://rest-api.upskills.in/api/rest_admin/products/category/{category_id}/limit/{limit}/page/{page}");
        System.out.println(resProduct.getBody().asString());
        System.out.println("the status code for products"+ resProduct.getStatusCode());
        System.out.println("x - pagination limit is " +resProduct.header("x-pagination-limit"));
        String head = resProduct.header("x-pagination-limit");
       // Assert.assertEquals(head,2);
    }
    @Test  (priority = 6)
    public void addProduct(){
        String payload1= "{\n" +
                "  \"model\": \"Lenovo Ideapad Laptop\",\n" +
                "  \"quantity\": \"1000\",\n" +
                "  \"price\": \"440000.00\",\n" +
                "  \"tax_class_id\": \"1011\",\n" +
                "  \"manufacturer_id\": \"2201\",\n" +
                "  \"sku\": \"demo sku\",\n" +
                "  \"product_seo_url\": [\n" +
                "    {\n" +
                "      \"keyword\": \"dem-keyword\",\n" +
                "      \"language_id\": \"111\",\n" +
                "      \"store_id\": \"012\"\n" +
                "    }    \n" +
                "  ],\n" +
                "  \"status\": \"1\",\n" +
                "  \"points\": 0,\n" +
                "  \"reward\": 0,\n" +
                "  \"image\": \"\",\n" +
                "  \"other_images\": [\n" +
                "    \"\"\n" +
                "  ],\n" +
                "  \"shipping\": \"1\",\n" +
                "  \"stock_status_id\": 0,\n" +
                "  \"upc\": \"\",\n" +
                "  \"ean\": \"\",\n" +
                "  \"jan\": \"\",\n" +
                "  \"isbn\": \"\",\n" +
                "  \"mpn\": \"\",\n" +
                "  \"location\": \"\",\n" +
                "  \"date_available\": \"2017-05-12\",\n" +
                "  \"weight\": 0,\n" +
                "  \"weight_class_id\": 0,\n" +
                "  \"length\": 0,\n" +
                "  \"width\": 0,\n" +
                "  \"height\": 0,\n" +
                "  \"length_class_id\": 0,\n" +
                "  \"subtract\": 0,\n" +
                "  \"minimum\": 0,\n" +
                "  \"sort_order\": \"\",\n" +
                "  \"product_store\": [\n" +
                "    \"0\"\n" +
                "  ],\n" +
                "  \"product_related\": [\n" +
                "    \"34\"\n" +
                "  ],\n" +
                "  \"product_filter\": [\n" +
                "    \"34\"\n" +
                "  ],\n" +
                "  \"product_description\": [\n" +
                "    {\n" +
                "      \"language_id\": \"1\",\n" +
                "      \"name\": \"Lenovo Ideapad s100\",\n" +
                "      \"description\": \"Description of the product\",\n" +
                "      \"meta_title\": \"Lenovo Ideapad s100\",\n" +
                "      \"meta_description\": \"Meta description of the product\",\n" +
                "      \"meta_keyword\": \"demo, keyword, demo2\",\n" +
                "      \"tag\": \"Product's tag, comma separeted\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_category\": [\n" +
                "    \"25\"\n" +
                "  ],\n" +
                "  \"product_special\": [\n" +
                "    {\n" +
                "      \"customer_group_id\": \"1\",\n" +
                "      \"price\": \"200\",\n" +
                "      \"priority\": \"1\",\n" +
                "      \"date_start\": \"2015-02-23\",\n" +
                "      \"date_end\": \"2019-02-23\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_discount\": [\n" +
                "    {\n" +
                "      \"name\": \"demo name\",\n" +
                "      \"customer_group_id\": \"1\",\n" +
                "      \"price\": \"200\",\n" +
                "      \"priority\": \"1\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"date_start\": \"2015-02-23\",\n" +
                "      \"date_end\": \"2019-02-23\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_attribute\": [\n" +
                "    {\n" +
                "      \"attribute_id\": \"16\",\n" +
                "      \"product_attribute_description\": [\n" +
                "        {\n" +
                "          \"text\": \"demo name\",\n" +
                "          \"language_id\": \"1\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"product_option\": [\n" +
                "    {\n" +
                "      \"type\": \"radio\",\n" +
                "      \"option_id\": \"11\",\n" +
                "      \"required\": \"1\",\n" +
                "      \"product_option_value\": [\n" +
                "        {\n" +
                "          \"price\": \"10.00\",\n" +
                "          \"price_prefix\": \"+\",\n" +
                "          \"subtract\": \"1\",\n" +
                "          \"points\": \"0\",\n" +
                "          \"points_prefix\": \"+\",\n" +
                "          \"weight\": \"0\",\n" +
                "          \"weight_prefix\": \"+\",\n" +
                "          \"option_value_id\": \"46\",\n" +
                "          \"quantity\": \"0\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Response resadd = given().header("Authorization", "Bearer "+access_token)
                .headers("Content-Type", "application/json").body(payload1).when()
                .post("http://rest-api.upskills.in/api/rest_admin/products");
        JsonPath jp= new JsonPath(resadd.getBody().asString());
        System.out.println(resadd.getBody().asString());
        System.out.println("the response code for adding a product is" + resadd.getStatusCode());


    }
}