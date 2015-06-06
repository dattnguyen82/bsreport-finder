__author__ = '212391398'

import userapp


api = userapp.API(app_id="54fd1fb89116b")

user_result = api.user.login(login="treadstone.poc@gmail.com", password="treadstonepoc123")
#print user_result

#result = api.token.get(token_id='gElLthQ0M5-zqs76B81Xkj')
#print result
myself = api.user.get()
print myself

result = api.user.count()
print result


result = api.user.search()
print result


result = api.user.search(page=1, page_size=100, fields='*', sort={'key':'asc'})
print result