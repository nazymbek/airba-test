package api;

import org.junit.Test;
import static api.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CatalogTest {

    //чек есть ли "Хлеб и пекарня" в списке продуктов
    @Test
    public void checkCatalogueTreeHasBreadBakery(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecOk());
        given()
                .header("workflow", UUID)
                .when()
                .get("api/nomenclature/catalog-tree/")
                .then().log().all()
                .body("data.categories.name[0]", hasItem("Хлеб и пекарня"));
    }

    //чек добавился ли продукт в корзину
    @Test
    public void checkAddedProductInCard(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecOk());
        given()
                .header("workflow", UUID)
                .body("{\"count\":1,\"product_id\":20321}")
                .when()
                .post("api/orders/cart/")
                .then().log().all()
                .body("data.cart.products.name[0]", equalTo("Багет Альпийский от пекарни Airba Fresh 300 г"));
    }


}
