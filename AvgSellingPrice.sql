# Write your MySQL query statement below
WITH Sales AS (
    SELECT 
        u.product_id, 
        SUM(p.price * u.units) AS total_revenue,
        SUM(u.units) AS total_units
    FROM Prices p
    JOIN UnitsSold u 
        ON p.product_id = u.product_id 
        AND u.purchase_date BETWEEN p.start_date AND p.end_date
    GROUP BY u.product_id
)
SELECT 
    p.product_id, 
    COALESCE(ROUND(S.total_revenue / S.total_units, 2), 0) AS average_price
FROM Prices p
LEFT JOIN Sales S 
    ON p.product_id = S.product_id
GROUP BY p.product_id;
