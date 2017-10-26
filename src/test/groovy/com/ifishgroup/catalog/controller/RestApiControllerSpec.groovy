package com.ifishgroup.catalog.controller

import com.ifishgroup.catalog.model.Product
import com.ifishgroup.catalog.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.util.UriComponentsBuilder
import spock.lang.*

class RestApiControllerSpec extends Specification {

    RestApiController controller

    ProductService productService

    def setup() {
        productService = Mock()

        controller = new RestApiController(
                productService: productService
        )
    }

    def "create new product returns http 201"() {
        given:
        Product product = new Product()
        product.name = "New Product"
        product.description = "New Product Description"

        when:
        ResponseEntity response = controller.createProduct(product, UriComponentsBuilder.newInstance())

        then:
        response.statusCode == HttpStatus.CREATED
    }

    def "get product by id that doesn't exist returns http 404"() {
        given:
        Product product = new Product()
        product.id = 1

        when:
        ResponseEntity response = controller.getProduct(product.id)

        then:
        response.statusCode == HttpStatus.NOT_FOUND
    }

    def "empty product list returns http 204"() {
        when:
        ResponseEntity response = controller.listAllProducts()

        then:
        response.statusCode == HttpStatus.NO_CONTENT
    }

    def "deleting product that doesn't exist returns 404"() {
        given:
        Product product = new Product()
        product.id = 1

        when:
        ResponseEntity response = controller.deleteProduct(product.id)

        then:
        response.statusCode == HttpStatus.NOT_FOUND
    }

    def "delete all products returns http 204"() {
        when:
        ResponseEntity response = controller.deleteAllProducts()

        then:
        response.statusCode == HttpStatus.NO_CONTENT
    }

}
