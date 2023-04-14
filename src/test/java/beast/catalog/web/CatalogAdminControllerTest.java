//package beast.cart.web;
//
//import beast.cart.cart.CartService;
//import beast.cart.catalog.CatalogService;
//import beast.cart.models.Product;
//import beast.cart.models.UserCart;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static beast.cart._testdata.Carts.CART_1;
//import static beast.cart._testdata.Users.USER_1;
//import static beast.cart._testdata.Users.USER_1_USERNAME;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(SpringExtension.class)
//class CatalogAdminControllerTest {
//
//    @InjectMocks
//    private CatalogAdminController catalogAdminController;
//
//    @Mock
//    private CatalogService catalogService;
//
//
//    @Test
//    public void test_getProduct() {
//
//        when(catalogService.getVendorProducts(USER_1_USERNAME))
//                .thenReturn(VENDOR_1_PRODUCTS);
//
//        // TEST
//        List<Product> vp = catalogAdminController.getVendorProducts(USER_1,"v1");
//
//        // VERIFY
//        assertEquals(2, vp.size());
//    }
//
//    @Test
//    void test_saveCart() {
//        catalogAdminController.saveCart(USER_1, CART_1);
//
//        verify(catalogService).saveCart(USER_1_USERNAME, CART_1);
//    }
//}