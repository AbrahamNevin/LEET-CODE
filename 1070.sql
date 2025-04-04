WITH RankedSales AS (
    SELECT *, 
           ROW_NUMBER() OVER (PARTITION BY product_id ORDER BY year) AS rn
    FROM Sales
)
SELECT product_id, year AS first_year, quantity, price
FROM RankedSales
WHERE rn = 1;
