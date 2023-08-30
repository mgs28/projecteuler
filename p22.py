def read_dat(filename):
    names = [];
    with open(filename, 'r') as file: 
        names = file.readline().replace("\"","").split(",")
        names.sort()
    return names;

def alpha_val(s):
    return sum([ord(c)-64 for c in s])

names = read_dat("p22_names.txt")
print(sum([alpha_val(name)*(idx+1) for idx, name in enumerate(names)]))
#871198282