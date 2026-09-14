SELECT 
    s.user_id,
    ROUND(
        IFNULL(
            count(CASE WHEN c.action = 'confirmed' THEN 1 END),
            0
        ) / COUNT(*),
        2
    ) AS confirmation_rate
FROM signups s
LEFT JOIN confirmations c
    ON s.user_id = c.user_id
GROUP BY s.user_id;