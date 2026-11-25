-- Replaces placeholder image URLs (example.com) with free, working images.
-- Run this once if you already ran step_1..step_3 with the old seed data.
-- Images: TheMealDB ingredient photos (https://www.themealdb.com), free for development / educational use.

-- Categories: match by name
UPDATE public.categories AS c
SET image = m.url
FROM (VALUES
    ('Beverages', 'https://www.themealdb.com/images/ingredients/Orange%20Juice.png'),
    ('Snacks', 'https://www.themealdb.com/images/ingredients/Cashew%20Nuts.png'),
    ('Desserts', 'https://www.themealdb.com/images/ingredients/Ice%20Cream.png'),
    ('Fruits', 'https://www.themealdb.com/images/ingredients/Mango.png'),
    ('Vegetables', 'https://www.themealdb.com/images/ingredients/Broccoli.png'),
    ('Dairy', 'https://www.themealdb.com/images/ingredients/Milk.png'),
    ('Bakery', 'https://www.themealdb.com/images/ingredients/Bread.png'),
    ('Meat', 'https://www.themealdb.com/images/ingredients/Beef.png'),
    ('Seafood', 'https://www.themealdb.com/images/ingredients/Salmon.png'),
    ('Grains', 'https://www.themealdb.com/images/ingredients/Rice.png')
) AS m(name, url)
WHERE c.name = m.name;

-- Products: seed names look like "<Category> <number> <Type>", e.g. "Beverage 3 Coffee".
-- Match on the exact type at the end of the name (old and new type names are both listed).
UPDATE public.products AS p
SET image = m.url
FROM (VALUES
    ('Cocoa', 'https://www.themealdb.com/images/ingredients/Cocoa.png'),
    ('Coffee', 'https://www.themealdb.com/images/ingredients/Cocoa.png'),
    ('Pineapple Juice', 'https://www.themealdb.com/images/ingredients/Pineapple%20Juice.png'),
    ('Tea', 'https://www.themealdb.com/images/ingredients/Pineapple%20Juice.png'),
    ('Orange Juice', 'https://www.themealdb.com/images/ingredients/Orange%20Juice.png'),
    ('Juice', 'https://www.themealdb.com/images/ingredients/Orange%20Juice.png'),
    ('Soda', 'https://www.themealdb.com/images/ingredients/Soda%20Water.png'),
    ('Water', 'https://www.themealdb.com/images/ingredients/Water.png'),
    ('Raisins', 'https://www.themealdb.com/images/ingredients/Raisins.png'),
    ('Chips', 'https://www.themealdb.com/images/ingredients/Raisins.png'),
    ('Nuts', 'https://www.themealdb.com/images/ingredients/Cashew%20Nuts.png'),
    ('Popcorn', 'https://www.themealdb.com/images/ingredients/Toffee%20Popcorn.png'),
    ('Pretzels', 'https://www.themealdb.com/images/ingredients/Pretzels.png'),
    ('Crackers', 'https://www.themealdb.com/images/ingredients/Digestive%20Biscuits.png'),
    ('Chocolate', 'https://www.themealdb.com/images/ingredients/Milk%20Chocolate.png'),
    ('Cake', 'https://www.themealdb.com/images/ingredients/Milk%20Chocolate.png'),
    ('Ice Cream', 'https://www.themealdb.com/images/ingredients/Ice%20Cream.png'),
    ('Cookie', 'https://www.themealdb.com/images/ingredients/Peanut%20Cookies.png'),
    ('Pie', 'https://www.themealdb.com/images/ingredients/Puff%20Pastry.png'),
    ('Pudding', 'https://www.themealdb.com/images/ingredients/Custard.png'),
    ('Apple', 'https://www.themealdb.com/images/ingredients/Apples.png'),
    ('Banana', 'https://www.themealdb.com/images/ingredients/Banana.png'),
    ('Orange', 'https://www.themealdb.com/images/ingredients/Orange.png'),
    ('Mango', 'https://www.themealdb.com/images/ingredients/Mango.png'),
    ('Grapefruit', 'https://www.themealdb.com/images/ingredients/Grapefruit.png'),
    ('Grape', 'https://www.themealdb.com/images/ingredients/Grapefruit.png'),
    ('Carrot', 'https://www.themealdb.com/images/ingredients/Carrots.png'),
    ('Broccoli', 'https://www.themealdb.com/images/ingredients/Broccoli.png'),
    ('Spinach', 'https://www.themealdb.com/images/ingredients/Spinach.png'),
    ('Pepper', 'https://www.themealdb.com/images/ingredients/Red%20Pepper.png'),
    ('Tomato', 'https://www.themealdb.com/images/ingredients/Tomato.png'),
    ('Milk', 'https://www.themealdb.com/images/ingredients/Milk.png'),
    ('Cheese', 'https://www.themealdb.com/images/ingredients/Cheddar%20Cheese.png'),
    ('Yogurt', 'https://www.themealdb.com/images/ingredients/Greek%20Yogurt.png'),
    ('Butter', 'https://www.themealdb.com/images/ingredients/Butter.png'),
    ('Cream', 'https://www.themealdb.com/images/ingredients/Double%20Cream.png'),
    ('Bread', 'https://www.themealdb.com/images/ingredients/Bread.png'),
    ('Baguette', 'https://www.themealdb.com/images/ingredients/Baguette.png'),
    ('Croissant', 'https://www.themealdb.com/images/ingredients/Baguette.png'),
    ('Muffin', 'https://www.themealdb.com/images/ingredients/English%20Muffins.png'),
    ('Ciabatta', 'https://www.themealdb.com/images/ingredients/Ciabatta.png'),
    ('Bagel', 'https://www.themealdb.com/images/ingredients/Ciabatta.png'),
    ('Naan', 'https://www.themealdb.com/images/ingredients/Naan%20Bread.png'),
    ('Pastry', 'https://www.themealdb.com/images/ingredients/Naan%20Bread.png'),
    ('Chicken', 'https://www.themealdb.com/images/ingredients/Chicken.png'),
    ('Beef', 'https://www.themealdb.com/images/ingredients/Beef.png'),
    ('Pork', 'https://www.themealdb.com/images/ingredients/Pork.png'),
    ('Lamb', 'https://www.themealdb.com/images/ingredients/Lamb.png'),
    ('Turkey', 'https://www.themealdb.com/images/ingredients/Turkey.png'),
    ('Salmon', 'https://www.themealdb.com/images/ingredients/Salmon.png'),
    ('Shrimp', 'https://www.themealdb.com/images/ingredients/Prawns.png'),
    ('Tuna', 'https://www.themealdb.com/images/ingredients/Tuna.png'),
    ('Cod', 'https://www.themealdb.com/images/ingredients/Cod.png'),
    ('Mussels', 'https://www.themealdb.com/images/ingredients/Mussels.png'),
    ('Crab', 'https://www.themealdb.com/images/ingredients/Mussels.png'),
    ('Rice', 'https://www.themealdb.com/images/ingredients/Rice.png'),
    ('Pasta', 'https://www.themealdb.com/images/ingredients/Spaghetti.png'),
    ('Quinoa', 'https://www.themealdb.com/images/ingredients/Quinoa.png'),
    ('Oats', 'https://www.themealdb.com/images/ingredients/Oats.png'),
    ('Couscous', 'https://www.themealdb.com/images/ingredients/Couscous.png'),
    ('Barley', 'https://www.themealdb.com/images/ingredients/Couscous.png')
) AS m(type, url)
WHERE p.name ~ ('^[A-Za-z]+ [0-9]+ ' || m.type || '$');
