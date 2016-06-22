# cash-register

Create a cash register that should be able to accept only $20, $10, $5, $2 and $1 bills. 
Given the charge and amount of money received return the change in each denomination that should be given from the cash register. 
Sometimes when the vendors couldn’t make exact change they would tell us they couldn’t make exact change.
It’s safe to assume that all output will be printed to the command line, below are some examples of how it would be used.

start program, waiting for command.

`> java Main ...`
 
`ready`

show current state in total and each denomination: $Total #$20 #$10 #$5 #$2 #$1.
for example $68 1 2 3 4 5 means:
Total=$68 $20x1 $10x2 $5x3 $2x4 $1x5.

`> show`
 
`$68 1 2 3 4 5`

put bills in each denomination: #$20 #$10 #$5 #$2 #$1 (show current state).

`> put 1 2 3 0 5`

`$128 2 4 6 4 10`

take bills in each denomination: #$20 #$10 #$5 #$2 #$1 (show current state).

`> take 1 4 3 0 5`

`$48 1 0 3 4 5`

given amount.

show change in each denomination: #$20 #$10 #$5 #$2 #$1 (and remove money from cash register).

`> change 8`

`0 0 1 1 1`
 
`> show`

`$40 1 0 2 3 4` 

show error if there is insufficient fund or no change can be made.

`> change 97`
 
`sorry`

exit program.

`> quit`

`bye`
