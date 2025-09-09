select score,
    DENSE_RANK() over (
        order by score DESC
    ) as 'rank'
from Scores;