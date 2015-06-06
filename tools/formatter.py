__author__ = '212391398'


with open("bdl") as f:
    lines = f.readlines()

    for line in lines:
        output = '"info": "' + line + '", "tokens":['
        #print output

        tokens = line.split(' ')
        for t in tokens:
            output += '"' + t + '",'

        output = output[:-1]

        output += ']}'

        print output
