__author__ = '212391398'


class BSContentObject:

    link = ''
    date = ''
    info = ''
    tokens = []

    def __init__(self, l, d, i):
        self.link = l
        self.date = d
        self.info = i

    def set_tokens(self, tokens):
        self.tokens = tokens

    def print_obj(self):
        print '{ "link": "' + self.link + '", "date": "' + str(self.date) + '", "info": "' + self.info + '"}'

    def to_json(self):
        json = '{ "link": "' + self.link + '", "date": "' + str(self.date) + '", "info": "' + self.info + '",'
        json += '"tokens":['
        for t in self.tokens:
            json += '"' + t + '",'

        json = json[:-1]

        json += ']}'

        return json

    def print_sql(self):
        print "INSERT INTO bsr_info(date,link,info) VALUES ('"+str(self.date)+"', '"+self.link+"', '"+self.info+"');"