__author__ = '212391398'

from httplib2 import Http

h = Http()
body = ''
header = {'Content-Type': 'application/json'}


with open("billdontlie.txt") as f:
    content = f.readlines()

    #resp = h.request("https://bsreport-finder.herokuapp.com/save", "POST", headers=header, body=content[0])
    #print resp
    for line in content:
        #print line
        line = line.lower()
        resp = h.request("https://bsreport-finder.herokuapp.com/save", "POST", headers=header, body=line)
        print resp
