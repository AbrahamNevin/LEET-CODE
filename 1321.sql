WITH DailyAmount AS (
    SELECT 
        visited_on,
        SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),
MovingAverage AS (
    SELECT 
        d1.visited_on,
        SUM(d2.amount) AS amount,
        ROUND(SUM(d2.amount) / 7, 2) AS average_amount
    FROM DailyAmount d1
    JOIN DailyAmount d2
      ON d2.visited_on BETWEEN DATE_SUB(d1.visited_on, INTERVAL 6 DAY) AND d1.visited_on
    GROUP BY d1.visited_on
    HAVING COUNT(*) = 7
)
SELECT * 
FROM MovingAverage
ORDER BY visited_on;
  
