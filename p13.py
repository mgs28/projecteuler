# Using readlines()
file1 = open('p13.txt', 'r')
Lines = file1.readlines()
 
count = 0
# Strips the newline character
for line in Lines:
    print(".{}.".format(int(line)))
