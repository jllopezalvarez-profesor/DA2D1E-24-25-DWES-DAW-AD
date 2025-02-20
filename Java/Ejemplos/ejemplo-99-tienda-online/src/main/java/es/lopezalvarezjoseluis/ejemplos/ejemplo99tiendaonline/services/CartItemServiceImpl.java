package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Product;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories.CartItemRepository;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<CartItem> findById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId);
    }

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }


    @Override
    public List<CartItem> addProduct(Long productId, Integer quantity) {
        cartItemRepository
                .findByProductProductId(productId)
                .ifPresentOrElse(
                        cartItem -> increaseCardItemQuantity(cartItem, quantity),
                        () -> addNewProduct(productId, quantity));

        return cartItemRepository.findAll();
    }

    @Override
    public Integer getQuantitySum() {
        return cartItemRepository.quantitySum();
    }

    private void addNewProduct(Long productId, Integer quantity) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No se ha encontrado el producto con id %s", productId)));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    private void increaseCardItemQuantity(CartItem cartItem, Integer quantity) {
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItemRepository.save(cartItem);
    }

}
