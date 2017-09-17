# Finding-the-max-prod-all-dirxns--in-2D-grid
Find the maximum product of 4 adjacent numbers(diagonal,up,right) in a grid

Find maximum product row-wise, then column wise, then left diagonal,and then right diagonal. Compare 4 maximum products and the highest.

left-diagonal: 
  Take advantage of symmetry of a square grid. 
  1. Start from bottom left diagonal
  2. flip the row and column to reach to symmetry at the other side of diagonal
  3. Terminate when reaches longest diagonal(middle diagonal).
 Right-diagonal:
  Interchange the columns of the original grid (0 with 19..)
  Perform the same algorithm.
