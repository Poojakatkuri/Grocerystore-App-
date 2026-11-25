WITH inserted_categories AS (
    INSERT INTO public.categories (name, image)
    VALUES
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
    RETURNING id, name
)
SELECT id, name FROM inserted_categories;