package myapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import myapp.domain.Product;
import myapp.domain.enumeration.ProductStatus;
import myapp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public static Product createProductSample(
        Long id,
        String title,
        String keywords,
        String description,
        Integer rating,
        Integer quantityInStock,
        String dimensions,
        BigDecimal price,
        ProductStatus status,
        Double weight,
        Instant dateAdded,
        Instant dateModified
    ) {
        return new Product()
            .id(id)
            .title(title)
            .keywords(keywords)
            .description(description)
            .rating(rating)
            .quantityInStock(quantityInStock)
            .dimensions(dimensions)
            .price(price)
            .status(status)
            .weight(weight)
            .dateAdded(dateAdded)
            .dateModified(dateModified);
    }

    @Test
    public void saveProduct_TC1() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC2() {
        Product product = createProductSample(
            1L,
            "titu",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut ",
            "descriptio",
            1,
            0,
            "Lorem ipsum dolor sit amet, consectetur adipiscin",
            BigDecimal.valueOf(1),
            ProductStatus.IN_STOCK,
            0.0,
            Instant.now(),
            Instant.now().minus(Duration.ofDays(1))
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC3() {
        Product product = createProductSample(
            1L,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi utas",
            "description",
            4,
            1,
            "Lorem ipsum dolor sit amet, consectetur adipiscina",
            BigDecimal.valueOf(1),
            ProductStatus.IN_STOCK,
            1.0,
            Instant.now(),
            Instant.now().minus(Duration.ofDays(1))
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC4() {
        Product product = createProductSample(
            1L,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi utas",
            "description",
            5,
            1,
            "Lorem ipsum dolor sit amet, consectetur adipiscina",
            BigDecimal.valueOf(1),
            ProductStatus.IN_STOCK,
            1.0,
            Instant.now(),
            Instant.now().minus(Duration.ofDays(1))
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC5() {
        Product product = createProductSample(
            1L,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi utas",
            "description",
            null,
            1,
            "Lorem ipsum dolor sit amet, consectetur adipiscina",
            BigDecimal.valueOf(1),
            ProductStatus.IN_STOCK,
            1.0,
            Instant.now(),
            Instant.now().minus(Duration.ofDays(1))
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC6() {
        Product product = createProductSample(
            1L,
            "ti",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC7() {
        Product product = createProductSample(
            1L,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore e",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC8() {
        Product product = createProductSample(
            1L,
            "	",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC9() {
        Product product = createProductSample(
            1L,
            "tit",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi utas ",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC10() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "descriptio",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC11() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            -1,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC12() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            6,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC13() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            "abc",
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC14() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(-1),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC15() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            "abc",
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC16() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            -1,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC17() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            -1.0,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC18() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            "Lorem ipsum dolor sit amet, consectetur adipiscing",
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC19() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().plus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC20() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.OUT_OF_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            Instant.now().plus(Duration.ofDays(1))
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }

    @Test
    public void saveProduct_TC21() {
        Product product = createProductSample(
            1L,
            "tit",
            "",
            "",
            0,
            null,
            null,
            BigDecimal.valueOf(0),
            ProductStatus.IN_STOCK,
            null,
            Instant.now().minus(Duration.ofDays(1)),
            null
        );

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);

        assertEquals(product, result);
    }
}
