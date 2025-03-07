import json
import csv

json_data = json.load(open('main.json', 'r', encoding='UTF-8'))

writer = csv.writer(open('rez_5.csv', 'w', encoding='UTF-8', newline=''), delimiter=';')

lessons = ['lessons']
atr = [[''] for _ in range(7)]

for lesson in json_data['lessons']:
    lessons += [lesson]
    ind = 0
    for tag in json_data['lessons'][lesson]:
        atr[ind][0] = tag
        atr[ind] += [json_data['lessons'][lesson][tag]]
        ind += 1

writer.writerow(['weeks'] + json_data['weeks'])
writer.writerow('')
writer.writerow(['day'] + [json_data['day']])
writer.writerow('')
writer.writerows([lessons, *atr])