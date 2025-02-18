INSERT INTO seller(seller_id, name, description, created_at, updated_at)
values (1, 'Seller A', 'Seller A description', '2025-02-06', '2025-02-06'),
       (2, 'Seller B', 'Seller B description', '2025-02-06', '2025-02-06'),
       (3, 'Seller C', 'Seller C description', '2025-02-06', '2025-02-06'),
       (4, 'Seller D', 'Seller D description', '2025-02-06', '2025-02-06'),
       (5, 'Seller E', 'Seller E description', '2025-02-06', '2025-02-06'),
       (6, 'Seller F', 'Seller F description', '2025-02-06', '2025-02-06');

INSERT INTO category (category_id, name, description)
VALUES (1, 'Fruits and Vegetables', 'Fresh fruits and vegetables, including organic options.'),
       (2, 'Dairy Products', 'Milk, cheese, yogurt, and other dairy-based items.'),
       (3, 'Bakery', 'Freshly baked bread, pastries, and sweet treats.'),
       (4, 'Meat and Seafood', 'High-quality meats, poultry, and seafood options.'),
       (5, 'Beverages', 'Juices, teas, coffees, and other refreshing drinks.');

-- Insert products
INSERT INTO product (product_id, name, description, price, stock, image_absolute_url)
VALUES (1, 'Apple', 'Fresh red apples, perfect for a healthy snack.', 1.50, 100,
        'https://example.com/images/apple.jpg'),
       (2, 'Banana', 'Organic bananas rich in potassium.', 1.20, 120, 'https://example.com/images/banana.jpg'),
       (3, 'Carrot', 'Crunchy and sweet carrots.', 0.80, 200, 'https://example.com/images/carrot.jpg'),
       (4, 'Milk', 'Fresh cow milk, 1L bottle.', 1.80, 150, 'https://example.com/images/milk.jpg'),
       (5, 'Cheese', 'Aged cheddar cheese, 200g block.', 3.50, 80, 'https://example.com/images/cheese.jpg'),
       (6, 'Bread', 'Whole wheat bread, freshly baked.', 2.00, 90, 'https://example.com/images/bread.jpg'),
       (7, 'Croissant', 'Butter croissant, flaky and delicious.', 1.50, 60, 'https://example.com/images/croissant.jpg'),
       (8, 'Chicken Breast', 'Boneless chicken breast, 500g.', 5.00, 70, 'https://example.com/images/chicken.jpg'),
       (9, 'Salmon Fillet', 'Fresh Atlantic salmon, 250g.', 7.50, 50, 'https://example.com/images/salmon.jpg'),
       (10, 'Orange Juice', '100% natural orange juice, 1L.', 3.00, 100, 'https://example.com/images/orange_juice.jpg'),
       (11, 'Strawberries', 'Fresh strawberries, 250g pack.', 2.80, 90, 'https://example.com/images/strawberries.jpg'),
       (12, 'Lettuce', 'Crisp green lettuce.', 1.00, 150, 'https://example.com/images/lettuce.jpg'),
       (13, 'Yogurt', 'Greek yogurt, 500g.', 2.50, 110, 'https://example.com/images/yogurt.jpg'),
       (14, 'Butter', 'Unsalted butter, 250g.', 3.20, 95, 'https://example.com/images/butter.jpg'),
       (15, 'Chocolate Cake', 'Rich chocolate cake, 500g.', 5.50, 40, 'https://example.com/images/chocolate_cake.jpg'),
       (16, 'Baguette', 'Classic French baguette.', 1.80, 75, 'https://example.com/images/baguette.jpg'),
       (17, 'Beef Steak', 'Premium beef steak, 300g.', 10.00, 60, 'https://example.com/images/beef_steak.jpg'),
       (18, 'Shrimp', 'Fresh shrimp, 500g.', 12.00, 40, 'https://example.com/images/shrimp.jpg'),
       (19, 'Coffee', 'Ground coffee, 500g.', 6.00, 100, 'https://example.com/images/coffee.jpg'),
       (20, 'Tea', 'Green tea, 100g.', 4.50, 80, 'https://example.com/images/tea.jpg'),
       (21, 'Watermelon', 'Juicy and refreshing watermelon.', 4.00, 70, 'https://example.com/images/watermelon.jpg'),
       (22, 'Blueberries', 'Fresh blueberries, 200g.', 3.50, 60, 'https://example.com/images/blueberries.jpg'),
       (23, 'Spinach', 'Organic spinach leaves.', 2.00, 100, 'https://example.com/images/spinach.jpg'),
       (24, 'Mozzarella Cheese', 'Fresh mozzarella, 250g.', 4.20, 85, 'https://example.com/images/mozzarella.jpg'),
       (25, 'Sourdough Bread', 'Traditional sourdough bread.', 3.00, 50, 'https://example.com/images/sourdough.jpg'),
       (26, 'Tuna', 'Canned tuna in olive oil.', 2.80, 120, 'https://example.com/images/tuna.jpg'),
       (27, 'Lemonade', 'Homemade style lemonade, 1L.', 2.50, 90, 'https://example.com/images/lemonade.jpg'),
       (28, 'Avocado', 'Creamy avocados, rich in nutrients.', 2.50, 80, 'https://example.com/images/avocado.jpg'),
       (29, 'Pineapple', 'Sweet and juicy pineapple.', 3.80, 70, 'https://example.com/images/pineapple.jpg'),
       (30, 'Eggs', 'Organic free-range eggs, dozen.', 4.50, 130, 'https://example.com/images/eggs.jpg'),
       (31, 'Butter Croissant', 'Classic butter croissant.', 1.70, 75,
        'https://example.com/images/butter_croissant.jpg'),
       (32, 'Beef Mince', 'Ground beef, 500g.', 7.00, 60, 'https://example.com/images/beef_mince.jpg'),
       (33, 'Cucumber', 'Fresh cucumbers.', 1.20, 110, 'https://example.com/images/cucumber.jpg'),
       (34, 'Almond Milk', 'Unsweetened almond milk, 1L.', 3.60, 95, 'https://example.com/images/almond_milk.jpg'),
       (35, 'Pumpkin Pie', 'Traditional pumpkin pie, 600g.', 6.80, 40, 'https://example.com/images/pumpkin_pie.jpg'),
       (36, 'Bagels', 'Assorted bagels, pack of 4.', 4.00, 55, 'https://example.com/images/bagels.jpg'),
       (37, 'Salami', 'Italian salami, 250g.', 5.50, 65, 'https://example.com/images/salami.jpg'),
       (38, 'Grapes', 'Sweet red grapes, 500g.', 4.00, 80, 'https://example.com/images/grapes.jpg'),
       (39, 'Goat Cheese', 'Soft goat cheese, 150g.', 4.80, 60, 'https://example.com/images/goat_cheese.jpg'),
       (40, 'Ciabatta', 'Italian ciabatta bread.', 2.50, 75, 'https://example.com/images/ciabatta.jpg'),
       (41, 'Turkey Breast', 'Sliced turkey breast, 200g.', 5.80, 90, 'https://example.com/images/turkey.jpg'),
       (42, 'Clams', 'Fresh clams, 500g.', 9.00, 50, 'https://example.com/images/clams.jpg'),
       (43, 'Espresso', 'Espresso ground coffee, 250g.', 5.50, 80, 'https://example.com/images/espresso.jpg'),
       (44, 'Herbal Tea', 'Chamomile herbal tea, 50g.', 3.00, 90, 'https://example.com/images/herbal_tea.jpg'),
       (45, 'Peanuts', 'Roasted salted peanuts, 250g.', 3.20, 100, 'https://example.com/images/peanuts.jpg'),
       (46, 'Ice Cream', 'Vanilla ice cream, 1L.', 6.00, 70, 'https://example.com/images/ice_cream.jpg'),
       (47, 'Peach', 'Fresh peaches, 500g.', 3.20, 80, 'https://example.com/images/peach.jpg'),
       (48, 'Walnuts', 'Organic walnuts, 200g.', 5.00, 90, 'https://example.com/images/walnuts.jpg'),
       (49, 'Dark Chocolate', '85% dark chocolate, 100g.', 2.80, 95, 'https://example.com/images/dark_chocolate.jpg'),
       (50, 'Coconut Water', 'Natural coconut water, 500ml.', 2.90, 120,
        'https://example.com/images/coconut_water.jpg');

-- Assign products to categories
INSERT INTO product_category (product_id, category_id)
VALUES (1, 1),  -- Apple -> Fruits and Vegetables
       (2, 1),  -- Banana -> Fruits and Vegetables
       (3, 1),  -- Carrot -> Fruits and Vegetables
       (4, 2),  -- Milk -> Dairy Products
       (5, 2),  -- Cheese -> Dairy Products
       (6, 3),  -- Bread -> Bakery
       (7, 3),  -- Croissant -> Bakery
       (8, 4),  -- Chicken Breast -> Meat and Seafood
       (9, 4),  -- Salmon Fillet -> Meat and Seafood
       (10, 5), -- Orange Juice -> Beverages
       (11, 1), -- Strawberries -> Fruits and Vegetables
       (12, 1), -- Lettuce -> Fruits and Vegetables
       (13, 2), -- Yogurt -> Dairy Products
       (14, 2), -- Butter -> Dairy Products
       (15, 3), -- Chocolate Cake -> Bakery
       (16, 3), -- Baguette -> Bakery
       (17, 4), -- Beef Steak -> Meat and Seafood
       (18, 4), -- Shrimp -> Meat and Seafood
       (19, 5), -- Coffee -> Beverages
       (20, 5), -- Tea -> Beverages
       (21, 1), -- Watermelon -> Fruits and Vegetables
       (22, 1), -- Blueberries -> Fruits and Vegetables
       (23, 1), -- Spinach -> Fruits and Vegetables
       (24, 2), -- Mozzarella Cheese -> Dairy Products
       (25, 3), -- Sourdough Bread -> Bakery
       (26, 4), -- Tuna -> Meat and Seafood
       (27, 5), -- Lemonade -> Beverages
       (28, 1), -- Avocado -> Fruits and Vegetables
       (29, 1), -- Pineapple -> Fruits and Vegetables
       (30, 2), -- Eggs -> Dairy Products
       (31, 3), -- Butter Croissant -> Bakery
       (32, 4), -- Beef Mince -> Meat and Seafood
       (33, 1), -- Cucumber -> Fruits and Vegetables
       (34, 2),
       (34, 5), -- Almond Milk -> Dairy Products, Beverages
       (35, 3), -- Pumpkin Pie -> Bakery
       (36, 3), -- Bagels -> Bakery
       (37, 4), -- Salami -> Meat and Seafood
       (38, 1), -- Grapes -> Fruits and Vegetables
       (39, 2), -- Goat Cheese -> Dairy Products
       (40, 3), -- Ciabatta -> Bakery
       (41, 4), -- Turkey Breast -> Meat and Seafood
       (42, 4), -- Clams -> Meat and Seafood
       (43, 5), -- Espresso -> Beverages
       (44, 5), -- Herbal Tea -> Beverages
       (45, 5), -- Peanuts -> Beverages
       (46, 2),
       (46, 5), -- Ice Cream -> Dairy Products, Beverages
       (47, 1), -- Peach -> Fruits and Vegetables
       (48, 5), -- Walnuts -> Beverages
       (49, 5), -- Dark Chocolate -> Beverages
       (50, 5); -- Coconut Water -> Beverages


UPDATE product SET seller_id = 1 where product_id = 1;
UPDATE product SET seller_id = 1 where product_id = 2;
UPDATE product SET seller_id = 1 where product_id = 3;
UPDATE product SET seller_id = 1 where product_id = 4;
UPDATE product SET seller_id = 1 where product_id = 5;
UPDATE product SET seller_id = 1 where product_id = 6;
UPDATE product SET seller_id = 2 where product_id = 7;
UPDATE product SET seller_id = 2 where product_id = 8;
UPDATE product SET seller_id = 2 where product_id = 9;
UPDATE product SET seller_id = 2 where product_id = 10;
UPDATE product SET seller_id = 2 where product_id = 11;
UPDATE product SET seller_id = 2 where product_id = 12;
UPDATE product SET seller_id = 5 where product_id = 13;
UPDATE product SET seller_id = 5 where product_id = 14;
UPDATE product SET seller_id = 5 where product_id = 15;
